package code.control.states;

import code.control.command.Command;
import code.control.command.DoNothingCommand;
import code.control.command.states.MainMenuCommand;
import code.model.Menu;
import code.view.game.DeathMenuViewer;
import code.view.gui.GUI;
import com.googlecode.lanterna.screen.TerminalScreen;

public class DeathState extends MenuState{
    private final DeathMenuViewer deathMenuViewer;
    private final State oldState;
    public DeathState(Menu menu, DeathMenuViewer deathMenuViewer, State oldState){
        super(menu);
        this.deathMenuViewer = deathMenuViewer;
        this.oldState = oldState;
    }

    @Override
    public Command getCommand(GUI.ACTION action) {
        if (action == GUI.ACTION.SELECT){
            return new MainMenuCommand();
        }
        return new DoNothingCommand();
    }

    @Override
    public void draw(TerminalScreen screen) {
        oldState.draw(screen);
        deathMenuViewer.draw(screen);
    }

}
