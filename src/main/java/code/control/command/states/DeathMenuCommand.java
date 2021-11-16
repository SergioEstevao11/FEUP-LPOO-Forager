package code.control.command.states;

import code.control.Game;
import code.control.command.Command;
import code.control.states.DeathState;
import code.control.states.State;
import code.model.Menu;
import code.view.game.DeathMenuViewer;

public class DeathMenuCommand implements Command {
    private final State oldState;
    public DeathMenuCommand(State oldState){
        this.oldState = oldState;
    }

    @Override
    public void exec(Game game) {
        game.setState(new DeathState(new Menu(1), new DeathMenuViewer(),oldState));
    }
}
