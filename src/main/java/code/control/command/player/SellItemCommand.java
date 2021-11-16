package code.control.command.player;

import code.control.Game;
import code.control.command.Command;


public class SellItemCommand implements Command {

    private final int option;

    public SellItemCommand( int option){
        this.option = option;
    }

    @Override
    public void exec(Game game) {
        game.getHero().getInventory().sellItem(game.getHero().getInventory().getItems().get(option));
    }
}