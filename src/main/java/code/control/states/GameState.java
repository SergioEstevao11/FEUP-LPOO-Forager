package code.control.states;

import code.control.command.Command;
import code.control.command.DoNothingCommand;
import code.control.command.player.*;
import code.control.command.states.DeathMenuCommand;
import code.control.command.states.InventoryMenuCommand;
import code.control.command.states.PauseMenuCommand;
import code.model.maps.LevelProgression;
import code.model.maps.Map;
import code.view.game.IslandViewer;
import code.view.gui.GUI;
import com.googlecode.lanterna.screen.TerminalScreen;

public class GameState implements State{
    private final IslandViewer islandViewer;
    private final LevelProgression levelProgression;
    public GameState(IslandViewer islandViewer, LevelProgression levelProgression){
        this.islandViewer = islandViewer;
        this.levelProgression = levelProgression;
    }

    @Override
    public Command getCommand(GUI.ACTION action) {
        if(action == GUI.ACTION.UP) return new MoveHeroUp(levelProgression.getCurrentIsland());
        if(action == GUI.ACTION.LEFT) return new MoveHeroLeft(levelProgression.getCurrentIsland());
        if(action == GUI.ACTION.DOWN) return new MoveHeroDown(levelProgression.getCurrentIsland());
        if(action == GUI.ACTION.RIGHT) return new MoveHeroRight(levelProgression.getCurrentIsland());
        if(action == GUI.ACTION.SELECT) return new InteractCommand(levelProgression.getCurrentIsland());
        if(action == GUI.ACTION.SWITCH) return new SwitchToolsCommand(levelProgression.getCurrentIsland());
        if(action == GUI.ACTION.ATTACK) return new AttackCommand(levelProgression.getCurrentIsland());
        if(action == GUI.ACTION.INVENTORY) return new InventoryMenuCommand(this);
        if(levelProgression.getCurrentIsland().getHero().getDead()){
            levelProgression.getCurrentIsland().getHero().setDead(false);
            return new DeathMenuCommand(this);
        }
        if(action == GUI.ACTION.QUIT) return new PauseMenuCommand(this);
        return new DoNothingCommand();
    }

    @Override
    public void draw(TerminalScreen screen) {

        islandViewer.draw(screen, levelProgression.getCurrentIsland(), levelProgression.getIslandCounter());
    }


    public Map getCurrentIsland() {
        return levelProgression.getCurrentIsland();
    }

    public void travel(){
        levelProgression.nextIsland();
    }

    public void recall(){ levelProgression.recall();}
}
