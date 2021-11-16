package code.control;

import code.control.command.Command;
import code.control.command.player.*;
import code.control.states.BuyShopState;
import code.control.states.GameState;
import code.model.Menu;
import code.model.Position;
import code.model.elements.Hero;
import code.model.elements.Resource;
import code.model.maps.Base;
import code.model.maps.LevelProgression;
import code.view.game.BuyShopViewer;
import code.view.game.IslandViewer;
import code.view.gui.GUI;
import code.view.gui.LanternaGUI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerCommandTest {

    @Test
    public void MoveHeroTest() {
        Hero hero = new Hero(20, 20);
        Base base = new Base(60,60, hero);

        LevelProgression levelprogression = new LevelProgression(hero);
        GUI lanternaGUI = new LanternaGUI();
        Menu menu = new Menu(5);
        GameState GameState = new GameState(new IslandViewer(), levelprogression);
        BuyShopState buyShopState = new BuyShopState(menu, new BuyShopViewer(), GameState);

        Game game = new Game(lanternaGUI, levelprogression, hero, buyShopState);

        MoveHeroUp moveHeroUp = new MoveHeroUp(base);
        MoveHeroLeft moveHeroLeft = new MoveHeroLeft(base);
        MoveHeroDown moveHeroDown= new MoveHeroDown(base);
        MoveHeroRight moveHeroRight = new MoveHeroRight(base);

        Position position = new Position(hero.getPosition().getX(), hero.getPosition().getY());


        moveHeroUp.exec(game);
        Position newPosition = new Position(hero.getPosition().getX(), hero.getPosition().getY());

        Assertions.assertEquals(position.getX(), newPosition.getX());
        Assertions.assertNotEquals(position.getY(), newPosition.getY());


        moveHeroLeft.exec(game);
        newPosition = new Position(hero.getPosition().getX(), hero.getPosition().getY());

        Assertions.assertNotEquals(position.getX(), newPosition.getX());
        Assertions.assertNotEquals(position.getY(), newPosition.getY());


        moveHeroDown.exec(game);
        newPosition = new Position(hero.getPosition().getX(), hero.getPosition().getY());

        Assertions.assertNotEquals(position.getX(), newPosition.getX());
        Assertions.assertEquals(position.getY(), newPosition.getY());


        moveHeroRight.exec(game);
        newPosition = new Position(hero.getPosition().getX(), hero.getPosition().getY());

        Assertions.assertEquals(position.getX(), newPosition.getX());
        Assertions.assertEquals(position.getY(), newPosition.getY());
    }

    @Test
    public void BuySellItemCommandTest(){
        Hero hero = new Hero(0, 0);
        hero.getInventory().addResource(new Resource("wood", 5));
        LevelProgression levelprogression = new LevelProgression(hero);
        GUI lanternaGUI = new LanternaGUI();
        Menu menu = new Menu(5);
        GameState GameState = new GameState(new IslandViewer(), levelprogression);
        BuyShopState buyShopState = new BuyShopState(menu, new BuyShopViewer(), GameState);

        Game game = new Game(lanternaGUI, levelprogression, hero, buyShopState);

        menu.nextOption();

        int numItems = hero.getInventory().getItems().size();

        Command command = new BuyItemCommand(((Base)GameState.getCurrentIsland()).getVendor(), menu.getCurrentChoice());
        command.exec(game);
        Assertions.assertEquals(hero.getInventory().getItems().size(), numItems+1);

        command = new SellItemCommand(menu.getCurrentChoice());

        command.exec(game);

        Assertions.assertEquals(hero.getInventory().getItems().size(), numItems);

    }
}
