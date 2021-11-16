package code.model;

import code.model.elements.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class DestructibleTest {

    @Test
    public void createTreeTest() {
        Tree tree = new Tree(5, 5, 0);

        Assertions.assertEquals(tree.getPosition(), new Position(5, 5));
    }

    @Test
    public void createRockTest() {
        Rock rock = new Rock( 6, 6, 0);

        Assertions.assertEquals(rock.getPosition(), new Position(6, 6));
    }

    @Test
    public void hpTest() {
        Destructible d = new Tree(1, 2, 0);

        Assertions.assertEquals(d.getHp(), 5);

        d.setHp(10);

        Assertions.assertEquals(d.getHp(), 10);

        d.changeHp(1);

        Assertions.assertEquals(d.getHp(), 11);
    }

    @Test
    public void resourceTest() {
        Destructible d = new Rock(3,2, 0);

        Assertions.assertEquals(d.getDrops(), new Resource ("rock"));

        Resource marble = new Resource("marble");
        d.setDrops(marble);

        Assertions.assertEquals(d.getDrops(), marble);
    }

    @Test
    public void frameCounterTest(){
        Destructible d = new Rock(1,3, 2);

        Assertions.assertEquals(d.getFrameCounter(), 0);

        d.setFrameCounter(10);

        Assertions.assertEquals(d.getFrameCounter(), 10);
        
        d.changeFrameCounter(-1);

        Assertions.assertEquals(d.getFrameCounter(), 9);
    }

    @Test
    public void receiveDropsTest(){
        Destructible d = new Rock(5,2, 2);
        Hero hero = new Hero(1,2);

        d.giveDrops(hero);

        Assertions.assertEquals(hero.getInventory().getResources().size(), 1);
    }
}
