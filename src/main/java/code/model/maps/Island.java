package code.model.maps;

import code.model.Position;
import code.model.elements.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Island extends Map {

    public Island(int x, int y, Hero hero, int level) {
        super(x, y, hero);
        addMonsters(3 + level);
        addObjects(10);
        boat = new Boat(13, 28);
    }

    public void addMonsters(int quantity) {
        int x, y, numDrops;
        for (int i = 0; i < quantity; i++) {
            while (true) {
                y = ThreadLocalRandom.current().nextInt((35 - getHeight()) / 2+1, (35 + getHeight()) / 2);
                x = ThreadLocalRandom.current().nextInt((70 - getWidth()) / 2+1, (70 + getWidth()) / 2);

                if (canElementMove(new Position(x,y)) && verifyMonsterCollisions(new Position(x, y))) {
                    numDrops = ThreadLocalRandom.current().nextInt(1, 3);
                    getMonsters().add(new Monster(x, y, 5, new Resource("flesh", numDrops)));
                    break;
                }
            }
        }
    }
    public boolean verifyMonsterCollisions(Position position) {
        for (Monster monster : getMonsters())
            if (monster.getPosition().equals(position))
                return false;

        return true;
    }
    public void moveMonsters() {
        Position p;
        for (Monster monster : getMonsters()) {
            do {
                p = monster.move(hero.getPosition());
            } while (!canElementMove(p));

            monster.setPosition(p);
            if (monster.getPosition().equals(hero.getPosition())){
                hero.changeHp(-1);
            }
        }
    }


    public void addObjects(int quantity) {
        List<DestructibleGenerator> DGenerator = new ArrayList<>();
        DGenerator.add(new TreeGenerator());
        DGenerator.add(new RockGenerator());


        int x, y, random;
        for (int i = 0; i < quantity; i++) {
            while (true) {
                y = ThreadLocalRandom.current().nextInt((35 - getHeight()) / 2+1, (35 + getHeight()) / 2);
                x = ThreadLocalRandom.current().nextInt((70 - getWidth()) / 2+1, (70 + getWidth()) / 2);

                if (canElementMove(new Position(x,y)) && verifyMonsterCollisions(new Position(x, y))) {
                    random = ThreadLocalRandom.current().nextInt(2);
                    getObjects().add(DGenerator.get(random).generator(x, y));
                    break;
                }
            }
        }
    }
    public boolean verifyDestructibleCollisions (Position position) {
        for (Destructible d : getObjects())
            if (d.getPosition().equals(position))
                return false;

        return true;
    }


    @Override
    public void createMargins() {

        for (int c = 0; c < 70; c++) {
            addMargin(new Water(c, (35-getHeight())/2-1));
            addMargin(new Water(c, (35+getHeight())/2));
        }

        for (int r = 0; r < 35; r++) {
            addMargin(new Water((70-getWidth())/2-1, r));
            addMargin(new Water((70+getWidth())/2, r));
        }

    }

    @Override
    public boolean canElementMove(Position position) {
        return verifyMarginCollisions(position) && verifyDestructibleCollisions(position);
    }

    @Override
    public void initHeroPos() {
        hero.setPosition(new Position(15, 28));
    }



}
