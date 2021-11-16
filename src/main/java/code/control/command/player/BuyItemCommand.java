package code.control.command.player;

import code.control.Game;
import code.control.command.Command;
import code.model.elements.Vendor;


public class BuyItemCommand implements Command {

    private final Vendor vendor;
    private final int option;

    public BuyItemCommand(Vendor vendor, int option){
        this.vendor = vendor;
        this.option = option;
    }

    @Override
    public void exec(Game game) {
        game.getHero().getInventory().buyItem(vendor.getInventory().get(option-1));
    }
}