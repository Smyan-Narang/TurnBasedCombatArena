package tbca.item;

import tbca.combatant.Combatant;
import tbca.engine.GameState;

public interface Item {
    void use(Combatant user, GameState gameState, int targetIndex);
    String getName();
    ItemType getType();
}