package tbca.combatant.enemy;

import tbca.combatant.Combatant;

/**
 * Abstract base for all enemy combatants.
 *
 * Enemies always perform BasicAttack on their turn (spec 3.2 / 4.vii).
 * The takeTurn() method is intentionally non-final so that future enemy
 * subclasses can override it with different AI strategies without
 * modifying this class (OCP).
 *
 * LSP: Enemy is fully substitutable as Combatant anywhere in BattleEngine.
 */
public abstract class Enemy extends Combatant {

    private final EnemyType type;

    // -------------------------------------------------------------- constructor
    protected Enemy(EnemyType type) {
        super(
            type.getDisplayName(),
            type.getMaxHp(),
            type.getAttack(),
            type.getDefense(),
            type.getSpeed()
        );
        this.type = type;
    }

    // ----------------------------------------------------------------- getters
    public EnemyType getType() { return type; }

    // --------------------------------------------------------------- isPlayer
    @Override
    public boolean isPlayer() { return false; }

    // ---------------------------------------------------------------- takeTurn
    /**
     * Default enemy behaviour: signals BasicAttack intent.
     * BattleEngine handles target selection and damage application.
     * Subclasses may override this to implement different AI strategies (OCP).
     */
    @Override
    public void takeTurn() {
        System.out.println(getName() + " prepares to attack!");
    }

    // --------------------------------------------------------------- isAlive
    @Override
    public boolean isAlive() { return getCurrHp() > 0; }

    // --------------------------------------------------------------- toString
    @Override
    public String toString() {
        return String.format("%s [HP: %d/%d | ATK: %d | DEF: %d | SPD: %d]",
            getName(), getCurrHp(), getMaxHp(),
            getAttack(), getDefense(), getSpeed());
    }
}