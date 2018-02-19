/**
 * Created by Temi-tee on 5/28/2017.
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;


public class HotelReservationApp extends Application{
    public HomePageView firstPageView;
    public int previous = 0;
    public int current = 0;

    // Initialize things before the app starts (optional)
    public void init() {
        //...
        System.out.println("App is about to start");
    }
    // Clean up things just before the app stops (optional)
    public void stop() {
        //...
        System.out.println("App is about to stop");
    }


    public void start(Stage primaryStage) {
        int height = 500;
        int width = 610;
        HomePageView homePage = new HomePageView();
        CheckInView checkIn = new CheckInView();
        CheckOutView checkOut = new CheckOutView();
        CustomerListView customerListView = new CustomerListView();

        ArrayList<Scene> scenes = new ArrayList<>();
        scenes.add(new Scene(homePage, width, height));
        scenes.add(new Scene(checkIn, width, height));
        scenes.add(new Scene(checkOut, width, height));
        scenes.add(new Scene(customerListView, width, height));

        //Sets the icon, title, scene, makes the HOME PAGE non-resizable
        primaryStage.getIcons().add(new Image("hotel2.jpg"));
        primaryStage.setResizable(false);
        primaryStage.setScene(scenes.get(0));
        primaryStage.show();

        homePage.getCheckInButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                primaryStage.setTitle("Booking");
                primaryStage.setScene(scenes.get(current=1));
            }});

        homePage.getCheckOutButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                checkOut.update();
                if(!checkOut.getFailed()) {
                    primaryStage.setTitle("Check Out");
                    primaryStage.setScene(scenes.get(current=2));
                }
            }});

        homePage.getViewCustomersButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                customerListView.update();
                primaryStage.setTitle("View Customers");
                primaryStage.setScene(scenes.get(3));
            }});

        homePage.getHotelMenuBar().getBookingItem().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setTitle("Booking");
                primaryStage.setScene(scenes.get(1));
            }
        } );

        homePage.getHotelMenuBar().getCheckOutItem().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkOut.update();
                if(!checkOut.getFailed()) {
                    primaryStage.setTitle("Check Out");
                    primaryStage.setScene(scenes.get(2));
                }
            }
        });

        homePage.getHotelMenuBar().getViewCustomersItem().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                customerListView.update();
                primaryStage.setTitle("View Customers");
                primaryStage.setScene(scenes.get(3));
            }
        });

        checkIn.getBackButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                checkIn.setBackPressed(true);
                checkIn.update();
                customerListView.update();
                primaryStage.setTitle("Home Page");
                primaryStage.setScene(scenes.get(0));
            }});

        checkIn.getSaveButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                //Update the secondPageView and save the customer Details
                checkIn.setSavePressed(true);
                checkIn.update();
            }
        });

        checkIn.getHotelMenuBar().getBookingItem().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setTitle("Booking");
                primaryStage.setScene(scenes.get(1));
            }
        } );

        checkIn.getHotelMenuBar().getCheckOutItem().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkOut.update();
                if(!checkOut.getFailed()) {
                    primaryStage.setTitle("Check Out");
                    primaryStage.setScene(scenes.get(2));
                }
            }
        });

        checkIn.getHotelMenuBar().getViewCustomersItem().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                customerListView.update();
                primaryStage.setTitle("View Customers");
                primaryStage.setScene(scenes.get(3));
            }
        });

        customerListView.getBackButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                customerListView.setBackPressed(true);
                customerListView.update();
                primaryStage.setTitle("Home Page");
                primaryStage.setScene(scenes.get(0));
            }});

        customerListView.getNamesList().setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                    customerListView.update();
            }
        });

        customerListView.getHotelMenuBar().getBookingItem().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setTitle("Booking");
                primaryStage.setScene(scenes.get(1));
            }
        } );

        customerListView.getHotelMenuBar().getCheckOutItem().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkOut.update();
                if(!checkOut.getFailed()) {
                    primaryStage.setTitle("Check Out");
                    primaryStage.setScene(scenes.get(2));
                }
            }
        });

        customerListView.getHotelMenuBar().getViewCustomersItem().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                customerListView.update();
                primaryStage.setTitle("View Customers");
                primaryStage.setScene(scenes.get(3));
            }
        });

        checkOut.getBackButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                checkOut.setBackPressed(true);
                checkOut.update();
                primaryStage.setTitle("Home Page");
                primaryStage.setScene(scenes.get(0));
            }});

        checkOut.getCheckOut().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                checkOut.setCheckoutPressed(true);
                checkOut.setBackPressed(true);
                checkOut.update();
                primaryStage.setTitle("Home Page");
                primaryStage.setScene(scenes.get(0));
            }});

        checkOut.getHotelMenuBar().getBookingItem().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setTitle("Booking");
                primaryStage.setScene(scenes.get(1));
            }
        } );

        checkOut.getHotelMenuBar().getCheckOutItem().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkOut.update();
                if(!checkOut.getFailed()) {
                    primaryStage.setTitle("Check Out");
                    primaryStage.setScene(scenes.get(2));
                }
            }
        });

        checkOut.getHotelMenuBar().getViewCustomersItem().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                customerListView.update();
                primaryStage.setTitle("View Customers");
                primaryStage.setScene(scenes.get(3));
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
