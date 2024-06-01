package Models;


public class Reservation {

    private int id;
    private String guestName;
    private int roomNumber;
    private String contactNumber;

    public Reservation(int id, String guestName, int roomNumber, String contactNumber) {
        this.id = id;
        this.guestName = guestName;
        this.roomNumber = roomNumber;
        this.contactNumber = contactNumber;
    }

    public Reservation() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }


    @Override
    public String toString() {
            return "Reservation{" +
                    "id=" + id +
                    ",guestName='" + guestName + '\'' +
                    ", roomNumber='" + roomNumber + '\'' +
                    ", contactNumber=" + contactNumber +
                    '}';

    }


}
