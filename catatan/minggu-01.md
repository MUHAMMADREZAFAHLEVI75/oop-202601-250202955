# Catatan Minggu 01: Paradigma Pemrograman dan Setup

## Yang saya kerjakan

Saya melengkapi tiga versi program sapaan yang sama dengan tiga gaya berbeda: `HelloProsedural` memakai fungsi statis, `HelloOOP` memakai class dengan field private, dan `HelloFungsional` memakai lambda yang mengembalikan `Function<String, String>`. Saya juga mengisi `mahasiswa.properties` dengan NIM dan nama saya, lalu menjalankan tes minggu 1 dan memastikan kelima tes hijau.

## Keputusan desain

Saya memilih bentuk sapaan satu baris `Hallo Aset-Pinjam <nama> (<NIM>)` dan memakai bentuk yang sama persis di ketiga gaya. Alasannya, tes membandingkan hasil ketiga gaya, jadi kalimatnya harus identik; dengan begitu perbedaan yang tersisa benar-benar hanya cara menulis programnya, bukan isi keluarannya. Pada versi OOP, nama dan NIM saya simpan sebagai field private dan hanya bisa dibaca lewat `sapa()`, sedangkan versi fungsional tidak menyimpan state: NIM diikat saat fungsi dibuat, lalu nama diberikan saat fungsi dipanggil.

Kelebihan dan keterbatasan tiap gaya untuk sistem peminjaman aset:

- **Prosedural:** kelebihannya sederhana dan mudah diikuti untuk tugas kecil seperti mencetak sapaan atau menghitung denda sederhana. Keterbatasannya, data dan fungsi terpisah sehingga sulit menjaga aturan tetap konsisten saat sistem membesar; menambah jenis aset biasanya berakhir dengan percabangan yang panjang.
- **OOP:** kelebihannya data dan perilaku dibungkus dalam objek, sehingga entitas seperti `Ruang`, `Laptop`, dan `AlatLab` lebih mudah dimodelkan dan perubahannya terlokalisasi. Keterbatasannya, ada lebih banyak kode pendukung (class, konstruktor, getter) dan hierarki bisa menjadi berlebihan kalau dipakai untuk hal yang sangat kecil.
- **Fungsional:** kelebihannya fungsi murni mudah diuji dan digabungkan, cocok untuk mengolah atau menyaring daftar aset. Keterbatasannya, status peminjaman yang berubah-ubah kurang alami direpresentasikan tanpa state; konsepnya juga bisa lebih sulit diikuti saat pertama kali dipelajari.

## Kendala

Saya sempat terkendala saat memasang Java dan Apache Maven. Setelah JDK 21 dan Maven terpasang, saya memastikan dengan `java -version` dan `mvn -v`, lalu menjalankan `.\scripts\uji.ps1 -Minggu 1`. Saya juga sempat bingung membedakan gaya prosedural, OOP, dan fungsional karena ketiganya menghasilkan teks yang sama; saya memahaminya dengan melihat perbedaan struktur kode, yaitu fungsi statis, class dengan field private, dan lambda.
