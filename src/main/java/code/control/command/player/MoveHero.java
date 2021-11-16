package code.control.command.player;
import code.control.command.Command;
import code.model.*;
import code.model.elements.Hero;
import code.model.maps.Base;
import code.model.maps.Island;
import code.model.maps.Map;

public abstract class MoveHero implements Command {
    protected Map map;

    public MoveHero(Map map){
        this.map = map;
    }

    public void checkMovement(Position pos){
        Hero hero = map.getHero();

        if (map instanceof Base){
            Base b = (Base) map;
            if (b.canElementMove(pos))
                hero.setPosition(pos);
        }
        else {
            Island i = (Island) map;
            if (map.canElementMove(pos)) {
                hero.setPosition(pos);

                if (!i.verifyMonsterCollisions(hero.getPosition())) {
                    hero.changeHp(-1);
                }
            }
        }

    }

}