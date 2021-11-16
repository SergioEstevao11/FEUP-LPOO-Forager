package code.view.game;

import code.model.elements.Hero;
import code.model.elements.Resource;
import code.model.Menu;
import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.util.List;

public class SellShopViewer {

    private TerminalScreen screen;
    private Menu menu;
    private Hero hero;


    public void draw(TerminalScreen screen, Menu menu, Hero hero){//needs fixing
        this.screen = screen;
        this.menu = menu;
        this.hero = hero;
        drawMenuBackground();
        drawOptions();
        drawOptionArrow();
    }

    private void drawMenuBackground(){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#999933"));
        graphics.fillRectangle(new TerminalPosition(10, 3), new TerminalSize(50, 14), ' ');
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.putString(33,3, "Sell");
        for(int j = 0 ; j < 50; j++){
            graphics.setCharacter(10 + j ,4 , Symbols.DOUBLE_LINE_HORIZONTAL);
            graphics.setCharacter(10 + j ,6 , Symbols.DOUBLE_LINE_HORIZONTAL);
        }
        for(int i = 0 ; i < 11; i++){
            graphics.setCharacter(27,5 + i , Symbols.DOUBLE_LINE_VERTICAL);
            graphics.setCharacter(43,5 + i , Symbols.DOUBLE_LINE_VERTICAL);
        }
        graphics.putString(16,5, "Items");
        graphics.putString(30,5, "You receive");
        graphics.putString(47,5, "Inventory");
    }

    private void drawOptions(){
        List<Resource> resourceList = hero.getInventory().getResources();
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#999933"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        for(int j = 0; j < hero.getInventory().getItems().size(); j++){
            graphics.putString(13,7 + j * 2 , hero.getInventory().getItems().get(j).getName());
        }
        for(int i = 0; i < resourceList.size(); i++){
            graphics.putString(47,9 + i, Integer.toString(resourceList.get(i).getQuantity()));
            graphics.putString(49,9 + i,"x");
            graphics.putString(51,9 + i , resourceList.get(i).getName());
        }
        graphics.putString(33,16, "Back");
    }

    private void drawOptionArrow() {
        int counter = 0;
        int option = menu.getCurrentChoice();
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#999933"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        if(option == 0)
            graphics.setCharacter(31,16, Symbols.TRIANGLE_RIGHT_POINTING_BLACK);
        else {
            graphics.setCharacter(11, 5 + option*2, Symbols.TRIANGLE_RIGHT_POINTING_BLACK);
            for(Resource r : hero.getInventory().getItems().get(option-1).getRecipe()){
                graphics.putString(30, 9 + counter,Integer.toString(r.getQuantity() / 2));
                graphics.putString(32,9 + counter ,"x");
                graphics.putString(35,9 + counter, r.getName());
                counter++;
            }
        }
    }

}

