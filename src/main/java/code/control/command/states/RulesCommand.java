package code.control.command.states;

import code.control.Game;
import code.control.command.Command;
import code.control.states.RulesState;
import code.model.Menu;
import code.view.game.RulesViewer;

public class RulesCommand implements Command {
    @Override
    public void exec(Game game) {
        game.setState(new RulesState(new Menu(1), new RulesViewer()));
    }
}
