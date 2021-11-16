package code.view.elements;

import code.model.elements.Monster;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class EnemyView implements ElementView<Monster>{
    @Override
    public void draw(Monster monster, TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#999933"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        graphics.putString(monster.getPosition().getX(), monster.getPosition().getY(), "M");
    }
}
