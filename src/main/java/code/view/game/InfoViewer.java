package code.view.game;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;

public class InfoViewer{
    private TerminalScreen screen;


    public void draw(TerminalScreen screen){
        this.screen = screen;
        drawMenuBackground();
        drawIsland();
        drawBoat();
        drawText();
        drawOptions();
        drawOptionArrow();
    }


    public void drawMenuBackground() {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#76dffb")); //water color
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(75, 35), ' ');
    }


    public void drawText(){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#999933"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.putString(28,9, "LPOO - FORAGER");
        graphics.putString(20,14,  "Edgar Torre - up201906573");
        graphics.putString(20,16, "Joao Afonso - up201905589");
        graphics.putString(20,18, "Sergio Estevao - up201905680");
    }


    public void drawOptions(){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#999933"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));

        graphics.putString(33,23, "Back");

    }


    public void drawIsland(){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#999933"));
        graphics.fillRectangle(new TerminalPosition(18, 8), new TerminalSize(35, 18), ' ');
    }


    public void drawBoat(){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#76dffb"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(15,17 ), ">");
        graphics.putString(new TerminalPosition(14, 17), "|");
        graphics.setForegroundColor(TextColor.Factory.fromString("#964B00"));
        graphics.putString(new TerminalPosition(13,18), "###");
    }

    private void drawOptionArrow() {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#999933"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.setCharacter(31, 23, Symbols.TRIANGLE_RIGHT_POINTING_BLACK);
    }

}
