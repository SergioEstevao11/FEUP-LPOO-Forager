package code.control.command.states;

import code.control.Game;
import code.control.command.Command;
import code.control.states.GameState;
import code.view.game.IslandViewer;

public class StartGameCommand implements Command {
    @Override
    public void exec(Game game) {
        game.resetLevelProgression();
        game.setState(new GameState(new IslandViewer(), game.getLevelProgression()));
    }
}
