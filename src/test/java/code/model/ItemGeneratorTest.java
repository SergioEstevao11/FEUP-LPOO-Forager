package code.model;

import code.model.elements.Resource;
import code.model.items.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class ItemGeneratorTest {
    @Test
    public void createItemGeneratorsTest() {
        List<Resource> recipe = new ArrayList<>();
        Resource r1 = new Resource("wood", 2);
        Resource r2 = new Resource("flesh", 2);
        recipe.add(r1);
        recipe.add(r2);

        Potion potion = new Potion("Potion", 1, recipe);
        PotionGenerator potionGenerator = new PotionGenerator(potion);
        Assertions.assertEquals(potionGenerator.generator().getName(), potion.getName());
        Assertions.assertEquals(potionGenerator.generator().getRecipe(), potion.getRecipe());
        Assertions.assertEquals(potionGenerator.generator().getHealing(), potion.getHealing());

        Pickaxe pickaxe = new Pickaxe("Pickaxe", 30, 1, recipe);
        PickaxeGenerator pickaxeGenerator = new PickaxeGenerator(pickaxe);
        Assertions.assertEquals(pickaxeGenerator.generator().getName(), pickaxe.getName());
        Assertions.assertEquals(pickaxeGenerator.generator().getDurability(), pickaxe.getDurability());
        Assertions.assertEquals(pickaxeGenerator.generator().getDamage(), pickaxe.getDamage());
        Assertions.assertEquals(pickaxeGenerator.generator().getRecipe(), pickaxe.getRecipe());


        Weapon weapon = new Weapon("Weapon", 35, 2, recipe);
        WeaponGenerator weaponGenerator = new WeaponGenerator(weapon);
        Assertions.assertEquals(weaponGenerator.generator().getName(), weapon.getName());
        Assertions.assertEquals(weaponGenerator.generator().getDurability(), weapon.getDurability());
        Assertions.assertEquals(weaponGenerator.generator().getDamage(), weapon.getDamage());
    }

    @Test
    public void  blah() {

    }
}
