package code.model;

import code.model.elements.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DestructibleGeneratorTest {

    @Test
    public void RockGeneratorTest() {
        RockGenerator rg = new RockGenerator();

        Rock rock = rg.generator(5,5);

        Assertions.assertEquals(rock.getPosition(), new Position(5, 5));
    }

    @Test
    public void TreeGeneratorTest() {
        TreeGenerator tg = new TreeGenerator();

        Tree tree = tg.generator(9, 9);

        Assertions.assertEquals(tree.getPosition(), new Position (9, 9));
    }
}
