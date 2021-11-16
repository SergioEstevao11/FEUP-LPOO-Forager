package code.model.elements;


import code.model.Position;
import code.model.items.*;

public class Hero extends Character {

    private String direction;
    private boolean dead;
    private int frameCounter;
    private boolean attackAction;

    private final int maxHP;

    private final Inventory inventory;

    public Hero(int x, int y) {
        super(x, y, 3);

        maxHP = 5;

        this.direction = "up";
        this.dead = false;
        this.frameCounter = 0;
        this.attackAction = false;

        this.inventory = new Inventory();
    }

    public Inventory getInventory(){
        return inventory;
    }

    public String getDirection(){
        return this.direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public boolean getDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public int getFrameCounter() {
        return frameCounter;
    }

    public void changeFrameCounter(int value) {
        frameCounter += value;
    }

    public boolean getAttackAction(){
        return attackAction;
    }

    public void setAttackAction(boolean attackAction){
        this.attackAction = attackAction;
    }

    public boolean inRange(Position position) {
        Position targetPos = new Position(getPosition());
        Position targetPosAdvanced = new Position(getPosition());
        switch (getDirection()) {
            case "up":
                targetPos.changeY(-1);
                targetPosAdvanced.changeY(-2);
                break;
            case "down":
                targetPos.changeY(1);
                targetPosAdvanced.changeY(2);
                break;
            case "left":
                targetPos.changeX(-1);
                targetPosAdvanced.changeX(-2);
                break;
            case "right":
                targetPos.changeX(1);
                targetPosAdvanced.changeX(2);
                break;
            default:
                System.out.println("Error at hero position");
        }
        return targetPos.equals(position) || targetPosAdvanced.equals(position);
    }

    public void doDamage(Element e){
        Tool equippedTool = inventory.getEquippedTool();
        equippedTool.doAction();
        if (e instanceof Destructible && equippedTool instanceof Pickaxe) {
            ((Destructible)e).changeHp(-equippedTool.getDamage());
        }
        else if (e instanceof Monster && equippedTool instanceof Weapon) {
            ((Monster)e).changeHp(-equippedTool.getDamage());
        }
        inventory.checkCurrentToolDurability();
    }

    public void useItem(Item item){
        if(item instanceof Tool){
            inventory.equipTool((Tool)item);
        }
        else{
           changeHp(((Potion)item).getHealing());
           inventory.getItems().remove(item);
        }
    }


    @Override
    public Position moveUp() {
        setDirection("up");
        return super.moveUp();
    }
    @Override
    public Position moveDown() {
        setDirection("down");
        return super.moveDown();
    }
    @Override
    public Position moveLeft() {
        setDirection("left");
        return super.moveLeft();
    }
    @Override
    public Position moveRight() {
        setDirection("right");
        return super.moveRight();
    }

    @Override
    public void changeHp(int change) {
        super.changeHp(change);
        if (getHp() == 0) {
            dead = true;
        }
        else{
            setHp(getHp()%maxHP);
        }
    }



}

