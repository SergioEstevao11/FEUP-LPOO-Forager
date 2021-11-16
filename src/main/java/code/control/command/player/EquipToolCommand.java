package code.control.command.player;

import code.control.Game;
import code.control.command.Command;
import code.model.items.Item;
import code.model.items.Potion;
import code.model.Menu;

public class EquipToolCommand implements Command {
    private final Menu menu;
    public EquipToolCommand(Menu menu){
        this.menu = menu;
    }
    @Override
    public void exec(Game game) {
        Item selectedItem = game.getHero().getInventory().getItems().get(menu.getCurrentChoice()-1);
        if(selectedItem instanceof Potion){
            menu.decreaseOptions();
        }
        game.getHero().useItem(selectedItem);
    }
}
