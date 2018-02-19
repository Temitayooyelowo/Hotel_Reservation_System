import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class CustomerListView extends VBox {
    private Button backButton;
    public Button getBackButton() {
        return backButton;
    }

    private Boolean backPressed= false;
    private ListView<Integer> namesList;
    private ReservationDetailView reservationDetailView;
    private CustomerDetailsView customerDetails;
    private HotelMenuBar hotelMenuBar;

    public ListView<Integer> getNamesList() { return namesList; }
    public ReservationDetailView getReservationDetailView() { return reservationDetailView; }
    public CustomerDetailsView getCustomerDetails() { return customerDetails; }
    public HotelMenuBar getHotelMenuBar() { return hotelMenuBar; }

    public void setBackPressed(Boolean backPressed) { this.backPressed = backPressed; }
    public CustomerListView(){
        Pane aPane = new Pane();
        hotelMenuBar= new HotelMenuBar();

        // Add the list
        namesList = new ListView<Integer>();
        namesList.setItems(FXCollections.observableArrayList(Database.getCustomerId()));
        namesList.setEditable(false);
        namesList.relocate(30, 10);
        namesList.setPrefSize(100, 140);
        aPane.getChildren().add(namesList);

        reservationDetailView = new ReservationDetailView(135);
        reservationDetailView.relocate(140, 10);
        reservationDetailView.setPrefSize(200, 150);
        aPane.getChildren().add(reservationDetailView);

        customerDetails = new CustomerDetailsView("CUSTOMER DETAILS");
        customerDetails.relocate(30,170);
        aPane.getChildren().add(customerDetails);

        //Create Back Button
        backButton = new Button("Back");
        backButton.relocate(20,445);
        aPane.getChildren().add(backButton);

        getChildren().addAll(hotelMenuBar,aPane);

        update();
    }

    public void update(){
        // Remember what was selected
        namesList.setItems(FXCollections.observableArrayList(Database.getCustomerId()));
        int selectedIndex = namesList.getSelectionModel().getSelectedIndex();

        if(selectedIndex>-1){
            int selectedItem = namesList.getSelectionModel().getSelectedItem();
            System.out.println("SELECTED ITEM: " + selectedItem);

            Customer newCustomer = Database.displayCustomer(Integer.toString(selectedItem));

            reservationDetailView.getBookfromTextField().setText(newCustomer.getDate_from());
            reservationDetailView.getBookToTextField().setText(newCustomer.getDate_to());
            reservationDetailView.getCustomer_idTextField().setText(Integer.toString(selectedItem));
            reservationDetailView.getMealPlanTextField().setText(newCustomer.getMyMealPlan());
            reservationDetailView.getRoom_noTextField().setText(Integer.toString(newCustomer.getMyRoom()));

            customerDetails.getTitleTextField().setText(newCustomer.getTitle());
            customerDetails.getFirsNameTextField().setText(newCustomer.getFirstName());
            customerDetails.getMiddleNameTextField().setText(newCustomer.getMiddleName());
            customerDetails.getLastNameTextField().setText(newCustomer.getLastName());
            customerDetails.getAgeTextField().setText(Integer.toString(newCustomer.getAge()));
            customerDetails.getPhoneNumberTextField().setText(newCustomer.getPhoneNumber());
            customerDetails.getEmailAddressTextField().setText(newCustomer.getEmailAddress());
        }

        if(backPressed){
            namesList.getSelectionModel().clearSelection();

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
        }
        System.out.println("SELECTED INDEX: " + selectedIndex);

    }
}
