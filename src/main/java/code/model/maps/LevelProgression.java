package code.model.maps;

import code.model.elements.Hero;

public class LevelProgression {
    private final Base baseIsland;
    private Map currentIsland;
    private Hero hero;
    private int islandCounter;

    public LevelProgression(Hero hero) {
        this.hero = hero;
        this.baseIsland = new Base(20, 9, hero);
        currentIsland = baseIsland;
        currentIsland.initHeroPos();
        islandCounter = 0;
    }

    public Map getCurrentIsland() {
        return currentIsland;
    }

    public void nextIsland(){
        islandCounter++;
        hero = currentIsland.getHero();
        currentIsland = new Island(40, 26, hero, islandCounter);
        currentIsland.initHeroPos();
    }

    public void recall(){
        this.currentIsland = baseIsland;
        currentIsland.initHeroPos();
        islandCounter = 0;
    }

    public int getIslandCounter(){return islandCounter;}
}
