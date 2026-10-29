package id.ac.upb.asetpinjam.model;

/** Minggu 3: aset berupa laptop. Spesifikasi dan nomor inventaris tidak boleh kosong. */
public class Laptop extends Aset {
    private String spesifikasi;
    private String nomorInventaris;

    private String validasiTeks(String teks, String namaField) {
        if (teks == null || teks.trim().isEmpty()) {
            throw new IllegalArgumentException(namaField + " tidak boleh null atau kosong");
        }
        return teks.trim();
    }
        

     // TODO minggu 3: field spesifikasi dan nomorInventaris.

    public Laptop(String kode, String nama, String spesifikasi, String nomorInventaris) {
        super(kode, nama);
        this.spesifikasi = validasiTeks(spesifikasi, "spesifikasi");
        this.nomorInventaris = validasiTeks(nomorInventaris, "nomorInventaris");
    }

    public String getSpesifikasi() {
        return spesifikasi;
    }

    public String getNomorInventaris() {
        return nomorInventaris;
    }

    // TODO minggu 3: override getJenis().
    public JenisAset getJenis() {
        return JenisAset.LAPTOP;
    }
    //  Minggu 4: override hitungDenda(int).

    /** Denda laptop memakai multiplier 2x. */
    @Override
    public long hitungDenda(int hariTerlambat) {
        return super.hitungDenda(hariTerlambat) * 2;
    }
}
