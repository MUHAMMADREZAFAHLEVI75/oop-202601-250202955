# Catatan Minggu 01: Paradigma Pemrograman dan Setup

## Yang saya kerjakan

Di minggu 1 saya membuat tiga program sapaan dengan cara yang berbeda. Yang pertama `HelloProsedural`, saya isi dengan fungsi statis `sapa` yang langsung mengembalikan teks sapaan. Yang kedua `HelloOOP`, saya buat class dengan field `nama` dan `nim` yang private, lalu teksnya diambil lewat method `sapa()`. Yang ketiga `HelloFungsional`, saya pakai lambda yang mengembalikan `Function<String, String>`.

Saya juga mengisi `mahasiswa.properties` dengan NIM dan nama saya, yaitu 250202955 dan Muhammad Reza Fahlevi. Setelah itu saya jalankan `.\scripts\uji.ps1 -Minggu 1` dan hasilnya 5 tes lulus semua.

## Keputusan desain

Saya memilih bentuk sapaan `Hallo Aset-Pinjam <nama> (<NIM>)` dan memakainya sama persis di ketiga versi. Alasannya karena tes membandingkan hasil ketiga versi, jadi kalau kalimatnya beda sedikit saja bisa gagal. Dengan begitu saya bisa lebih fokus melihat bedanya di cara menulis kodenya.

Di versi OOP, nama dan NIM saya simpan di field private, jadi tidak bisa diubah langsung dari luar class dan hanya bisa dibaca lewat `sapa()`. Di versi fungsional saya tidak menyimpan data di field. NIM diikat waktu fungsi dibuat, lalu nama diberikan waktu fungsi dipanggil.

Kelebihan dan kekurangan tiap gaya untuk sistem peminjaman aset:

- **Prosedural:** gampang dipakai untuk program kecil karena kodenya pendek dan mudah dibaca. Tapi data dan fungsinya terpisah, jadi kalau programnya makin besar saya merasa lebih susah menjaga aturannya tetap sama. Kalau jenis asetnya makin banyak, nanti bisa banyak `if` yang panjang.
- **OOP:** data dan method ada di dalam satu class, jadi lebih rapi dan gampang dipahami. Cocok untuk membuat objek seperti `Ruang`, `Laptop`, dan `AlatLab`. Kekurangannya, kode yang ditulis jadi lebih banyak karena harus membuat class, konstruktor, dan getter. Kalau dipakai untuk hal yang sangat kecil, malah terasa berlebihan.
- **Fungsional:** fungsi murni gampang dites dan bisa digabung, jadi cocok untuk mengolah daftar aset. Tapi untuk status peminjaman yang berubah-ubah, saya merasa agak susah karena gaya ini tidak menyimpan data yang berubah-ubah. Konsepnya juga masih agak sulit buat saya yang baru belajar.

## Kendala

Kendala pertama saya alami waktu memasang Java dan Apache Maven. Setelah JDK 21 dan Maven terpasang, saya cek dengan `java -version` dan `mvn -v` untuk memastikan sudah benar. Setelah itu baru saya jalankan `.\scripts\uji.ps1 -Minggu 1`.

Saya juga sempat bingung membedakan prosedural, OOP, dan fungsional karena hasil teksnya sama semua. Akhirnya saya lihat dari struktur kodenya: prosedural cuma fungsi statis, OOP ada class dengan field private, dan fungsional memakai lambda. Dari situ saya mulai paham kalau yang beda bukan hasilnya, tapi cara menyusun programnya.

## Penggunaan AI

- Alat yang dipakai: Tidak memakai AI.
- Bagian yang dibantu AI: Tidak ada.
- Prompt utama: Tidak ada.
- Yang saya ubah atau tolak dari saran AI, dan alasannya: Tidak ada.
- Satu hal yang saya pahami lebih baik sekarang: Saya lebih paham perbedaan prosedural, OOP, dan fungsional. Prosedural memakai fungsi statis, OOP membungkus data dan method di dalam class, sedangkan fungsional memakai lambda.
