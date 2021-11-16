package code.view.game;

import code.model.elements.Destructible;
import code.model.elements.Monster;
import code.model.elements.Rock;
import code.model.elements.Tree;
import code.model.maps.Base;
import code.model.maps.Map;
import code.view.elements.*;
import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;


public class IslandViewer { //routeGUI
    private TerminalScreen screen;
    private int islandCounter;

    public void draw(TerminalScreen screen, Map map, int islandCounter){
        this.screen = screen;
        this.islandCounter = islandCounter;
        drawBackground(map);
        drawElements(map);
    }


    public void drawBackground(Map map){
        int height = map.getHeight();
        int width = map.getWidth();

        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#76dffb"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(70, 35), ' ');



        graphics.setBackgroundColor(TextColor.Factory.fromString("#2b1d0e"));
        graphics.fillRectangle(new TerminalPosition(0, 35), new TerminalSize(70, 3), ' ');

        if(map instanceof Base) {
            graphics.setBackgroundColor(TextColor.Factory.fromString("#999933"));
            graphics.fillRectangle(new TerminalPosition(25, 17), new TerminalSize(width, height), ' ');
        }
        else{
            graphics.setBackgroundColor(TextColor.Factory.fromString("#f7f7f7"));
            graphics.fillRectangle(new TerminalPosition(29, 0), new TerminalSize(12, 3), ' ');
            graphics.setForegroundColor(TextColor.Factory.fromString("#76dffb"));
            graphics.putString(30, 1, "Island: " + islandCounter);

            graphics.setBackgroundColor(TextColor.Factory.fromString("#999933"));
            graphics.fillRectangle(new TerminalPosition((70-width)/2, (35-height)/2), new TerminalSize(width, height), ' ');
            graphics.fillRectangle(new TerminalPosition((70-width)/2 - 3, 31), new TerminalSize(45, 3), ' ');
            graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
            graphics.putString((71-width)/2 - 2, 32, "To advance, you must kill all the monsters!");
        }
    }

    public void drawElements(Map map){
        TextGraphics graphics;
        graphics = screen.newTextGraphics();
        new HeroView().draw(map.getHero(), graphics );

        new BoatView().draw(map.getBoat(), graphics);

        if(map instanceof Base){
            Base b = (Base) map;
            graphics = screen.newTextGraphics();
            new VendorView().draw(b.getVendor(), graphics);
        }

        for(Monster m : map.getMonsters()){
            graphics = screen.newTextGraphics();
            new EnemyView().draw(m, graphics);
        }

        for(Destructible d : map.getObjects()){
            graphics = screen.newTextGraphics();
            if(d instanceof Rock){
                new RockView().draw((Rock)d, graphics);
            }
            else{
                new TreeView().draw((Tree)d, graphics);
            }
        }
    }

}