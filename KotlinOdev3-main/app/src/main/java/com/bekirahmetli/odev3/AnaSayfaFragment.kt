package com.bekirahmetli.odev3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class AnasayfaFragment : Fragment(R.layout.fragment_ana_sayfa) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.btnToA).setOnClickListener {
            findNavController().navigate(R.id.action_anaSayfaFragment_to_sayfaAFragment)
        }
        view.findViewById<Button>(R.id.btnToX).setOnClickListener {
            findNavController().navigate(R.id.action_anaSayfaFragment_to_sayfaXFragment)
        }
    }
}