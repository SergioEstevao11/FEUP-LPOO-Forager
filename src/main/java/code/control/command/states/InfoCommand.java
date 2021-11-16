package code.control.command.states;

import code.control.Game;
import code.control.command.Command;
import code.control.states.InfoState;
import code.model.Menu;
import code.view.game.InfoViewer;

public class InfoCommand implements Command {
    @Override
    public void exec(Game game) {
        game.setState(new InfoState(new Menu(1), new InfoViewer()));
    }
}
