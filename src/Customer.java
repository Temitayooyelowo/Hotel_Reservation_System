/**
 * Created by Temi-tee on 4/27/2017.
 */
public class Customer extends Person{

    //Declare variables
    private String date_to;
    private String date_from;
    private int myRoom;
    private String myMealPlan;
    private int customerId;

    //Get methods
    public String getDate_from() {return date_from; }
    public String getDate_to(){return date_to;}
    public int getMyRoom(){return myRoom;}
    public String  getMyMealPlan() {return myMealPlan;}
    public int getCustomerId(){return customerId;}

    //Set methods
    public void setDate_from(String date_from) { this.date_from = date_from; }
    public void setMyRoom (int  room){this.myRoom = room;}
    public void setCustomerId(int customerId){this.customerId = customerId;}
    public void setDate_to(String date_to) {this.date_to = date_to;}
    public void setMyMealPlan(String myMealPlan){this.myMealPlan = myMealPlan;}

    //Zero Parameter constructor.
    public Customer()
    {
        super();
        this.date_to ="";
        this.date_from ="";
        this.myRoom = -1;
        this.myMealPlan = "";
        this.customerId = -1;
    }

    //Multiple Argument constructor
    public Customer (int customerId, String title,String firstName, String middleName,String lastname, String phoneNum, String email,
                     int age, int roomNumber,String mealPlan, String date_to, String date_from)
    {
        super(title,firstName,middleName,lastname,age, email,phoneNum);

        this.date_to = date_to;
        this.date_from = date_from;
        this.myRoom = roomNumber;
        this.myMealPlan = mealPlan;
        this.customerId = customerId;
    }

    /*public String toString()
    {
        return super.toString() + ": "+ customerId + " and would be staying for " + lengthOfStay + " days. in room " + myRoom.getRoomNumber() + " Total Cost: $"
                + String.format("%,1.2f",totalCost()) + " PhoneNumber: " + getPhoneNumber();
    }

    public float totalCost()
    {
        float totalPrice=0;

        if(myRoom!=null) totalPrice += myRoom.getPrice();
        if(myMealPlan !=null) totalPrice +=myMealPlan.getPrice();

        totalPrice *= lengthOfStay;

        return totalPrice;
    }*/

}
