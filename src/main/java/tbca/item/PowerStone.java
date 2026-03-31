package tbca.item;

import tbca.combatant.Combatant;
import tbca.combatant.player.Player;

public class PowerStone implements Item {

   @Override
   public void use(Combatant user, Combatant target) {
       if (user instanceof Player) {
           Player userPlayer = (Player) user;
           userPlayer.executeSpecialSkillFree(target);
       }
   }
   @Override
   public String getName(){
   return "Power Stone";
   }
}
