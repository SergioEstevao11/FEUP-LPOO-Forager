package code.view.game;

import code.model.Menu;
import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;

public class ShopViewer { //StoreGUI
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
        graphics.fillRectangle(new TerminalPosition(22, 3), new TerminalSize(24, 10), ' ');
        graphics.setBackgroundColor(TextColor.Factory.fromString("#999933"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.putString(32,4, "Shop");
        for(int j = 0 ; j < 24; j++){
            graphics.setCharacter(22 + j ,5 , Symbols.DOUBLE_LINE_HORIZONTAL);
        }
        graphics.putString(32,7, "Buy");
        graphics.putString(32,9, "Sell");
    }

    private void drawOptions(){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#999933"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.putString(32,11, "Back");
    }

    private void drawOptionArrow() {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#999933"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.setCharacter(30,7 + menu.getCurrentChoice() * 2, Symbols.TRIANGLE_RIGHT_POINTING_BLACK);
    }


}
