import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class CheckOutView extends VBox{
    private Button backButton;
    public Button getBackButton() {
        return backButton;
    }

    private Boolean backPressed= false;
    private ListView<Integer> namesList;
    private ReservationDetailView reservationDetailView;
    private CustomerDetailsView customerDetails;
    private Boolean failed = true;
    private Boolean checkoutPressed = false;
    private Button checkOut;
    private String customerId = "";;
    private HotelMenuBar hotelMenuBar;

    public void setCheckoutPressed(Boolean checkoutPressed) { this.checkoutPressed = checkoutPressed; }
    public Boolean getCheckoutPressed() { return checkoutPressed; }

    public Button getCheckOut() { return checkOut; }
    public Boolean getFailed() { return failed; }
    public void setFailed(Boolean failed) { this.failed = failed; }
    public Boolean getBackPressed() { return backPressed; }
    public ListView<Integer> getNamesList() { return namesList; }
    public ReservationDetailView getReservationDetailView() { return reservationDetailView; }
    public CustomerDetailsView getCustomerDetails() { return customerDetails; }
    public HotelMenuBar getHotelMenuBar() { return hotelMenuBar; }

    public void setBackPressed(Boolean backPressed) { this.backPressed = backPressed; }

    public CheckOutView(){
        Pane aPane = new Pane();
        hotelMenuBar= new HotelMenuBar();

        reservationDetailView = new ReservationDetailView(175);
        reservationDetailView.relocate(30, 10);
        reservationDetailView.setPrefSize(300, 150);
        aPane.getChildren().add(reservationDetailView);

        customerDetails = new CustomerDetailsView("CUSTOMER DETAILS");
        customerDetails.relocate(30,170);
        aPane.getChildren().add(customerDetails);

        //Create Back Button
        backButton = new Button("Back");
        backButton.relocate(20,445);
        aPane.getChildren().add(backButton);

        checkOut = new Button("Check Out");
        checkOut.relocate(530,445);
        aPane.getChildren().add(checkOut);

        getChildren().addAll(hotelMenuBar,aPane);
        //update();
    }

    public void update(){
        Customer newCustomer=null;
        Alert alert = new Alert(Alert.AlertType.ERROR);
        // Get the Stage and add a custom icon
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("hotel2.jpg"));

        if(backPressed){
            reservationDetailView.getBookfromTextField().setText("");
            reservationDetailView.getBookToTextField().setText("");
            reservationDetailView.getCustomer_idTextField().setText("");
            reservationDetailView.getMealPlanTextField().setText("");
            reservationDetailView.getRoom_noTextField().setText("");

            customerDetails.getTitleTextField().setText("");
            customerDetails.getFirsNameTextField().setText("");
            customerDetails.getMiddleNameTextField().setText("");
            customerDetails.getLastNameTextField().setText("");
            customerDetails.getAgeTextField().setText("");
            customerDetails.getPhoneNumberTextField().setText("");
            customerDetails.getEmailAddressTextField().setText("");
            backPressed = false;
        }else{
            TextInputDialog dialog = new TextInputDialog();
            // Get the Stage and add a custom icon
            Stage dialogStage = (Stage) dialog.getDialogPane().getScene().getWindow();
            dialogStage.getIcons().add(new Image("hotel2.jpg"));

            dialog.setTitle("Input Required");
            dialog.setHeaderText(null);
            dialog.setContentText("Please enter your customer id:");
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()){
                customerId = result.get();
                System.out.println("Your ID is: " + customerId);
                newCustomer = Database.displayCustomer(customerId);

                if(newCustomer !=null){
                    reservationDetailView.getBookfromTextField().setText(newCustomer.getDate_from());
                    reservationDetailView.getBookToTextField().setText(newCustomer.getDate_to());
                    reservationDetailView.getCustomer_idTextField().setText(customerId);
                    reservationDetailView.getMealPlanTextField().setText(newCustomer.getMyMealPlan());
                    reservationDetailView.getRoom_noTextField().setText(Integer.toString(newCustomer.getMyRoom()));

                    customerDetails.getTitleTextField().setText(newCustomer.getTitle());
                    customerDetails.getFirsNameTextField().setText(newCustomer.getFirstName());
                    customerDetails.getMiddleNameTextField().setText(newCustomer.getMiddleName());
                    customerDetails.getLastNameTextField().setText(newCustomer.getLastName());
                    customerDetails.getAgeTextField().setText(Integer.toString(newCustomer.getAge()));
                    customerDetails.getPhoneNumberTextField().setText(newCustomer.getPhoneNumber());
                    customerDetails.getEmailAddressTextField().setText(newCustomer.getEmailAddress());

                    failed = false;
                }else{
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Error !");
                    alert.setHeaderText(null);
                    alert.setContentText("Customer not found");
                    alert.showAndWait();
                    failed = true;
                }
            }else{
                failed = true;
            }
        }

        if(customerId != "" && checkoutPressed) {
            Database.deleteCustomers(customerId);
            System.out.println("Customer Id1: " + customerId);
            System.out.println("Check out pressed1: " + checkoutPressed);

            System.out.println("DELETING CUSTOMTERS....");
            checkoutPressed = false;

            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setTitle("IMPORTANT INFORMATION");
            alert.setContentText("You have been checked out.");
            alert.setHeaderText(null);
            alert.showAndWait();
            checkoutPressed = false;
            customerId = "";
        }

        checkoutPressed = false;
    }
}
