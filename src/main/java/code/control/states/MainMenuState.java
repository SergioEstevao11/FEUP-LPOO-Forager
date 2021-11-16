package code.control.states;

import code.control.command.Command;
import code.control.command.*;
import code.control.command.menu.*;
import code.control.command.states.InfoCommand;
import code.control.command.states.RulesCommand;
import code.control.command.states.StartGameCommand;
import code.model.Menu;
import code.view.game.MainMenuViewer;
import code.view.gui.GUI;
import com.googlecode.lanterna.screen.TerminalScreen;

public class MainMenuState extends MenuState{
    private final MainMenuViewer mainMenuViewer;

    public MainMenuState(Menu menu, MainMenuViewer mainMenuViewer){
        super(menu);
        this.mainMenuViewer = mainMenuViewer;
    }

    @Override
    public Command getCommand(GUI.ACTION action) {
        if (action == GUI.ACTION.UP) return new previousMenuOption(menu);
        if (action == GUI.ACTION.DOWN) return new nextMenuOption(menu);
        if (action == GUI.ACTION.SELECT){
            int option = menu.getCurrentChoice();
            if(option == 0) return new StartGameCommand();
            if(option == 1) return new RulesCommand();
            if(option == 2) return new InfoCommand();
            if(option == 3) return new EndProgramCommand();
        }
        return new DoNothingCommand();
    }

    @Override
    public void draw(TerminalScreen screen) {
        mainMenuViewer.draw(screen,getMenu());
    }

}
