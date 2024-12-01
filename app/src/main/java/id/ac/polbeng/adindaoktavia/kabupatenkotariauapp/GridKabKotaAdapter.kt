package id.ac.polbeng.adindaoktavia.kabupatenkotariauapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.ac.polbeng.adindaoktavia.kabupatenkotariauapp.databinding.ItemGridKabkotaBinding

class GridKabKotaAdapter(private val listKabKota: ArrayList<KabKota>) :
    RecyclerView.Adapter<GridKabKotaAdapter.GridViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: KabKota)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val binding = ItemGridKabkotaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GridViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val kabKota = listKabKota[position]

        Glide.with(holder.itemView.context)
            .load(kabKota.gambar)
            .into(holder.binding.imgItemPhoto)

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(kabKota)
        }
    }

    override fun getItemCount(): Int = listKabKota.size

    inner class GridViewHolder(val binding: ItemGridKabkotaBinding) :
        RecyclerView.ViewHolder(binding.root)
}

