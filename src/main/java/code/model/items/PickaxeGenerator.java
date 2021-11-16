package code.model.items;

import code.model.elements.Resource;

import java.util.List;

public class PickaxeGenerator implements ItemGenerator {

    private final Pickaxe pickaxe;

    public PickaxeGenerator(Pickaxe pickaxe){
        this.pickaxe = pickaxe;
    }

    @Override
    public List<Resource> getRecipe() {
        return pickaxe.getRecipe();
    }

    @Override
    public String getName() {
        return pickaxe.getName();
    }

    @Override
    public Pickaxe generator() {
        return new Pickaxe(getName(), pickaxe.getDurability(), pickaxe.getDamage(), getRecipe());
    }
}
