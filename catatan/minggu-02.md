# Catatan Minggu 02: Class, Object, dan Encapsulation

## Yang saya kerjakan

Saya melengkapi kelas `Aset` dengan empat field private (`kode`, `nama`, `status`, `kondisi`), konstruktor dua parameter, getter, dan setter untuk field yang boleh berubah. Konstruktor mengisi nilai awal `StatusAset.TERSEDIA` dan `Kondisi.BAIK`, serta menolak kode atau nama yang null/kosong dengan `IllegalArgumentException`. Saya juga menambahkan tes pribadi `AsetNormalisasiTest` dan menjalankan tes minggu 1 sampai 2 sampai hijau.

## Keputusan desain

Saya memutuskan kode dan nama aset di-trim, tetapi huruf besar/kecilnya tidak diubah. Spasi di awal atau akhir hampir pasti kesalahan input dan bisa membuat kode yang sama terlihat berbeda, sedangkan mengubah kapitalisasi berisiko tidak cocok dengan data sumber seperti `LP-01`. Keputusan ini saya catat di `docs/asumsi.md` sebagai A-01.

Field `kode` saya buat `final` dan tidak diberi setter karena kode adalah identitas aset. Validasi saya letakkan di satu metode privat `validasiTeks` yang dipanggil konstruktor dan `setNama`, sehingga aturan null/kosong tidak ditulis ulang. Validasi dijalankan sebelum nilai ditempel ke field, jadi jika `setNama` gagal, nama lama tetap utuh.

## Kendala

Saya sempat terkendala saat memasang Java dan Apache Maven. Setelah JDK 21 dan Maven terpasang, saya memastikan dengan `java -version` dan `mvn -v`, lalu menjalankan `.\scripts\uji.ps1 -Minggu 2`. Awalnya saya juga sempat bingung membedakan validasi di konstruktor dan di setter; saya menyelesaikannya dengan memusatkan validasi teks di `validasiTeks` agar perilakunya konsisten.

## Penggunaan AI

## Penggunaan dan Proses Pengerjaan

- **Alat yang dipakai:** Visual Studio Code.
- **Bagian yang dikerjakan:** `Aset.java` yang meliputi konstruktor, validasi, getter, dan setter. Selain itu, saya membuat pengujian `AsetNormalisasiTest`, mencatat keputusan normalisasi pada `docs/asumsi.md` bagian A-01, serta menyusun catatan minggu 2.
- **Langkah pengerjaan:**
  1. Mengerjakan materi minggu 2 berdasarkan panduan `docs/minggu-02.md` dan `catatan/minggu-02.md` tanpa melakukan commit.
  2. Melengkapi `Aset.java` dengan field private, validasi kode dan nama, getter/setter, serta nilai awal `TERSEDIA` dan `BAIK`. Saya tidak menambahkan `setKode`.
  3. Membuat pengujian untuk memastikan proses normalisasi berjalan sesuai keputusan yang telah ditentukan.
  4. Mencatat keputusan normalisasi pada `docs/asumsi.md` dan melengkapi catatan minggu 2.
- **Keputusan yang saya ambil:** Saya menggunakan `trim()` untuk menghilangkan spasi di awal dan akhir teks tanpa mengubah huruf menjadi kapital semua. Hal ini dilakukan agar kode aset tetap sesuai dengan data sumber. Saya juga tidak menambahkan `setKode` supaya identitas aset tidak dapat diubah setelah objek dibuat.
- **Hal yang saya pahami:** Encapsulation bukan hanya tentang membuat field menjadi private, tetapi juga memastikan objek selalu memiliki data yang valid. Validasi perlu dilakukan sebelum nilai field diubah agar ketika setter menerima data yang tidak valid, kondisi objek tetap aman dan tidak mengalami perubahan sebagian.
