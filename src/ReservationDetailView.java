import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReservationDetailView extends Pane {
    //
    private TextField bookToTextField;
    private TextField bookFromTextField;
    private TextField customer_idTextField;
    private TextField mealPlanTextField;
    private TextField room_noTextField;
    private TextField costTextField;

    //Get methods
    public TextField getCostTextField() { return costTextField; }
    public TextField getRoom_noTextField() { return room_noTextField; }
    public TextField getMealPlanTextField() { return mealPlanTextField; }
    public TextField getCustomer_idTextField() { return customer_idTextField; }
    public TextField getBookfromTextField() {
        return bookFromTextField;
    }
    public TextField getBookToTextField() {
        return bookToTextField;
    }

    public ReservationDetailView(int butWidth){
        Pane innerPane = new Pane();
        innerPane.setStyle("-fx-background-color: white; \n" +
                "-fx-border-color: gray; \n" +
                "-fx-padding: 4 4;"); // margin spacing at bottom right

        /*int buttonHeight=30, buttonWidth=135, buttonX=150, buttonY=20, buttonIncrement=35,
                labelHeight = 30, labelWidth=100, labelX=10, labelY=buttonY;*/

        int buttonHeight=30, buttonWidth=butWidth, labelHeight = 30, labelWidth=100;
        int labelX=10, labelY1=10, labelY2=70, increment= buttonWidth+10;
        int buttonX=labelX, buttonY1=40, buttonY2=100;

        // Create the labels and textfields
        Label bookFromLabel = new Label ("Check In Date:");
        bookFromLabel.relocate(labelX, labelY1);
        bookFromLabel.setStyle("-fx-font-size:15");
        String pattern = "yyyy-MM-dd";
        bookFromTextField = new TextField();
        bookFromTextField.setEditable(false);
        bookFromTextField.relocate(buttonX, buttonY1);
        bookFromTextField.setPrefSize(buttonWidth, buttonHeight);

        Label bookToLabel = new Label ("Check Out Date:");
        bookToLabel.relocate(labelX,labelY2);
        bookToLabel.setStyle("-fx-font-size: 15");
        bookToTextField = new TextField();
        bookToTextField.setEditable(false);
        bookToTextField.relocate(buttonX, buttonY2);
        bookToTextField.setPrefSize(buttonWidth, buttonHeight);

        labelX += increment;
        buttonX = labelX;
        // Create the labels and textfields
        Label customer_id = new Label("Customer ID:");
        customer_id.setStyle("-fx-font-size: 15");
        customer_id.relocate(labelX,labelY1);
        customer_id.setPrefSize(labelWidth, labelHeight);
        customer_idTextField = new TextField();
        customer_idTextField.setEditable(false);
        customer_idTextField.relocate(buttonX, buttonY1);
        customer_idTextField.setPrefSize(buttonWidth, buttonHeight);

        Label mealPlanLabel = new Label("Meal Plan:");
        mealPlanLabel.setStyle("-fx-font-size: 15");
        mealPlanLabel.relocate(labelX,labelY2);
        mealPlanLabel.setPrefSize(labelWidth, labelHeight);
        mealPlanTextField = new TextField();
        mealPlanTextField.setEditable(false);
        mealPlanTextField.relocate(buttonX, buttonY2);
        mealPlanTextField.setPrefSize(buttonWidth, buttonHeight);

        labelX += increment;
        buttonX = labelX;

        Label room_no = new Label("Room No");
        room_no.setStyle("-fx-font-size: 15");
        room_no.relocate(labelX,labelY1);
        room_no.setPrefSize(120, labelHeight);
        room_noTextField = new TextField();
        room_noTextField.setEditable(false);
        room_noTextField.relocate(buttonX, buttonY1);
        room_noTextField.setPrefSize(buttonWidth-20, buttonHeight);

        Label cost = new Label("Cost");
        cost.setStyle("-fx-font-size: 15");
        cost.relocate(labelX,labelY2);
        cost.setPrefSize(120, labelHeight);
        costTextField = new TextField();
        costTextField.setEditable(false);
        costTextField.relocate(buttonX, buttonY2);
        costTextField.setPrefSize(buttonWidth-20, buttonHeight);


        //Store the items in this pane
        innerPane.getChildren().addAll(bookFromLabel, bookFromTextField,customer_id, customer_idTextField,
                bookToTextField,bookToLabel, mealPlanLabel, mealPlanTextField, room_no, room_noTextField, cost,
                costTextField);
        getChildren().add(innerPane);
    }
}
