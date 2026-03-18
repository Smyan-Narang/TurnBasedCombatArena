package tbca.combatant;

public abstract class Combatant {
    private String name;
    private int maxHp, maxMp;
    private int currHp, currMp;

    public int getMaxHp() {
        return maxHp;
    }

    public int getMaxMp() {
        return maxMp;
    }

    public int getCurrHp() {
        return currHp;
    }

    public int getCurrMp() {
        return currMp;
    }

    public abstract boolean isPlayer();

    @Override
    public abstract String toString();

}
