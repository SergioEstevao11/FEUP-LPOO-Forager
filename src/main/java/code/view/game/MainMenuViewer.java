package code.view.game;

import code.model.Menu;
import com.googlecode.lanterna.*;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.graphics.TextGraphics;

public class MainMenuViewer{ //StartGUI

    private TerminalScreen screen;
    private Menu menu;
    int firstR = 0;


    public void draw(TerminalScreen terminalScreen, Menu menu){
        screen = terminalScreen;
        this.menu = menu;
        drawMenuBackground();
        drawIsland();
        drawOptions();
        drawBoat();
        drawOptionArrow();
    }


    public void drawMenuBackground() {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#76dffb")); //water color
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(70, 38), ' ');
        drawLetterF();
        drawLetterO();
        drawLetterR();
        drawLetterA();
        drawLetterG();
        drawLetterE();
        drawLetterR();
    }

    private void drawLetterF(){
        TextGraphics graphics = screen.newTextGraphics();
        //Letter F
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FF7F00")); //orange color
        graphics.fillRectangle(new TerminalPosition(13, 5), new TerminalSize(2,5), ' ');
        graphics.fillRectangle(new TerminalPosition(13, 5), new TerminalSize(5,1), ' ');
        graphics.fillRectangle(new TerminalPosition(13, 7), new TerminalSize(5,1), ' ');
    }

    private void drawLetterO() {
        TextGraphics graphics = screen.newTextGraphics();
        //Letter O
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FF7F00")); //orange color
        graphics.fillRectangle(new TerminalPosition(19, 5), new TerminalSize(2, 5), ' ');
        graphics.fillRectangle(new TerminalPosition(19, 5), new TerminalSize(4, 1), ' ');
        graphics.fillRectangle(new TerminalPosition(23, 5), new TerminalSize(2, 5), ' ');
        graphics.fillRectangle(new TerminalPosition(19, 9), new TerminalSize(4, 1), ' ');
    }


    private void drawLetterR() {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FF7F00")); //orange color
        if(firstR == 0) {
            //Letter R
            graphics.fillRectangle(new TerminalPosition(26, 5), new TerminalSize(2, 5), ' ');
            graphics.fillRectangle(new TerminalPosition(26, 5), new TerminalSize(4, 1), ' ');
            graphics.fillRectangle(new TerminalPosition(30, 5), new TerminalSize(2, 2), ' ');
            graphics.fillRectangle(new TerminalPosition(26, 7), new TerminalSize(6, 1), ' ');
            graphics.fillRectangle(new TerminalPosition(28, 8), new TerminalSize(2, 1), ' ');
            graphics.fillRectangle(new TerminalPosition(30, 9), new TerminalSize(2, 1), ' ');
            firstR = 1;
        }
        else { //Second Letter R
            graphics.fillRectangle(new TerminalPosition(53, 5), new TerminalSize(2, 5), ' ');
            graphics.fillRectangle(new TerminalPosition(53, 5), new TerminalSize(4, 1), ' ');
            graphics.fillRectangle(new TerminalPosition(57, 5), new TerminalSize(2, 2), ' ');
            graphics.fillRectangle(new TerminalPosition(54, 7), new TerminalSize(5, 1), ' ');
            graphics.fillRectangle(new TerminalPosition(55, 8), new TerminalSize(2, 1), ' ');
            graphics.fillRectangle(new TerminalPosition(57, 9), new TerminalSize(2, 1), ' ');
            firstR = 0;
        }
    }

    private void drawLetterA() {
        TextGraphics graphics = screen.newTextGraphics();
        //Letter A
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FF7F00")); //orange color
        graphics.fillRectangle(new TerminalPosition(33, 5), new TerminalSize(2, 5), ' ');
        graphics.fillRectangle(new TerminalPosition(37, 5), new TerminalSize(2, 5), ' ');
        graphics.fillRectangle(new TerminalPosition(33, 7), new TerminalSize(6, 1), ' ');
        graphics.fillRectangle(new TerminalPosition(33, 5), new TerminalSize(6, 1), ' ');
    }
    private void drawLetterG() {
        TextGraphics graphics = screen.newTextGraphics();
        //Letter G
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FF7F00")); //orange color
        graphics.fillRectangle(new TerminalPosition(40, 5), new TerminalSize(2, 5), ' ');
        graphics.fillRectangle(new TerminalPosition(41, 5), new TerminalSize(5, 1), ' ');
        graphics.fillRectangle(new TerminalPosition(44, 7), new TerminalSize(2, 3), ' ');
        graphics.fillRectangle(new TerminalPosition(40, 9), new TerminalSize(4, 1), ' ');
    }
    private void drawLetterE() {
        TextGraphics graphics = screen.newTextGraphics();
        //Letter E
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FF7F00")); //orange color
        graphics.fillRectangle(new TerminalPosition(47, 5), new TerminalSize(2, 5), ' ');
        graphics.fillRectangle(new TerminalPosition(47, 5), new TerminalSize(5, 1), ' ');
        graphics.fillRectangle(new TerminalPosition(47, 7), new TerminalSize(5, 1), ' ');
        graphics.fillRectangle(new TerminalPosition(47, 9), new TerminalSize(5, 1), ' ');
    }

    public void drawOptions(){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#999933"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));

        graphics.putString(30,18, "Begin Game");
        graphics.putString(30,20, "Rules");
        graphics.putString(30,22, "Credits");
        graphics.putString(30,24, "Quit");
    }


    public void drawIsland(){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#999933"));
        graphics.fillRectangle(new TerminalPosition(25, 17), new TerminalSize(20, 9), ' ');
    }


    public void drawBoat(){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#76dffb"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(23,20 ), ">");
        graphics.putString(new TerminalPosition(22, 20), "|");
        graphics.setForegroundColor(TextColor.Factory.fromString("#964B00"));
        graphics.putString(new TerminalPosition(21,21), "###");
    }

    private void drawOptionArrow() {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#999933"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.setCharacter(28,18 + menu.getCurrentChoice()*2, Symbols.TRIANGLE_RIGHT_POINTING_BLACK);
        //graphics.setCharacter(20, (25 + 2 * menu.getcurrentChoice()), Symbols.TRIANGLE_LEFT_POINTING_MEDIUM_BLACK);
    }



}
