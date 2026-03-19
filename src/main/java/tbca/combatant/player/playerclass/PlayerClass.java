package tbca.combatant.player.playerclass;

public enum PlayerClass {
    WIZARD("Wizard"),
    WARRIOR("Warrior");

    private final String label;

    PlayerClass(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }


    public static PlayerClass fromLabel(String label) {
        for (PlayerClass pc : PlayerClass.values()) {
            if (pc.label.equalsIgnoreCase(label)) {
                return pc;
            }
        }
        throw new IllegalArgumentException("Unknown PlayerClass: " + label);
    }
}
