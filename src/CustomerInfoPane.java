import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class CustomerInfoPane extends Pane {
    private TextField firstNameTextField;
    private TextField middleNameTextField;
    private TextField lastnameTextField;
    private TextField ageTextField;
    private TextField address1TextField;
    private TextField address2TextField;
    private TextField cityTextField;
    private TextField provinceTextField;
    private TextField postalCodeTextField;
    private TextField phoneNumberTextField;
    private TextField emailAddressTextField;

    private ComboBox countryComboBox;
    private ComboBox titleBox;

    private ArrayList<String> countriesList = new ArrayList<String>();

    //Get methods
    public ComboBox getTitleBox() {return titleBox;}
    public TextField getFirstNameTextField() {return firstNameTextField;}
    public TextField getMiddleNameTextField() {return middleNameTextField;}
    public TextField getLastnameTextField() {return lastnameTextField;}
    public TextField getAgeTextField() { return ageTextField; }
    public TextField getAddress1TextField() {return address1TextField;}
    public TextField getAddress2TextField() {return address2TextField;}
    public TextField getCityTextField() {return cityTextField;}
    public TextField getProvinceTextField(){return provinceTextField;}
    public TextField getPostalCodeTextField() {return postalCodeTextField;}
    public TextField getPhoneNumberTextField() {return phoneNumberTextField;}
    public TextField getEmailAddressTextField() {return emailAddressTextField;}
    public ComboBox getCountryComboBox() { return countryComboBox; }


    public CustomerInfoPane(){
        setStyle(" -fx-background-color: white;\n" +
                "-fx-border-color: gray; \n" + "-fx-padding: 4 4;");

        int buttonHeight=10, buttonWidth=150, buttonX=110, buttonY=20, buttonIncrement=30, labelX=10, labelY=buttonY;
        //Create the Labels
        Label titleLabel = new Label("Title:*");
        titleLabel.relocate(labelX, labelY);
        titleLabel.setStyle("-fx-font-size: 15");
        String [] title = {"Mr.", "Mrs.", "Ms."};
        ObservableList<String> titleOptions = FXCollections.observableArrayList(title);
        titleBox = new ComboBox(titleOptions);
        titleBox.setPromptText("What's your title?");
        titleBox.relocate(buttonX,buttonY);
        titleBox.setPrefSize(buttonWidth,buttonHeight);

        buttonY+=buttonIncrement;
        labelY=buttonY;

        Label firstNameLabel = new Label ("First Name:*");
        firstNameLabel.relocate (labelX, labelY);
        firstNameLabel.setStyle("-fx-font-size: 15");
        firstNameTextField = new TextField();
        firstNameTextField.setPromptText("Enter your FirstName:");
        firstNameTextField.relocate(buttonX,buttonY);
        firstNameTextField.setPrefSize(buttonWidth,buttonHeight);

        buttonY+=buttonIncrement;
        labelY=buttonY;

        Label middleNameLabel = new Label ("Middle Name:");
        middleNameLabel.relocate (labelX, labelY);
        middleNameLabel.setStyle("-fx-font-size: 15");
        middleNameTextField = new TextField();
        middleNameTextField.setPromptText("Enter your Middle Name:");
        middleNameTextField.relocate(buttonX,buttonY);
        middleNameTextField.setPrefSize(buttonWidth,buttonHeight);

        buttonY+=buttonIncrement;
        labelY=buttonY;

        Label lastnameLabel = new Label ("Lastname:*");
        lastnameLabel.relocate (labelX, labelY);
        lastnameLabel.setStyle("-fx-font-size: 15");
        lastnameTextField = new TextField();
        lastnameTextField.setPromptText("Enter your Surname:");
        lastnameTextField.relocate(buttonX,buttonY);
        lastnameTextField.setPrefSize(buttonWidth,buttonHeight);

        buttonY+=buttonIncrement;
        labelY=buttonY;

        Label ageLabel = new Label ("Age:*");
        ageLabel.relocate (labelX, labelY);
        ageLabel.setStyle("-fx-font-size: 15");
        ageTextField = new TextField();
        ageTextField.setPromptText("Enter your Age:");
        ageTextField.relocate(buttonX,buttonY);
        ageTextField.setPrefSize(buttonWidth,buttonHeight);

        buttonY+=buttonIncrement;
        labelY=buttonY;

        Label address1Label = new Label ("Address 1:*");
        address1Label.relocate (labelX, labelY);
        address1Label.setStyle("-fx-font-size: 15");
        address1TextField = new TextField();
        address1TextField.setPromptText("Enter your Address:");
        address1TextField.relocate(buttonX,buttonY);
        address1TextField.setPrefSize(buttonWidth,buttonHeight);

        buttonY+=buttonIncrement;
        labelY=buttonY;

        Label address2Label = new Label ("Address 2:");
        address2Label.relocate (labelX, labelY);
        address2Label.setStyle("-fx-font-size: 15");
        address2TextField = new TextField();
        address2TextField.setPromptText("Enter your Address:");
        address2TextField.relocate(buttonX,buttonY);
        address2TextField.setPrefSize(buttonWidth,buttonHeight);

        buttonY+=buttonIncrement;
        labelY=buttonY;

        Label cityLabel = new Label ("City:*");
        cityLabel.relocate (labelX, labelY);
        cityLabel.setStyle("-fx-font-size: 15");
        cityTextField = new TextField();
        cityTextField.setPromptText("Enter your City:");
        cityTextField.relocate(buttonX,buttonY);
        cityTextField.setPrefSize(buttonWidth,buttonHeight);

        buttonY+=buttonIncrement;
        labelY=buttonY;

        Label provinceLabel = new Label ("Province:*");
        provinceLabel.relocate (labelX, labelY);
        provinceLabel.setStyle("-fx-font-size: 15");
        provinceTextField = new TextField();
        provinceTextField.setPromptText("Enter your province:");
         provinceTextField.relocate(buttonX,buttonY);
        provinceTextField.setPrefSize(buttonWidth,buttonHeight);

        buttonY+=buttonIncrement;
        labelY=buttonY;

        Label countryLabel = new Label ("Country:*");
        countryLabel.relocate (labelX, labelY);
        countryLabel.setStyle("-fx-font-size: 15");
        countryComboBox = new ComboBox(FXCollections.observableArrayList(getCountriesList()));
        countryComboBox.setPromptText("Select a country ...");
        countryComboBox.relocate(buttonX,buttonY);
        countryComboBox.setPrefSize(buttonWidth,buttonHeight);

        buttonY+=buttonIncrement;
        labelY=buttonY;

        Label postalCodeLabel = new Label ("Postal Code:*");
        postalCodeLabel.relocate (labelX, labelY);
        postalCodeLabel.setStyle("-fx-font-size: 15");
        postalCodeTextField = new TextField();
        postalCodeTextField.setPromptText("Enter your Postal Code:");
        postalCodeTextField.relocate(buttonX,buttonY);
        postalCodeTextField.setPrefSize(buttonWidth,buttonHeight);

        buttonY+=buttonIncrement;
        labelY=buttonY;

        Label phoneNumberLabel = new Label ("Phone No:*");
        phoneNumberLabel.relocate (labelX, labelY);
        phoneNumberLabel.setStyle("-fx-font-size: 15");
        phoneNumberTextField = new TextField();
        phoneNumberTextField.setPromptText("Enter your Phone No:");
        phoneNumberTextField.relocate(buttonX,buttonY);
        phoneNumberTextField.setPrefSize(buttonWidth,buttonHeight);

        buttonY+=buttonIncrement;
        labelY=buttonY;

        Label emailAddressLabel = new Label ("Email Address:");
        emailAddressLabel.relocate (labelX, labelY);
        emailAddressLabel.setStyle("-fx-font-size: 15");
        emailAddressTextField = new TextField();
        emailAddressTextField.setPromptText("Enter your Email Address:");
        emailAddressTextField.relocate(buttonX,buttonY);
        emailAddressTextField.setPrefSize(buttonWidth,buttonHeight);

        //Store the items in this pane
        getChildren().addAll(titleLabel,titleBox,firstNameLabel,firstNameTextField, middleNameLabel,
                middleNameTextField,lastnameLabel, lastnameTextField, ageLabel, ageTextField, address1Label, address1TextField,
                address2Label, address2TextField, cityLabel, cityTextField, provinceLabel, provinceTextField,
                countryLabel, countryComboBox, postalCodeLabel, postalCodeTextField, phoneNumberLabel,phoneNumberTextField,
                emailAddressLabel, emailAddressTextField);
    }

    public ArrayList<String> getCountriesList() {
        String[] locales = Locale.getISOCountries();

        for (String countryCode : locales) {
            Locale obj = new Locale("", countryCode);
            countriesList.add(obj.getDisplayCountry(Locale.ENGLISH));
        }
        Collections.sort(countriesList);
        return countriesList;
    }

    public void getCountriesList2(){
        ObservableList<String> cities = FXCollections.observableArrayList();
        ComboBox<String> country = new ComboBox<String>(cities);

        String[] countries = Locale.getISOCountries();
        for (String countrylist : countries) {
            Locale obj = new Locale("", countrylist);
            String[] city = { obj.getDisplayCountry() };
            for (int x = 0; x < city.length; x++) {
                cities.add(obj.getDisplayCountry());
            }
        }
        country.setItems(cities);
    }
}
