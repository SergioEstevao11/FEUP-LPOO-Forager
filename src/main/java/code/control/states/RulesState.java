package code.control.states;

import code.control.command.Command;
import code.control.command.DoNothingCommand;
import code.control.command.states.MainMenuCommand;
import code.model.Menu;
import code.view.game.RulesViewer;
import code.view.gui.GUI;
import com.googlecode.lanterna.screen.TerminalScreen;

public class RulesState extends MenuState{

    private final RulesViewer rulesViewer;

    public RulesState(Menu menu, RulesViewer rulesViewer){
        super(menu);
        this.rulesViewer = rulesViewer;
    }

    @Override
    public Command getCommand(GUI.ACTION action) {
        if(action == GUI.ACTION.SELECT) return new MainMenuCommand();
        return new DoNothingCommand();
    }

    @Override
    public void draw(TerminalScreen screen) {
        rulesViewer.draw(screen);
    }
}
