import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class CustomerDetailsView extends Pane {
    private TextField firsNameTextField;
    private TextField middleNameTextField;
    private TextField lastNameTextField;
    private TextField titleTextField;
    private TextField ageTextField;
    private TextField phoneNumberTextField;
    private TextField emailAddressTextField;

    public TextField getMiddleNameTextField() {
        return middleNameTextField;
    }

    public TextField getLastNameTextField() {
        return lastNameTextField;
    }

    public TextField getTitleTextField() {
        return titleTextField;
    }

    public TextField getAgeTextField() {
        return ageTextField;
    }

    public TextField getPhoneNumberTextField() {
        return phoneNumberTextField;
    }

    public TextField getEmailAddressTextField() {
        return emailAddressTextField;
    }

    public TextField getFirsNameTextField() {
        return firsNameTextField;
    }

    public CustomerDetailsView(String title){
        Pane innerPane = new Pane();
        innerPane.setStyle("-fx-background-color: white; \n" +
                "-fx-border-color: gray; \n" +
                "-fx-padding: 4 4;"); // margin spacing at bottom right

        int buttonHeight=30, buttonWidth=385, buttonX=150, buttonY=20, buttonIncrement=35,
                labelHeight = 25, labelWidth=100, labelX=10, labelY=buttonY;

        Label Gender = new Label("Title:");
        Gender.setStyle("-fx-font-size: 15");
        Gender.relocate(labelX, labelY);
        Gender.setPrefSize(labelWidth, labelHeight);
        titleTextField = new TextField();
        titleTextField.setEditable(false);
        titleTextField.relocate(buttonX, buttonY);
        titleTextField.setPrefSize(buttonWidth,buttonHeight);

        buttonY+=buttonIncrement;
        labelY=buttonY;

        // Create the labels and textfields
        Label firstName = new Label("FirstName:");
        firstName.setStyle("-fx-font-size: 15");
        firstName.relocate(labelX, labelY);
        firstName.setPrefSize(labelWidth, labelHeight);
        firsNameTextField = new TextField();
        firsNameTextField.setEditable(false);
        firsNameTextField.relocate(buttonX, buttonY);
        firsNameTextField.setPrefSize(buttonWidth,buttonHeight);

        buttonY+=buttonIncrement;
        labelY=buttonY;

        Label middleNameLabel = new Label ("Middle Name:");
        middleNameLabel.relocate (labelX, labelY);
        middleNameLabel.setStyle("-fx-font-size: 15");
        middleNameTextField = new TextField();
        middleNameTextField.setEditable(false);
        middleNameTextField.relocate(buttonX,buttonY);
        middleNameTextField.setPrefSize(buttonWidth,buttonHeight);

        buttonY+=buttonIncrement;
        labelY=buttonY;

        Label LastName = new Label("LastName:");
        LastName.setStyle("-fx-font-size: 15");
        LastName.relocate(labelX, labelY);
        LastName.setPrefSize(labelWidth, labelHeight);
        lastNameTextField = new TextField();
        lastNameTextField.setEditable(false);
        lastNameTextField.relocate(buttonX, buttonY);
        lastNameTextField.setPrefSize(buttonWidth,buttonHeight);

        buttonY+=buttonIncrement;
        labelY=buttonY;

        Label Age = new Label("Age:");
        Age.setStyle("-fx-font-size: 15");
        Age.relocate(labelX, labelY);
        Age.setPrefSize(labelWidth, labelHeight);
        ageTextField = new TextField();
        ageTextField.setEditable(false);
        ageTextField.relocate(buttonX, buttonY);
        ageTextField.setPrefSize(buttonWidth,buttonHeight);

        buttonY+=buttonIncrement;
        labelY=buttonY;

        Label PhoneNumber = new Label("Phone Number:");
        PhoneNumber.setStyle("-fx-font-size: 15");
        PhoneNumber.relocate(labelX, labelY);
        PhoneNumber.setPrefSize(labelWidth, labelHeight);
        phoneNumberTextField = new TextField();
        phoneNumberTextField.setEditable(false);
        phoneNumberTextField.relocate(buttonX, buttonY);
        phoneNumberTextField.setPrefSize(buttonWidth,buttonHeight);

        buttonY+=buttonIncrement;
        labelY=buttonY;

        Label emailAddress = new Label("Email Address:");
        emailAddress.setStyle("-fx-font-size: 15");
        emailAddress.relocate(labelX, labelY);
        emailAddress.setPrefSize(labelWidth, labelHeight);
        emailAddressTextField = new TextField();
        emailAddressTextField.setEditable(false);
        emailAddressTextField.relocate(buttonX, buttonY);
        emailAddressTextField.setPrefSize(buttonWidth,buttonHeight);

        // Add all labels and textfields to the pane
        innerPane.getChildren().addAll(firstName, LastName, Gender, Age, PhoneNumber,
                firsNameTextField, middleNameLabel, middleNameTextField, lastNameTextField, titleTextField,
                ageTextField, phoneNumberTextField, emailAddress, emailAddressTextField);

        // Make a title for border and add it as well as inner pane to main pane
        Label titleLabel = new Label(); // Title to be placed onto border
        titleLabel.setText(title); // Incoming constructor parameter
        titleLabel.setStyle("-fx-background-color: white; \n" +
                "-fx-translate-y: -8; \n" +
                "-fx-translate-x: 10;");
        getChildren().addAll(innerPane, titleLabel);
    }
}
