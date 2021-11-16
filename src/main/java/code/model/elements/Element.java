package code.model.elements;

import code.model.Position;

import java.util.Objects;

public abstract class Element {
    private Position position;

    public Element(int x, int y){
        position = new Position(x, y);
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return Objects.equals(getPosition(), element.getPosition());
    }

}
