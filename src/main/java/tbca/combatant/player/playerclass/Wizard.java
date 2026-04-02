package tbca.combatant.player.playerclass;

import java.util.List;

import tbca.combatant.Combatant;
import tbca.combatant.player.Player;
import tbca.effect.ArcaneBlastBuff;
import tbca.engine.logic.utility.DamageUtility;

public class Wizard extends Player {
    public Wizard() {
        super(PlayerClass.WIZARD);
    }
    private void performArcaneBlast(List<? extends Combatant> enemies) {
        int kills = 0;
        for (Combatant enemy : enemies) {
            if (!enemy.isAlive()) continue;
            int damage = DamageUtility.computeBasicAttackDamage(this, enemy);
            enemy.takeDamage(damage);
            
            if (!enemy.isAlive()) {
                kills++;
            }
        }
        for (int i = 0; i < kills; i++) {
            this.addStatusEffect(new ArcaneBlastBuff());
        }

        System.out.printf("%s unleashed Arcane Blast! Kills: %d%n", getName(), kills);
    }
    @Override
    public void executeSpecialSkill(tbca.engine.GameState gameState, int targetIndex) {
        if (getSpecialSkillCooldown() == 0) {
            List<Combatant> enemies = gameState.getCurrEnemies();
            performArcaneBlast(enemies);
            setSpecialSkillCooldown(3);
        } else {
            System.out.println("Arcane Blast is still recharging!");
        }
    }
    @Override
    public void executeSpecialSkillFree(tbca.engine.GameState gameState, int targetIndex) {
        List<Combatant> enemies = gameState.getCurrEnemies();
        performArcaneBlast(enemies);
        System.out.println("(Power Stone) " + getName() + " triggered a bonus Arcane Blast!");
    }


}