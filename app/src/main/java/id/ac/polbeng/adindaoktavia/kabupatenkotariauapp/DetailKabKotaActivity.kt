package id.ac.polbeng.adindaoktavia.kabupatenkotariauapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import id.ac.polbeng.adindaoktavia.kabupatenkotariauapp.databinding.ActivityDetailKabKotaBinding

class DetailKabKotaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailKabKotaBinding

    companion object {
        const val EXTRA_KAB_KOTA = "extra_kab_kota"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailKabKotaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val dataKabKota = intent.getParcelableExtra<KabKota>(EXTRA_KAB_KOTA) ?: return
        displayData(dataKabKota)
        setButtonClickListener(dataKabKota)
    }

    private fun displayData(dataKabKota: KabKota) {
        Glide.with(applicationContext)
            .load(dataKabKota.gambar)
            .into(binding.imgItemPhoto)

        binding.apply {
            tvNama.text = dataKabKota.kabupaten_kota
            tvPusatPemerintahan.text = dataKabKota.pusat_pemerintahan
            tvBupatiWalikota.text = dataKabKota.bupati_walikota
            tvLuasWilayah.text = dataKabKota.luas_wilayah.toString()
            tvJumlahPenduduk.text = dataKabKota.jumlah_penduduk.toString()
            tvJumlahKecamatan.text = dataKabKota.jumlah_kecamatan.toString()
            tvJumlahKelurahan.text = dataKabKota.jumlah_kelurahan.toString()
            tvJumlahDesa.text = dataKabKota.jumlah_desa.toString()
        }
    }

    private fun setButtonClickListener(dataKabKota: KabKota) {
        binding.btnViewPeta.setOnClickListener {
            val showViewPeta = Intent(this, ViewPetaActivity::class.java)
            showViewPeta.putExtra(ViewPetaActivity.EXTRA_URL_PETA, dataKabKota.url_peta_wilayah)
            startActivity(showViewPeta)
        }
    }
}
