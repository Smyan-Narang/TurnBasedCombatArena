package tbca.combatant;

import java.util.ArrayList;
import java.util.List;
import tbca.effect.StatusEffect;

public abstract class Combatant {
    private final String name;
    private final int maxHp;
    private int currHp;
    private final int baseAttack; // Made final to preserve original stat
    private int attack;
    private final int baseDefense; // Made final to preserve original stat
    private int defense;
    private final int speed;

    private boolean canAct = true;
    private boolean invulnerable = false;
    private int specialSkillCooldown = 0;
    private final List<StatusEffect> effects = new ArrayList<>();

    protected Combatant(String name, int maxHp, int attack, int defense, int speed) {
        this.name = name;
        this.maxHp = maxHp;
        this.currHp = maxHp;
        this.baseAttack = attack;
        this.attack = attack;
        this.baseDefense = defense;
        this.defense = defense;
        this.speed = speed;
    }

    // --- ITEM COMPATIBILITY ---

    /** Required by Potion.java */
    public void setHp(int hp) {
        this.setCurrHp(hp);
    }

    /** Required by PowerStone.java */
    public void executeSpecialSkillFree() {
        this.specialSkillCooldown = 0;
        System.out.println(name + "'s Special Skill is now ready!");
    }

    // --- EFFECT LOGIC ---

    public void addStatusEffect(StatusEffect effect) {
        this.effects.add(effect);
        effect.applyEffect(this);
    }

    public void tickEffects() {
        for (int i = effects.size() - 1; i >= 0; i--) {
            StatusEffect e = effects.get(i);
            e.tick(this);
            if (e.isExpired()) {
                effects.remove(i);
            }
        }
    }

    // --- COMBAT LOGIC ---

    public void takeDamage(int damage) {
        if (invulnerable) {
            System.out.println(name + " is invulnerable! No damage taken.");
            return;
        }
        setCurrHp(getCurrHp() - damage);
    }

    public void decrementCooldown() {
        if (specialSkillCooldown > 0) specialSkillCooldown--;
    }

    // --- STAT RESET HELPERS (Ensures consistency after effects expire) ---
    
    public void resetAttack() { this.attack = baseAttack; }
    public void resetDefense() { this.defense = baseDefense; }

    // Getters & Setters
    public String getName() { return name; }
    public int getCurrHp() { return currHp; }
    public int getMaxHp() { return maxHp; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public int getSpeed() { return speed; }
    public boolean canAct() { return canAct; }
    public int getSpecialSkillCooldown() { return specialSkillCooldown; }
    
    public void setCurrHp(int hp) { this.currHp = Math.max(0, Math.min(maxHp, hp)); }
    public void setAttack(int attack) { this.attack = attack; }
    public void setDefense(int defense) { this.defense = defense; }
    public void setCanAct(boolean canAct) { this.canAct = canAct; }
    public void setInvulnerable(boolean inv) { this.invulnerable = inv; }
    public void setSpecialSkillCooldown(int cd) { this.specialSkillCooldown = cd; }
    
    public abstract boolean isPlayer();
    public abstract void takeTurn();
    public boolean isAlive() { return currHp > 0; }
}