package code.control.command.states;

import code.control.Game;
import code.control.command.Command;
import code.control.states.GameState;
import code.control.states.BuyShopState;
import code.control.states.State;
import code.model.Menu;
import code.view.game.BuyShopViewer;

public class BuyShopCommand implements Command {
    private final State oldState;

    public BuyShopCommand(State oldState){
        this.oldState = oldState;
    }

    @Override
    public void exec(Game game) {
        game.setState(new BuyShopState(new Menu(6), new BuyShopViewer(), (GameState) oldState));
    }
}
