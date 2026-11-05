package id.ac.upb.asetpinjam.denda;

import id.ac.upb.asetpinjam.kontrak.AturanDenda;
import id.ac.upb.asetpinjam.model.Aset;

/**
 * Minggu 5: denda yang makin berat bila makin lama terlambat.
 *
 * <p>Rumus progresifnya KEPUTUSAN ANDA (catat di docs/asumsi.md). Syarat minimal yang diuji:
 * 0 hari = 0; tidak pernah lebih murah dari DendaFlat; tidak pernah turun saat hari bertambah.
 */
public class DendaProgresif implements AturanDenda {

    /**
     * Denda dasar ditambah 25% untuk setiap blok 7 hari keterlambatan.
     * Contoh: 7 hari menjadi 1,25x denda flat, 30 hari menjadi 2x denda flat.
     */
    @Override
    public long hitung(Aset aset, int hariTerlambat) {
        long dasar = aset.hitungDenda(hariTerlambat);
        long blokMinggu = hariTerlambat / 7;
        return dasar + (dasar * blokMinggu * 25 / 100);
    }
}
