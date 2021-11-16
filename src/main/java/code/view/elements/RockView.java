package code.view.elements;

import code.model.elements.Rock;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class RockView implements ElementView<Rock>{
    @Override
    public void draw(Rock rock, TextGraphics graphics) {
        int frameCounter = rock.getFrameCounter();
        if(frameCounter%2 == 0) {
            graphics.setBackgroundColor(TextColor.Factory.fromString("#999933"));
            graphics.setForegroundColor(TextColor.Factory.fromString("#808080"));
            graphics.putString(rock.getPosition().getX(), rock.getPosition().getY(), "R");
        }
        if(frameCounter > 0){
            rock.changeFrameCounter(-1);
        }
    }
}
