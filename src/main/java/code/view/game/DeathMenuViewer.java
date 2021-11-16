package code.view.game;

import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;

public class DeathMenuViewer {
    private TerminalScreen screen;


    public void draw(TerminalScreen screen){//needs fixing
        this.screen = screen;
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
        graphics.putString(32,18, "You Died");

        for(int i = 0 ; i < 10; i++){
            graphics.setCharacter(31 + i ,17 , Symbols.DOUBLE_LINE_HORIZONTAL);
            graphics.setCharacter(31 + i ,19 , Symbols.DOUBLE_LINE_HORIZONTAL);
        }
        graphics.putString(26,23, "Go Back to Main Menu");
    }

    private void drawOptionArrow() {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#999933"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.setCharacter(24,23, Symbols.TRIANGLE_RIGHT_POINTING_BLACK);
    }
}
