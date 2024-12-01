package id.ac.polbeng.adindaoktavia.kabupatenkotariauapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.ac.polbeng.adindaoktavia.kabupatenkotariauapp.databinding.ItemListKabkotaBinding

class ListKabKotaAdapter(private val listKabKota: ArrayList<KabKota>) :
    RecyclerView.Adapter<ListKabKotaAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: KabKota)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemListKabkotaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (gambar, kabupaten_kota, pusat_pemerintahan) = listKabKota[position]

        Glide.with(holder.binding.imgItemPhoto.context)
            .load(gambar)
            .apply(RequestOptions().override(55, 55))
            .into(holder.binding.imgItemPhoto)

        holder.binding.tvItemName.text = kabupaten_kota
        holder.binding.tvItemDetail.text = "Pusat Pemerintahan: $pusat_pemerintahan"

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listKabKota[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listKabKota.size

    inner class ListViewHolder(val binding: ItemListKabkotaBinding) : RecyclerView.ViewHolder(binding.root)
}
