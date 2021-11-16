
package code.control.command.menu;
import code.control.Game;
import code.control.command.Command;
import code.model.Menu;

public class nextMenuOption implements Command{
    private final Menu menu;

    public nextMenuOption(Menu menu){
        this.menu = menu;
    }


    @Override
    public void exec(Game game) {
        menu.nextOption();
    }
}
