package code.model.items;

import code.model.elements.Resource;

import java.util.List;

public class Potion extends Item{
    private final int healing;

    public Potion(String name, int healing, List<Resource> recipe){
        super(name, recipe);
        this.healing = healing;
    }

    public int getHealing() {
        return healing;
    }
}
