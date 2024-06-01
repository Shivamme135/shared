package Services;

import Dao.ReservationDAO;
import Models.Reservation;

import java.sql.SQLException;
import java.util.List;

public class ReservationService {

    private static ReservationDAO reservationDAO;

    public ReservationService() {
        reservationDAO = new ReservationDAO();
    }


    public static void addReservation(Reservation reservation) throws SQLException {
        reservationDAO.addReservation(reservation);
    }
    public Reservation getReservationByRoomNumber(int id) throws SQLException {
        return reservationDAO.getReservationByRoomNumber(id);
    }

    public static List<Reservation> getAllReservations() throws SQLException {
        return reservationDAO.getAllReservation();
    }

    public void updateReservation(Reservation reservation) throws SQLException {
        reservationDAO.updateReservation(reservation);
    }

    public void deleteReservation(int id) throws SQLException {
        reservationDAO.deleteReservation(id);
    }
}
