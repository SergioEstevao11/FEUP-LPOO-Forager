package code.control.command.menu;

import code.control.Game;
import code.control.command.Command;
import code.model.Menu;

public class previousMenuOption implements Command {//TODO
    private final Menu menu;

    public previousMenuOption(Menu menu){
        this.menu = menu;
    }


    @Override
    public void exec(Game game) {
        menu.previousOption();
    }
}
