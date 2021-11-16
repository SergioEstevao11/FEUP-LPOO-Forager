package code.model.elements;

import code.model.Position;

import java.util.concurrent.ThreadLocalRandom;

public class Monster extends Character {

    private final Resource drops;

    public Monster(int x, int y, int hp, Resource drops){
        super(x, y, hp);
        this.drops = drops;
    }

    public Position move(Position heroPos) {
        Position p = getPosition();
        int randomNum = ThreadLocalRandom.current().nextInt(2);

        switch(randomNum){
            case 0:
                if(heroPos.getY() > p.getY())   return super.moveDown();
                else    return super.moveUp();
            case 1:
                if(heroPos.getX() > p.getX())   return super.moveRight();
                else    return super.moveLeft();
            default:
                return p;
        }

    }

    public void giveDrops(Hero hero){
        hero.getInventory().addResource(drops);
    }
}
