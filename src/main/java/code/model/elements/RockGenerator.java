package code.model.elements;

import java.util.concurrent.ThreadLocalRandom;

public class RockGenerator implements DestructibleGenerator {
    @Override
    public Rock generator(int x, int y) {
        int random = ThreadLocalRandom.current().nextInt(1, 3);
        return new Rock(x, y, random);
    }
}
