package code.model.items;

import code.model.elements.Resource;

import java.util.List;

public class WeaponGenerator implements ItemGenerator {

    private final Weapon weapon;

    public WeaponGenerator(Weapon w){
        weapon = w;
    }

    @Override
    public List<Resource> getRecipe() {
        return weapon.getRecipe();
    }

    @Override
    public String getName() {
        return weapon.getName();
    }

    @Override
    public Weapon generator() {
        return new Weapon(getName(), weapon.getDurability(), weapon.getDamage(), getRecipe());
    }
}