package code.control.command.player;

import code.control.Game;
import code.model.*;
import code.model.maps.Map;

public class MoveHeroRight extends MoveHero{
    public MoveHeroRight(Map map){
        super(map);
    }

    @Override
    public void exec(Game game){
        Position pos = map.getHero().moveRight();
        checkMovement(pos);
    }
}
