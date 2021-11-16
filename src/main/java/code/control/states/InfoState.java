package code.control.states;

import code.control.command.Command;
import code.control.command.DoNothingCommand;
import code.control.command.states.MainMenuCommand;
import code.model.Menu;
import code.view.game.InfoViewer;
import code.view.gui.GUI;
import com.googlecode.lanterna.screen.TerminalScreen;

public class InfoState extends MenuState{
    private final InfoViewer infoViewer;

    public InfoState(Menu menu, InfoViewer infoViewer){
       super(menu);
       this.infoViewer = infoViewer;
    }

    @Override
    public void draw(TerminalScreen screen) {
        infoViewer.draw(screen);
    }

    @Override
    public Command getCommand(GUI.ACTION action) {
        if(action == GUI.ACTION.SELECT) return new MainMenuCommand();
        return new DoNothingCommand();
    }
}
