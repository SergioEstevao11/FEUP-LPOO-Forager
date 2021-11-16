package code.view.game;

import code.model.Menu;
import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;

public class TravelMenuViewer {
    private TerminalScreen screen;
    private Menu menu;


    public void draw(TerminalScreen screen, Menu menu){//needs fixing
        this.screen = screen;
        this.menu = menu;
        drawMenuBackground();
        drawOptions();
        drawOptionArrow();
    }

    private void drawOptionArrow() {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#999933"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.setCharacter(28,21 + menu.getCurrentChoice()*2, Symbols.TRIANGLE_RIGHT_POINTING_BLACK);
    }

    private void drawOptions() {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#999933"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.putString(32,18, "Travel");

        for(int i = 0 ; i < 8; i++){
            graphics.setCharacter(31 + i ,17 , Symbols.DOUBLE_LINE_HORIZONTAL);
            graphics.setCharacter(31 + i ,19 , Symbols.DOUBLE_LINE_HORIZONTAL);
        }
        graphics.putString(30,21, "Next Island");
        graphics.putString(30,23, "Go Back Home");
        graphics.putString(30,25, "Cancel");
    }

    private void drawMenuBackground() {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#999933"));
        graphics.fillRectangle(new TerminalPosition(25, 17), new TerminalSize(20, 11), ' ');
    }
}
