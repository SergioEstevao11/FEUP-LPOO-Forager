package code.control.command.player;

import code.control.Game;
import code.model.*;
import code.model.maps.Map;

public class MoveHeroLeft extends MoveHero{

    public MoveHeroLeft(Map map){
        super(map);
    }

    @Override
    public void exec(Game game){
        Position pos = map.getHero().moveLeft();
        checkMovement(pos);
    }
}
