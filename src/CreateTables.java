//STEP 1. Import required packages

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/hotel_reservation_system";

    //  Database credentials
    static final String USER = "hoteladmin";
    static final String PASS = "password@1";

    public static void main(String[] args) {
        customersTable();
        createRooms();
        mealPlans();
        reservationsTable();
        reservedRooms();
    }//end main

    public static void reservationsTable(){
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
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();

            String sql = "CREATE TABLE RESERVATION " +
                    "(reservation_id INTEGER NOT NULL AUTO_INCREMENT," +
                    "customer_id INTEGER, " +
                    "mealPlan_id INTEGER, " +
                    "FOREIGN KEY (customer_id) REFERENCES CUSTOMERS(customer_id)," +
                    "FOREIGN KEY (mealPlan_id) REFERENCES MEALPLAN(mealPlan_id)," +
                    "PRIMARY KEY (reservation_id ))";

            stmt.executeUpdate(sql);
            System.out.println("Created reservation table in given database...");
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
    }// end createReservationTable


    public static void reservedRooms(){
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
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();

            String sql = "CREATE TABLE RESERVED_ROOMS " +
                    "(room_no INTEGER NOT NULL," +
                    "reservation_id INTEGER NOT NULL, " +
                    "date_to DATE,"  +
                    "date_from DATE," +
                    "FOREIGN KEY (reservation_id) REFERENCES RESERVATION (reservation_id)," +
                    "FOREIGN KEY (room_no) REFERENCES ROOMS (room_no)," +
                    "PRIMARY KEY (room_no, reservation_id))";
            stmt.executeUpdate(sql);
            System.out.println("Created reserved rooms table in given database...");
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
    }//end createReservedRoomTable

    public static void createRooms(){
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
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();

            String sql = "CREATE TABLE ROOMS" +
                    "(room_no INTEGER NOT NULL AUTO_INCREMENT," +
                    "type VARCHAR(50), " +
                    "cost INTEGER, " +
                    "PRIMARY KEY (room_no))";
            stmt.executeUpdate(sql);

            System.out.println("Created rooms table in given database...");
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
    }//end createRoomTable

    public static void mealPlans(){
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
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();

            String sql = "CREATE TABLE MEALPLAN " +
                    "(mealPlan_id INTEGER NOT NULL AUTO_INCREMENT," +
                    "name VARCHAR(50), " +
                    "cost INTEGER, " +
                    "PRIMARY KEY (mealPlan_id))";

            stmt.executeUpdate(sql);
            System.out.println("Created mealplan table in given database...");
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
    }//end createMealPlanasTable


    public static void customersTable(){
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
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();

            String sql = "CREATE TABLE CUSTOMERS " +
                    "(customer_id INTEGER NOT NULL AUTO_INCREMENT," +
                    " title VARCHAR(4), " +
                    " firstname VARCHAR(100), " +
                    " middlename VARCHAR(100), " +
                    " lastname VARCHAR(100), " +
                    " email VARCHAR(200), " +
                    " age INTEGER, " +
                    " phoneNumber VARCHAR(12), " +
                    " address1 VARCHAR(150), " +
                    " address2 VARCHAR(150), " +
                    " city VARCHAR(20), " +
                    " country VARCHAR(30), " +
                    " postalCode VARCHAR(6), " +
                    " province VARCHAR(20), " +
                    " PRIMARY KEY (customer_id))";

            stmt.executeUpdate(sql);
            System.out.println("Created customers table in given database...");
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
    }// end createCustomersTable
}//end CreateDatabase