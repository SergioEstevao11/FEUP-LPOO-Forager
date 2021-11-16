package code.model;

public class Menu {
    private int numOptions;
    private int currentChoice;

    public Menu(int numOptions) {
        this.numOptions = numOptions;
        currentChoice = 0;

    }

    public void nextOption(){
        currentChoice++;
        currentChoice %= numOptions;
    }

    public void previousOption(){
        currentChoice--;
        if(currentChoice == -1){
            currentChoice = numOptions-1;
        }
    }

    public void decreaseOptions(){
        numOptions--;
        currentChoice %= numOptions;
    }

    public int getCurrentChoice() {
        return currentChoice;
    }
}
