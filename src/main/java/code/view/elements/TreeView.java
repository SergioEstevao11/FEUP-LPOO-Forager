package code.view.elements;

import code.model.elements.Tree;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class TreeView implements ElementView<Tree>{
    @Override
    public void draw(Tree tree, TextGraphics graphics) {
        int frameCounter = tree.getFrameCounter();
        if(frameCounter%2 == 0) {
            graphics.setBackgroundColor(TextColor.Factory.fromString("#999933"));
            graphics.setForegroundColor(TextColor.Factory.fromString("#654321"));
            graphics.putString(tree.getPosition().getX(), tree.getPosition().getY(), "T");
        }
        if(frameCounter > 0){
            tree.changeHp(-1);
        }
    }
}
