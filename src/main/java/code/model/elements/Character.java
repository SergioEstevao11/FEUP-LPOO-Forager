package code.model.elements;

import code.model.Position;

public abstract class Character extends Element {

    private int hp;

    public Character(int x, int y, int hp) {
        super(x,y);
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void changeHp(int value) {
        setHp(getHp() + value);
    }

    public Position moveUp() {
        return new Position(getPosition().getX(), getPosition().getY() - 1);
    }
    public Position moveDown() {
        return new Position(getPosition().getX(), getPosition().getY() + 1);
    }
    public Position moveLeft() {
        return new Position(getPosition().getX() - 1, getPosition().getY());
    }
    public Position moveRight() {
        return new Position(getPosition().getX() + 1, getPosition().getY());
    }

}
