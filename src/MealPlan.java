/**
 * Created by Temi-tee on 5/1/2017.
 */
public class MealPlan {
    private String name;
    private String     description;
    private float       price;

    //Room Constructor
    public MealPlan() {
        name = null;
        description = null;
        price = 0;
    }

    //Room constructor
    public MealPlan(String name, String description, float price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public MealPlan(String name, float price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    //To String method
    public String toString () {
        return name;
    }

    //Get Type method
    public String getName() { return name; }
    //Get Description method
    public String getDescription(){return description;}
    //Get Price method
    public float getPrice() {return price;}
}
