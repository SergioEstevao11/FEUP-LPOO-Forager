package code.model.elements;

import java.util.concurrent.ThreadLocalRandom;

public class TreeGenerator implements DestructibleGenerator {
    @Override
    public Tree generator(int x, int y) {
        int random = ThreadLocalRandom.current().nextInt(1, 3);
        return new Tree(x, y, random);
    }
}
