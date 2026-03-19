package tbca.combatant.player;

import tbca.combatant.Combatant;
import tbca.combatant.player.playerclass.PlayerClass;

public abstract class Player extends Combatant {

    @Override
    public boolean isPlayer() {
        return true;
    }

    public abstract void executeSpecialSkill();
    public abstract PlayerClass getPlayerClass();
}
