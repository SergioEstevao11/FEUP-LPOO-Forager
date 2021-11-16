package code.control.command.states;

import code.control.Game;
import code.control.command.Command;
import code.control.states.State;
import code.control.states.TravelMenuState;
import code.model.elements.Monster;
import code.model.Menu;
import code.view.game.TravelMenuViewer;

import java.util.List;

public class TravelMenuCommand implements Command {
    private final State oldState;
    private final List<Monster> monsters;
    public TravelMenuCommand(State oldState, List<Monster> monsters){
        this.oldState = oldState;
        this.monsters = monsters;
    }

    @Override
    public void exec(Game game) {
        game.setState(new TravelMenuState(new Menu(3), new TravelMenuViewer(), oldState, monsters));
    }
}