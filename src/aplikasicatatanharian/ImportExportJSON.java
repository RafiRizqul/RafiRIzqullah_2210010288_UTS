/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasicatatanharian;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author ACER
 */
public class ImportExportJSON {

    public static void importCatatanFromJSON(FrameCatatanHarian frame) {
        // Membuka JFileChooser untuk memilih file JSON
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Pilih File JSON Catatan");
        int result = fileChooser.showOpenDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            try {
                // Membaca file JSON
                String content = new String(Files.readAllBytes(selectedFile.toPath()));
                JSONArray catatanArray = new JSONArray(content);

                List<Catatan> catatanList = new ArrayList<>();
                for (int i = 0; i < catatanArray.length(); i++) {
                    JSONObject catatanObject = catatanArray.getJSONObject(i);

                    String judul = catatanObject.getString("judul");
                    String tanggal = catatanObject.getString("tanggal"); // Anda bisa mengonversi string tanggal ke Date jika perlu
                    String cuaca = catatanObject.getString("cuaca");
                    String isiCatatan = catatanObject.getString("isiCatatan");

                    // Membuat objek Catatan baru
                    Catatan catatan = new Catatan(-1, judul, LocalDate.parse(tanggal), cuaca, isiCatatan);
                    catatanList.add(catatan);
                }

                // Menyimpan catatan ke database atau model
                for (Catatan catatan : catatanList) {
                    frame.dbHelper.tambahCatatan(catatan);  // Menambahkan catatan ke database
                }

                // Memuat ulang catatan setelah diimpor
                frame.loadCatatan();

                JOptionPane.showMessageDialog(frame, "Catatan berhasil diimpor.");
            } catch (IOException | org.json.JSONException e) {
                JOptionPane.showMessageDialog(frame, "Terjadi kesalahan saat membaca file JSON: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void exportCatatanToJSON(FrameCatatanHarian frame) {
        // Membuka JFileChooser untuk memilih lokasi penyimpanan file JSON
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Pilih Lokasi untuk Menyimpan File JSON");
        int result = fileChooser.showSaveDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            // Jika file tidak berakhiran ".json", tambahkan ekstensi ".json"
            if (!selectedFile.getName().endsWith(".json")) {
                selectedFile = new File(selectedFile.getAbsolutePath() + ".json");
            }

            try {
                // Mengambil daftar catatan dari database
                List<Catatan> catatanList = frame.dbHelper.getAllCatatan();
                JSONArray catatanArray = new JSONArray();

                for (Catatan catatan : catatanList) {
                    // Membuat objek JSON untuk setiap catatan
                    JSONObject catatanObject = new JSONObject();
                    catatanObject.put("judul", catatan.getJudul());
                    catatanObject.put("tanggal", catatan.getTanggal().toString());  // Konversi LocalDate ke String
                    catatanObject.put("cuaca", catatan.getCuaca());
                    catatanObject.put("isiCatatan", catatan.getIsiCatatan());

                    // Menambahkan objek catatan ke dalam array JSON
                    catatanArray.put(catatanObject);
                }

                // Menyimpan array JSON ke file
                Files.write(selectedFile.toPath(), catatanArray.toString(4).getBytes());

                JOptionPane.showMessageDialog(frame, "Catatan berhasil diekspor ke " + selectedFile.getAbsolutePath());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(frame, "Terjadi kesalahan saat menyimpan file JSON: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
