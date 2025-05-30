package com.bekirahmetli.bitirmeprojesi.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.bekirahmetli.bitirmeprojesi.data.model.Yemek
import com.bekirahmetli.bitirmeprojesi.databinding.FragmentFoodDetailBinding
import com.bekirahmetli.bitirmeprojesi.viewmodel.FoodDetailViewModel
import com.bumptech.glide.Glide

class FoodDetailFragment : Fragment() {
    private lateinit var binding: FragmentFoodDetailBinding
    private val viewModel: FoodDetailViewModel by viewModels()
    private lateinit var yemek: Yemek
    private var adet = 1

    companion object {
        fun newInstance(yemek: Yemek): FoodDetailFragment {
            val fragment = FoodDetailFragment()
            val bundle = Bundle()
            bundle.putSerializable("yemek", yemek)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        yemek = arguments?.getSerializable("yemek") as Yemek
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFoodDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.tvFoodDetailName.text = yemek.yemek_adi
        binding.tvFoodDetailPrice.text = "₺${yemek.yemek_fiyat}"
        Glide.with(requireContext())
            .load("http://kasimadalan.pe.hu/yemekler/resimler/${yemek.yemek_resim_adi}")
            .into(binding.imgFoodDetail)


        binding.tvFoodCount.text = adet.toString()

        binding.btnIncrease.setOnClickListener {
            adet++
            binding.tvFoodCount.text = adet.toString()
        }
        binding.btnDecrease.setOnClickListener {
            if (adet > 1) {
                adet--
                binding.tvFoodCount.text = adet.toString()
            }
        }
        binding.btnAddToCart.setOnClickListener {
            viewModel.sepeteEkle(yemek, adet) { basarili ->
                if (basarili) {
                    Toast.makeText(requireContext(), "Sepete eklendi!", Toast.LENGTH_SHORT).show()
                    parentFragmentManager.popBackStack()
                } else {
                    Toast.makeText(requireContext(), "Hata oluştu!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}