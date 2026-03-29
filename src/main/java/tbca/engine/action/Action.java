package tbca.engine.action;

import tbca.combatant.Combatant;
import tbca.engine.GameState;
import tbca.ui.Ui;

public abstract class Action {
    private Combatant actor;

    public abstract ActionType getType();

    public abstract void execute(Ui ui, GameState gameState);

}
