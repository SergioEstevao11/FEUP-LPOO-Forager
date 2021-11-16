package code.control.states;

import code.control.command.Command;
import code.model.Menu;
import code.view.gui.GUI;

public abstract class MenuState implements State{

    protected Menu menu;

    public MenuState(Menu menu){
        this.menu = menu;
    }

    @Override
    public abstract Command getCommand(GUI.ACTION action);

    public Menu getMenu(){
        return menu;
    }
}
