package code.control.command.states;

import code.control.Game;
import code.control.command.Command;
import code.control.states.GameState;
import code.control.states.InventoryState;
import code.control.states.State;
import code.model.Menu;
import code.view.game.InventoryViewer;


public class InventoryMenuCommand implements Command {

    private final State oldState;

    public InventoryMenuCommand(State oldState){
        this.oldState = oldState;
    }

    @Override
    public void exec(Game game) {
        int numTools = game.getHero().getInventory().getItems().size();
        game.setState(new InventoryState(new Menu(1+numTools), new InventoryViewer(), (GameState) oldState));
    }
}
