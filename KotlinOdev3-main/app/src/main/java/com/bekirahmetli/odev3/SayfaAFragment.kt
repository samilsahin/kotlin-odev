package com.bekirahmetli.odev3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class SayfaAFragment : Fragment(R.layout.fragment_sayfa_a) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.btnToB).setOnClickListener {
            findNavController().navigate(R.id.action_sayfaAFragment_to_sayfaBFragment)
        }
    }
}