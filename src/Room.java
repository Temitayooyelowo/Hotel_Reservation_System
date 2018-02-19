/**
 * Created by Temi-tee on 5/1/2017.
 */
public class Room {
    private String type;
    private int        roomNumber;
    private float       price;
    private int maxGuests;

    //Get methods
    public String getType(){return type;}
    public int getRoomNumber() { return roomNumber; }
    public float getPrice() {return price;}
    public int getMaxGuests() { return maxGuests; }

    public Room() {
        type = null;
        roomNumber = -1;
        price = 0;
        maxGuests = -1;
    }

    public Room(int roomNumber, String type, int maxGuests, float price) {
        this.type = type;
        this.roomNumber =  roomNumber;
        this.maxGuests = maxGuests;
        this.price = price;
    }

    public Room(String type,  float price) {
        this.type = type;
        this.roomNumber =  -1;
        this.maxGuests = -1;
        this.price = price;
    }

    //To String method
    public String toString () {
        return type;
    }
}
