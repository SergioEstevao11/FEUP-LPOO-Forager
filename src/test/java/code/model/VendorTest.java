package code.model;

import code.model.items.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import code.model.elements.*;

import java.util.ArrayList;
import java.util.List;

public class VendorTest{
    
    @Test
    public void addItemTest(){
        Vendor vendor = new Vendor(10, 10, new ArrayList<>());
        List<Resource> recipe = new ArrayList<>();
        Weapon dawnBringer = new Weapon("Dawnbringer", 99, 99, recipe);
        ItemGenerator weapon = new WeaponGenerator(dawnBringer);
        
        vendor.addItem(weapon);

        Assertions.assertEquals(1, vendor.getInventory().size());
    }
    
    @Test
    public void craftingTest(){
        Vendor vendor = new Vendor(10, 10, new ArrayList<>());
        List<Resource> recipe = new ArrayList<>();
        Weapon dawnBringer = new Weapon("Dawnbringer", 99, 99, recipe);
        ItemGenerator Dawner = new WeaponGenerator(dawnBringer);
        
        vendor.addItem(Dawner);

        Assertions.assertEquals(vendor.craft(), dawnBringer);

        Pickaxe WoodPick = new Pickaxe("Wood Pickaxe", 25, 10, recipe);
        ItemGenerator Picker = new PickaxeGenerator(WoodPick);

        vendor.addItem(Picker);
        vendor.selectRight();

        Assertions.assertEquals(vendor.craft(), WoodPick);
    }
}