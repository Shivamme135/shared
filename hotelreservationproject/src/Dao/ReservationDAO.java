package Dao;

import Models.Reservation;
import Utility.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {

    public void addReservation(Reservation reservation) throws SQLException {
        String sql = "INSERT INTO reservations (reservation_id,guest_name, room_number, contact_number)" +
                " VALUES (?, ?, ? , ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, reservation.getId());
            stmt.setString(2, reservation.getGuestName());
            stmt.setInt(3, reservation.getRoomNumber());
            stmt.setString(4, reservation.getContactNumber());
            stmt.executeUpdate();
        }
    }

    public List<Reservation> getAllReservation() throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM reservations";

        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Reservation reservation = new Reservation();
                reservation.setId(rs.getInt("reservation_id"));
                reservation.setGuestName(rs.getString("guest_name"));
                reservation.setRoomNumber(rs.getInt("room_number"));
                reservation.setContactNumber(rs.getString("contact_number"));

            }
        }
        return reservations;
    }

    public Reservation getReservationByRoomNumber(int id) throws SQLException {
        String sql = "SELECT * FROM reservations WHERE id=?";
        Reservation resevation = null;

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    resevation = new Reservation();
                    resevation.setId(rs.getInt("id"));
                    resevation.setGuestName(rs.getString("guest_name"));
                    resevation.setRoomNumber(rs.getInt("room_number"));
                    resevation.setContactNumber(rs.getString("contact_number"));
                }
            }
            return resevation;
        }
    }
    public void updateReservation(Reservation reservation) throws SQLException {
        String sql = "UPDATE reservations SET guest_name = ?, room_number = ?, contact_number = ? WHERE reservation_id = ?";

        try (Connection conn = DBUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, reservation.getGuestName());
            stmt.setInt(2, reservation.getRoomNumber());
            stmt.setString(3, reservation.getContactNumber());
            stmt.setInt(4, reservation.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteReservation(int id) throws SQLException {
        String sql = "DELETE FROM reservations WHERE id = ?";

        try (Connection conn = DBUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }

    }

}

