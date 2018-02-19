import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

public class HotelMenuBar extends MenuBar{
    //Creates a menuBar
    private MenuBar menuBar;

    //Create menuItems
    private MenuItem viewCustomersItem;
    private MenuItem BookingItem;
    private MenuItem checkOutItem;

    public MenuItem getViewCustomersItem() { return viewCustomersItem; }
    public MenuItem getBookingItem() { return BookingItem; }
    public MenuItem getCheckOutItem() { return checkOutItem; }

    public HotelMenuBar(){
        //Create the menus
        Menu firstMenu = new Menu ("Options");
        Menu secondMenu = new Menu (" Help ");
        Menu thirdMenu = new Menu ("Contact");
        Menu EmployeeMenu = new Menu("Employee");

        //Creates the items in the menu
        viewCustomersItem = new MenuItem("View Customers");
        BookingItem = new MenuItem("Booking");
        checkOutItem = new MenuItem("Check Out");

        EmployeeMenu.getItems().addAll(viewCustomersItem,checkOutItem);
        firstMenu.getItems().addAll(BookingItem, new SeparatorMenuItem(),EmployeeMenu);

        //Add the menu to the menuBar and then add the menubar to the pane

        getMenus().addAll(firstMenu,secondMenu,thirdMenu);
    }
}
