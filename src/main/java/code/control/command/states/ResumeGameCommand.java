package code.control.command.states;

import code.control.Game;
import code.control.command.Command;
import code.control.states.State;

public class ResumeGameCommand implements Command {
    private final State state;
    public ResumeGameCommand(State state){
        this.state = state;
    }


    @Override
    public void exec(Game game) {
        game.setState(state);
    }
}
