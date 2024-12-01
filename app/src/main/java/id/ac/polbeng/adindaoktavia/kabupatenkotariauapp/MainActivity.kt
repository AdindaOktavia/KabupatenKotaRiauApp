package id.ac.polbeng.adindaoktavia.kabupatenkotariauapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.polbeng.adindaoktavia.kabupatenkotariauapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Menggunakan View Binding untuk mengelola elemen UI
    private lateinit var binding: ActivityMainBinding

    // Variabel untuk menyimpan judul ActionBar
    private var title: String = "Mode List View"

    // List untuk menyimpan data kabupaten/kota
    private var listData: ArrayList<KabKota> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set Toolbar sebagai ActionBar
        setSupportActionBar(binding.myToolbar)

        // Set judul awal pada ActionBar
        setActionBarTitle(title)

        // Tambahkan data ke dalam listData
        listData.addAll(KabKotaData.listDataKabKota)

        // Tampilkan RecyclerView dengan mode List View
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate menu utama ke dalam ActionBar
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Tangani item yang dipilih di menu
        setMode(item.itemId)
        return true
    }

    private fun setMode(selectedMode: Int) {
        // Ubah mode RecyclerView berdasarkan item yang dipilih
        when (selectedMode) {
            R.id.action_list -> {
                title = "Mode List View"
                showRecyclerList()
            }
            R.id.action_grid -> {
                title = "Mode Grid View"
                showRecyclerGrid()
            }
            R.id.action_cardview -> {
                title = "Mode Card View"
                showRecyclerCardView()
            }
        }
        setActionBarTitle(title)
    }

    private fun setActionBarTitle(title: String) {
        // Set judul pada ActionBar
        supportActionBar?.title = title
    }

    private fun showRecyclerList() {
        // Atur RecyclerView dengan mode List View
        binding.rvKabKota.layoutManager = LinearLayoutManager(this)
        val listAdapter = ListKabKotaAdapter(listData)
        binding.rvKabKota.adapter = listAdapter

        listAdapter.setOnItemClickCallback(object :
            ListKabKotaAdapter.OnItemClickCallback {
            override fun onItemClicked(data: KabKota) {
                showDataKabKota(data)
            }
        })
    }

    private fun showRecyclerGrid() {
        // Atur RecyclerView dengan mode Grid View
        binding.rvKabKota.layoutManager = GridLayoutManager(this, 2)
        val gridAdapter = GridKabKotaAdapter(listData)
        binding.rvKabKota.adapter = gridAdapter

        gridAdapter.setOnItemClickCallback(object :
            GridKabKotaAdapter.OnItemClickCallback {
            override fun onItemClicked(data: KabKota) {
                showDataKabKota(data)
            }
        })
    }

    private fun showRecyclerCardView() {
        // Atur RecyclerView dengan mode Card View
        binding.rvKabKota.layoutManager = LinearLayoutManager(this)
        val cardAdapter = CardKabKotaAdapter(listData)
        binding.rvKabKota.adapter = cardAdapter

        cardAdapter.setOnItemClickCallback(object :
            CardKabKotaAdapter.OnItemClickCallback {
            override fun onItemClicked(data: KabKota) {
                showDataKabKota(data)
            }
        })
    }

    private fun showDataKabKota(data: KabKota) {
        // Pindah ke activity detail dengan membawa data KabKota
        val intent = Intent(this@MainActivity, DetailKabKotaActivity::class.java)
        intent.putExtra(DetailKabKotaActivity.EXTRA_KAB_KOTA, data)
        startActivity(intent)
    }
}
