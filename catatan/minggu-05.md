# Catatan Minggu 05: Abstraction

## Yang saya kerjakan

Saya mengubah `Aset` menjadi abstract class dan mengisi `bisaDipinjam()` supaya hanya bernilai true ketika status TERSEDIA dan kondisi bukan RUSAK_BERAT. Saya juga membuat `hitungDenda` abstrak, memindahkan perhitungan denda dasar ke `dendaDasar`, lalu menyesuaikan `Ruang`, `Laptop`, dan `AlatLab` agar tetap memakai multiplier 1x, 2x, dan 4x. Setelah itu saya mengimplementasikan `DendaFlat` dan `DendaProgresif`, menambahkan tes pribadi `DendaProgresifTest`, dan menjalankan tes minggu 1 sampai 5.

## Keputusan desain

`Aset` saya pertahankan sebagai abstract class, bukan interface, karena menyimpan state bersama (`kode`, `nama`, `status`, `kondisi`) dan sudah memiliki perilaku konkret seperti getter, setter, dan `bisaDipinjam()`. Kalau `Aset` dijadikan interface, field dan validasi bersama harus diduplikasi di setiap subclass. Interface saya pakai untuk kontrak yang tidak membutuhkan state, yaitu `DapatDipinjam` dan `AturanDenda`.

`hitungDenda` saya jadikan abstrak karena setiap jenis aset punya multiplier berbeda. Agar validasi hari negatif dan perhitungan tarif tidak ditulis ulang, saya menambahkan `protected long dendaDasar(int)` di `Aset`; subclass cukup mengalikan hasilnya dengan multiplier jenisnya. `getJenis()` juga saya jadikan abstrak karena tiap subclass sudah mengetahui jenisnya sendiri.

Untuk denda progresif, saya memilih rumus denda flat ditambah 25% dari denda flat untuk setiap blok 7 hari penuh: `flat + (flat x 25% x (hari / 7))`. Rumus ini tercatat sebagai A-02 di `docs/asumsi.md`. Alasannya, hasilnya tetap 0 pada hari ke-0, tidak pernah lebih murah dari denda flat, tidak pernah turun saat hari bertambah, dan pada hari ke-30 menjadi 2x denda flat sehingga keterlambatan lama lebih berat.

## Kendala

Saya sempat terkendala saat memasang Java dan Apache Maven; setelah JDK 21 dan Maven terpasang saya memastikan dengan `java -version` dan `mvn -v`. Kendala lain muncul setelah `hitungDenda` dijadikan abstrak, karena subclass tidak bisa lagi memanggil `super.hitungDenda`. Saya mengatasinya dengan memindahkan logika dasar ke `dendaDasar` agar validasi hari negatif tetap di satu tempat. Saya juga memastikan tes minggu 2 tetap berjalan karena `TestSupport.aset(...)` otomatis memakai `Ruang` setelah `Aset` menjadi abstrak.

## Penggunaan AI

- Alat yang dipakai: OpenCode.
- Bagian yang dibantu AI: implementasi `Aset.bisaDipinjam`, perubahan `hitungDenda` menjadi abstrak beserta helper `dendaDasar`, penyesuaian `Ruang`, `Laptop`, dan `AlatLab`, implementasi `DendaFlat` dan `DendaProgresif`, serta penyusunan catatan ini.
- Prompt utama: "Kerjakan Minggu 5: Abstraction ... tanpa commit" (ringkasan tugas minggu 5 beserta aturan pasti dan tesnya).
- Yang saya ubah atau tolak dari saran AI, dan alasannya: Saya menetapkan rumus progresif 25% per 7 hari dan menambahkan `DendaProgresifTest` untuk membuktikannya. Saya juga mempertahankan validasi hari negatif di `dendaDasar` agar tidak hilang saat `hitungDenda` menjadi abstrak.
- Satu hal yang saya pahami lebih baik sekarang: Abstract class dipakai saat subclass perlu berbagi state dan perilaku, sedangkan interface dipakai untuk kontrak perilaku tanpa state. Saya juga memahami bahwa method abstrak memaksa subclass menyediakan implementasi, tetapi logika bersama tetap bisa ditaruh di method konkret kelas induk.
