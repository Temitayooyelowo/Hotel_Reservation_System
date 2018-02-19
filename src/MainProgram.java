import java.util.Scanner;

public class MainProgram {


    public static void main(String[] args){

        //Database.findAvailableRoom("Family Room","2017-12-28", "2018-12-28");
        MainMenu();                     //calls the main Menu method
    }

    public static void MainMenu(){

        Scanner sc = new Scanner (System.in);
        String menuChoice = "-1";
        String menuText = "Enter your menu choice --> ";

        while(!menuChoice.equals("6")){
            System.out.println("\n////////////////////////////////////////////////");
            System.out.println("*********   1. Check In               *********");
            System.out.println("*********   2. Check Out              *********");
            System.out.println("*********   3. View Customers         *********");
            System.out.println("*********   4. Search by name         *********");
            System.out.println("*********   5. Search by customer ID  *********");
            System.out.println("*********   6. Quit                   *********");
            System.out.println("////////////////////////////////////////////////");
            System.out.print(menuText);
            menuChoice = sc.nextLine();
            menuText = "Enter your menu choice --> ";

            switch(menuChoice){
                case "1":
                    CheckIn();
                    break;
                case "2":
                    CheckOut();
                    break;
                case "3":
                    Database.viewCustomers();
                    break;
                case "4":
                    String name = "";
                    System.out.print("\nEnter a name --> ");
                    name = sc.nextLine();
                    System.out.println("");
                    Database.searchByName(name);
                    break;
                case "5":
                    String id = "";
                    System.out.print("\nEnter your id --> ");
                    id = sc.nextLine();
                    System.out.println("");
                    Database.searchByCustomerID(id);
                    break;
                case "6":
                    // do something
                    System.out.println("Goodbye !!!");
                    break;
                default:
                    menuText = "Error! Invalid menu choice. Please a valid menu choice --> ";
            }
        }
    }

    public static void CheckOut() {
        Scanner sc = new Scanner (System.in);
        String answer = "";
        String customerID = "";

        System.out.print("\nAre you sure you want to checkout?(y/n) ");
        answer = sc.nextLine();

        while (!answer.toLowerCase().equals("yes") && !answer.toLowerCase().equals("y") &&
                !answer.toLowerCase().equals("n") && !answer.toLowerCase().equals("no")){

            System.out.println("Please enter a valid answer");
            System.out.print("Are you sure you want to checkout?(y/n) ");
            answer = sc.nextLine();
        }

        if(answer.toLowerCase().equals("n") || answer.toLowerCase().equals("no")){
            return;
        }

        System.out.print("Enter your customer id--> ");
        customerID = sc.nextLine();

        Database.deleteCustomers(customerID);

        System.out.println("You've been checked out. Goodbye!");
    }

    public static void CheckIn(){
        Scanner sc = new Scanner (System.in);

        String title = "", firstName = "", middleName = "",lastname = "", tempAge ="";
        String emailAddress = "", phoneNumber = "", address1 = "", address2 = "";
        String city = "", province ="", country = "", postalCode = "";
        String roomName = "", mealName = "", date_from = "", date_to = "";
        int age = -1;
        boolean isValid= false;

        System.out.print("\nEnter your title --> ");
        title = sc.nextLine();

        System.out.print("Enter your first name --> ");
        firstName = sc.nextLine();
        isValid = ValidityChecks.isTextValid(firstName);
        while(!isValid){
            System.out.print("Name should only contain letters. Enter a valid name --> ");
            firstName = sc.nextLine();
            isValid = ValidityChecks.isTextValid(firstName);
        }

        System.out.print("Enter your middle name --> ");
        middleName = sc.nextLine();
        isValid = ValidityChecks.isTextValid(middleName);
        while(!isValid){
            System.out.print("Name should only contain letters. Enter a valid name --> ");
            middleName = sc.nextLine();
            isValid = ValidityChecks.isTextValid(middleName);
        }

        System.out.print("Enter your lastname --> ");
        lastname = sc.nextLine();
        isValid = ValidityChecks.isTextValid(lastname);
        while(!isValid){
            System.out.print("Name should only contain letters. Enter a valid name --> ");
            lastname = sc.nextLine();
            isValid = ValidityChecks.isTextValid(lastname);
        }

        System.out.print("Enter your age --> ");
        tempAge = sc.nextLine();
        isValid = ValidityChecks.isNumberValid(tempAge);
        while(!isValid){
            System.out.print("Name should only contain letters. Enter a valid name --> ");
            tempAge = sc.nextLine();
            isValid = ValidityChecks.isNumberValid(tempAge);
        }
        age = Integer.parseInt(tempAge);

        System.out.print("Enter your email address --> ");
        emailAddress = sc.nextLine();
        isValid = ValidityChecks.isEmailValid(emailAddress);
        while(!isValid){
            System.out.print("Email is not valid. Enter a valid email--> ");
            emailAddress = sc.nextLine();
            isValid = ValidityChecks.isEmailValid(emailAddress);
        }

        System.out.print("Enter your phone number --> ");
        phoneNumber = sc.nextLine();

        System.out.print("Enter your address --> ");
        address1 = sc.nextLine();

        System.out.print("Enter your address --> ");
        address2 = sc.nextLine();

        System.out.print("Enter your city --> ");
        city = sc.nextLine();
        isValid = ValidityChecks.isTextValid(city);
        while(!isValid){
            System.out.print("City names should only contain letters. Enter a valid city --> ");
            city = sc.nextLine();
            isValid = ValidityChecks.isTextValid(city);
        }

        System.out.print("Enter your province/state --> ");
        province = sc.nextLine();
        isValid = ValidityChecks.isTextValid(province);
        while(!isValid){
            System.out.print("City names should only contain letters. Enter a valid province/state --> ");
            province = sc.nextLine();
            isValid = ValidityChecks.isTextValid(province);
        }

        System.out.print("Enter your country --> ");
        country = sc.nextLine();
        isValid = ValidityChecks.isTextValid(country);
        while(!isValid){
            System.out.print("City names should only contain letters. Enter a valid city --> ");
            country = sc.nextLine();
            isValid = ValidityChecks.isTextValid(country);
        }

        System.out.print("Enter your postal code --> ");
        postalCode = sc.nextLine();
        System.out.print("Enter the date from (yyyy-mm-dd) --> ");
        date_from = sc.nextLine();

        isValid = ValidityChecks.isDateValid(date_from);
        while(!isValid){
            System.out.print("Wrong format! Enter the date from in the correct format (yyy-mm-dd)--> ");
            date_from = sc.nextLine();
            isValid = ValidityChecks.isDateValid(date_from);
        }

        System.out.print("Enter the date to (yyy-mm-dd)--> ");
        date_to = sc.nextLine();
        isValid = ValidityChecks.isDateValid(date_to);
        while(!isValid){
            System.out.print("Wrong format! Enter the date to in the correct format (yyy-mm-dd)--> ");
            date_to = sc.nextLine();
            isValid = ValidityChecks.isDateValid(date_to);
        }
        System.out.println("");

        mealName = MealPlan();
        roomName = roomMenu();

        if(Database.findAvailableRoom(roomName, date_from, date_to)!= -1) {
            Database.insertCustomers(title, firstName, middleName, lastname, emailAddress, age, phoneNumber, address1,
                    address2, city, province, country, postalCode);
            Database.createReservation(Database.lastCustomer(), mealName);
            Database.insertReservedRoom(roomName, date_from, date_to);
        }else{
            System.out.println("No available room was found. Customer could NOT be checked in!");
        }
    }

    public  static String roomMenu(){
        Scanner sc = new Scanner (System.in);

        String roomMenuChoice = "-1";
        String roomName="";
        while(!roomMenuChoice.equals("1") && !roomMenuChoice.equals("2") && !roomMenuChoice.equals("3") &&
                !roomMenuChoice.equals("4")) {
            System.out.println("/////////////////////////////////////");
            System.out.println("*********   1. Single Room  *********");
            System.out.println("*********   2. Twin Room    *********");
            System.out.println("*********   3. Family Room  *********");
            System.out.println("*********   4. Quit      *********");
            System.out.println("//////////////////////////////////");
            System.out.print("Enter your menu choice --> ");
            roomMenuChoice = sc.nextLine();
            System.out.println("");

            switch (roomMenuChoice) {
                case "1":
                    //returns the available single room
                    roomName = "Single Room";
                    break;
                case "2":
                    //do something
                    roomName = "Twin Room";
                    break;
                case "3":
                    //do something
                    roomName = "Family Room";
                    break;
                case "4":
                    // do something
                    System.out.println("Goodbye !!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Error! Invalid menu choice");
            }//end of switch statement
        }//end of while loop
        return roomName;
    }

    public  static String MealPlan(){
        Scanner sc = new Scanner (System.in);

        String roomMenuChoice = "-1";
        String mealName = "";
        while(!roomMenuChoice.equals("1") && !roomMenuChoice.equals("2") && !roomMenuChoice.equals("3") &&
                !roomMenuChoice.equals("4")) {
            System.out.println("/////////////////////////////////////////////////////////////////////////////////");
            System.out.println("*********   1. No meal Plan - Does not include any meals ($0.00)       *********");
            System.out.println("*********   2. Continental Plan (CP) - A meal per day $(30.00)         *********");
            System.out.println("*********   3. Modified American Plan (MAP) - Two meals per day ($60)  *********");
            System.out.println("*********   4. American Plan (AP) - Three meals per day                *********");
            System.out.println("/////////////////////////////////////////////////////////////////////////////////");
            System.out.print("Enter your menu choice --> ");
            roomMenuChoice = sc.nextLine();
            System.out.println("");

            switch (roomMenuChoice) {
                case "1":
                    //returns the available single room
                    mealName = "No meal Plan";
                    break;
                case "2":
                    //do something
                    mealName = "Continental Plan";
                    break;
                case "3":
                    //do something
                    mealName = "Modified American Plan";
                    break;
                case "4":
                    //do something
                    mealName = "American Plan";
                    break;
                case "5":
                    // do something
                    System.out.println("Goodbye !!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Error! Invalid menu choice");
            }//end of switch statement
        }//end of while loop
        return mealName;
    }
}

