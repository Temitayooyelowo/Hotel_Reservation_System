//STEP 1. Import required packages
import java.sql.*;
import java.util.*;
import java.util.Date;

public class Database {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/hotel_reservation_system";

    //  Database credentials
    static final String USER = "hoteladmin";
    static final String PASS = "password@1";

    public static int lastCustomer(){
        int customer_id = 0;
        Connection conn = null;
        Statement stmt=null;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Inserting records into the CUSTOMER table...");
            stmt = conn.createStatement();

            System.out.println("Getting the customer id");
            String sql = "SELECT * FROM CUSTOMERS ORDER BY customer_id DESC LIMIT 1";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                customer_id = rs.getInt("customer_id");
                System.out.println("Last customer id: " + customer_id);
            }

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        return customer_id;
    }

    public static void createReservation(int customer_id, String mealPlanName){
        Connection conn = null;
        Statement stmt = null;
        int reservation_id = 0;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Inserting records into the RESERVATION table...");
            stmt = conn.createStatement();

            System.out.println("Getting the mealPlan name");
            String sql = "SELECT mealPlan_id FROM MEALPLAN WHERE name = '" + mealPlanName + "'";
            ResultSet rs = stmt.executeQuery(sql);

            int mealPlan_id = 0;

            while(rs.next()) {
                mealPlan_id = rs.getInt("mealPlan_id");
                System.out.println("MEALPLAN ID: " + mealPlan_id);
            }
            reservation_id = getReservationId()+1;
            sql = "INSERT INTO RESERVATION(reservation_id, customer_id, mealPlan_id) VALUES ('" + reservation_id +
                    "','" + customer_id + "','"+ mealPlan_id + "')";
            stmt.executeUpdate(sql);
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }

    public static void insertReservedRoom(String roomName, String date_from, String date_to){
        int reservation_id = 0;
        Connection conn = null;
        Statement stmt=null;
        int roomNum = -1;

        //viewCustomers();

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Inserting records into the RESERVED_ROOMS table...");
            stmt = conn.createStatement();

            roomNum = findAvailableRoom(roomName, date_from, date_to);

            if(roomNum != -1) {
                String sql = "INSERT INTO RESERVED_ROOMS(room_no, reservation_id,date_to,date_from) VALUES ('" +
                        roomNum + "','" + getReservationId() + "','" + date_to + "','" + date_from + "')";
                stmt.executeUpdate(sql);
            }else{
                System.out.println("No available room found that meets your requirements");
            }
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    public static int getReservationId(){
        int reservation_id = 0;
        Connection conn = null;
        Statement stmt=null;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Inserting records into the RESERVED_ROOMS table...");
            stmt = conn.createStatement();

            //GET THE RESERVATION ID
            System.out.println("Getting the  reservation_id");
            String sql = "SELECT * FROM RESERVATION ORDER BY reservation_id DESC LIMIT 1";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                reservation_id = rs.getInt("reservation_id"); //increase the reservation id by 1
                System.out.println("RESERVATION ID: " + reservation_id);
            }

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try

        return reservation_id;
    }

    public static int findAvailableRoom(String roomName, String date_from, String date_to){
        Connection conn = null;
        Statement stmt=null;
        int roomNumber = -1;
        ArrayList<Integer> roomNumbers = new ArrayList<Integer>();

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Inserting records into the RESERVED_ROOMS table...");
            stmt = conn.createStatement();

            //Get the room numbers of the room that matches to a room type from the ROOM table
            String sql = "SELECT * FROM ROOMS WHERE type = '" + roomName + "'";
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("SIZE: " + rs.getFetchSize());

            while(rs.next()) {
                int roomNum = rs.getInt("room_no");
                System.out.println("ROOM NUM: " + roomNum );
                roomNumbers.add(roomNum);

            }//Found the room numbers of the room that matches to a room type
            System.out.println("");


            for(int i=0; i<roomNumbers.size(); i++){
                /*Look for the rooms that are not in the reserved rooms table*/
                sql = "SELECT * FROM ROOMS WHERE room_no = '" + roomNumbers.get(i) + "' AND (NOT EXISTS" +
                "(SELECT room_no FROM RESERVED_ROOMS WHERE room_no = '" + roomNumbers.get(i) + "'))";
                rs = stmt.executeQuery(sql);

                if(rs.next()){
                    roomNumber = rs.getInt("room_no");
                    System.out.println("Room no: " + rs.getInt("room_no"));
                    System.out.println("Type: " + rs.getString("type"));
                    System.out.println("Cost: " + rs.getInt("cost") + "\n");

                    return roomNumber;
                }else {
                    sql = "SELECT * FROM RESERVED_ROOMS WHERE room_no = '" + roomNumbers.get(i) + "' AND NOT(" +
                            "(date_from BETWEEN '" + date_from + "'AND '" + date_to + "') OR" +
                            "(date_to BETWEEN '" + date_from + "'AND '" + date_to + "')  OR" +
                            "(date_from <= '" + date_from + "' AND date_to >= '" + date_to + "'))";
                    rs = stmt.executeQuery(sql);

                    while (rs.next()) {
                        roomNumber = rs.getInt("room_no");
                        System.out.println("Room no: " + rs.getInt("room_no"));
                        System.out.println("Reservation id: " + rs.getInt("reservation_id"));
                        System.out.println("Date to: " + rs.getDate("date_to"));
                        System.out.println("Date from: " + rs.getDate("date_from") + "\n");

                        return roomNumber;
                    }
                }

            }
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        return roomNumber;
    }

    public static int insertCustomers(String title, String firstname, String middlename, String lastname,
                                       String email, int age, String phoneNumber, String address1, String address2,
                                       String city, String province, String country, String postalCode){
        Connection conn = null;
        Statement stmt = null;
        int customer_id = 0;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Inserting records into the customers table...");
            stmt = conn.createStatement();

            String sql = "INSERT INTO CUSTOMERS(title, firstname,middlename,lastname, email, age,phoneNumber, address1," +
                    "address2, city, country, postalCode, province) VALUES ('" + title + "','" + firstname +
                    "','" + middlename + "','" + lastname + "','" + email + "','" + age + "','" + phoneNumber + "','" +
                    address1 + "','" + address2 + "','" + city + "','" + country + "','" + postalCode + "','" + province + "')";
            stmt.executeUpdate(sql);

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
        return customer_id;
    }

    public static void deleteCustomers(String customerID){
        Connection conn = null;
        Statement stmt = null;
        int reservation_id = 0;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "SELECT * FROM RESERVATION WHERE customer_id = '" + customerID + "'";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                reservation_id = rs.getInt("reservation_id");
                System.out.println("Reservation id" + reservation_id);
            }

            sql = "DELETE FROM RESERVED_ROOMS WHERE reservation_id = '" + reservation_id + "'";
            stmt.executeUpdate(sql);

            sql = "DELETE FROM RESERVATION WHERE reservation_id = '" + reservation_id + "'";
            stmt.executeUpdate(sql);

            sql = "DELETE FROM CUSTOMERS WHERE customer_id = '" + customerID + "'";
            stmt.executeUpdate(sql);
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }

    public static void viewCustomers(){
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql = "SELECT * FROM CUSTOMERS";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            printCustomers(rs);
            rs.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }

    public static void searchByName(String name){
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql = "SELECT * FROM CUSTOMERS WHERE firstname LIKE '%"+
                    name + "%'";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            System.out.println("SIZE: " + rs.getFetchSize() + "");
            printCustomers(rs);
            rs.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }

    public static void searchByCustomerID(String cuID){
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql = "SELECT * FROM CUSTOMERS WHERE customer_id LIKE '%"+
                    cuID + "%'";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            printCustomers(rs);
            rs.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }

    public static void printCustomers(ResultSet rs){
        int count = 0;
        try {
            while (rs.next()) {
                count++;
                //Retrieve by column name
                String customerID = rs.getString("customer_id");
                String title = rs.getString("title");
                String firstname = rs.getString("firstname");
                String middlename = rs.getString("middlename");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                int age = rs.getInt("age");
                String phoneNumber = rs.getString("phoneNumber");
                String address1 = rs.getString("address1");
                String address2 = rs.getString("address2");
                String city = rs.getString("city");
                String province = rs.getString("province");
                String country = rs.getString("country");
                String postalCode = rs.getString("postalCode");

                //Display values
                System.out.println("CustomerID: " + customerID);
                System.out.println("Title: " + title);
                System.out.println("Firstname: " + firstname);
                System.out.println("Middlename: " + middlename);
                System.out.println("Lastname: " + lastname);
                System.out.println("Email: " + email);
                System.out.println("Age: " + age);
                System.out.println("Phonenumber: " + phoneNumber);
                System.out.println("Address1: " + address1);
                System.out.println("Address2: " + address2);
                System.out.println("City: " + city);
                System.out.println("Province: " + province);
                System.out.println("Country: " + country);
                System.out.println("PostalCode: " + postalCode + "\n");
            }
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }

        if(count<1){
            System.out.println("Customer was NOT found!!!");
        }
    }

    //change datatype to a set
    public static Set<Room> typesOfRooms(){
        Set<Room> typesOfRooms = new HashSet<Room>();

        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql = "SELECT * FROM ROOMS ";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                typesOfRooms.add(new Room(rs.getString("type"), rs.getInt("cost")));
            }

            rs.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");

        return typesOfRooms;
    }

    public static ArrayList<MealPlan> mealPlanList(){
        ArrayList<MealPlan> typesOfMealPlans = new ArrayList<MealPlan>();

        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql = "SELECT * FROM MEALPLAN ";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                typesOfMealPlans.add(new MealPlan(rs.getString("name"),
                        rs.getInt("cost")));
            }
            rs.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");

        return typesOfMealPlans;
    }

    public static ArrayList<Integer> getCustomerId(){
        ArrayList<Integer> customerIdList = new ArrayList<Integer>();
        Connection conn = null;
        Statement stmt=null;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Inserting records into the CUSTOMER table...");
            stmt = conn.createStatement();

            System.out.println("Getting the customer id");
            String sql = "SELECT customer_id FROM CUSTOMERS";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                customerIdList.add(rs.getInt("customer_id"));
            }

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        return customerIdList;
    }

    public static Customer displayCustomer(String customerID){
        Connection conn = null;
        Statement stmt = null;
        Customer newCustomer = new Customer();
        int reservation_id = 0;
        int mealPlan_id = 0;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "SELECT * FROM RESERVATION WHERE customer_id = '" + customerID + "'";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                reservation_id = rs.getInt("reservation_id");
                mealPlan_id = rs.getInt("mealPlan_id");
            }

            sql = "SELECT * FROM MEALPLAN WHERE mealPlan_id = '" + mealPlan_id + "'";
            rs = stmt.executeQuery(sql);

            while(rs.next()){
                System.out.println("MEALPLAN: " + rs.getString("name"));
                newCustomer.setMyMealPlan(rs.getString("name"));
            }

            sql = "SELECT * FROM RESERVED_ROOMS WHERE reservation_id = '" + reservation_id + "'";
            rs = stmt.executeQuery(sql);

            while(rs.next()){
                newCustomer.setDate_from(rs.getString("date_from"));
                newCustomer.setDate_to(rs.getString("date_to"));
                newCustomer.setMyRoom(rs.getInt("room_no"));
            }

            sql = "SELECT * FROM CUSTOMERS WHERE customer_id = '" + customerID + "'";
            rs = stmt.executeQuery(sql);

            while(rs.next()){
                newCustomer.setTitle(rs.getString("title"));
                newCustomer.setFirstName(rs.getString("firstname"));
                newCustomer.setMiddleName(rs.getString("middlename"));
                newCustomer.setLastName(rs.getString("lastname"));
                newCustomer.setAge(rs.getInt("age"));
                newCustomer.setPhoneNumber(rs.getString("phoneNumber"));
                newCustomer.setEmailAddress(rs.getString("email"));
                return newCustomer;
            }
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
        return null;
    }
}
