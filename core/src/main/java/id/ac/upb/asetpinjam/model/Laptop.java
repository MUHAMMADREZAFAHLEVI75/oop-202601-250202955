package id.ac.upb.asetpinjam.model;

/** Minggu 3: aset berupa laptop. Spesifikasi dan nomor inventaris tidak boleh kosong. */
public class Laptop extends Aset {
    private final String spesifikasi;
    private final String nomorInventaris;

    public Laptop(String kode, String nama, String spesifikasi, String nomorInventaris) {
        super(kode, nama);
        this.spesifikasi = validasiTeks(spesifikasi, "spesifikasi");
        this.nomorInventaris = validasiTeks(nomorInventaris, "nomorInventaris");
    }

    private String validasiTeks(String teks, String namaField) {
        if (teks == null || teks.trim().isEmpty()) {
            throw new IllegalArgumentException(namaField + " tidak boleh null atau kosong");
        }
        return teks.trim();
    }

    public String getSpesifikasi() {
        return spesifikasi;
    }

    public String getNomorInventaris() {
        return nomorInventaris;
    }

    @Override
    public JenisAset getJenis() {
        return JenisAset.LAPTOP;
    }

    /** Denda laptop memakai multiplier 2x. */
    @Override
    public long hitungDenda(int hariTerlambat) {
        return dendaDasar(hariTerlambat) * 2;
    }
}
