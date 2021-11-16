package code.view.gui;

import code.control.states.State;
import code.model.Position;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public interface GUI {
    void clear();
    KeyStroke pollKey() throws IOException;
    void close() throws IOException;
    void draw(State state) throws IOException;
    GUI.ACTION getAction() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT, SWITCH, ATTACK, INVENTORY}
}
