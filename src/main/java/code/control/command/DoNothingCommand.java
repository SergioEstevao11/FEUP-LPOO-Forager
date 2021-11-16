package code.control.command;

import code.control.Game;

public class DoNothingCommand implements Command {

    public DoNothingCommand(){}

    @Override
    public void exec(Game game) {}
}