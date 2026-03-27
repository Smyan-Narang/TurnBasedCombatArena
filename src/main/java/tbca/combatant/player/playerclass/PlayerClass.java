package tbca.combatant.player.playerclass;

/**
 * Defines every player class together with its base stats.
 *
 * Warrior : HP 260 | ATK 40 | DEF 20 | SPD 30
 * Wizard  : HP 200 | ATK 50 | DEF 10 | SPD 20
 */
public enum PlayerClass {

    WARRIOR("Warrior", 260, 40, 20, 30),
    WIZARD ("Wizard",  200, 50, 10, 20);

    // ----------------------------------------------------------------- fields
    private final String label;
    private final int maxHp;
    private final int attack;
    private final int defense;
    private final int speed;

    // -------------------------------------------------------------- constructor
    PlayerClass(String label, int maxHp, int attack, int defense, int speed) {
        this.label   = label;
        this.maxHp   = maxHp;
        this.attack  = attack;
        this.defense = defense;
        this.speed   = speed;
    }

    // ----------------------------------------------------------------- getters
    public String getLabel()   { return label; }
    public int getMaxHp()      { return maxHp; }
    public int getAttack()     { return attack; }
    public int getDefense()    { return defense; }
    public int getSpeed()      { return speed; }

    @Override
    public String toString() { return label; }

    public static PlayerClass fromLabel(String label) {
        for (PlayerClass pc : PlayerClass.values()) {
            if (pc.label.equalsIgnoreCase(label)) return pc;
        }
        throw new IllegalArgumentException("Unknown PlayerClass: " + label);
    }
}