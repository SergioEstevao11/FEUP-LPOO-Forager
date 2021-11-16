package code.model.items;

import code.model.elements.Resource;

import java.util.List;

public interface ItemGenerator {
    List<Resource> getRecipe();
    String getName();
    Item generator();
}
