package code.control;

import code.control.command.menu.nextMenuOption;
import code.control.command.menu.previousMenuOption;
import code.control.command.player.*;
import code.control.command.states.*;
import code.control.states.*;
import code.control.command.*;
import code.model.Menu;
import code.model.elements.Hero;
import code.model.maps.LevelProgression;
import code.view.game.*;
import code.view.gui.GUI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class StateTest {
    private Hero hero;
    private Menu menu;
    private GameState gameState;


    @Test
    public void BuyShopStateTest() {
        hero = new Hero(5,5);
        IslandViewer iv = new IslandViewer();
        LevelProgression lp = new LevelProgression(hero);

        gameState = new GameState(iv, lp);

        menu = new Menu(4);
        BuyShopViewer buyShopViewer = new BuyShopViewer();
        BuyShopState buyShopState = new BuyShopState(menu, buyShopViewer, gameState);

        Assertions.assertEquals(buyShopState.getCommand(GUI.ACTION.UP).getClass(), previousMenuOption.class);
        Assertions.assertEquals(buyShopState.getCommand(GUI.ACTION.DOWN).getClass(), nextMenuOption.class);
        Assertions.assertEquals(buyShopState.getCommand(GUI.ACTION.SELECT).getClass(), ShopCommand.class);
        Assertions.assertEquals(buyShopState.getCommand(GUI.ACTION.INVENTORY).getClass(), DoNothingCommand.class);
    }

    @Test
    public void DeathStateTest() {
        hero = new Hero(5,5);
        IslandViewer iv = new IslandViewer();
        LevelProgression lp = new LevelProgression(hero);

        gameState = new GameState(iv, lp);
        menu = new Menu(4);

        DeathMenuViewer deathMenuViewer = new DeathMenuViewer();
        DeathState deathState = new DeathState(menu, deathMenuViewer, gameState);

        Assertions.assertEquals(deathState.getCommand(GUI.ACTION.SELECT).getClass(), MainMenuCommand.class);
        Assertions.assertEquals(deathState.getCommand(GUI.ACTION.INVENTORY).getClass(), DoNothingCommand.class);
    }

    @Test
    public void GameStateTest() {
        hero = new Hero(5,5);
        IslandViewer iv = new IslandViewer();
        LevelProgression lp = new LevelProgression(hero);

        gameState = new GameState(iv, lp);

        Assertions.assertEquals(gameState.getCommand(GUI.ACTION.UP).getClass(), MoveHeroUp.class);
        Assertions.assertEquals(gameState.getCommand(GUI.ACTION.LEFT).getClass(), MoveHeroLeft.class);
        Assertions.assertEquals(gameState.getCommand(GUI.ACTION.DOWN).getClass(), MoveHeroDown.class);
        Assertions.assertEquals(gameState.getCommand(GUI.ACTION.RIGHT).getClass(), MoveHeroRight.class);
        Assertions.assertEquals(gameState.getCommand(GUI.ACTION.SELECT).getClass(), InteractCommand.class);
        Assertions.assertEquals(gameState.getCommand(GUI.ACTION.SWITCH).getClass(), SwitchToolsCommand.class);
        Assertions.assertEquals(gameState.getCommand(GUI.ACTION.ATTACK).getClass(), AttackCommand.class);
        Assertions.assertEquals(gameState.getCommand(GUI.ACTION.INVENTORY).getClass(), InventoryMenuCommand.class);
        Assertions.assertEquals(gameState.getCommand(GUI.ACTION.QUIT).getClass(), PauseMenuCommand.class);
        Assertions.assertEquals(gameState.getCommand(GUI.ACTION.NONE).getClass(), DoNothingCommand.class);
    }

    @Test
    public void InfoStateTest() {
        menu = new Menu(4);

        InfoViewer infoViewer = new InfoViewer();
        InfoState infoState = new InfoState(menu, infoViewer);

        Assertions.assertEquals(infoState.getCommand(GUI.ACTION.SELECT).getClass(), MainMenuCommand.class);
        Assertions.assertEquals(infoState.getCommand(GUI.ACTION.NONE).getClass(), DoNothingCommand.class);
    }

    @Test
    public void InventoryStateTest() {
        hero = new Hero(5, 5);
        menu = new Menu(5);

        IslandViewer iv = new IslandViewer();
        LevelProgression lp = new LevelProgression(hero);

        gameState = new GameState(iv, lp);

        InventoryViewer inventoryViewer = new InventoryViewer();
        InventoryState inventoryState = new InventoryState(menu, inventoryViewer, gameState);


        Assertions.assertEquals(inventoryState.getCommand(GUI.ACTION.UP).getClass(), previousMenuOption.class);
        Assertions.assertEquals(inventoryState.getCommand(GUI.ACTION.DOWN).getClass(), nextMenuOption.class);
        Assertions.assertEquals(inventoryState.getCommand(GUI.ACTION.SELECT).getClass(), ResumeGameCommand.class);
        Assertions.assertEquals(inventoryState.getCommand(GUI.ACTION.NONE).getClass(), DoNothingCommand.class);

    }

    @Test
    public void MainMenuStateTest() {
        menu = new Menu(4);

        MainMenuViewer mainMenuViewer = new MainMenuViewer();
        MainMenuState mainMenuState = new MainMenuState(menu, mainMenuViewer);

        Assertions.assertEquals(mainMenuState.getCommand(GUI.ACTION.UP).getClass(), previousMenuOption.class);
        Assertions.assertEquals(mainMenuState.getCommand(GUI.ACTION.DOWN).getClass(), nextMenuOption.class);
        Assertions.assertEquals(mainMenuState.getCommand(GUI.ACTION.SELECT).getClass(), StartGameCommand.class);
        Assertions.assertEquals(mainMenuState.getCommand(GUI.ACTION.NONE).getClass(), DoNothingCommand.class);

    }

    @Test
    public void PauseMenuStateTest() {
        menu = new Menu(4);
        hero = new Hero(5,5);
        IslandViewer iv = new IslandViewer();
        LevelProgression lp = new LevelProgression(hero);

        gameState = new GameState(iv, lp);

        PauseMenuViewer pauseMenuViewer = new PauseMenuViewer();
        PauseMenuState pauseMenuState = new PauseMenuState(menu, pauseMenuViewer, gameState);

        Assertions.assertEquals(pauseMenuState.getCommand(GUI.ACTION.UP).getClass(), previousMenuOption.class);
        Assertions.assertEquals(pauseMenuState.getCommand(GUI.ACTION.DOWN).getClass(), nextMenuOption.class);
        Assertions.assertEquals(pauseMenuState.getCommand(GUI.ACTION.SELECT).getClass(), ResumeGameCommand.class);
        Assertions.assertEquals(pauseMenuState.getCommand(GUI.ACTION.NONE).getClass(), DoNothingCommand.class);

    }

    @Test
    public void RulesStateTest() {
        menu = new Menu(5);

        RulesViewer rulesViewer = new RulesViewer();
        RulesState rulesState = new RulesState(menu, rulesViewer);

        Assertions.assertEquals(rulesState.getCommand(GUI.ACTION.SELECT).getClass(), MainMenuCommand.class);
        Assertions.assertEquals(rulesState.getCommand(GUI.ACTION.NONE).getClass(), DoNothingCommand.class);

    }

    @Test
    public void SellShopStateTest() {
        menu = new Menu(4);
        hero = new Hero(5,5);
        IslandViewer iv = new IslandViewer();
        LevelProgression lp = new LevelProgression(hero);

        gameState = new GameState(iv, lp);

        SellShopViewer sellShopViewer = new SellShopViewer();
        SellShopState sellShopState = new SellShopState(menu, sellShopViewer, gameState);

        Assertions.assertEquals(sellShopState.getCommand(GUI.ACTION.UP).getClass(), previousMenuOption.class);
        Assertions.assertEquals(sellShopState.getCommand(GUI.ACTION.DOWN).getClass(), nextMenuOption.class);
        Assertions.assertEquals(sellShopState.getCommand(GUI.ACTION.SELECT).getClass(), ShopCommand.class);
        Assertions.assertEquals(sellShopState.getCommand(GUI.ACTION.NONE).getClass(), DoNothingCommand.class);

    }

    @Test
    public void ShopStateTest(){
        menu = new Menu(4);
        hero = new Hero(5,5);
        IslandViewer iv = new IslandViewer();
        LevelProgression lp = new LevelProgression(hero);

        gameState = new GameState(iv, lp);
        ShopViewer shopViewer = new ShopViewer();
        ShopState shopState = new ShopState(menu, shopViewer, gameState);

        Assertions.assertEquals(shopState.getCommand(GUI.ACTION.UP).getClass(), previousMenuOption.class);
        Assertions.assertEquals(shopState.getCommand(GUI.ACTION.DOWN).getClass(), nextMenuOption.class);
        Assertions.assertEquals(shopState.getCommand(GUI.ACTION.SELECT).getClass(), BuyShopCommand.class);
        Assertions.assertEquals(shopState.getCommand(GUI.ACTION.NONE).getClass(), DoNothingCommand.class);

    }

    @Test
    public void TravelMenuStateTest() {
        menu = new Menu(4);
        hero = new Hero(5,5);
        IslandViewer iv = new IslandViewer();
        LevelProgression lp = new LevelProgression(hero);

        gameState = new GameState(iv, lp);
        TravelMenuViewer travelMenuViewer = new TravelMenuViewer();
        TravelMenuState travelMenuState = new TravelMenuState(menu, travelMenuViewer, gameState, new ArrayList<>());

        Assertions.assertEquals(travelMenuState.getCommand(GUI.ACTION.UP).getClass(), previousMenuOption.class);
        Assertions.assertEquals(travelMenuState.getCommand(GUI.ACTION.DOWN).getClass(), nextMenuOption.class);
        Assertions.assertEquals(travelMenuState.getCommand(GUI.ACTION.SELECT).getClass(), TravelCommand.class);
        Assertions.assertEquals(travelMenuState.getCommand(GUI.ACTION.NONE).getClass(), DoNothingCommand.class);

    }
}
