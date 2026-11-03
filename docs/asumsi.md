# Asumsi dan Keputusan Desain

Isi bagian ini sendiri. Satu entri per keputusan. Dinilai dari kejelasan alasan dan konsistensi dengan kode dan tes Anda,
bukan dari jawaban "benar".

Format tiap entri:

```
## A-NN: judul singkat
- Pertanyaan: ...
- Keputusan: ...
- Alasan: ...
- Dampak ke kode: ... (kelas/metode)
- Tes yang membuktikan: ... (nama tes di folder mahasiswa/)
```

## Aturan ambigu dari docs/aturan-bisnis.md

Salin setiap pertanyaan ambigu (nomor 1 sampai 7) ke sini dan jawab. Contoh:

## A-01: batas waktu bentrok
- Pertanyaan: 09:00-11:00 dan 11:00-13:00 pada aset yang sama bentrok atau tidak?
- Keputusan: (isi)
- Alasan: (isi)
- Dampak ke kode: (isi)
- Tes yang membuktikan: (isi)

## Asumsi lain

Tambahkan di sini keputusan lain yang Anda ambil: rumus denda progresif, perubahan skema database, format error API, dan seterusnya.

## A-01: normalisasi kode dan nama aset
- Pertanyaan: Apakah kode dan nama aset di-trim dan/atau diubah menjadi huruf besar?
- Keputusan: Kode dan nama di-trim (spasi awal/akhir dibuang), tetapi huruf besar/kecil tidak diubah.
- Alasan: Spasi di awal/akhir hampir pasti kesalahan input dan dapat membuat kode yang sama terlihat berbeda. Kapitalisasi dipertahankan agar kode seperti `LP-01` tetap sama dengan data sumber.
- Dampak ke kode: `Aset.validasiTeks` dipakai oleh konstruktor `Aset` dan `Aset.setNama`.
- Tes yang membuktikan: `AsetNormalisasiTest` di `core/src/test/java/id/ac/upb/asetpinjam/mahasiswa/`.
