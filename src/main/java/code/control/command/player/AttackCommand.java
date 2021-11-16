package code.control.command.player;

import code.control.Game;
import code.control.command.Command;
import code.model.maps.Map;

public class AttackCommand implements Command {
    private final Map map;
    public AttackCommand(Map map){
        this.map = map;
    }
    @Override
    public void exec(Game game) {
        //map.checkAttack
        game.getHero().setAttackAction(true);
        map.checkHeroAttack();
    }


}
