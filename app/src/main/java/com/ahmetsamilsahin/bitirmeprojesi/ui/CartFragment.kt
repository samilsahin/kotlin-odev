package com.bekirahmetli.bitirmeprojesi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bekirahmetli.bitirmeprojesi.R
import com.bekirahmetli.bitirmeprojesi.viewmodel.CartViewModel

class CartFragment : Fragment() {
    private val viewModel: CartViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val rv = view.findViewById<RecyclerView>(R.id.rvCart)
        rv.layoutManager = LinearLayoutManager(requireContext())

        viewModel.sepetYemekler.observe(viewLifecycleOwner) { sepetYemekler ->
            rv.adapter = SepetAdapter(sepetYemekler) { silinecekYemek ->
                viewModel.sepettenSil(silinecekYemek.sepet_yemek_id.toInt()) {
                    viewModel.sepetiYukle()
                }
            }
            val toplam = sepetYemekler.sumOf { it.yemek_fiyat.toInt() * it.yemek_siparis_adet.toInt() }
            view.findViewById<TextView>(R.id.tvCartTotal).text = "Toplam: ₺$toplam"
        }

        viewModel.sepetiYukle()

        view.findViewById<Button>(R.id.btnConfirmCart).setOnClickListener {
            Toast.makeText(requireContext(), "Siparişiniz alındı!", Toast.LENGTH_SHORT).show()
        }
    }
}