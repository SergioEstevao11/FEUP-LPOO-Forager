package code.control.command.player;

import code.control.Game;
import code.model.maps.Map;
import code.model.Position;

public class MoveHeroDown extends MoveHero{
    public MoveHeroDown(Map map){
        super(map);
    }

    @Override
    public void exec(Game game){
        Position pos = map.getHero().moveDown();
        checkMovement(pos);
    }
}
