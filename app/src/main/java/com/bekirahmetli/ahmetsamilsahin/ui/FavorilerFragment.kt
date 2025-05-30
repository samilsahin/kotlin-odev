package com.bekirahmetli.bitirmeprojesi.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bekirahmetli.bitirmeprojesi.data.model.Yemek
import com.bekirahmetli.bitirmeprojesi.databinding.FragmentFavorilerBinding
import com.bekirahmetli.bitirmeprojesi.util.FavoriManager
import com.bekirahmetli.bitirmeprojesi.viewmodel.HomeViewModel

class FavorilerFragment : Fragment() {
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: FragmentFavorilerBinding

    private var favoriYemekler: MutableList<Yemek> = mutableListOf()
    private lateinit var adapter: YemekAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFavorilerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.rvFoods.layoutManager = LinearLayoutManager(requireContext())


        adapter = YemekAdapter(
            favoriYemekler,
            onClick = {  },
            onFavClick = {

                val favoriIdler = FavoriManager.getFavoriler(requireContext())
                favoriYemekler.clear()
                favoriYemekler.addAll(viewModel.yemekler.value?.filter { favoriIdler.contains(it.yemek_id) } ?: emptyList())
                adapter.notifyDataSetChanged()
            }
        )
        binding.rvFoods.adapter = adapter


        viewModel.yemekler.observe(viewLifecycleOwner) { yemekler ->
            val favoriIdler = FavoriManager.getFavoriler(requireContext())
            favoriYemekler.clear()
            favoriYemekler.addAll(yemekler.filter { favoriIdler.contains(it.yemek_id) })
            adapter.notifyDataSetChanged()
        }

        viewModel.yemekleriYukle()
        binding.fabCart.visibility = View.GONE
        binding.etSearch.visibility = View.GONE
    }
}