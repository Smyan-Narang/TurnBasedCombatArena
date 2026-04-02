package tbca.item;
import tbca.combatant.Combatant;
import tbca.engine.GameState;

public class Potion implements Item{
    @Override
    public void use(Combatant user, GameState gameState, int targetIndex){
        int healAmount = 100;
        int newHp = Math.min(user.getCurrHp() + healAmount, user.getMaxHp());
        user.setHp(newHp);
    }

    @Override
    public String getName(){
        return "Potion";
    }

    public ItemType getType(){
        return ItemType.POTION;
    }
}