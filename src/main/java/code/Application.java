package code;

import code.control.Game;
import code.control.states.MainMenuState;
import code.control.states.State;
import code.model.elements.Hero;
import code.model.maps.LevelProgression;
import code.model.Menu;
import code.view.game.MainMenuViewer;
import code.view.gui.GUI;
import code.view.gui.LanternaGUI;

import java.io.IOException;

public class Application {

    public static void main(String[] args) {
        Hero hero = new Hero(0, 0);

        LevelProgression levelprogression = new LevelProgression(hero);

        GUI lanternaGUI = new LanternaGUI();

        State state = new MainMenuState(new Menu(4), new MainMenuViewer());

        try {
            Game game = new Game(lanternaGUI, levelprogression, hero, state);
            game.run();

        } catch (IOException | InterruptedException ignored) { }
    }
}

