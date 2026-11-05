# Catatan Minggu 03: Inheritance

## Yang saya kerjakan

Saya melengkapi tiga turunan `Aset`, yaitu `Ruang`, `Laptop`, dan `AlatLab`. Masing-masing memiliki field khas (`kapasitas`; `spesifikasi` dan `nomorInventaris`; `laboratorium` dan `tingkatRisiko`), konstruktor yang memanggil `super(kode, nama)`, getter, dan `getJenis()` yang mengembalikan `JenisAset` sesuai jenisnya. Saya juga menambahkan validasi khusus di tiap kelas, lalu menjalankan tes minggu 1 sampai 3 dengan `.\scripts\uji.ps1 -Minggu 3` dan memastikan 23 tes hijau.

## Keputusan desain

Field `kode`, `nama`, `status`, dan `kondisi` saya letakkan di `Aset` karena keempatnya dimiliki semua jenis aset. Field yang hanya berlaku untuk satu jenis saya letakkan di subclass: `kapasitas` di `Ruang`, `spesifikasi` dan `nomorInventaris` di `Laptop`, serta `laboratorium` dan `tingkatRisiko` di `AlatLab`. Dengan begitu `Aset` tidak menyimpan data yang tidak relevan untuk semua turunannya, dan subclass tidak perlu mewarisi field yang tidak dipakainya.

Konstruktor subclass memanggil `super(kode, nama)` supaya validasi kode dan nama dari `Aset` tetap berjalan. Validasi khusus subclass saya kerjakan di konstruktor masing-masing: kapasitas harus lebih dari 0, spesifikasi dan nomor inventaris tidak boleh kosong, laboratorium tidak boleh kosong, dan tingkat risiko tidak boleh null. `getJenis()` di-override agar setiap objek melaporkan jenisnya sendiri, sehingga `List<Aset>` bisa diproses secara seragam.

Satu contoh di sistem ini di mana inheritance kurang tepat adalah `Peminjaman`. `Peminjaman` tidak seharusnya `extends Aset` hanya untuk memakai ulang `kode` dan `nama`, karena peminjaman bukan jenis aset, melainkan transaksi yang merujuk pada satu aset. Hubungan yang tepat adalah komposisi: `Peminjaman` memiliki field `Aset aset` dan `Peminjam peminjam`. Kalau memakai inheritance, `Peminjaman` akan ikut mewarisi `status` dan `kondisi` aset, padahal status yang dimaksud berbeda (status peminjaman).

## Kendala

Saya sempat terkendala saat memasang Java dan Apache Maven. Setelah JDK 21 dan Maven terpasang, saya memastikan dengan `java -version` dan `mvn -v`, lalu menjalankan `.\scripts\uji.ps1 -Minggu 3`. Kendala berikutnya adalah menentukan batas antara field induk dan field subclass; saya menyelesaikannya dengan menanyakan apakah field tersebut masuk akal dimiliki semua jenis aset. Kalau tidak, field saya taruh di subclass.

## Penggunaan AI

- Alat yang dipakai: Tidak menggunakan AI.
- Bagian yang dibantu AI: Tidak ada.
- Prompt utama: Tidak ada.
- Yang saya ubah atau tolak dari saran AI, dan alasannya: Tidak ada saran AI yang dipakai.
- Satu hal yang saya pahami lebih baik sekarang: Inheritance tepat dipakai saat ada hubungan "adalah" seperti `Ruang` adalah `Aset`, bukan sekadar untuk berbagi field. Saya juga memahami bahwa `super(...)` membuat validasi induk tetap berjalan, sedangkan komposisi lebih tepat untuk hubungan "memiliki" seperti `Peminjaman` memiliki `Aset`.
