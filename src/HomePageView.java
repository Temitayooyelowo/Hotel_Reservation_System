import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * Created by Temi-tee on 5/28/2017.
 */
public class HomePageView extends VBox {

    //Create Buttons
    private Button checkInButton;
    private Button checkOutButton;
    private Button viewCustomersButton;
    private HotelMenuBar hotelMenuBar;

    //Get methods for buttons
    public Button getCheckInButton(){return checkInButton;}
    public Button getCheckOutButton(){return checkOutButton;}
    public Button getViewCustomersButton(){return viewCustomersButton;}
    public HotelMenuBar getHotelMenuBar() { return hotelMenuBar; }

    //Create canvas and pen
    private Canvas canvas;
    private GraphicsContext aPen;

    // The model to which this view is attached
    public HomePageView() {
        //Create a pane
        Pane aPane = new Pane();
        int imageHeight = 500, imageWidth = 620;
        int buttonHeight=40, buttonWidth=120, buttonX=30, buttonY=180, buttonIncrement=127;

        //Create an image
        Image image = new Image("hotel1.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(imageWidth);
        imageView.setFitHeight(imageHeight);

        //Create a canvas
        canvas = new Canvas(imageWidth-10, imageHeight);

        //Get a pen to start drawing shapes into the canvas
        aPen = canvas.getGraphicsContext2D();
        aPen.setStroke(Color.BLACK);
        aPen.setFill(Color.DIMGREY);

        // Draw a filled rounded rectangle with its top left at(x, y) having given  & height and arc width & height
        aPen.setStroke(Color.BLACK);
        aPen.setFill(Color.WHITE);
        aPen.setFont(Font.font("Monotype Corsiva", 60));
        aPen.fillText("Welcome", 95, 90);
        aPen.setFont(Font.font("Monotype Corsiva", 40));
        aPen.fillText("to", 180, 120);
        aPen.setFont(Font.font("Monotype Corsiva", 45));
        aPen.fillText("ByTown Inn", 95, 155);

        // Create and position the "Customers" Button
        checkInButton = new Button("Booking");
        checkInButton.relocate(buttonX, buttonY);
        checkInButton.setStyle("-fx-base: GREEN; -fx-font: 18 arial; -fx-text-fill: WHITE");
        checkInButton.setPrefSize(buttonWidth, buttonHeight);

        // Create and position the "Customers" Button
        checkOutButton = new Button("Check Out");
        buttonX += buttonIncrement;
        checkOutButton.relocate(buttonX, buttonY);
        checkOutButton.setStyle("-fx-base: MIDNIGHTBLUE; -fx-font: 18 arial; -fx-text-fill: WHITE");
        checkOutButton.setPrefSize(buttonWidth, buttonHeight);

        // Create and position the "Customers" Button
        viewCustomersButton = new Button("View Customers");
        buttonX += buttonIncrement;
        viewCustomersButton.relocate(buttonX, buttonY);
        viewCustomersButton.setStyle("-fx-base: GREY; -fx-font: 18 arial; -fx-text-fill: WHITE");
        viewCustomersButton.setPrefSize(buttonWidth+40, buttonHeight);

        aPane.setPrefWidth(Integer.MAX_VALUE);
        aPane.setPrefHeight(Integer.MAX_VALUE);

        // Add all the components to the window
        aPane.getChildren().addAll(imageView, canvas, checkInButton, checkOutButton, viewCustomersButton);

        hotelMenuBar= new HotelMenuBar();

        getChildren().addAll(hotelMenuBar,aPane);

        //Call the update function
        update();
    }
    // This method is called whenever the model changes
    public void update() {
            // ... code for refreshing the view

    }

}
