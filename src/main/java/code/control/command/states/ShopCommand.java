package code.control.command.states;

import code.control.Game;
import code.control.command.Command;
import code.control.states.GameState;
import code.control.states.ShopState;
import code.control.states.State;
import code.model.Menu;
import code.view.game.ShopViewer;

public class ShopCommand implements Command {
    private final State oldState;

    public ShopCommand(State oldState){
        this.oldState = oldState;
    }

    @Override
    public void exec(Game game) {
        game.setState(new ShopState(new Menu(3), new ShopViewer(), (GameState) oldState));
    }
}
