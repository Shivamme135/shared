import Services.ReservationService;
import Models.Reservation;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class Main {
    private ReservationService reservationService;
    private Scanner scanner;
    private String guestName;

    public static void main(String[] args) {
//        System.out.println("hello");
        Main main=new Main();
        main.run();
    }

    public Main() {
        reservationService = new ReservationService();
        scanner = new Scanner(System.in);
    }
    public void run() {
        while (true) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            try {
                switch (choice) {
                    case 1:
                        addReservation();
                        break;
                    case 2:
                        viewAllReservation();;
                        break;
                    case 3:
                        updateReservation();
                        break;
                    case 4:
                        deleteReservation();
                        break;
                    case 5:
                        viewReservationByRoomNumber();
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void showMenu() {
        System.out.println("\nHotel reservation system");
        System.out.println("1. Reserve a room");
        System.out.println("2. view reservations");
        System.out.println("3. Update reservation");
        System.out.println("4. Delete reservation");
        System.out.println("5. View reservation by id");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private void addReservation() throws SQLException {
        System.out.print("enter reservation id");
        int id = scanner.nextInt();
        System.out.print("Enter name: ");
        String guestName = scanner.nextLine();
        System.out.print("Enter roomNumber: ");
        int roomNumber = scanner.nextInt();
        System.out.print("Enter contactNumber: ");
        String contactNumber = scanner.next();

        Reservation reservation = new Reservation();
        reservation.setId(id);
        reservation.setGuestName(guestName);
        reservation.setRoomNumber(roomNumber);
        reservation.setContactNumber(contactNumber);

        ReservationService.addReservation( reservation);
        System.out.println("Reservation added successfully!");
    }

    private void viewAllReservation() throws SQLException {
        List<Reservation> reservations = ReservationService.getAllReservations();
        System.out.println("\nReservation List:");
        for (Reservation reservation : reservations) {
            System.out.println("ID: " + reservation.getId() + ", Name: " + reservation.getGuestName() +
                    ", roomNumber: " + reservation.getRoomNumber() + ", contact_number: " + reservation.getContactNumber());
        }
    }

    private void updateReservation() throws SQLException {
        System.out.print("Enter reservation ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new roomNumber: ");
        int roomNumber = scanner.nextInt();
        System.out.print("Enter new contactNumber: ");
        String contactNumber = scanner.nextLine();

        Reservation reservation = new Reservation();
        reservation.setId(id);
        reservation.setGuestName(guestName);
        reservation.setRoomNumber(roomNumber);
        reservation.setContactNumber(contactNumber);

        reservationService.updateReservation(reservation);
        System.out.println("Reservation updated successfully!");
    }

    private void deleteReservation() throws SQLException {
        System.out.print("Enter reservation ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());

        reservationService.deleteReservation(id);
        System.out.println("Reservation deleted successfully!");
    }

    private void viewReservationByRoomNumber() throws SQLException {
        System.out.print("Enter reservation ID to view: ");
        int id = Integer.parseInt(scanner.nextLine());

        Reservation reservation = reservationService.getReservationByRoomNumber(id);
        if (reservation != null) {
            System.out.println("ID: " + reservation.getId() + ", guest_name: " + reservation.getGuestName() +
                    ", room_number: " + reservation.getRoomNumber() + ", contact_number: " + reservation.getContactNumber());
        } else {
            System.out.println("Reservation not found with ID: " + id);
        }
    }
}