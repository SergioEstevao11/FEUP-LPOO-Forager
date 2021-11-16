package code.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MenuTest {
    @Test
    public void creatingMenuTest() {
        Menu menu = new Menu(5);

        Assertions.assertEquals(menu.getCurrentChoice(), 0);

        menu.nextOption();

        Assertions.assertEquals(menu.getCurrentChoice(), 1);

        menu.nextOption();
        menu.previousOption();
        menu.previousOption();

        Assertions.assertEquals(menu.getCurrentChoice(), 0);

        menu.decreaseOptions();

    }
}
