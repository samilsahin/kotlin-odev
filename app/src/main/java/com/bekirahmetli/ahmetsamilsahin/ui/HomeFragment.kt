package com.bekirahmetli.bitirmeprojesi.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bekirahmetli.bitirmeprojesi.R
import com.bekirahmetli.bitirmeprojesi.data.model.Yemek
import com.bekirahmetli.bitirmeprojesi.databinding.FragmentHomeBinding
import com.bekirahmetli.bitirmeprojesi.viewmodel.HomeViewModel
import androidx.core.widget.addTextChangedListener

class HomeFragment : Fragment() {
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: FragmentHomeBinding

    private var tumYemekler: List<Yemek> = emptyList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.rvFoods.layoutManager = LinearLayoutManager(requireContext())


        fun updateAdapter(liste: List<Yemek>) {
            binding.rvFoods.adapter = YemekAdapter(
                liste,
                onClick = { secilenYemek ->
                    parentFragmentManager.beginTransaction()
                        .replace(
                            R.id.fragmentContainer,
                            FoodDetailFragment.newInstance(secilenYemek)
                        )
                        .addToBackStack(null)
                        .commit()
                },
                onFavClick = {
                    val arama = binding.etSearch.text.toString()
                    val guncelListe = if (arama.isEmpty()) tumYemekler else tumYemekler.filter {
                        it.yemek_adi.contains(arama, ignoreCase = true)
                    }
                    updateAdapter(guncelListe)
                }
            )
        }


        viewModel.yemekler.observe(viewLifecycleOwner) { yemekler ->
            tumYemekler = yemekler
            updateAdapter(yemekler)
        }


        binding.etSearch.addTextChangedListener { text ->
            val filtreliListe = tumYemekler.filter {
                it.yemek_adi.contains(text.toString(), ignoreCase = true)
            }
            updateAdapter(filtreliListe)
        }

        viewModel.yemekleriYukle()

        binding.fabCart.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(
                    R.id.fragmentContainer,
                    CartFragment()
                )
                .addToBackStack(null)
                .commit()
        }
    }
}