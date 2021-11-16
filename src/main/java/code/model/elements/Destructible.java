package code.model.elements;

public abstract class Destructible extends Element {
    private int hp;
    private Resource drops;
    private int frameCounter;

    public Destructible(int x, int y, int hitPoints, Resource drops) {
        super(x, y);
        this.hp = hitPoints;
        this.drops = drops;
        frameCounter = 0;
    }

    public int getHp() {
        return this.hp; 
    }
    public void setHp(int hp){
        this.hp = hp;
    }
    public void changeHp(int value){
        if(value < 0) frameCounter = 1;
        this.hp += value;
    }

    public Resource getDrops() {
        return this.drops;
    }
    public void setDrops(Resource drops) {
        this.drops = drops;
    }

    public void giveDrops(Hero hero){
        hero.getInventory().addResource(drops);
    }

    public int getFrameCounter(){
        return frameCounter;
    }
    public void setFrameCounter(int frameCounter) {
        this.frameCounter = frameCounter;
    }
    public void changeFrameCounter(int value){
        frameCounter += value;
    }


}
