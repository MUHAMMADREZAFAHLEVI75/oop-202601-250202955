# Catatan Minggu 04: Polymorphism

## Yang saya kerjakan

Saya melengkapi `hitungDenda(int)` di `Aset` beserta override-nya di `Ruang`, `Laptop`, dan `AlatLab`, lalu mengisi dua overload `cari(...)` di `KatalogAset`. Denda dihitung dari jumlah hari, multiplier jenis (Ruang 1x, Laptop 2x, AlatLab 4x), dan tarif dari `Varian.aktif().dendaPerHari`. Saya juga menjalankan tes minggu 1 sampai 4 dan memastikan semuanya hijau.

## Keputusan desain

Validasi hari negatif dan perkalian tarif dasar saya letakkan di `Aset.hitungDenda(int)`. Subclass cukup memanggil `super.hitungDenda(hari)` lalu mengalikannya dengan multiplier jenisnya. Dengan begitu aturan validasi tidak ditulis ulang di empat tempat, tetapi perilaku tiap jenis tetap berbeda lewat overriding. Untuk pencarian, saya memakai `toLowerCase(Locale.ROOT)` agar pencocokan tidak bergantung pada locale, dan overload kedua menyaring hasil dari overload pertama berdasarkan `JenisAset`.

## Kendala

Awalnya saya bingung membedakan overloading dan overriding di kode ini. Overloading terlihat pada dua metode `cari` yang namanya sama tetapi parameternya berbeda, sedangkan overriding terlihat pada `hitungDenda` yang dideklarasikan ulang di tiap subclass dan dipilih saat runtime lewat dynamic binding. Saya memastikan pemahaman itu dengan membaca ulang tes dan mencoba menjalankan tes dari kondisi bersih (`mvn clean test`).

## Penggunaan AI

- **Alat yang dipakai:** Tidak menggunakan AI.
- **Bagian yang dikerjakan:** Aset.hitungDenda, override hitungDenda di Ruang, Laptop, AlatLab, serta kedua metode cari di KatalogAset.
- **Prompt utama:** Tidak ada
- **Yang saya ubah atau tolak dari saran AI, dan alasannya:** Tidak ada saran AI yang digunakan. 
- **Satu hal yang saya pahami lebih baik sekarang:** Saya memahami perbedaan overloading dan overriding. Overloading dipilih berdasarkan parameter saat compile time, sedangkan overriding menggunakan implementasi metode berdasarkan objek sebenarnya saat runtime. Saya juga memahami bahwa `super` dapat digunakan untuk memanggil metode dari kelas induk agar logika program dapat digunakan kembali.