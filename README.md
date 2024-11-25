Nama: Rafi Rizkullah  
Kelas: 5A REG BJB  
NPM: 2210010288  

# Catatan Harian - Aplikasi Pengelola Catatan

Aplikasi ini memungkinkan pengguna untuk membuat, mengedit, menghapus, dan mencari catatan harian mereka. Pengguna juga dapat mengimpor dan mengekspor catatan dalam format JSON.

## Fitur
- **Buat Catatan Baru**: Membuat catatan baru dengan judul, tanggal, cuaca, dan isi catatan.
- **Edit Catatan**: Mengedit catatan yang sudah ada.
- **Hapus Catatan**: Menghapus catatan yang sudah tidak diperlukan.
- **Cari Catatan**: Mencari catatan berdasarkan judul, cuaca, atau isi.
- **Impor dan Ekspor JSON**: Mengimpor catatan dari file JSON dan mengekspor catatan ke file JSON.

## Prasyarat
- **Java 8 atau lebih tinggi**: Pastikan Anda sudah menginstal Java JDK versi 8 atau lebih tinggi.
- **IDE**: Disarankan menggunakan IDE seperti [NetBeans](https://netbeans.apache.org/) atau [IntelliJ IDEA](https://www.jetbrains.com/idea/) untuk pengembangan.

## Instalasi
1. Clone repository atau unduh file proyek.
2. Buka proyek di IDE pilihan Anda.
3. Pastikan untuk menambahkan dependency berikut pada proyek Anda:
   - **org.json**: Library untuk bekerja dengan JSON. Anda bisa mengunduhnya dari [https://mvnrepository.com/artifact/org.json/json](https://mvnrepository.com/artifact/org.json/json) dan menambahkannya ke build path proyek Anda.

## Penggunaan
1. Jalankan aplikasi dengan memilih opsi **Buat Baru** untuk membuat catatan baru.
2. Anda dapat memilih catatan dari daftar yang tersedia untuk melihat detailnya, mengedit, atau menghapusnya.
3. Gunakan fitur pencarian untuk mencari catatan berdasarkan kata kunci.
4. Untuk mengimpor catatan, pilih **Impor JSON** dari menu dan pilih file JSON yang berisi catatan yang ingin dimuat.
5. Untuk mengekspor catatan, pilih **Ekspor JSON** dan tentukan lokasi file untuk menyimpan catatan dalam format JSON.

## Struktur Kode
- **FrameCatatanHarian.java**: Frame utama aplikasi yang menampilkan daftar catatan dan detail catatan yang dipilih.
- **Catatan.java**: Kelas model yang menyimpan data catatan (judul, tanggal, cuaca, isi catatan).
- **CatatanDatabaseHelper.java**: Kelas yang mengelola operasi database (misalnya, menambahkan, menghapus, dan mengambil catatan).
- **ImportExportJSON.java**: Kelas untuk mengimpor dan mengekspor catatan dalam format JSON.


### Penjelasan:

- **Fitur**: Menyediakan gambaran umum tentang apa yang aplikasi ini bisa lakukan.
- **Prasyarat**: Menyebutkan apa saja yang diperlukan agar aplikasi ini dapat dijalankan.
- **Instalasi**: Langkah-langkah untuk memulai proyek di sistem Anda.
- **Penggunaan**: Menjelaskan bagaimana pengguna dapat menggunakan aplikasi ini.
- **Struktur Kode**: Deskripsi tentang file-file utama dalam aplikasi.
- **Contoh Format JSON**: Contoh format file JSON yang digunakan untuk impor catatan.
- **License**: Menyebutkan lisensi proyek.



