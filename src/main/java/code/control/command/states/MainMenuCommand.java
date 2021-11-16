package code.control.command.states;

import code.control.Game;
import code.control.command.Command;
import code.control.states.MainMenuState;
import code.model.Menu;
import code.view.game.MainMenuViewer;

public class MainMenuCommand implements Command {
    @Override
    public void exec(Game game) {
        game.setState(new MainMenuState(new Menu(4), new MainMenuViewer()));
    }
}
