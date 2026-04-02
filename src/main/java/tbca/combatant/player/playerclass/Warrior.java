package tbca.combatant.player.playerclass;

import tbca.combatant.Combatant;
import  tbca.combatant.player.Player;
import tbca.effect.StunEffect;
import tbca.engine.logic.utility.DamageUtility;

public class Warrior extends Player {
    public Warrior() {
        super(PlayerClass.WARRIOR);
    }

    private void performShieldBash(Combatant target) {
        int damage = DamageUtility.computeBasicAttackDamage(this, target);
        target.takeDamage(damage);
        
        target.addStatusEffect(new StunEffect()); 
        
        System.out.printf("%s uses Shield Bash! %s is STUNNED.%n", getName(), target.getName());
    }

    @Override
    public void executeSpecialSkill(tbca.engine.GameState gameState, int targetIndex) {
        if (getSpecialSkillCooldown() == 0) {
            if (targetIndex >= 0 && targetIndex < gameState.getCurrEnemies().size()) {
                Combatant target = gameState.getCurrEnemies().get(targetIndex);
                performShieldBash(target);
                setSpecialSkillCooldown(3);
            } else {
                System.out.println("Invalid target selected");
            }
        } else {
            System.out.println("Skill is still on cooldown");
        }
    }

    @Override
    public void executeSpecialSkillFree(tbca.engine.GameState gameState, int targetIndex) {
        Combatant target = gameState.getCurrEnemies().get(targetIndex);
        performShieldBash(target);
        System.out.println("(Power Stone) " + getName() + " activated a bonus Shield Bash!");
    }


}