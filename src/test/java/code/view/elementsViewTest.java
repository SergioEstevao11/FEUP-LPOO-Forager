package code.view;

import code.control.Game;
import code.control.command.Command;
import code.control.command.states.ShopCommand;
import code.control.states.BuyShopState;
import code.control.states.GameState;
import code.control.states.ShopState;
import code.model.Menu;
import code.model.elements.Hero;
import code.model.maps.LevelProgression;
import code.view.game.BuyShopViewer;
import code.view.game.IslandViewer;
import code.view.gui.GUI;
import code.view.gui.LanternaGUI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class elementsViewTest {

    @Test
    public void IslandViewerTest() throws IOException {
        Hero hero = new Hero(0, 0);
        LevelProgression levelprogression = new LevelProgression(hero);
        GUI lanternaGUI = Mockito.mock(GUI.class);
        Menu menu = new Menu(3);
        GameState GameState = new GameState(new IslandViewer(), levelprogression);

        Game game = new Game(lanternaGUI, levelprogression, hero, GameState);

        game.updateScreen();

        Mockito.verify(lanternaGUI, Mockito.times(1)).draw(GameState);

        GameState.travel();

        Mockito.verify(lanternaGUI, Mockito.times(1)).draw(GameState);

    }

    @Test
    public void BuyShopViewerTest() throws IOException {
        Hero hero = new Hero(0, 0);
        LevelProgression levelprogression = new LevelProgression(hero);
        GUI lanternaGUI = Mockito.mock(GUI.class);
        GameState GameState = new GameState(new IslandViewer(), levelprogression);
        Menu menu = new Menu(5);
        BuyShopState buyShopState = new BuyShopState(menu, new BuyShopViewer(), GameState);

        Game game = new Game(lanternaGUI, levelprogression, hero, buyShopState);

        game.updateScreen();

        Mockito.verify(lanternaGUI, Mockito.times(1)).draw(buyShopState);
    }
}
