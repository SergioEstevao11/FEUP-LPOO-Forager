package code.view.elements;

import code.model.elements.Element;
import com.googlecode.lanterna.graphics.TextGraphics;

public interface ElementView<T extends Element> {
    void draw(T element, TextGraphics graphics);
}
