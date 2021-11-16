package code.control.command;

import code.control.Game;

public class EndProgramCommand implements Command {

    public EndProgramCommand(){}

    @Override
    public void exec(Game game) {
        game.stopRunning();
    }
}