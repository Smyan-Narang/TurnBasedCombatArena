package tbca.combatant;

import tbca.combatant.enemy.EnemyType;
import tbca.combatant.enemy.Goblin;
import tbca.combatant.enemy.Wolf;
import tbca.combatant.player.Player;
import tbca.combatant.player.Warrior;
import tbca.combatant.player.Wizard;
import tbca.combatant.player.playerclass.PlayerClass;
import tbca.item.Item;

import java.util.List;

/**
 * Factory for creating Combatant instances.
 *
 * DIP  : callers depend on Combatant abstraction, not concrete classes.
 * OCP  : adding a new player class or enemy type only requires adding a
 *        case here, nothing else changes.
 * SRP  : solely responsible for combatant instantiation.
 */
public final class CombatantFactory {

    // Prevent instantiation — purely static factory
    private CombatantFactory() {}

    /**
     * Create a player combatant of the given class, pre-loaded with items.
     *
     * @param playerClass the chosen player class
     * @param items       up to 2 items chosen at game start (duplicates allowed)
     * @return fully initialised Player instance
     */
    public static Player createPlayer(PlayerClass playerClass, List<Item> items) {
        Player player = switch (playerClass) {
            case WARRIOR -> new Warrior();
            case WIZARD  -> new Wizard();
        };
        for (Item item : items) {
            player.addItem(item);
        }
        return player;
    }

    /**
     * Create a fresh enemy combatant of the given type.
     *
     * @param enemyType the type of enemy to spawn
     * @return fully initialised Enemy instance
     */
    public static Combatant createEnemy(EnemyType enemyType) {
        return switch (enemyType) {
            case GOBLIN -> new Goblin();
            case WOLF   -> new Wolf();
        };
    }
}