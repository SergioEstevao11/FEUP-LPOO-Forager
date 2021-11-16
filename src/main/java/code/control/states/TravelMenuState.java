package code.control.states;

import code.control.command.Command;
import code.control.command.DoNothingCommand;
import code.control.command.menu.nextMenuOption;
import code.control.command.menu.previousMenuOption;
import code.control.command.states.RecallCommand;
import code.control.command.states.ResumeGameCommand;
import code.control.command.states.TravelCommand;
import code.model.elements.Monster;
import code.model.Menu;
import code.view.game.TravelMenuViewer;
import code.view.gui.GUI;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.util.List;

public class TravelMenuState extends MenuState{
    private final State oldState;
    private final TravelMenuViewer travelMenuViewer;
    private final List<Monster> monsters;

    public TravelMenuState(Menu menu, TravelMenuViewer travelMenuViewer, State oldState, List<Monster> monsters) {
        super(menu);
        this.travelMenuViewer = travelMenuViewer;
        this.oldState = oldState;
        this.monsters = monsters;
    }


    @Override
    public Command getCommand(GUI.ACTION action) {
        if (action == GUI.ACTION.UP) return new previousMenuOption(menu);
        if (action == GUI.ACTION.DOWN) return new nextMenuOption(menu);
        if (action == GUI.ACTION.SELECT){
            int option = menu.getCurrentChoice();
            if(option == 0){
                if(monsters.size() == 0)
                    return new TravelCommand(oldState);
            }
            if(option == 1) return new RecallCommand(oldState);
            if(option == 2) return new ResumeGameCommand(oldState);
        }
        return new DoNothingCommand();
    }

    @Override
    public void draw(TerminalScreen screen) {
        oldState.draw(screen);
        travelMenuViewer.draw(screen, getMenu());
    }
}