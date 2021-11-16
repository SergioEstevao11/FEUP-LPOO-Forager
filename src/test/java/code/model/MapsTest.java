package code.model;

import code.model.elements.*;
import code.model.maps.Base;
import code.model.maps.Island;
import code.model.maps.LevelProgression;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MapsTest {

    @Test
    public void createBaseTest() {
        Hero hero = new Hero(5,5);
        Base b = new Base(30, 35, hero);

        Assertions.assertEquals(b.getWidth(), 30);
        Assertions.assertEquals(b.getHeight(), 35);
        Assertions.assertEquals(b.getHero().getPosition(), new Position(5,5));
        Assertions.assertEquals(b.getBoat().getPosition(), new Position(40, 16));
        Assertions.assertEquals(b.getVendor().getPosition(), new Position(29, 18));

        b.initHeroPos();
        Assertions.assertEquals(b.getHero().getPosition(), new Position(35, 20));
    }

    @Test
    public void createIslandTest(){
        Hero hero = new Hero(5,5);
        Island i = new Island(40, 45, hero, 1);

        Assertions.assertEquals(i.getWidth(), 40);
        Assertions.assertEquals(i.getHeight(), 45);
        Assertions.assertEquals(i.getHero().getPosition(), new Position(5,5));
        Assertions.assertEquals(i.getBoat().getPosition(), new Position(13, 28));
        Assertions.assertEquals(i.getMonsters().size(), 4);
        Assertions.assertEquals(i.getObjects().size(), 10);

        i.initHeroPos();
        Assertions.assertEquals(i.getHero().getPosition(), new Position(15, 28));
    }

    @Test
    public void islandObjectsCreationTest(){
        Hero hero = new Hero(5,5);
        Island island = new Island(50,50, hero, 1);

        Assertions.assertEquals(island.getMonsters().size(), 4);
        Assertions.assertEquals(island.getObjects().size(), 10);

        island.addObjects(10);

        Assertions.assertEquals(island.getObjects().size(), 20);

        island.addMonsters(7);

        Assertions.assertEquals(island.getMonsters().size(), 11);
    }

    @Test
    public void baseHeroMovimentTest(){
        Hero hero = new Hero(5,5);
        Base base = new Base(50, 50, hero);
        base.initHeroPos();

        Assertions.assertTrue(base.canElementMove(hero.moveUp()));

        Position p = new Position(base.getVendor().getPosition().getX(), base.getVendor().getPosition().getY());
        p.changeY(1);
        base.getHero().setPosition(p);

        Assertions.assertFalse(base.canElementMove(hero.moveUp()));
    }

    @Test
    public void islandHeroMovementTest(){
        Hero hero = new Hero(5,5);
        Island island = new Island(50, 50, hero, 1);
        island.initHeroPos();

        island.getMonsters().clear();
        island.getObjects().clear();

        Assertions.assertTrue(island.canElementMove(hero.moveUp()));

        Position p = new Position(25, 25);
        island.getObjects().add(new Tree(p.getX(), p.getY(), 2));
        island.getMonsters().add(new Monster(p.getX(), p.getY(), 1, new Resource("flesh")));
        p.changeY(1);
        island.getHero().setPosition(p);

        Assertions.assertFalse(island.canElementMove(hero.moveUp()));

        island.getObjects().clear();

        Assertions.assertTrue(island.canElementMove(hero.moveUp()));
    }

    @Test
    public void islandMoveMonstersTest(){
        Hero hero = new Hero(5, 5);
        Island island = new Island(50, 50, hero, 1);

        ArrayList<Position> originalPositions = new ArrayList<>();
        for (Monster m : island.getMonsters())
            originalPositions.add(new Position(m.getPosition().getX(), m.getPosition().getY()));

        island.moveMonsters();

        ArrayList<Position> newPositions = new ArrayList<>();
        for (Monster m : island.getMonsters())
            newPositions.add(new Position(m.getPosition().getX(), m.getPosition().getY()));

        boolean xEquals, yEquals;
        for (int i = 0; i < originalPositions.size(); i++) {
            xEquals = originalPositions.get(i).getX() == newPositions.get(i).getX();
            yEquals = originalPositions.get(i).getY() == newPositions.get(i).getY();
            // Only one of X or Y coordinate can change at every monster move, therefore a XOR operator is needed.
            Assertions.assertTrue(xEquals ^ yEquals);
        }
    }

    @Test
    public void createLevelProgressionTest() {
        Hero hero = new Hero(5, 5);
        LevelProgression levelProgression = new LevelProgression(hero);

        Assertions.assertEquals(levelProgression.getIslandCounter(), 0);
        Assertions.assertEquals(levelProgression.getCurrentIsland().getClass(), Base.class);

        levelProgression.nextIsland();
        Assertions.assertEquals(levelProgression.getCurrentIsland().getClass(), Island.class);

        levelProgression.recall();
        Assertions.assertEquals(levelProgression.getCurrentIsland().getClass(), Base.class);
    }
}
