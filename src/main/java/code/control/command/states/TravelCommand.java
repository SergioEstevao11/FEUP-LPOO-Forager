package code.control.command.states;

import code.control.Game;
import code.control.command.Command;
import code.control.states.GameState;
import code.control.states.State;

public class TravelCommand implements Command {

    private final State state;
    public TravelCommand(State state){
        this.state = state;
    }
    @Override
    public void exec(Game game) {
        ((GameState)state).travel();
        new ResumeGameCommand(state).exec(game);
    }
}
