package code.model.items;

import code.model.elements.Resource;

import java.util.List;

public class PotionGenerator implements ItemGenerator {

    private final Potion potion;

    public PotionGenerator(Potion potion){
        this.potion = potion;
    }

    @Override
    public List<Resource> getRecipe() {
        return potion.getRecipe();
    }

    @Override
    public String getName() {
        return potion.getName();
    }

    @Override
    public Potion generator() {
        return new Potion(getName(), potion.getHealing(), getRecipe());
    }
}
