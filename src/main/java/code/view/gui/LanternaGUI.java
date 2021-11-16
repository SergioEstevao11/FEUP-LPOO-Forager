package code.view.gui;

import code.control.states.State;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class LanternaGUI implements GUI{
    private Screen screen;

    public LanternaGUI(){
        try {
            int terminalColumns = 70;
            int terminalRows = 38;
            TerminalSize terminalSize = new TerminalSize(terminalColumns, terminalRows);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);   // we don't need a cursor
            screen.startScreen();             // screens must be started
            screen.doResizeIfNecessary();     // resize screen if necessary


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public KeyStroke pollKey() throws IOException {
        com.googlecode.lanterna.input.KeyStroke key;
        key = screen.pollInput();

        return key;
    }

    public GUI.ACTION getAction() throws IOException {
        com.googlecode.lanterna.input.KeyStroke key = pollKey();
        KeyType type;
        Character chr;

        if (key == null) return ACTION.NONE;

        type = key.getKeyType();

        if (type == null) return ACTION.NONE;
        if (type == KeyType.Escape) return ACTION.QUIT;
        if (type == KeyType.Enter) return ACTION.SELECT;
        if (type == KeyType.Tab) return ACTION.SWITCH;
        if (type != KeyType.Character) return ACTION.NONE;

        chr = key.getCharacter();

        if (chr == 'w') return ACTION.UP;
        if (chr == 'a') return ACTION.LEFT;
        if (chr == 's') return ACTION.DOWN;
        if (chr == 'd') return ACTION.RIGHT;
        if (chr == 'e') return ACTION.ATTACK;
        if (chr == 'p') return ACTION.ATTACK;
        if (chr == 'i') return ACTION.INVENTORY;

        return ACTION.NONE;
    }


    public void draw(State state) throws IOException {
        clear();
        state.draw((TerminalScreen) screen);
        refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }

    public void refresh() throws IOException {
        this.screen.refresh();
    }


}
