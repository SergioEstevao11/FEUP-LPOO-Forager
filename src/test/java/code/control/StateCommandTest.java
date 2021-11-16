package code.control;

import code.control.command.Command;
import code.control.command.states.*;
import code.control.states.*;
import code.model.Menu;
import code.model.elements.Hero;
import code.model.maps.Base;
import code.model.maps.Island;
import code.model.maps.LevelProgression;
import code.view.game.IslandViewer;
import code.view.game.MainMenuViewer;
import code.view.game.PauseMenuViewer;
import code.view.game.ShopViewer;
import code.view.gui.GUI;
import code.view.gui.LanternaGUI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StateCommandTest {

    @Test
    public void BuyShopCommandTest(){
        Hero hero = new Hero(0, 0);
        LevelProgression levelprogression = new LevelProgression(hero);
        GUI lanternaGUI = new LanternaGUI();
        Menu menu = new Menu(3);
        GameState GameState = new GameState(new IslandViewer(), levelprogression);
        State state = new ShopState(menu, new ShopViewer(), GameState);

        Game game = new Game(lanternaGUI, levelprogression, hero, state);

        Command command = new BuyShopCommand(GameState);
        command.exec(game);

        Assertions.assertTrue(game.getState() instanceof BuyShopState);
    }

    @Test
    public void DeathMenuCommandTest(){
        Hero hero = new Hero(0, 0);
        LevelProgression levelprogression = new LevelProgression(hero);
        GUI lanternaGUI = new LanternaGUI();
        GameState GameState = new GameState(new IslandViewer(), levelprogression);

        Game game = new Game(lanternaGUI, levelprogression, hero, GameState);

        Command command = new DeathMenuCommand(GameState);
        command.exec(game);

        Assertions.assertTrue(game.getState() instanceof DeathState);
    }

    @Test
    public void InfoCommandTest(){
        Hero hero = new Hero(0, 0);
        LevelProgression levelprogression = new LevelProgression(hero);
        GUI lanternaGUI = new LanternaGUI();
        GameState GameState = new GameState(new IslandViewer(), levelprogression);

        Game game = new Game(lanternaGUI, levelprogression, hero, GameState);

        Command command = new InfoCommand();
        command.exec(game);

        Assertions.assertTrue(game.getState() instanceof InfoState);
    }

    @Test
    public void InventoryMenuCommandTest(){
        Hero hero = new Hero(0, 0);
        LevelProgression levelprogression = new LevelProgression(hero);
        GUI lanternaGUI = new LanternaGUI();
        GameState GameState = new GameState(new IslandViewer(), levelprogression);

        Game game = new Game(lanternaGUI, levelprogression, hero, GameState);

        Command command = new InventoryMenuCommand(GameState);
        command.exec(game);

        Assertions.assertTrue(game.getState() instanceof InventoryState);
    }

    @Test
    public void MainMenuCommandTest(){
        Hero hero = new Hero(0, 0);
        LevelProgression levelprogression = new LevelProgression(hero);
        GUI lanternaGUI = new LanternaGUI();
        GameState GameState = new GameState(new IslandViewer(), levelprogression);

        Game game = new Game(lanternaGUI, levelprogression, hero, GameState);

        Command command = new MainMenuCommand();
        command.exec(game);

        Assertions.assertTrue(game.getState() instanceof MainMenuState);
    }

    @Test
    public void PauseMenuCommandTest(){
        Hero hero = new Hero(0, 0);
        LevelProgression levelprogression = new LevelProgression(hero);
        GUI lanternaGUI = new LanternaGUI();
        GameState GameState = new GameState(new IslandViewer(), levelprogression);

        Game game = new Game(lanternaGUI, levelprogression, hero, GameState);

        Command command = new PauseMenuCommand(GameState);
        command.exec(game);

        Assertions.assertTrue(game.getState() instanceof PauseMenuState);
    }

    @Test
    public void RecallandTravelCommandTest(){
        Hero hero = new Hero(0, 0);
        LevelProgression levelprogression = new LevelProgression(hero);
        GUI lanternaGUI = new LanternaGUI();
        GameState GameState = new GameState(new IslandViewer(), levelprogression);

        Game game = new Game(lanternaGUI, levelprogression, hero, GameState);

        Command command = new TravelCommand(GameState);
        command.exec(game);

        Assertions.assertTrue(game.getLevelProgression().getCurrentIsland() instanceof Island);

        command = new RecallCommand(GameState);
        command.exec(game);

        Assertions.assertTrue(game.getLevelProgression().getCurrentIsland() instanceof Base);
    }

    @Test
    public void ResumeGameCommandTest(){
        Hero hero = new Hero(0, 0);
        LevelProgression levelprogression = new LevelProgression(hero);
        GUI lanternaGUI = new LanternaGUI();
        Menu menu = new Menu(2);
        GameState GameState = new GameState(new IslandViewer(), levelprogression);
        PauseMenuState pause = new PauseMenuState(menu, new PauseMenuViewer(), GameState);
        Game game = new Game(lanternaGUI, levelprogression, hero, pause);

        Command command = new ResumeGameCommand(GameState);
        command.exec(game);

        Assertions.assertTrue(game.getState() instanceof GameState);
    }

    @Test
    public void RulesCommandTest(){
        Hero hero = new Hero(0, 0);
        LevelProgression levelprogression = new LevelProgression(hero);
        GUI lanternaGUI = new LanternaGUI();
        GameState GameState = new GameState(new IslandViewer(), levelprogression);

        Game game = new Game(lanternaGUI, levelprogression, hero, GameState);

        Command command = new RulesCommand();
        command.exec(game);

        Assertions.assertTrue(game.getState() instanceof RulesState);
    }

    @Test
    public void SellShopCommandTest(){
        Hero hero = new Hero(0, 0);
        LevelProgression levelprogression = new LevelProgression(hero);
        GUI lanternaGUI = new LanternaGUI();
        GameState GameState = new GameState(new IslandViewer(), levelprogression);

        Game game = new Game(lanternaGUI, levelprogression, hero, GameState);

        Command command = new SellShopCommand(GameState);
        command.exec(game);

        Assertions.assertTrue(game.getState() instanceof SellShopState);
    }

    @Test
    public void ShopCommandTest(){
        Hero hero = new Hero(0, 0);
        LevelProgression levelprogression = new LevelProgression(hero);
        GUI lanternaGUI = new LanternaGUI();
        GameState GameState = new GameState(new IslandViewer(), levelprogression);

        Game game = new Game(lanternaGUI, levelprogression, hero, GameState);

        Command command = new ShopCommand(GameState);
        command.exec(game);

        Assertions.assertTrue(game.getState() instanceof ShopState);
    }

    @Test
    public void StartGameCommandTest(){
        Hero hero = new Hero(0, 0);
        LevelProgression levelprogression = new LevelProgression(hero);
        GUI lanternaGUI = new LanternaGUI();
        Menu menu = new Menu(4);
        MainMenuState mainMenuState = new MainMenuState(menu, new MainMenuViewer());
        Game game = new Game(lanternaGUI, levelprogression, hero, mainMenuState);

        Command command = new StartGameCommand();
        command.exec(game);

        Assertions.assertTrue(game.getState() instanceof GameState);
    }

    @Test
    public void TravelMenuCommandTest(){
        Hero hero = new Hero(0, 0);
        LevelProgression levelprogression = new LevelProgression(hero);
        GUI lanternaGUI = new LanternaGUI();
        GameState GameState = new GameState(new IslandViewer(), levelprogression);

        Game game = new Game(lanternaGUI, levelprogression, hero, GameState);

        Command command = new TravelMenuCommand(GameState, GameState.getCurrentIsland().getMonsters());
        command.exec(game);

        Assertions.assertTrue(game.getState() instanceof TravelMenuState);
    }

}
