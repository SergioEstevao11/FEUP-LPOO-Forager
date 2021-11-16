package code.view.elements;

import code.model.Position;
import code.model.elements.Boat;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class BoatView implements ElementView<Boat>{
    @Override
    public void draw(Boat boat, TextGraphics graphics) {
        Position boatPos = boat.getPosition();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#76dffb"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        graphics.putString(boatPos.getX(), boatPos.getY()-1, "|>");
        graphics.setForegroundColor(TextColor.Factory.fromString("#964B00"));
        graphics.putString(boatPos.getX()-1, boatPos.getY(), "###");
    }
}
