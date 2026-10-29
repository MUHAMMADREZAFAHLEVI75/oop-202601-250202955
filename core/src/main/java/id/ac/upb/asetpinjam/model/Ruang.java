package id.ac.upb.asetpinjam.model;

/** Minggu 3: aset berupa ruang. Kapasitas harus lebih dari 0 (IllegalArgumentException). */
public class Ruang extends Aset {
    private int kapasitas;
    // TODO minggu 3: field kapasitas.

    public Ruang(String kode, String nama, int kapasitas) {
        super(kode, nama);
        this.kapasitas = kapasitas;
        if (kapasitas <= 0) {
            throw new IllegalArgumentException("Kapasitas harus lebih dari 0");
        }
    }

    public int getKapasitas() {
        return kapasitas;
    }

    // TODO minggu 3: override getJenis().
    public JenisAset getJenis() {
        return JenisAset.RUANG;
    }
    //  Minggu 4: override hitungDenda(int).

    /** Denda ruang memakai multiplier 1x. */
    @Override
    public long hitungDenda(int hariTerlambat) {
        return super.hitungDenda(hariTerlambat);
    }
}
