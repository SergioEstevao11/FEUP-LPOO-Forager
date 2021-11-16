package code.view.elements;

import code.model.Position;
import code.model.items.Pickaxe;
import code.model.items.Weapon;

import com.googlecode.lanterna.*;
import code.model.elements.Hero;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class HeroView implements ElementView<Hero>{
    TextGraphics graphics;
    @Override
    public void draw(Hero hero, TextGraphics graphics) {
        this.graphics = graphics;
        if(hero.getFrameCounter() % 2 == 0) {
            Position pos = hero.getPosition();
            graphics.setBackgroundColor(TextColor.Factory.fromString("#999933"));
            graphics.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
            switch (hero.getDirection()) {
                case "up":
                    if(hero.getAttackAction()) graphics.setCharacter(pos.getX(), pos.getY() - 1, '|');
                    graphics.setForegroundColor(TextColor.Factory.fromString("#FF7F00"));
                    graphics.setCharacter(pos.getX(), pos.getY(),Symbols.TRIANGLE_UP_POINTING_BLACK);
                    break;
                case "down":
                    if(hero.getAttackAction()) graphics.setCharacter(pos.getX(), pos.getY() + 1, '|');
                    graphics.setForegroundColor(TextColor.Factory.fromString("#FF7F00"));
                    graphics.setCharacter(pos.getX(), pos.getY(),Symbols.TRIANGLE_DOWN_POINTING_BLACK);
                    break;
                case "left":
                    if(hero.getAttackAction()) graphics.setCharacter(pos.getX() - 1, pos.getY(), '-');
                    graphics.setForegroundColor(TextColor.Factory.fromString("#FF7F00"));
                    graphics.setCharacter(pos.getX(), pos.getY(),Symbols.TRIANGLE_LEFT_POINTING_BLACK);
                    break;
                case "right":
                    if(hero.getAttackAction()) graphics.setCharacter(pos.getX() + 1, pos.getY(), '-');
                    graphics.setForegroundColor(TextColor.Factory.fromString("#FF7F00"));
                    graphics.setCharacter(pos.getX(), pos.getY(),Symbols.TRIANGLE_RIGHT_POINTING_BLACK);
                    break;
            }
            hero.setAttackAction(false);
        }
        else
            hero.changeFrameCounter(-1);

        graphics.setBackgroundColor(TextColor.Factory.fromString("#2b1d0e"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        graphics.putString(2, 36, "HP: ");
        for(int c = 0; c < hero.getHp(); c++){
            graphics.setCharacter(6+c, 36, '|');
        }
        Weapon w = hero.getInventory().getWeapon();
        Pickaxe p = hero.getInventory().getPickaxe();

        if(hero.getInventory().getEquippedTool() == p) {
            graphics.setForegroundColor(TextColor.Factory.fromString("#999933"));
            graphics.putString(12, 36, w.getName() + ": ");
            graphics.putString(15 + w.getName().length(), 36, w.getDamage()+"dmg ; ");
            graphics.putString(21+w.getName().length(), 36, w.getDurability()+"dur");

            graphics.setForegroundColor(TextColor.Factory.fromString("#76dffb"));

        }
        else{
            graphics.setForegroundColor(TextColor.Factory.fromString("#76dffb"));
            graphics.putString(12, 36, w.getName() + ": ");
            graphics.putString(15 + w.getName().length(), 36, w.getDamage()+"dmg ; ");
            graphics.putString(21+w.getName().length(), 36, w.getDurability()+"dur");

            graphics.setForegroundColor(TextColor.Factory.fromString("#999933"));

        }
        graphics.putString(40, 36, p.getName()+": ");
        graphics.putString(43 + p.getName().length(), 36, p.getDamage()+"dmg ; ");
        graphics.putString(49+p.getName().length(), 36, p.getDurability()+"dur");

    }
}