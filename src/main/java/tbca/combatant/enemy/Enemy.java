package tbca.combatant.enemy;

import tbca.combatant.Combatant;

public abstract class Enemy extends Combatant {

    @Override
    public boolean isPlayer() {
        return false;
    }
}
