package code.control.states;

import code.control.command.Command;
import code.control.command.DoNothingCommand;
import code.control.command.menu.nextMenuOption;
import code.control.command.menu.previousMenuOption;
import code.control.command.player.BuyItemCommand;
import code.control.command.states.ShopCommand;
import code.model.elements.Hero;
import code.model.elements.Vendor;
import code.model.maps.Base;
import code.model.Menu;
import code.view.game.BuyShopViewer;
import code.view.gui.GUI;
import com.googlecode.lanterna.screen.TerminalScreen;

public class BuyShopState extends MenuState{
    private final BuyShopViewer buyShopViewer;
    private final State oldState;
    private final Hero hero;
    private final Vendor vendor;

    public BuyShopState(Menu menu, BuyShopViewer buyShopViewer, GameState oldState){
        super(menu);
        this.buyShopViewer = buyShopViewer;
        this.oldState = oldState;
        this.vendor = ((Base)oldState.getCurrentIsland()).getVendor();
        this.hero = oldState.getCurrentIsland().getHero();
    }

    @Override
    public Command getCommand(GUI.ACTION action) {
        if (action == GUI.ACTION.UP) return new previousMenuOption(menu);
        if (action == GUI.ACTION.DOWN) return new nextMenuOption(menu);
        if (action == GUI.ACTION.SELECT){
            int option = menu.getCurrentChoice();
            if(option == 0) return new ShopCommand(oldState);
            else return new BuyItemCommand(vendor,option);
        }
        return new DoNothingCommand();
    }

    @Override
    public void draw(TerminalScreen screen) {
        oldState.draw(screen);
        buyShopViewer.draw(screen,getMenu(),vendor,hero);
    }
}
