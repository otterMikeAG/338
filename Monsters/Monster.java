package Monsters;

import Abilities.Attack;

import java.util.HashMap;
import java.util.Random;

public abstract class Monster {
    private Integer hp;
    private Integer xp;
    private Integer maxHP;
    private HashMap<String, Integer> items;
    Integer agi = 0;
    Integer def = 0;
    Integer str = 0;
    Attack attack;

    public Monster(Integer maxHP, Integer xp, HashMap<String, Integer> items) {
        this.maxHP = maxHP;
        hp = this.maxHP;
        this.xp = xp;
        this.items = items;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public HashMap<String, Integer> getItems() {
        return items;
    }

    public void setItems(HashMap<String, Integer> items) {
        this.items = items;
    }

    public Integer getXp() {
        return xp;
    }

    public Integer getMaxHP() {
        return maxHP;
    }

    @Override
    public String toString(){
        return "hp = " + getHp() + "/" + getMaxHP();
    }

    @Override
    public boolean equals(Object other) {
        if(other instanceof Monster) {
            Monster monster = (Monster)other;
            if(this.hp.equals(monster.hp)
                    && this.xp.equals(monster.xp)
                    && this.maxHP.equals(monster.maxHP)
                    && this.items.equals(monster.items)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public Integer attackTarget(Monster o) {
        return attack.attack(o);
    }

    public Integer getAgi() { return agi; }

    public Integer getDef() { return def; }

    public Integer getStr() { return str; }

    public Integer getAttribute(Integer min, Integer max) {
        Random rand = new Random();
        if (min > max) {
            Integer temp = max;
            min = max;
            max = temp;
        }
        //retruns a random number between min and max inclusive.
        return rand.nextInt(max-min) + min;
    }
}
