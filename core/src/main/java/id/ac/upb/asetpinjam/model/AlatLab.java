package id.ac.upb.asetpinjam.model;

/** Minggu 3: alat laboratorium. Laboratorium tidak boleh kosong; risiko tidak boleh null. */
public class AlatLab extends Aset {
    private String laboratorium;
    private TingkatRisiko tingkatRisiko;


    // TODO minggu 3: field laboratorium dan tingkatRisiko.

    public AlatLab(String kode, String nama, String laboratorium, TingkatRisiko tingkatRisiko) {
        super(kode, nama);
        if (laboratorium == null || laboratorium.trim().isEmpty()) {
            throw new IllegalArgumentException("Laboratorium tidak boleh null atau kosong");
        }
        if (tingkatRisiko == null) {
            throw new IllegalArgumentException("Tingkat risiko tidak boleh null");
        }
        this.laboratorium = laboratorium.trim();
        this.tingkatRisiko = tingkatRisiko;
    }

    public String getLaboratorium() {
        return laboratorium;
    }

    public TingkatRisiko getTingkatRisiko() {
        return tingkatRisiko;
    }

    // TODO minggu 3: override getJenis(). 
    public JenisAset getJenis() {
        return JenisAset.ALAT_LAB;
    }
    // Minggu 4: override hitungDenda(int).

    /** Denda alat laboratorium memakai multiplier 4x. */
    @Override
    public long hitungDenda(int hariTerlambat) {
        return super.hitungDenda(hariTerlambat) * 4;
    }
}
