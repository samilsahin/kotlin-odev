package com.bekirahmetli.bitirmeprojesi.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bekirahmetli.bitirmeprojesi.R
import com.bekirahmetli.bitirmeprojesi.data.model.Yemek
import com.bekirahmetli.bitirmeprojesi.databinding.ItemFoodBinding
import com.bekirahmetli.bitirmeprojesi.util.FavoriManager
import com.bumptech.glide.Glide


class YemekAdapter(
    private val yemekler: List<Yemek>,
    private val onClick: (Yemek) -> Unit,
    private val onFavClick: (() -> Unit)? = null // Favoriler güncellendiğinde listeyi yenilemek için
) : RecyclerView.Adapter<YemekAdapter.YemekVH>() {

    class YemekVH(val binding: ItemFoodBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YemekVH {
        val binding = ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return YemekVH(binding)
    }

    override fun onBindViewHolder(holder: YemekVH, position: Int) {
        val yemek = yemekler[position]
        with(holder.binding) {
            tvFoodName.text = yemek.yemek_adi
            tvFoodPrice.text = "₺${yemek.yemek_fiyat}"
            Glide.with(root.context)
                .load("http://kasimadalan.pe.hu/yemekler/resimler/${yemek.yemek_resim_adi}")
                .into(imgFood)
            root.setOnClickListener { onClick(yemek) }

            // Favori butonu
            val isFav = FavoriManager.isFavori(root.context, yemek.yemek_id)
            btnFav.setImageResource(if (isFav) R.drawable.ic_favorite else R.drawable.ic_favorite_border)

            btnFav.setOnClickListener {
                if (isFav) {
                    FavoriManager.favoriKaldir(root.context, yemek.yemek_id)
                } else {
                    FavoriManager.favoriEkle(root.context, yemek.yemek_id)
                }
                notifyItemChanged(position)
                onFavClick?.invoke()
            }
        }
    }

    override fun getItemCount() = yemekler.size
}