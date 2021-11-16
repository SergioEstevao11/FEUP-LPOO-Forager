package code.control.states;

import code.control.command.Command;
import code.control.command.DoNothingCommand;
import code.control.command.menu.nextMenuOption;
import code.control.command.menu.previousMenuOption;
import code.control.command.player.SellItemCommand;
import code.control.command.states.ShopCommand;
import code.model.elements.Hero;
import code.model.Menu;
import code.view.game.SellShopViewer;
import code.view.gui.GUI;
import com.googlecode.lanterna.screen.TerminalScreen;

public class SellShopState extends MenuState{
    private final SellShopViewer sellShopViewer;
    private final State oldState;
    private final Hero hero;

    public SellShopState(Menu menu, SellShopViewer sellShopViewer, GameState oldState){
        super(menu);
        this.sellShopViewer = sellShopViewer;
        this.oldState = oldState;
        this.hero = oldState.getCurrentIsland().getHero();
    }

    @Override
    public Command getCommand(GUI.ACTION action) {
        if (action == GUI.ACTION.UP) return new previousMenuOption(menu);
        if (action == GUI.ACTION.DOWN) return new nextMenuOption(menu);
        if (action == GUI.ACTION.SELECT){
            int option = menu.getCurrentChoice();
            if(option == 0) return new ShopCommand(oldState);
            else{
                menu.decreaseOptions();
                return new SellItemCommand(option-1);
            }
        }
        return new DoNothingCommand();
    }

    @Override
    public void draw(TerminalScreen screen) {
        oldState.draw(screen);
        sellShopViewer.draw(screen,getMenu(),hero);
    }
}
