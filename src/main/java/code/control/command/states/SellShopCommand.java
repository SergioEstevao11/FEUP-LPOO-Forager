package code.control.command.states;

import code.control.Game;
import code.control.command.Command;
import code.control.states.GameState;
import code.control.states.SellShopState;
import code.control.states.State;
import code.model.Menu;
import code.view.game.SellShopViewer;

public class SellShopCommand implements Command {
    private final State oldState;

    public SellShopCommand(State oldState){
        this.oldState = oldState;
    }

    @Override
    public void exec(Game game) {
        game.setState(new SellShopState(new Menu(game.getHero().getInventory().getItems().size() + 1),
                                        new SellShopViewer(),
                                        (GameState) oldState));
    }
}
