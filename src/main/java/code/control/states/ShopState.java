package code.control.states;

import code.control.command.Command;
import code.control.command.DoNothingCommand;
import code.control.command.menu.nextMenuOption;
import code.control.command.menu.previousMenuOption;
import code.control.command.states.BuyShopCommand;
import code.control.command.states.ResumeGameCommand;
import code.control.command.states.SellShopCommand;
import code.model.Menu;
import code.view.game.ShopViewer;
import code.view.gui.GUI;
import com.googlecode.lanterna.screen.TerminalScreen;

public class ShopState extends MenuState{

    private final ShopViewer shopViewer;
    private final State oldState;

    public ShopState(Menu menu, ShopViewer shopViewer, GameState oldState){
        super(menu);
        this.shopViewer= shopViewer;
        this.oldState = oldState;
    }

    @Override
    public Command getCommand(GUI.ACTION action) {
        if (action == GUI.ACTION.UP) return new previousMenuOption(menu);
        if (action == GUI.ACTION.DOWN) return new nextMenuOption(menu);
        if (action == GUI.ACTION.SELECT){
            int option = menu.getCurrentChoice();
            if(option == 0) return new BuyShopCommand(oldState);
            if(option == 1) return new SellShopCommand(oldState);
            else return new ResumeGameCommand(oldState);
        }
        return new DoNothingCommand();
    }

    @Override
    public void draw(TerminalScreen screen) {
        oldState.draw(screen);
        shopViewer.draw(screen,getMenu());
    }
}
