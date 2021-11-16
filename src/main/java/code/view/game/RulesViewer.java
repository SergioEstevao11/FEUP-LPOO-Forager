package code.view.game;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;

public class RulesViewer{
    TerminalScreen screen;


    public void draw(TerminalScreen screen) {
        this.screen = screen;
        drawMenuBackground();
        drawIsland();
        drawBoat();
        drawText();
        drawOptions();
        drawOptionArrow();
    }


    public void drawIsland() {

        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#999933"));
        graphics.fillRectangle(new TerminalPosition(9, 5), new TerminalSize(52, 25), ' ');

    }


    public void drawMenuBackground() {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#76dffb")); //water color
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(75, 35), ' ');
    }

    public void drawText() {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#999933"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));

        graphics.putString(11,6, "Discover the open world and collect reources!");
        graphics.putString(11,8, "When you have enough resources, go to the vendor");
        graphics.putString(11,9, "and aquire new items!");
        graphics.putString(11,11, "With your new items you will be able to progress");
        graphics.putString(11,12, "and sucessfully finish your missions.");
        graphics.putString(11,14, "Finishing missions will allow you to unlock");
        graphics.putString(11,15, "new levels with harder dificulty.");
        graphics.putString(11,17, "Controls:");
        graphics.putString(20,18, "Moves Up");
        graphics.putString(20,19, "Moves Down");
        graphics.putString(20,20, "Moves Left");
        graphics.putString(20,21, "Moves Right");
        graphics.putString(20,22, "Attack/Collect Resources");
        graphics.putString(20,23, "Opens Inventory");
        graphics.putString(20,24, "Opens Menu");
        graphics.putString(20,25, "Chooses Option/Interact");
        graphics.putString(20,26, "Switch tools");


    }


    public void drawOptions(){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#999933"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));

        graphics.putString(15,18, "W");
        graphics.setCharacter(18,18, Symbols.TRIANGLE_RIGHT_POINTING_BLACK);
        graphics.putString(15,19, "S");
        graphics.setCharacter(18,19, Symbols.TRIANGLE_RIGHT_POINTING_BLACK);
        graphics.putString(15,20, "A");
        graphics.setCharacter(18,20, Symbols.TRIANGLE_RIGHT_POINTING_BLACK);
        graphics.putString(15,21, "D");
        graphics.setCharacter(18,21, Symbols.TRIANGLE_RIGHT_POINTING_BLACK);
        graphics.putString(15,22, "E");
        graphics.setCharacter(18,22, Symbols.TRIANGLE_RIGHT_POINTING_BLACK);
        graphics.putString(15,23, "I");
        graphics.setCharacter(18,23, Symbols.TRIANGLE_RIGHT_POINTING_BLACK);
        graphics.putString(14,24, "ESC");
        graphics.setCharacter(18,24, Symbols.TRIANGLE_RIGHT_POINTING_BLACK);
        graphics.putString(12,25, "ENTER");
        graphics.setCharacter(18,25, Symbols.TRIANGLE_RIGHT_POINTING_BLACK);
        graphics.putString(14,26, "TAB");
        graphics.setCharacter(18,26, Symbols.TRIANGLE_RIGHT_POINTING_BLACK);


        graphics.putString(33,28, "Back");



    }

    public void drawBoat() {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#76dffb"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(7, 17), ">");
        graphics.putString(new TerminalPosition(6, 17), "|");
        graphics.setForegroundColor(TextColor.Factory.fromString("#964B00"));
        graphics.putString(new TerminalPosition(5, 18), "###");
    }


    private void drawOptionArrow(){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#999933"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.setCharacter(31, 28, Symbols.TRIANGLE_RIGHT_POINTING_BLACK);
    }
}
