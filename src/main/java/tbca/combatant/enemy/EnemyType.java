package tbca.combatant.enemy;

/**
 * Defines every enemy variant together with its base stats from the spec.
 *
 * Centralising stats here means changing a Goblin's HP only ever
 * requires editing one place — single source of truth (SRP / OCP).
 *
 * Goblin : HP 55 | ATK 35 | DEF 15 | SPD 25
 * Wolf   : HP 40 | ATK 45 | DEF  5 | SPD 35
 */
public enum EnemyType {

    GOBLIN("Goblin", 55, 35, 15, 25),
    WOLF  ("Wolf",   40, 45,  5, 35);

    // ----------------------------------------------------------------- fields
    private final String displayName;
    private final int maxHp;
    private final int attack;
    private final int defense;
    private final int speed;

    // -------------------------------------------------------------- constructor
    EnemyType(String displayName, int maxHp, int attack, int defense, int speed) {
        this.displayName = displayName;
        this.maxHp       = maxHp;
        this.attack      = attack;
        this.defense     = defense;
        this.speed       = speed;
    }

    // ----------------------------------------------------------------- getters
    public String getDisplayName() { return displayName; }
    public int getMaxHp()          { return maxHp; }
    public int getAttack()         { return attack; }
    public int getDefense()        { return defense; }
    public int getSpeed()          { return speed; }

    @Override
    public String toString()       { return displayName; }
}