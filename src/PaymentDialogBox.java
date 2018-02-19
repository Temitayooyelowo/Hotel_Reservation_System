import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

/**
 * Created by Temi-tee on 6/20/2017.
 */
public class PaymentDialogBox extends Dialog {
    //Declare Variables
    private CheckInView view;

    //Create Labels
    private Label paymentLabel = new Label ("Payment Method");
    private Label cardNumberLabel = new Label("Card Number *");
    private Label expiryDateLabel = new Label("Expirty Date *");
    private Label securityCodeLabel = new Label("CVV2 Security Code *");
    private Label cardHolderLabel = new Label("Card Holder *");
    private Label billingAddressLabel = new Label("Billing Address *");
    private Label postCodeLabel = new Label("Post Code *");
    private Label cityLabel = new Label ("City *");
    private Label provinceLabel = new Label("Province *");
    private Label countryLabel = new Label("Country *");

    //Create Text Box
    private TextField cardNumberTextField = new TextField();
    private TextField securityCodeTextField = new TextField();
    private TextField cardHolderTextField  = new TextField();
    private TextField address1TextField = new TextField();
    private TextField address2TextField  = new TextField();
    private TextField postCodeTextField = new TextField();
    private TextField cityTextField  = new TextField();
    private TextField provinceTextField = new TextField();

    //Combo Box
    private ComboBox countryComboBox  = new ComboBox();
    private ComboBox monthBox;
    private ComboBox yearBox;

    private ArrayList<String> countriesList = new ArrayList<String>();

    //Create button type
    private ButtonType bookRoomButtonType;

    public ButtonType getBookRoomButtonType() {
        return bookRoomButtonType;
    }

    //Create checkBox
    CheckBox  termsOfService;

    public PaymentDialogBox(){
        view = new CheckInView();

        //Sets the title of the dialog box
        setTitle("Payment Method");
        setHeaderText(null);

        //Adds the okayButton and the cancel button to the dialog box
        bookRoomButtonType = new ButtonType("Book Room", ButtonBar.ButtonData.OK_DONE);
        getDialogPane().getButtonTypes().addAll(bookRoomButtonType, ButtonType.CANCEL);

        //Creates a dialog box and sets the hgap and vgap
        Pane grid = new Pane();
        grid.setPadding(new Insets(10, 10,10, 10));

        //Creates the TextFields and sets the width and prompt text
        cardNumberTextField.setPromptText("Card Number");
        securityCodeTextField.setMaxWidth(100);

        String[] months= { "01","02","03","04","05","06","07","08","09","10", "11", "12"};
        String[] years= { "2018","2019","2020","2021","2022"};
        monthBox = new ComboBox(FXCollections.observableArrayList(months));
        monthBox.setPromptText("Month");
        monthBox.setMaxWidth(100);
        yearBox = new ComboBox(FXCollections.observableArrayList(years));
        yearBox.setPromptText("Year");
        yearBox.setMaxWidth(100);
        countryComboBox = new ComboBox(FXCollections.observableArrayList(getCountriesList()));
        countryComboBox.setPromptText("Country");

        termsOfService = new CheckBox("I accept the terms of service and the privacy policy");

        paymentLabel.relocate(150,10);
        paymentLabel.setStyle("-fx-font-size: 15");
        cardNumberLabel.relocate(10,40);
        cardNumberLabel.setStyle("-fx-font-size: 15");
        expiryDateLabel.relocate(10,70);
        expiryDateLabel.setStyle("-fx-font-size: 15");
        securityCodeLabel.relocate(10,100);
        securityCodeLabel.setStyle("-fx-font-size: 15");
        cardHolderLabel.relocate(10,130);
        cardHolderLabel.setStyle("-fx-font-size: 15");
        billingAddressLabel.relocate(10,160);
        billingAddressLabel.setStyle("-fx-font-size: 15");
        postCodeLabel.relocate(10,220);
        postCodeLabel.setStyle("-fx-font-size: 15");
        cityLabel.relocate(10,250);
        cityLabel.setStyle("-fx-font-size: 15");
        provinceLabel.relocate(10,280);
        provinceLabel.setStyle("-fx-font-size: 15");
        countryLabel.relocate(10,310);
        countryLabel.setStyle("-fx-font-size: 15");

        cardNumberTextField.relocate(160,40);
        cardNumberTextField.setPrefWidth(210);
        monthBox.relocate(160,70);
        monthBox.setPrefWidth(100);
        yearBox.relocate(270,70);
        yearBox.setPrefWidth(100);
        securityCodeTextField.relocate(160,100);
        securityCodeTextField.setPrefWidth(210);
        cardHolderTextField.relocate(160,130);
        cardHolderTextField.setPrefWidth(210);
        address1TextField.relocate(160,160);
        address1TextField.setPrefWidth(210);
        address2TextField.relocate(160,190);
        address2TextField.setPrefWidth(210);
        postCodeTextField.relocate(160,220);
        postCodeTextField.setPrefWidth(210);
        cityTextField.relocate(160,250);
        cityTextField.setPrefWidth(210);
        provinceTextField.relocate(160,280);
        provinceTextField.setPrefWidth(210);
        countryComboBox.relocate(160,310);
        countryComboBox.setPrefWidth(210);

        //Adds the labels and textfields to the GridPane
        grid.getChildren().addAll(paymentLabel,cardNumberLabel,expiryDateLabel,securityCodeLabel,cardHolderLabel,
                billingAddressLabel,postCodeLabel,cityLabel,provinceLabel,countryLabel,cardNumberTextField, monthBox,
                yearBox,securityCodeTextField,cardHolderTextField, address1TextField, address2TextField, postCodeTextField,
                cityTextField, provinceTextField, countryComboBox);

        //Adds the gridpane to the dialog box
        getDialogPane().setContent(grid);
        getDialogPane().setMinSize(400,400);

        update();
    }

    public void update() {

    }

    //Get countries and sort them (Source included in the link below)
    //https://stackoverflow.com/questions/32364470/how-to-get-countries-list-alphabetically-arranged-with-the-correct-names
    public ArrayList<String> getCountriesList() {
        String[] locales = Locale.getISOCountries();

        for (String countryCode : locales) {
            Locale obj = new Locale("", countryCode);
            countriesList.add(obj.getDisplayCountry(Locale.ENGLISH));
        }
        Collections.sort(countriesList);
        return countriesList;
    }

}
