package code.control.command.player;

import code.control.Game;
import code.control.command.Command;
import code.model.maps.Map;

public class SwitchToolsCommand implements Command {
    private final Map map;
    public SwitchToolsCommand(Map map){
        this.map = map;
    }

    @Override
    public void exec(Game game) {
            map.getHero().getInventory().switchTools();
    }
}
