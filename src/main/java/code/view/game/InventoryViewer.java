package code.view.game;

import code.model.elements.Hero;
import code.model.elements.Resource;
import code.model.items.Item;
import code.model.items.Potion;
import code.model.Menu;
import code.model.items.Tool;
import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;

public class InventoryViewer { //BagGUI
    private TerminalScreen screen;
    private Menu menu;
    private Hero hero;


    public void draw(TerminalScreen screen, Menu menu, Hero hero){//needs fixing
        this.screen = screen;
        this.menu = menu;
        this.hero = hero;
        drawMenuBackground();
        drawOptions();
        drawInventory();
        drawOptionArrow();
    }

    private void drawMenuBackground(){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#999933"));
        graphics.fillRectangle(new TerminalPosition(10, 12), new TerminalSize(49, 14), ' ');
    }

    private void drawInventory(){
        int counter = 0;
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#999933"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        for(Item t : hero.getInventory().getItems()){
            graphics.putString(13,15+ counter,t.getName());
            graphics.setCharacter(14 + t.getName().length() ,15 + counter , Symbols.TRIANGLE_RIGHT_POINTING_BLACK);
            if (t instanceof Potion){
                graphics.putString(16 + t.getName().length(),15 + counter ,"Healing:");
                graphics.putString(24 + t.getName().length(),15+ counter ,Integer.toString(((Potion) t).getHealing()));

            }
            else {
                graphics.putString(16 + t.getName().length(), 15 + counter, "Damage:");
                graphics.putString(24 + t.getName().length(), 15 + counter, Integer.toString(((Tool) t).getDamage()));
                graphics.putString(26 + t.getName().length(), 15 + counter, ";");
                graphics.putString(28 + t.getName().length(), 15 + counter, "Durability:");
                graphics.putString(40 + t.getName().length(), 15 + counter, Integer.toString(((Tool) t).getDurability()));
            }
            counter++;
        }
        counter++;
        for(Resource resource : hero.getInventory().getResources()){
            graphics.putString(13,15 + counter,resource.getName());
            graphics.setCharacter(14 + resource.getName().length() ,15 + counter , Symbols.TRIANGLE_RIGHT_POINTING_BLACK);
            graphics.putString(16 + resource.getName().length(),15 + counter ,"Quantity:");
            graphics.putString(26 +  resource.getName().length(),15 + counter,Integer.toString(resource.getQuantity()));
            counter++;
        }
    }

    private void drawOptions(){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#999933"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.putString(30,13, "Inventory");

        for(int i = 0 ; i < 49; i++){
            graphics.setCharacter(10 + i ,14 , Symbols.DOUBLE_LINE_HORIZONTAL);
        }
        graphics.putString(32,25, "Back");
    }

    private void drawOptionArrow() {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#999933"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        int option = menu.getCurrentChoice();
        if(option == 0)
            graphics.setCharacter(30,25 , Symbols.TRIANGLE_RIGHT_POINTING_BLACK);
        else{
            graphics.setCharacter(11,14+option , Symbols.TRIANGLE_RIGHT_POINTING_BLACK);
        }
    }



}
