package tbca.combatant.enemy;

/**
 * Concrete implementation of the Wolf enemy.
 * Stats (from EnemyType): HP 40 | ATK 45 | DEF 5 | SPD 35
 */
public class Wolf extends Enemy {

    public Wolf() {
        super(EnemyType.WOLF);
    }

    // Inherits takeTurn() from Enemy, which performs BasicAttack.
}