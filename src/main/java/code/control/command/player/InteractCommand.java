package code.control.command.player;

import code.control.Game;
import code.control.command.Command;
import code.control.command.states.ShopCommand;
import code.control.command.states.TravelMenuCommand;
import code.model.elements.Hero;
import code.model.maps.Base;
import code.model.maps.Map;

public class InteractCommand implements Command {
    Map map;
    public InteractCommand(Map map){
        this.map = map;
    }

    @Override
    public void exec(Game game) {
        Hero h = map.getHero();
        if (map instanceof Base){
            Base b = (Base) map;
            if (h.inRange(b.getVendor().getPosition())){
                new ShopCommand(game.getState()).exec(game);
            }
        }
        if(h.inRange(map.getBoat().getPosition())){
            new TravelMenuCommand(game.getState(),map.getMonsters()).exec(game);
        }

    }
}