package tbca.combatant.enemy;

/**
 * Concrete implementation of the Goblin enemy.
 * Stats (pulled from EnemyType.GOBLIN):
 * HP: 55 | ATK: 35 | DEF: 15 | SPD: 25
 */
public class Goblin extends Enemy {

    /**
     * Constructs a new Goblin using the base Enemy constructor 
     * and passing the GOBLIN enum type.
     */
    public Goblin() {
        super(EnemyType.GOBLIN);
    }

    // Inherits default behavior from Enemy: always performs BasicAttack.
}