package tbca.item;

import tbca.combatant.Combatant;
import tbca.combatant.player.Player;
import tbca.engine.GameState;

public class PowerStone implements Item {

   @Override
   public void use(Combatant user, GameState gameState, int targetIndex) {
       if (user instanceof Player userPlayer) {
           userPlayer.executeSpecialSkillFree(gameState, targetIndex);
       }
   }
   @Override
   public String getName(){
   return "Power Stone";
   }

    public ItemType getType(){
        return ItemType.POWER_STONE;
    }
}
