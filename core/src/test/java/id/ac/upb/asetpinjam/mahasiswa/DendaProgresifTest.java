package id.ac.upb.asetpinjam.mahasiswa;

import static org.assertj.core.api.Assertions.assertThat;

import id.ac.upb.asetpinjam.denda.DendaFlat;
import id.ac.upb.asetpinjam.denda.DendaProgresif;
import id.ac.upb.asetpinjam.kontrak.AturanDenda;
import id.ac.upb.asetpinjam.model.Aset;
import id.ac.upb.asetpinjam.model.Laptop;
import id.ac.upb.asetpinjam.model.Ruang;
import java.util.List;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/** Tes keputusan pribadi: rumus denda progresif (lihat docs/asumsi.md A-02). */
@Tag("week5")
class DendaProgresifTest {

    private final AturanDenda flat = new DendaFlat();
    private final AturanDenda progresif = new DendaProgresif();
    private final Aset ruang = new Ruang("R-01", "Aula", 20);
    private final Aset laptop = new Laptop("L-01", "Laptop", "i5", "INV-1");

    @Test
    void nolHariTetapNol() {
        assertThat(progresif.hitung(ruang, 0)).isZero();
        assertThat(progresif.hitung(laptop, 0)).isZero();
    }

    @Test
    void setiapBlokTujuhHariMenambahDuaPuluhLimaPersen() {
        long flatTujuh = flat.hitung(ruang, 7);
        assertThat(progresif.hitung(ruang, 7)).isEqualTo(flatTujuh + flatTujuh * 25 / 100);
    }

    @Test
    void tigaPuluhHariMenjadiDuaKaliDendaFlat() {
        assertThat(progresif.hitung(ruang, 30)).isEqualTo(flat.hitung(ruang, 30) * 2);
        assertThat(progresif.hitung(laptop, 30)).isEqualTo(flat.hitung(laptop, 30) * 2);
    }

    @Test
    void tidakPernahTurunDanTidakPernahLebihMurahDariFlat() {
        for (Aset aset : List.of(ruang, laptop)) {
            long sebelumnya = 0;
            for (int hari = 0; hari <= 30; hari++) {
                long nilai = progresif.hitung(aset, hari);
                assertThat(nilai).isGreaterThanOrEqualTo(flat.hitung(aset, hari));
                assertThat(nilai).isGreaterThanOrEqualTo(sebelumnya);
                sebelumnya = nilai;
            }
        }
    }
}
