package code.control.states;

import code.control.command.Command;
import code.control.command.DoNothingCommand;
import code.control.command.menu.nextMenuOption;
import code.control.command.menu.previousMenuOption;
import code.control.command.states.MainMenuCommand;
import code.control.command.states.ResumeGameCommand;
import code.model.Menu;
import code.view.game.PauseMenuViewer;
import code.view.gui.GUI;
import com.googlecode.lanterna.screen.TerminalScreen;

public class PauseMenuState extends MenuState {
    private final State oldState;
    private final PauseMenuViewer pauseMenuViewer;
    public PauseMenuState(Menu menu, PauseMenuViewer pauseMenuViewer, State oldState){
        super(menu);
        this.pauseMenuViewer = pauseMenuViewer;
        this.oldState = oldState;
    }

    @Override
    public Command getCommand(GUI.ACTION action) {
        if (action == GUI.ACTION.UP) return new previousMenuOption(menu);
        if (action == GUI.ACTION.DOWN) return new nextMenuOption(menu);
        if (action == GUI.ACTION.SELECT){
            int option = menu.getCurrentChoice();
            if(option == 0) return new ResumeGameCommand(oldState);
            if(option == 1) return new MainMenuCommand();
        }
        return new DoNothingCommand();
    }

    @Override
    public void draw(TerminalScreen screen) {
        oldState.draw(screen);
        pauseMenuViewer.draw(screen, getMenu());
    }

    public State getOldState() {
        return oldState;
    }
}
