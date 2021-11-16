package code.model.elements;

import code.model.items.*;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private final int maxNumItems;
    private final List<Resource> resources;
    private List<Item> items;

    private Weapon currentWeapon;
    private Pickaxe currentPickaxe;
    private Tool equippedTool;

    public Tool getEquippedTool() {
        return equippedTool;
    }

    public Inventory(){
        maxNumItems = 5;
        resources = new ArrayList<>();
        items = new ArrayList<>();

        List<Resource> recipe = new ArrayList<>();
        recipe.add(new Resource("wood", 2));
        currentPickaxe = new Pickaxe("Wooden Pickaxe", 20, 3, recipe);
        currentWeapon = new Weapon ("Toy Sword", 20, 1, recipe);

        items.add(currentPickaxe);
        items.add(currentWeapon);
        this.equippedTool = currentPickaxe;
    }

    public void equipTool(Tool tool){
        if(tool instanceof Weapon){
            this.currentWeapon = (Weapon)tool;
        }
        else{
            this.currentPickaxe = (Pickaxe)tool;
        }
        updateCurrentWeapon();
    }

    private void updateCurrentWeapon(){
        if (equippedTool instanceof Pickaxe)
            equippedTool = currentPickaxe;
        else
            equippedTool = currentWeapon;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public Resource findResource(Resource resource){
        for (Resource r : resources)
            if (r.equals(resource))
                return r;

        return null;
    }

    public void addResource(Resource resource) {
        if (!resources.contains(resource))
            resources.add(resource);
        else {
            Resource r = this.findResource(resource);
            r.changeQuantity(resource.getQuantity());
        }
    }

    public void removeResource(Resource resource) {

        Resource heroResource = findResource(resource);
        heroResource.changeQuantity(-resource.getQuantity());

        if (heroResource.getQuantity() == 0) {
            resources.remove(findResource(resource));
        }
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void buyItem(ItemGenerator ig) {
        List<Resource> receipt = ig.getRecipe();
        if (items.size() < maxNumItems){
            for (Resource r : receipt) {
                if (resources.contains(r)) {
                    if (r.getQuantity() > findResource(r).getQuantity())
                        return;
                }
                else return;
            }
            for (Resource r : receipt) {
                removeResource(r);
            }
            items.add(ig.generator());
        }
    }

    public void sellItem(Item t) {
        items.remove(t);
        if (currentWeapon == t){
            currentWeapon = new Weapon("Fist", -1, 1, new ArrayList<>());
        }
        else if(currentPickaxe == t){
            currentPickaxe = new Pickaxe("Fist", -1, 1, new ArrayList<>());
        }
        updateCurrentWeapon();
        boolean resourceFound = false;
        for(Resource res : t.getRecipe()) {
            for(Resource res2 : resources){
                if(res2.equals(res)){
                    res2.changeQuantity(res.getQuantity() / 2);
                    resourceFound = true;
                }
            }
            if(!resourceFound)
                resources.add(new Resource(res.getName(), res.getQuantity()/2));
            resourceFound = false;
        }
    }

    public Pickaxe getPickaxe() {
        return currentPickaxe;
    }

    public Weapon getWeapon() {
        return currentWeapon;
    }

    public void checkCurrentToolDurability(){
        if (equippedTool.getDurability() == 0) {
            items.remove(equippedTool);
            equipUnarmed();
        }
    }

    private void equipUnarmed(){
        if (equippedTool instanceof Weapon) {
            currentWeapon = new Weapon("Fist", -1, 1, new ArrayList<>());
            equippedTool = currentWeapon;
        }
        else {
            currentPickaxe = new Pickaxe("Fist", -1, 1, new ArrayList<>());
            equippedTool = currentPickaxe;
        }
    }

    public void switchTools() {
        if (equippedTool instanceof Pickaxe) equippedTool = currentWeapon;
        else equippedTool = currentPickaxe;
    }
}
