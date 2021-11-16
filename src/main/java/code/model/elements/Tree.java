package code.model.elements;

public class Tree extends Destructible {

    public Tree(int x, int y, int numDrops) {
        super(x, y, 5, new Resource("wood", numDrops));
    }


}
