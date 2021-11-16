package code.model.maps;

import code.model.Position;
import code.model.elements.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Map {
    private final int width;
    private final int height;
    protected Hero hero;
    private final List<Water> margins;
    private final List<Monster> monsters;
    private final List<Destructible> objects;
    protected Boat boat;

    public Map(int w, int h, Hero hero) {
        this.width = w;
        this.height = h;
        this.hero = hero;

        this.margins = new ArrayList<>();
        this.monsters = new ArrayList<>();
        this.objects = new ArrayList<>();

        createMargins();
    }

    public int getWidth() {
        return this.width;
    }
    public int getHeight() {
        return this.height;
    }

    public Hero getHero() {
        return this.hero;
    }
    public void setHero(Hero hero) {
        this.hero = hero;
    }
    public Boat getBoat() {
        return this.boat;
    }
    public List<Destructible> getObjects() {
        return objects;
    }
    public List<Water> getMargins() {
        return this.margins;
    }

    public void addMargin(Water margin) {
        this.margins.add(margin);
    }
    public boolean verifyMarginCollisions(Position position) {
        for (Water w : margins)
            if (w.getPosition().equals(position))
                return false;

        return true;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }
    public abstract void moveMonsters();

    public abstract void createMargins();
    public abstract void initHeroPos();
    public abstract boolean canElementMove(Position position);

    public void checkHeroAttack(){
        for (Monster m : monsters) {
            if(hero.inRange(m.getPosition())){
                hero.doDamage(m);
                if (m.getHp() <= 0){
                    m.giveDrops(hero);
                    monsters.remove(m);
                    break;
                }
            }
        }
        for (Destructible d : objects) {
            if (hero.inRange(d.getPosition())) {
                hero.doDamage(d);
                if (d.getHp() <= 0) {
                    d.giveDrops(hero);
                    objects.remove(d);
                    break;
                }
            }
        }
    }

}