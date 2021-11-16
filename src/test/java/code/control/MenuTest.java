package code.control;

import code.control.command.Command;
import code.control.command.menu.nextMenuOption;
import code.control.command.menu.previousMenuOption;
import code.control.states.MainMenuState;
import code.control.states.State;
import code.model.Menu;
import code.model.elements.Hero;
import code.model.maps.LevelProgression;
import code.view.game.MainMenuViewer;
import code.view.gui.GUI;
import code.view.gui.LanternaGUI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class MenuTest {

    @Test
    public void MenuNavigation(){
        Hero hero = new Hero(0, 0);
        LevelProgression levelprogression = new LevelProgression(hero);
        GUI lanternaGUI = new LanternaGUI();
        Menu menu = new Menu(4);
        State state = new MainMenuState(menu, new MainMenuViewer());

        Game game = new Game(lanternaGUI, levelprogression, hero, state);

        Command command = new nextMenuOption(menu);
        command.exec(game);
        Assertions.assertEquals(menu.getCurrentChoice(), 1);
        command = new previousMenuOption(menu);
        command.exec(game);
        Assertions.assertEquals(menu.getCurrentChoice(), 0);
    }


}
