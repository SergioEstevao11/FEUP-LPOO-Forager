package code.model.elements;

import java.util.Objects;

public class Resource {
    String name;
    int quantity;

    public Resource (String name){
        this.name = name;
        this.quantity = 1;
    }
    public Resource (String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getQuantity(){
        return this.quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public void changeQuantity(int change){
        setQuantity(getQuantity() + change);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resource that = (Resource) o;
        return Objects.equals(getName(), that.getName());
    }

}
