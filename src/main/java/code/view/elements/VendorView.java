package code.view.elements;

import code.model.elements.Vendor;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class VendorView implements ElementView<Vendor>{
    @Override
    public void draw(Vendor vendor, TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#999933"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#d5b60a"));
        graphics.putString(vendor.getPosition().getX(), vendor.getPosition().getY(), "V");
    }
}
