package tbca.combatant.player.playerclass;

import tbca.combatant.player.Player;

public abstract class Wizard extends Player {
    @Override
    public PlayerClass getPlayerClass() {
        return PlayerClass.WIZARD;
    }
}
