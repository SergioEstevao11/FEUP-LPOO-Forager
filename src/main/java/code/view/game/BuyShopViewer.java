package code.view.game;

import code.model.elements.Hero;
import code.model.elements.Resource;
import code.model.elements.Vendor;
import code.model.Menu;
import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;

public class BuyShopViewer { //StoreGUI
    private TerminalScreen screen;
    private Menu menu;
    private Vendor vendor;
    private Hero hero;


    public void draw(TerminalScreen screen, Menu menu, Vendor vendor, Hero hero){//needs fixing
        this.screen = screen;
        this.menu = menu;
        this.hero = hero;
        this.vendor = vendor;
        drawMenuBackground();
        drawOptions();
        drawOptionArrow();
    }

    private void drawMenuBackground(){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#999933"));
        graphics.fillRectangle(new TerminalPosition(10, 3), new TerminalSize(50, 14), ' ');
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.putString(33,3, "Buy");
        for(int j = 0 ; j < 50; j++){
            graphics.setCharacter(10 + j ,4 , Symbols.DOUBLE_LINE_HORIZONTAL);
            graphics.setCharacter(10 + j ,6 , Symbols.DOUBLE_LINE_HORIZONTAL);
        }
        for(int i = 0 ; i < 11; i++){
            graphics.setCharacter(27,5 + i , Symbols.DOUBLE_LINE_VERTICAL);
            graphics.setCharacter(43,5 + i , Symbols.DOUBLE_LINE_VERTICAL);
        }
        graphics.putString(16,5, "Items");
        graphics.putString(33,5, "Recipe");
        graphics.putString(47,5, "Inventory");
    }

    private void drawOptions(){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#999933"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        for(int i = 0; i < vendor.getInventory().size(); i++){
            graphics.putString(13,7 + i * 2, vendor.getInventory().get(i).getName());
        }
        for(int j = 0; j < hero.getInventory().getResources().size(); j++){
            graphics.putString(47,9 + j, Integer.toString(hero.getInventory().getResources().get(j).getQuantity()));
            graphics.putString(49,9 + j,"x");
            graphics.putString(51,9 + j, hero.getInventory().getResources().get(j).getName());
        }
        graphics.putString(33,16, "Back");
    }

    private void drawOptionArrow() {
        int option = menu.getCurrentChoice();
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#999933"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        if(option == 0)
            graphics.setCharacter(31,16, Symbols.TRIANGLE_RIGHT_POINTING_BLACK);
        else{

            graphics.setCharacter(11, 5 + option * 2, Symbols.TRIANGLE_RIGHT_POINTING_BLACK);
            int textHeight = 9;
            for(Resource r : vendor.getInventory().get(option - 1).getRecipe()) {
                graphics.putString(31, textHeight, Integer.toString(r.getQuantity()));
                graphics.putString(33, textHeight, "x");
                graphics.putString(36, textHeight, r.getName());
                textHeight++;
            }
        }
    }


}
