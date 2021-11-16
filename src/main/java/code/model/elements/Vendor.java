package code.model.elements;

import code.model.items.*;
import code.model.items.ItemGenerator;

import java.util.List;

public class Vendor extends Element {

    private final List<ItemGenerator> items;
    int itemSelected;

    public Vendor(int x, int y, List<ItemGenerator> items){
        super(x, y);
        this.items = items;
        itemSelected = 0;
    }

    public void addItem(ItemGenerator newItem){
        items.add(newItem);
    }

    public List<ItemGenerator> getInventory(){
        return this.items;
    }


    public Item craft(){
        return items.get(itemSelected).generator();
    }

    public void selectRight(){
        if (itemSelected < items.size() - 1)
            itemSelected++;
    }

}