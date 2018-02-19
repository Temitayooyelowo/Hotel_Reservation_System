import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BookingInfoPane  extends Pane {
    private TextField firstNameTextField;
    private TextField middleNameTextField;
    private TextField surnameTextField;
    private TextField houseNumberTextField;
    private TextField address1TextField;
    private TextField address2TextField;
    private TextField cityTextField;
    private TextField provinceTextField;
    private TextField countryTextField;
    private TextField postalCodeTextField;
    private TextField phoneNumberTextField;
    private TextField emailAddressTextField;
    private TextField customerIdTextField;
    private TextField totalTextField;

    //Combo Boxes
    ComboBox roomTypeBox;
    ComboBox mealPlanBox;

    //Date pickers
    private DatePicker bookToDatePicker;
    private DatePicker bookFromDatePicker;

    public DatePicker getBookFromDatePicker() {
        return bookFromDatePicker;
    }
    public DatePicker getBookToDatePicker() {
        return bookToDatePicker;
    }

    public ComboBox getMealPlanBox() {return mealPlanBox;}
    public ComboBox getRoomTypeBox() {return roomTypeBox;}
    public TextField getCustomerIdTextField() {return customerIdTextField;}
    public TextField getTotalTextField() {return totalTextField;}

    public BookingInfoPane(){
        //Create the first pane and it's components
        setStyle(" -fx-background-color: white;\n" +
                "-fx-border-color: gray; \n" + "-fx-padding: 4 4;");

        int buttonHeight=10, buttonWidth=150, buttonX=110, buttonY=15, buttonIncrement=35, labelX=10, labelY=buttonY;

        Label bookFromLabel = new Label ("Book From:*");
        bookFromLabel.relocate(labelX,labelY);
        bookFromLabel.setStyle("-fx-font-size:15");
        String pattern = "yyyy-MM-dd";
        bookFromDatePicker = new DatePicker();
        bookFromDatePicker.setPromptText(pattern.toLowerCase());
        bookFromDatePicker.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        });
        bookFromDatePicker.relocate(buttonX,buttonY);
        bookFromDatePicker.setEditable(true);
        bookFromDatePicker.setPrefSize(150,10);

        buttonY+=buttonIncrement;
        labelY=buttonY;

        Label bookToLabel = new Label ("Book To:*");
        bookToLabel.relocate(labelX,labelY);
        bookToLabel.setStyle("-fx-font-size: 15");
        bookToDatePicker = new DatePicker();
        bookToDatePicker.setPromptText(pattern.toLowerCase());
        bookToDatePicker.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        });
        bookToDatePicker.relocate(buttonX, buttonY);
        bookToDatePicker.setEditable(true);
        bookToDatePicker.setPrefSize(150,10);

        buttonY+=buttonIncrement;
        labelY=buttonY;

        Label roomTypeLabel = new Label ("Room Type:*");
        roomTypeLabel.relocate(labelX,labelY);
        roomTypeLabel.setStyle("-fx-font-size: 15");
        //String a[] = Building.typesOfRooms().toArray();
        ObservableList<Room> roomTypeOptions = FXCollections.observableArrayList(Database.typesOfRooms());
        roomTypeBox = new ComboBox(roomTypeOptions);
        roomTypeBox.setPromptText("Choose your Room: ");
        roomTypeBox.relocate(buttonX,buttonY);
        roomTypeBox.setPrefSize(150,10);

        buttonY+=buttonIncrement;
        labelY=buttonY;

        Label mealPlanLabel = new Label ("Meal Plan:*");
        mealPlanLabel.relocate(labelX,labelY);
        mealPlanLabel.setStyle("-fx-font-size: 15");
        ObservableList<MealPlan> mealPlanOptions = FXCollections.observableArrayList(Database.mealPlanList());
        mealPlanBox = new ComboBox(mealPlanOptions);
        mealPlanBox.setPromptText("Choose your MealPlan: ");
        mealPlanBox.relocate(buttonX,buttonY);
        mealPlanBox.setPrefSize(150,10);

        buttonY+=buttonIncrement;
        labelY=buttonY;

        Label totalLabel = new Label ("Total: ");
        totalLabel.relocate(labelX, labelY);
        totalLabel.setStyle("-fx-font-size: 15");
        totalTextField = new TextField();
        totalTextField.setPromptText("$0.00");
        totalTextField.setEditable(false);
        totalTextField.relocate(buttonX,buttonY);
        totalTextField.setPrefSize(150,10);

        buttonY+=buttonIncrement;
        labelY=buttonY;

        Label customerIdLabel = new Label ("Customer Id: ");
        customerIdLabel.relocate(labelX, labelY);
        customerIdLabel.setStyle("-fx-font-size: 15");
        customerIdTextField = new TextField();
        customerIdTextField.setPromptText("Customer Id:");
        customerIdTextField.setEditable(false);
        customerIdTextField.relocate(buttonX,buttonY);
        customerIdTextField.setPrefSize(150,10);


        //Store the items in this pane
        getChildren().addAll(bookFromLabel,bookFromDatePicker,bookToDatePicker,bookToLabel,
                roomTypeLabel,roomTypeBox, mealPlanLabel, mealPlanBox, totalLabel,totalTextField, customerIdLabel,
                customerIdTextField);
    }
}
