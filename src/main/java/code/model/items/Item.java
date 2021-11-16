package code.model.items;

import code.model.elements.Resource;
import java.util.List;

public class Item {
    private final String name;
    private final List<Resource> recipe;

    public Item(String name, List<Resource> recipe){
        this.name = name;
        this.recipe = recipe;
    }

    public String getName() {
        return name;
    }

    public List<Resource> getRecipe() {
        return recipe;
    }
}
