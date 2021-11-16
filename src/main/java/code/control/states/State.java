package code.control.states;

import code.control.command.Command;
import code.view.gui.GUI;
import com.googlecode.lanterna.screen.TerminalScreen;

public interface State {
    Command getCommand(GUI.ACTION action);
    void draw(TerminalScreen screen);
}
