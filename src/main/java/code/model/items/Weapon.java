package code.model.items;

import code.model.elements.Resource;

import java.util.List;

public class Weapon extends Tool {
    public Weapon(String n, int dur, int dmg, List<Resource> rcp){
        super(n, dur, dmg, rcp);
    }

}
