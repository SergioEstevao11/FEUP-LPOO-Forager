package code.model.elements;

public class Rock extends Destructible {

    public Rock(int x, int y, int numDrops) {
        super(x, y, 10, new Resource("rock", numDrops));
    }


}
