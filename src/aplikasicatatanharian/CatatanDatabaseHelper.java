/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasicatatanharian;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class CatatanDatabaseHelper {

    private static final String DATABASE_URL = "jdbc:sqlite:catatan.db";
    private static final String TABLE_NAME = "catatan";

    // Constructor
    public CatatanDatabaseHelper() {
        createTableIfNotExists();
    }

    // Metode untuk membuat tabel jika belum ada
    private void createTableIfNotExists() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "judul TEXT NOT NULL, " +
                "tanggal TEXT NOT NULL, " +
                "cuaca TEXT, " +
                "isi_catatan TEXT" +
                ");";

        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
        }
    }

    // Metode untuk menambahkan catatan baru
    public void tambahCatatan(Catatan catatan) {
        String insertSQL = "INSERT INTO " + TABLE_NAME + " (judul, tanggal, cuaca, isi_catatan) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, catatan.getJudul());
            pstmt.setString(2, catatan.getTanggal().toString()); // LocalDate diubah ke String
            pstmt.setString(3, catatan.getCuaca());
            pstmt.setString(4, catatan.getIsiCatatan());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error inserting catatan: " + e.getMessage());
        }
    }

    // Metode untuk mengambil semua catatan
    public List<Catatan> getAllCatatan() {
        List<Catatan> catatanList = new ArrayList<>();
        String selectSQL = "SELECT * FROM " + TABLE_NAME;

        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectSQL)) {

            while (rs.next()) {
                Catatan catatan = new Catatan(
                        rs.getInt("id"),
                        rs.getString("judul"),
                        LocalDate.parse(rs.getString("tanggal")), // String diubah ke LocalDate
                        rs.getString("cuaca"),
                        rs.getString("isi_catatan")
                );
                catatanList.add(catatan);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving catatan: " + e.getMessage());
        }
        return catatanList;
    }

    // Metode untuk memperbarui catatan berdasarkan ID
    public void updateCatatan(Catatan catatan) {
        String updateSQL = "UPDATE " + TABLE_NAME + " SET judul = ?, tanggal = ?, cuaca = ?, isi_catatan = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
            pstmt.setString(1, catatan.getJudul());
            pstmt.setString(2, catatan.getTanggal().toString()); // LocalDate diubah ke String
            pstmt.setString(3, catatan.getCuaca());
            pstmt.setString(4, catatan.getIsiCatatan());
            pstmt.setInt(5, catatan.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error updating catatan: " + e.getMessage());
        }
    }

    // Metode untuk menghapus catatan berdasarkan ID
    public void deleteCatatan(int id) {
        String deleteSQL = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error deleting catatan: " + e.getMessage());
        }
    }
}
