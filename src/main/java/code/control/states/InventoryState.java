package code.control.states;

import code.control.command.Command;
import code.control.command.DoNothingCommand;
import code.control.command.menu.nextMenuOption;
import code.control.command.menu.previousMenuOption;
import code.control.command.player.EquipToolCommand;
import code.control.command.states.ResumeGameCommand;
import code.model.elements.Hero;
import code.model.Menu;
import code.view.game.InventoryViewer;
import code.view.gui.GUI;
import com.googlecode.lanterna.screen.TerminalScreen;

public class InventoryState extends MenuState{

    private final InventoryViewer inventoryViewer;
    private final State oldState;
    private final Hero hero;

    public InventoryState(Menu menu, InventoryViewer inventoryViewer, GameState oldState){
        super(menu);
        this.inventoryViewer = inventoryViewer;
        this.oldState = oldState;
        this.hero = oldState.getCurrentIsland().getHero();
    }

    @Override
    public Command getCommand(GUI.ACTION action) {
        if (action == GUI.ACTION.UP) return new previousMenuOption(menu);
        if (action == GUI.ACTION.DOWN) return new nextMenuOption(menu);
        if (action == GUI.ACTION.SELECT) {
            int option = menu.getCurrentChoice();
            if(option == 0) return new ResumeGameCommand(oldState);
            else return new EquipToolCommand(menu);
        }
        return new DoNothingCommand();
    }

    @Override
    public void draw(TerminalScreen screen) {
        oldState.draw(screen);
        inventoryViewer.draw(screen,getMenu(),hero);
    }
}
