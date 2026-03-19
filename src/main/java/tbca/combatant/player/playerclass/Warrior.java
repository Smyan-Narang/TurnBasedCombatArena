package tbca.combatant.player.playerclass;

import tbca.combatant.player.Player;

public abstract class Warrior extends Player {
    @Override
    public PlayerClass getPlayerClass() {
        return PlayerClass.WARRIOR;
    }
}
