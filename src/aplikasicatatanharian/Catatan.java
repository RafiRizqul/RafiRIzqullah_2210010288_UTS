/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasicatatanharian;

import java.time.LocalDate;

/**
 *
 * @author ACER
 */
public class Catatan {

    private int id;          // ID untuk catatan
    private String judul;    // Judul catatan
    private LocalDate tanggal;    // Tanggal catatan dibuat
    private String cuaca;    // Cuaca saat catatan dibuat
    private String isiCatatan; // Isi catatan
    
    public Catatan() {
        this.id = -1;
    }

    // Constructor untuk membuat objek Catatan
    public Catatan(int id, String judul, LocalDate tanggal, String cuaca, String isiCatatan) {
        this.id = id;
        this.judul = judul;
        this.tanggal = tanggal;
        this.cuaca = cuaca;
        this.isiCatatan = isiCatatan;
    }

    // Getter dan Setter untuk id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter dan Setter untuk judul
    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    // Getter dan Setter untuk tanggal
    public LocalDate getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
    }

    // Getter dan Setter untuk cuaca
    public String getCuaca() {
        return cuaca;
    }

    public void setCuaca(String cuaca) {
        this.cuaca = cuaca;
    }

    // Getter dan Setter untuk isi catatan
    public String getIsiCatatan() {
        return isiCatatan;
    }

    public void setIsiCatatan(String isiCatatan) {
        this.isiCatatan = isiCatatan;
    }

    // Method toString() untuk memudahkan mencetak objek Catatan
    @Override
    public String toString() {
        return "(" + tanggal + ") " + judul;
    }
}
