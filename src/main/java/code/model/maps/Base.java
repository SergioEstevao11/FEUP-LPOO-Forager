package code.model.maps;

import code.model.Position;
import code.model.elements.*;
import code.model.items.*;

import java.util.ArrayList;
import java.util.List;

public class Base extends Map {

    private final Vendor vendor;

    public Base(int x, int y, Hero hero){
        super(x, y, hero);

        boat = new Boat(40, 16);
        vendor = new Vendor(29, 18, vendorStockGenerator());
    }

    public Vendor getVendor(){
        return this.vendor;
    }


    private List<ItemGenerator> vendorStockGenerator(){
        List<ItemGenerator> stock = new ArrayList<>();

        List<Resource> recipe = new ArrayList<>();
        recipe.add(new Resource("wood"));
        stock.add(new WeaponGenerator(new Weapon("Wood Sword", 25, 5, recipe)));
        stock.add(new PickaxeGenerator(new Pickaxe("Wood Pickaxe", 50, 3, recipe)));
        recipe = new ArrayList<>();
        recipe.add(new Resource("rock", 10));
        recipe.add(new Resource("wood", 10));
        stock.add(new PickaxeGenerator(new Pickaxe("Pickstachio", 50, 8, recipe)));
        recipe = new ArrayList<>();
        recipe.add(new Resource("flesh", 12));
        recipe.add(new Resource("rock", 5));
        stock.add(new WeaponGenerator(new Weapon("BladeTongue", 50, 8, recipe)));
        recipe = new ArrayList<>();
        recipe.add(new Resource("flesh", 5));
        stock.add(new PotionGenerator(new Potion("Green Herb", 1, recipe)));
        return stock;
    }

    public boolean verifyVendorCollisions(Position heroPosition){
        return !vendor.getPosition().equals(heroPosition);
    }



    @Override
    public void createMargins() {

        for (int c = 0; c < 70; c++) {
            getMargins().add(new Water(c, 16));
            getMargins().add(new Water(c, 26));
        }

        for (int r = 0; r < 35; r++) {
            getMargins().add(new Water(24, r));
            getMargins().add(new Water(45, r));
        }

    }

    @Override
    public boolean canElementMove(Position position) {
        return verifyMarginCollisions(position) && verifyVendorCollisions(position);
    }
    @Override
    public void initHeroPos() {
        hero.setPosition(new Position(35, 20));
    }

    public void moveMonsters() {}
}
