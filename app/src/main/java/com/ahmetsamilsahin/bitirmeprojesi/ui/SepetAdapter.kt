package com.bekirahmetli.bitirmeprojesi.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bekirahmetli.bitirmeprojesi.data.model.SepetYemek
import com.bekirahmetli.bitirmeprojesi.databinding.ItemCartBinding
import com.bumptech.glide.Glide

class SepetAdapter(
    private val sepetYemekler: List<SepetYemek>,
    private val onDelete: (SepetYemek) -> Unit
) : RecyclerView.Adapter<SepetAdapter.SepetVH>() {

    class SepetVH(val binding: ItemCartBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SepetVH {
        val binding = ItemCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SepetVH(binding)
    }

    override fun onBindViewHolder(holder: SepetVH, position: Int) {
        val yemek = sepetYemekler[position]
        with(holder.binding) {
            tvCartFoodName.text = yemek.yemek_adi
            tvCartFoodCount.text = "Adet: ${yemek.yemek_siparis_adet}"
            tvCartFoodPrice.text = "₺${yemek.yemek_fiyat.toInt() * yemek.yemek_siparis_adet.toInt()}"
            Glide.with(root.context)
                .load("http://kasimadalan.pe.hu/yemekler/resimler/${yemek.yemek_resim_adi}")
                .into(imgCartFood)
            btnDeleteCartFood.setOnClickListener {
                onDelete(yemek)
            }
        }
    }

    override fun getItemCount() = sepetYemekler.size
}