package id.ac.upb.asetpinjam.model;

import id.ac.upb.asetpinjam.config.Varian;
import id.ac.upb.asetpinjam.kontrak.DapatDipinjam;


/**
 * Aset yang dapat dipinjam.
 *
 * <p>Minggu 2: lengkapi field, konstruktor, getter/setter, dan validasi (encapsulation).
 * Minggu 3: tambahkan getJenis() di tiap subclass.
 * Minggu 4: hitungDenda() dioverride di tiap subclass.
 * Minggu 5: isi bisaDipinjam() dan ubah menjadi class abstrak
 * (TestSupport.aset(...) di folder test menyesuaikan sendiri, lihat docs/minggu-05.md).
 */

public abstract class Aset implements DapatDipinjam {
    private final String kode;
    private String nama;
    private StatusAset status;
    private Kondisi kondisi;

    /**
     * Membuat aset dengan nilai awal status TERSEDIA dan kondisi BAIK.
     *
     * @throws IllegalArgumentException jika kode atau nama null/kosong
     */
    public Aset(String kode, String nama) {
        this.kode = validasiTeks(kode, "kode");
        this.nama = validasiTeks(nama, "nama");
        this.status = StatusAset.TERSEDIA;
        this.kondisi = Kondisi.BAIK;
    }

    /**
     * Memvalidasi teks wajib dan menormalkannya dengan trim.
     * Huruf tidak diubah agar kode aset tetap sesuai data sumber.
     */
    private static String validasiTeks(String teks, String namaField) {
        if (teks == null || teks.isBlank()) {
            throw new IllegalArgumentException(namaField + " tidak boleh null atau kosong");
        }
        return teks.trim();
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public StatusAset getStatus() {
        return status;
    }

    public Kondisi getKondisi() {
        return kondisi;
    }

    /** Mengubah nama aset. Nama baru tidak boleh null atau kosong. */
    public void setNama(String nama) {
        this.nama = validasiTeks(nama, "nama");
    }

    /** Mengubah status aset. Status baru tidak boleh null. */
    public void setStatus(StatusAset status) {
        if (status == null) {
            throw new IllegalArgumentException("Status tidak boleh null");
        }
        this.status = status;
    }

    /** Mengubah kondisi aset. Kondisi baru tidak boleh null. */
    public void setKondisi(Kondisi kondisi) {
        if (kondisi == null) {
            throw new IllegalArgumentException("Kondisi tidak boleh null");
        }
        this.kondisi = kondisi;
    }

    /** True hanya jika status TERSEDIA dan kondisi bukan RUSAK_BERAT. */
    @Override
    public boolean bisaDipinjam() {
        return status == StatusAset.TERSEDIA && kondisi != Kondisi.RUSAK_BERAT;
    }

    /** Jenis aset; diimplementasikan tiap subclass. */
    public abstract JenisAset getJenis();

    /**
     * Denda keterlambatan sesuai jenis aset. Tiap subclass wajib mengimplementasikan
     * dan memakai {@link #dendaDasar(int)} agar validasi hari tetap konsisten.
     */
    public abstract long hitungDenda(int hariTerlambat);

    /**
     * Denda dasar tanpa multiplier jenis (multiplier 1x).
     * Memvalidasi hari negatif dan memakai tarif varian yang aktif.
     */
    protected long dendaDasar(int hariTerlambat) {
        if (hariTerlambat < 0) {
            throw new IllegalArgumentException("Hari terlambat tidak boleh negatif: " + hariTerlambat);
        }
        return (long) hariTerlambat * Varian.aktif().dendaPerHari;
    }
}
