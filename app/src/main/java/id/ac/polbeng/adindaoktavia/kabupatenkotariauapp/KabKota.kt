package id.ac.polbeng.adindaoktavia.kabupatenkotariauapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class KabKota(
    var gambar: Int = R.drawable.logo_default,
    var kabupaten_kota: String = "",
    var pusat_pemerintahan: String = "",
    var bupati_walikota: String = "",
    var luas_wilayah: Double = 0.0,
    var jumlah_penduduk: Int = 0,
    var jumlah_kecamatan: Int = 0,
    var jumlah_kelurahan: Int = 0,
    var jumlah_desa: Int = 0,
    var url_peta_wilayah: String = ""
): Parcelable
