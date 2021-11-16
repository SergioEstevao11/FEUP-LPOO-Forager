package code.model;

import code.model.elements.Hero;
import code.model.elements.Monster;
import code.model.elements.Resource;
import code.model.elements.Vendor;
import code.model.items.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class HeroTest {
    @Test
    public void createHeroTest() {
        Hero hero = new Hero(5 ,5);

        Assertions.assertEquals(hero.getPosition(), new Position(5, 5));
        Assertions.assertEquals(hero.getFrameCounter(), 0);
        Assertions.assertEquals(hero.getDirection(), "up");
        Assertions.assertFalse(hero.getDead());
        Assertions.assertEquals(hero.getInventory().getResources().size(), 0);
        Assertions.assertEquals(hero.getInventory().getPickaxe().getName(), "Wooden Pickaxe");
        Assertions.assertEquals(hero.getInventory().getWeapon().getName(), "Toy Sword");
        Assertions.assertEquals(hero.getInventory().getEquippedTool(), hero.getInventory().getPickaxe());
    }

    @Test
    public void heroSetterAndGettersTest() {

        Hero hero = new Hero(5,5);

        // String direction;
        Assertions.assertEquals(hero.getDirection(), "up");
        hero.setDirection("down");
        Assertions.assertEquals(hero.getDirection(), "down");

        // boolean dead;
        Assertions.assertFalse(hero.getDead());
        hero.setDead(true);
        Assertions.assertTrue(hero.getDead());

        // int frameCounter;
        Assertions.assertEquals(hero.getFrameCounter(), 0);
        hero.changeFrameCounter(2);
        Assertions.assertEquals(hero.getFrameCounter(), 2);

        // boolean attackAction;
        Assertions.assertFalse(hero.getAttackAction());
        hero.setAttackAction(true);
        Assertions.assertTrue(hero.getAttackAction());

        // List<Resource> backpack;
        Assertions.assertEquals(hero.getInventory().getResources().size(), 0);
        Resource wool = new Resource("wool", 5);
        hero.getInventory().addResource(wool);
        Assertions.assertEquals(hero.getInventory().getResources().size(), 1);
        Assertions.assertEquals(hero.getInventory().findResource(wool), new Resource("wool"));
        hero.getInventory().addResource(wool);
        Assertions.assertEquals(hero.getInventory().getResources().size(), 1);
        Assertions.assertEquals(hero.getInventory().findResource(wool).getQuantity(), 10);
        hero.getInventory().removeResource(new Resource ("wool", 10));
        Assertions.assertEquals(hero.getInventory().getResources().size(), 0);

        // List<Tool> tools;
        Assertions.assertEquals(hero.getInventory().getItems().size(), 2);

        List<Item> newItems = new ArrayList<>();
        hero.getInventory().setItems(newItems);
        Assertions.assertEquals(hero.getInventory().getItems(), newItems);

        List<Resource> a = new ArrayList<>();
        a.add(new Resource("wood", 10));
        Pickaxe pickaxe = new Pickaxe("hammer", 30, 2, a);
        hero.getInventory().getItems().add(pickaxe);
        Assertions.assertEquals(hero.getInventory().getItems().size(), 1);

        hero.getInventory().equipTool(pickaxe);
        Assertions.assertEquals(hero.getInventory().getPickaxe(), pickaxe);

        hero.getInventory().sellItem(pickaxe);
        Assertions.assertEquals(hero.getInventory().getItems().size(), 0);

        Potion potion = new Potion("Healing", 1, new ArrayList<>());
        hero.getInventory().getItems().add(potion);
        hero.useItem(potion);
        Assertions.assertEquals(hero.getInventory().getItems().size(), 0);
        Assertions.assertEquals(hero.getInventory().getResources().size(), 1);

        hero.getInventory().getItems().add(pickaxe);
        hero.getInventory().equipTool(pickaxe);

        // Pickaxe pickaxe;
        Assertions.assertEquals(hero.getInventory().getPickaxe(), pickaxe);
        Pickaxe p = new Pickaxe("Plak", 50, 2, new ArrayList<>());
        hero.getInventory().getItems().add(p);
        hero.getInventory().equipTool(p);
        if (hero.getInventory().getEquippedTool().getClass()  == Weapon.class)
            hero.getInventory().switchTools();
        Assertions.assertEquals(hero.getInventory().getPickaxe(), p);

        // Weapon weapon;
        Assertions.assertEquals(hero.getInventory().getWeapon(), new Weapon("Toy Sword", 20, 1, new ArrayList<>()));
        Weapon w = new Weapon("Long Claw", 150, 3, new ArrayList<>());
        hero.getInventory().getItems().add(w);
        hero.getInventory().equipTool(w);
        if (hero.getInventory().getEquippedTool().getClass() == Pickaxe.class)
            hero.getInventory().switchTools();
        Assertions.assertEquals(hero.getInventory().getWeapon(), w);

        // Tool currentTool;
        Assertions.assertEquals(hero.getInventory().getEquippedTool(), hero.getInventory().getWeapon());
        hero.getInventory().switchTools();
        Assertions.assertEquals(hero.getInventory().getEquippedTool(), hero.getInventory().getPickaxe());
    }

    @Test
    public void heroMoveTest(){
        Hero hero = new Hero(0, 0);

        hero.setPosition(hero.moveDown());

        Assertions.assertEquals(new Position(0,1) , hero.getPosition());
        Assertions.assertEquals("down", hero.getDirection());

        hero.setPosition(hero.moveDown());
        hero.setPosition(hero.moveRight());

        Assertions.assertEquals(new Position(1,2) , hero.getPosition());
        Assertions.assertEquals("right", hero.getDirection());

        hero.setPosition(hero.moveUp());
        hero.setPosition(hero.moveRight());

        Assertions.assertEquals(new Position(2,1) , hero.getPosition());
        Assertions.assertEquals("right", hero.getDirection());

        hero.setPosition(hero.moveLeft());
        hero.setPosition(hero.moveLeft());

        Assertions.assertEquals(new Position(0,1), hero.getPosition());
        Assertions.assertEquals("left", hero.getDirection());

        hero.setPosition(hero.moveUp());

        Assertions.assertEquals(new Position(0,0), hero.getPosition());
        Assertions.assertEquals("up", hero.getDirection());
    }

    @Test
    public void heroBuyToolTest() {
        Hero hero = new Hero(5, 5);

        Resource wood = new Resource("wood", 5);
        Resource stone = new Resource("rock", 2);

        hero.getInventory().addResource(wood);
        hero.getInventory().addResource(stone);

        Assertions.assertEquals(hero.getInventory().getResources().size(), 2);
        Assertions.assertEquals(hero.getInventory().getItems().size(), 2);

        List<Resource> recipe = new ArrayList<>();
        recipe.add(wood);
        recipe.add(stone);

        Pickaxe excalibur = new Pickaxe("excalibur", 200, 15, recipe);
        ItemGenerator excaliburGenerator = new PickaxeGenerator(excalibur);

        hero.getInventory().buyItem(excaliburGenerator);

        Assertions.assertEquals(hero.getInventory().getItems().size(), 3);
    }

    @Test
    public void heroVendorInteractionTest(){
        Hero hero = new Hero(10, 10);
        Vendor vendor = new Vendor(8, 10, new ArrayList<>());

        hero.setPosition(hero.moveLeft());

        Assertions.assertTrue(hero.inRange(vendor.getPosition()));
    }

    @Test
    public void heroDoDamageTest() {

        Hero hero = new Hero(5,5);
        Monster monster = new Monster(5, 5, 1, new Resource("air"));

        hero.getInventory().getWeapon().setDurability(1);
        hero.getInventory().getWeapon().setDamage(1);

        if (hero.getInventory().getEquippedTool().getClass() == Pickaxe.class)
            hero.getInventory().switchTools();

        hero.doDamage(monster);

        Assertions.assertEquals(hero.getInventory().getEquippedTool(), new Weapon("Fist", -1, 1, new ArrayList<>()));
    }

    @Test
    public void heroChangeHpTest() {
        Hero hero = new Hero(5, 5);
        Assertions.assertEquals(hero.getHp(), 3);
        hero.changeHp(-1);
        Assertions.assertEquals(hero.getHp(), 2);
        Assertions.assertFalse(hero.getDead());
        hero.changeHp(-2);
        Assertions.assertTrue(hero.getDead());
    }
}
