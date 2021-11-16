package code.model.items;

import code.model.elements.Resource;

import java.util.List;

public abstract class Tool extends Item{

    private int durability;
    private int damage;

    public Tool(String name, int durability, int damage, List<Resource> recipe) {
        super(name, recipe);
        this.durability = durability;
        this.damage = damage;

    }



    public int getDurability() {
        return durability;
    }
    public void setDurability(int durability) {
        this.durability = durability;
    }
    public void changeDurability(int value) {
        setDurability(getDurability() + value);
    }


    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void doAction(){
        if (durability > 0) changeDurability(-1);
        if (durability == 0) {
            damage = 0;
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tool tool = (Tool) o;
        return getName().equals(tool.getName());
    }

}
