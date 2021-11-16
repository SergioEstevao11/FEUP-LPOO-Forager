package code.control.command.states;

import code.control.Game;
import code.control.command.Command;
import code.control.states.PauseMenuState;
import code.control.states.State;
import code.model.Menu;
import code.view.game.PauseMenuViewer;

public class PauseMenuCommand implements Command {
    private final State oldState;

    public PauseMenuCommand(State oldState){
        this.oldState = oldState;
    }

    @Override
    public void exec(Game game) {
        game.setState(new PauseMenuState(new Menu(2), new PauseMenuViewer(), oldState));
    }
}
