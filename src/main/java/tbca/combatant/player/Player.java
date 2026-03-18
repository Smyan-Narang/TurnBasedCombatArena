package tbca.combatant.player;

import tbca.combatant.Combatant;

public abstract class Player extends Combatant {

    @Override
    public boolean isPlayer() {
        return true;
    }

    public abstract void executeSpecialSkill();
}
