package id.ac.upb.asetpinjam.mahasiswa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import id.ac.upb.asetpinjam.TestSupport;
import id.ac.upb.asetpinjam.model.Aset;
import id.ac.upb.asetpinjam.model.Kondisi;
import id.ac.upb.asetpinjam.model.StatusAset;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/** Tes keputusan pribadi: normalisasi kode dan nama aset (lihat docs/asumsi.md A-01). */
@Tag("week2")
class AsetNormalisasiTest {

    @Test
    void memangkasSpasiDiAwalDanAkhirKodeDanNama() {
        Aset aset = TestSupport.aset("  A-01  ", "  Proyektor  ");

        assertThat(aset.getKode()).isEqualTo("A-01");
        assertThat(aset.getNama()).isEqualTo("Proyektor");
    }

    @Test
    void tidakMengubahHurufBesarKecil() {
        Aset aset = TestSupport.aset("lp-01", "laptop Lab");

        assertThat(aset.getKode()).isEqualTo("lp-01");
        assertThat(aset.getNama()).isEqualTo("laptop Lab");
    }

    @Test
    void namaYangTidakValidTidakMengubahNamaLama() {
        Aset aset = TestSupport.aset("A-01", "Proyektor");

        assertThatThrownBy(() -> aset.setNama("   "))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(aset.getNama()).isEqualTo("Proyektor");
    }

    @Test
    void nilaiAwalStatusDanKondisiTetap() {
        Aset aset = TestSupport.aset("A-01", "Proyektor");

        assertThat(aset.getStatus()).isEqualTo(StatusAset.TERSEDIA);
        assertThat(aset.getKondisi()).isEqualTo(Kondisi.BAIK);
    }
}
