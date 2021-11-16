package code.control;

import code.control.command.Command;
import code.control.command.DoNothingCommand;
import code.control.states.GameState;
import code.control.states.State;
import code.model.elements.*;
import code.model.maps.LevelProgression;
import code.view.gui.GUI;
import java.io.IOException;

public class Game {
    private final GUI lanternaGUI;
    private LevelProgression levelProgression;
    private Hero hero;
    private State state;
    private boolean running;

    public Game(GUI lanternaGUI, LevelProgression levelProgression, Hero hero, State state) {
        this.lanternaGUI = lanternaGUI;
        this.levelProgression = levelProgression;
        this.hero = hero;
        this.state = state;
        this.running = true;
    }

    public void run() throws IOException, InterruptedException {
        int frameCounter = 0;
        updateScreen();
        while (running) {
            frameCounter%=50;
            frameCounter++;
            Thread.sleep(20);
            GUI.ACTION action = lanternaGUI.getAction();
            Command command = state.getCommand(action);
            command.exec(this);
            if(state instanceof GameState) {
                if (frameCounter == 50)
                    levelProgression.getCurrentIsland().moveMonsters();
                updateScreen();
            }
            else if (!(command instanceof DoNothingCommand)){
                updateScreen();
            }


        }
        closeWindow();
    }

    public LevelProgression getLevelProgression() { return levelProgression; }

    public Hero getHero() { return hero; }

    public State getState() { return state; }

    public void setHero(Hero hero) { this.hero = hero; }

    public void setState(State state) { this.state = state; }

    public void resetLevelProgression(){
        hero = new Hero(0,0);
        levelProgression = new LevelProgression(hero);
    }

    public void stopRunning() {
        running = false;
    }

    public void updateScreen() throws IOException {
        lanternaGUI.draw(state);
    }

    public void closeWindow() throws IOException {
        lanternaGUI.close();
    }

    public boolean isRunning(){
        return running;
    }

}
