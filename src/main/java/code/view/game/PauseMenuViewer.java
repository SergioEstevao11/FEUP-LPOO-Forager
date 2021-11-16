package code.view.game;

import code.model.Menu;
import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;

public class PauseMenuViewer { //PauseGUI
    private TerminalScreen screen;
    private Menu menu;


    public void draw(TerminalScreen screen, Menu menu){//needs fixing
        this.screen = screen;
        this.menu = menu;
        drawMenuBackground();
        drawOptions();
        drawOptionArrow();
    }

    private void drawMenuBackground(){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#999933"));
        graphics.fillRectangle(new TerminalPosition(25, 17), new TerminalSize(20, 9), ' ');
    }

    private void drawOptions(){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#999933"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.putString(32,18, "Paused");

        for(int i = 0 ; i < 8; i++){
            graphics.setCharacter(31 + i ,17 , Symbols.DOUBLE_LINE_HORIZONTAL);
            graphics.setCharacter(31 + i ,19 , Symbols.DOUBLE_LINE_HORIZONTAL);
        }
        graphics.putString(30,21, "Resume");
        graphics.putString(30,23, "Main Menu");
    }

    private void drawOptionArrow() {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#999933"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.setCharacter(28,21 + menu.getCurrentChoice()*2, Symbols.TRIANGLE_RIGHT_POINTING_BLACK);
    }

}