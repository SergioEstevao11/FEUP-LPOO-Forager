package code.control;

import code.control.command.Command;
import code.control.command.DoNothingCommand;
import code.control.command.EndProgramCommand;
import code.control.states.GameState;
import code.model.elements.Hero;
import code.model.maps.LevelProgression;
import code.view.game.IslandViewer;
import code.view.gui.GUI;
import code.view.gui.LanternaGUI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OtherCommandTest {

    @Test
    public void DoNothingCommandTest(){
        Hero hero = new Hero(0, 0);
        LevelProgression levelprogression = new LevelProgression(hero);
        GUI lanternaGUI = new LanternaGUI();
        GameState GameState = new GameState(new IslandViewer(), levelprogression);

        Game game = new Game(lanternaGUI, levelprogression, hero, GameState);

        Command command = new DoNothingCommand();
        command.exec(game);

        Assertions.assertEquals(game.getState(), game.getState());
    }

    @Test
    public void EndProgramCommandTest(){
        Hero hero = new Hero(0, 0);
        LevelProgression levelprogression = new LevelProgression(hero);
        GUI lanternaGUI = new LanternaGUI();
        GameState GameState = new GameState(new IslandViewer(), levelprogression);

        Game game = new Game(lanternaGUI, levelprogression, hero, GameState);

        Command command = new EndProgramCommand();
        command.exec(game);

        Assertions.assertFalse(game.isRunning());
    }
}
