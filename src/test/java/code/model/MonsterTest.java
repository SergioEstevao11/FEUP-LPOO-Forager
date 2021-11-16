package code.model;

import code.model.elements.Hero;
import code.model.elements.Monster;
import code.model.elements.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MonsterTest {

    @Test
    public void createMonsterTest(){
        Monster m = new Monster(5, 5, 10, new Resource("flesh"));

        Assertions.assertEquals(m.getPosition(), new Position(5, 5));
        Assertions.assertEquals(m.getHp(), 10);
    }

    @Test
    public void monsterMoveTest(){
        Monster m = new Monster(5, 5, 10, new Resource("flesh"));
        Hero hero = new Hero(10,10);

        Position originalPosition = m.getPosition();

        m.setPosition(m.move(hero.getPosition()));

        Assertions.assertNotEquals(m.getPosition(), originalPosition);
    }

    @Test
    public void monsterDropsTest(){
        Monster m = new Monster(5, 5, 10, new Resource("flesh", 2));
        Hero hero = new Hero(5,5);
        hero.getInventory().getResources().clear();
        m.giveDrops(hero);
        Assertions.assertEquals(hero.getInventory().getResources().size(), 1);
    }
}
