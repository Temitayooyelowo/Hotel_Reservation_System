import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Optional;

/**
 * Created by Temi-tee on 5/28/2017.
 */
public class CheckInView extends VBox {
    //Check if the save button is pressed
    private Boolean savePressed= false;
    private Boolean backPressed= false;
    public void setSavePressed(Boolean savePressed) {this.savePressed = savePressed;}
    public void setBackPressed(Boolean backPressed) { this.backPressed = backPressed; }

    public Boolean getSavePressed() {return savePressed;}

    //Back button
    private Button backButton;
    private Button saveButton;
    private HotelMenuBar hotelMenuBar;

    public Button getBackButton() {
        return backButton;
    }
    public Button getSaveButton() {
        return saveButton;
    }
    public HotelMenuBar getHotelMenuBar() { return hotelMenuBar; }

    //Create canvas and pen
    private Canvas canvas;

    Pane myPane;

    BookingInfoPane bookingInfoPane;
    CustomerInfoPane customerInfoPane;

    // The model to which this view is attached
    public CheckInView() {
        Label bookingDetailsLabel = new Label("Booking Details");
        bookingDetailsLabel.relocate(100,20);
        bookingDetailsLabel.setStyle("-fx-background-color: white; \n" +
                "-fx-translate-y: -8; \n" + "-fx-translate-x: 10;");
        Label customerDetailsLabel = new Label (" Customer Details");
        customerDetailsLabel.relocate(375,20);
        customerDetailsLabel.setStyle("-fx-background-color: white; \n" +
                "-fx-translate-y: -8; \n" + "-fx-translate-x: 10;");

        int innerPaneWidth =265, innerPaneHeight = 420;

        //Create a pane
        myPane = new Pane();
        int canvasHeight = 500, canvasWidth = 620;

        //Create a canvas
        canvas = new Canvas(canvasWidth, canvasHeight);

        hotelMenuBar= new HotelMenuBar();

        myPane.setPrefWidth(Integer.MAX_VALUE);
        myPane.setPrefHeight(Integer.MAX_VALUE);

        //Create Back Button
        backButton = new Button("Back");
        backButton.relocate(20,innerPaneHeight+25);
        saveButton = new Button ("Booking");
        saveButton.relocate(530,innerPaneHeight+25);

        //Store the items in this pane
        bookingInfoPane = new BookingInfoPane();
        bookingInfoPane.relocate(35,20);
        bookingInfoPane.setPrefSize(innerPaneWidth,innerPaneHeight);
        //This signifies the end of the bookingInfoPane

        //Create the second pane and all it's components
        customerInfoPane = new CustomerInfoPane();
        customerInfoPane .setStyle(" -fx-background-color: white;\n" +
                "-fx-border-color: gray; \n" + "-fx-padding: 4 4;");
        customerInfoPane .relocate(310,20);
        customerInfoPane .setPrefSize(innerPaneWidth,innerPaneHeight);
        //This signifies the end of the customerInfoPane

        // Add all the components to the window
        myPane.getChildren().addAll(bookingInfoPane,customerInfoPane,bookingDetailsLabel,customerDetailsLabel,
                backButton, saveButton);
        getChildren().addAll(hotelMenuBar,myPane);

        //Call the update function
        update();
    }
    // This method is called whenever the model changes
    public void update() {
        // ... code for refreshing the view
        int number =0;
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        // Get the Stage and add a custom icon
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("hotel2.jpg"));

        alert.setX(460);
        alert.setY(250);

        //Checks if all the required fields are filled (Need to ensure the dayBox, adultsBox and childrenBox are
        //filled by the user to prevent getting NullPointerExceptions.
        if(savePressed) {

            if ((customerInfoPane.getTitleBox().getValue() != null) &&
                    (customerInfoPane.getFirstNameTextField().getText().length()>0) &&
                    (customerInfoPane.getLastnameTextField().getText().length()>0) &&
                    (customerInfoPane.getProvinceTextField().getText().length()>0) &&
                    (customerInfoPane.getAddress1TextField().getText().length()>0) &&
                    (customerInfoPane.getCityTextField().getText().length()>0) &&
                    (customerInfoPane.getCountryComboBox().getValue() != null) &&
                    (customerInfoPane.getPostalCodeTextField().getText().length()>0) &&
                    (customerInfoPane.getPhoneNumberTextField().getText().length()>0) &&
                    (bookingInfoPane.getRoomTypeBox().getValue()!= null) &&
                    (bookingInfoPane.getMealPlanBox().getValue()!= null)) {

                Dialog dialog = new PaymentDialogBox();
                stage = (Stage) dialog.getDialogPane().getScene().getWindow();
                stage.getIcons().add(new Image("hotel2.jpg")); // To add an icon
                Optional result = dialog.showAndWait();

                if(result.get() == ButtonType.CANCEL ){
                    System.out.println("Cancel button is clicked");
                }else{
                    System.out.println("Purchase button is clicked");

                    savePressed = false;
                    if(Database.findAvailableRoom( bookingInfoPane.roomTypeBox.getValue().toString(),
                            bookingInfoPane.getBookFromDatePicker().getValue().toString(),
                            bookingInfoPane.getBookToDatePicker().getValue().toString())!= -1) {

                        String errorOutput = "";
                        boolean isValid = true;
                        if(!ValidityChecks.isTextValid(customerInfoPane.getFirstNameTextField().getText())){
                            errorOutput+="Invalid input in the First Name Field\n";
                            isValid=false;
                        }
                        if(!ValidityChecks.isTextValid(customerInfoPane.getMiddleNameTextField().getText())){
                            errorOutput+="Invalid input in the Middle Name Field\n";
                            isValid=false;
                        }
                        if(!ValidityChecks.isTextValid(customerInfoPane.getLastnameTextField().getText())){
                            errorOutput+="Invalid input in the Last Name Field\n";
                            isValid=false;
                        }
                        if(!ValidityChecks.isEmailValid(customerInfoPane.getEmailAddressTextField().getText())){
                            errorOutput+="Invalid input in Email Address Field\n";
                            isValid=false;
                        }
                        if(!ValidityChecks.isNumberValid(customerInfoPane.getAgeTextField().getText())){
                            errorOutput+="Invalid input in Age Field\n";
                            isValid=false;
                        }
                        if(!ValidityChecks.isNumberValid(customerInfoPane.getPhoneNumberTextField().getText())){
                            errorOutput+="Invalid input in Phone Number Field\n";
                            isValid=false;
                        }
                        if(!ValidityChecks.isTextValid(customerInfoPane.getCityTextField().getText())){
                            errorOutput+="Invalid input in the City Field\n";
                            isValid=false;
                        }
                        if(!ValidityChecks.isTextValid(customerInfoPane.getProvinceTextField().getText())){
                            errorOutput+= "Invalid input in the Province Field";
                            isValid=false;
                        }

                        if(isValid){
                            Database.insertCustomers(customerInfoPane.getTitleBox().getValue().toString(),
                                    customerInfoPane.getFirstNameTextField().getText(),
                                    customerInfoPane.getMiddleNameTextField().getText(),
                                    customerInfoPane.getLastnameTextField().getText(),
                                    customerInfoPane.getEmailAddressTextField().getText(),
                                    Integer.parseInt(customerInfoPane.getAgeTextField().getText()),
                                    customerInfoPane.getPhoneNumberTextField().getText(),
                                    customerInfoPane.getAddress1TextField().getText(),
                                    customerInfoPane.getAddress2TextField().getText(),
                                    customerInfoPane.getCityTextField().getText(),
                                    customerInfoPane.getProvinceTextField().getText(),
                                    customerInfoPane.getCountryComboBox().getValue().toString(),
                                    customerInfoPane.getPostalCodeTextField().getText());
                            int customerId = Database.lastCustomer();
                            Database.createReservation(customerId, bookingInfoPane.getMealPlanBox().getValue().toString());
                            Database.insertReservedRoom(bookingInfoPane.getRoomTypeBox().getValue().toString(),
                                    bookingInfoPane.getBookFromDatePicker().getValue().toString(),
                                    bookingInfoPane.getBookToDatePicker().getValue().toString());
                            bookingInfoPane.getCustomerIdTextField().setText(Integer.toString(customerId));

                            alert.setAlertType(Alert.AlertType.INFORMATION);
                            alert.setTitle("The information is now saved");
                            alert.setHeaderText(null);
                            alert.setContentText("Thank you for booking with us.");
                            alert.setX(460);
                            alert.setY(250);
                            alert.showAndWait();
                        }else{
                            alert.setAlertType(Alert.AlertType.ERROR);
                            alert.setTitle("Error Dialog");
                            alert.setHeaderText("Invalid input entered");
                            alert.setContentText(errorOutput);
                            alert.showAndWait();
                        }
                    }else{
                        System.out.println("No available room was found. Customer could NOT be checked in!");
                        alert.setAlertType(Alert.AlertType.ERROR);
                        alert.setTitle("IMPORTANT");
                        alert.setHeaderText(null);
                        alert.setContentText("No available " + bookingInfoPane.roomTypeBox.getValue().toString() +
                                " room was found for the time period you selected.");
                        alert.showAndWait();
                    }
                }
            } else{
                System.out.println("Not all required fields were filled out!!!!");
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setTitle("IMPORTANT");
                alert.setHeaderText(null);
                alert.setContentText("Please fill out all the required fields. Thanks for your co-operation.");
                alert.showAndWait();

                savePressed = false;
            }//end of else
        }//end of if safe pressed

        if(backPressed){
            bookingInfoPane.getBookFromDatePicker().setValue(null);
            bookingInfoPane.getBookToDatePicker().setValue(null);
            bookingInfoPane.getRoomTypeBox().setValue(null);
            bookingInfoPane.getMealPlanBox().setValue(null);
            bookingInfoPane.getTotalTextField().setText("");
            bookingInfoPane.getCustomerIdTextField().setText("");

            customerInfoPane.getFirstNameTextField().setText("");
            customerInfoPane.getMiddleNameTextField().setText("");
            customerInfoPane.getLastnameTextField().setText("");
            customerInfoPane.getAgeTextField().setText("");
            customerInfoPane.getAddress1TextField().setText("");
            customerInfoPane.getAddress2TextField().setText("");
            customerInfoPane.getCityTextField().setText("");
            customerInfoPane.getProvinceTextField().setText("");
            customerInfoPane.getCountryComboBox().setValue(null);
            customerInfoPane.getPostalCodeTextField().setText("");
            customerInfoPane.getPhoneNumberTextField().setText("");
            customerInfoPane.getEmailAddressTextField().setText("");
            //System.out.println("Back pressed: " + backPressed);
            backPressed=false;
        }//end of if(backPressed) statement
    }


}
