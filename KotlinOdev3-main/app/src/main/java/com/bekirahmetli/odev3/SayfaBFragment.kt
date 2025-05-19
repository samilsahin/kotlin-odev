package com.bekirahmetli.odev3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class SayfaBFragment : Fragment(R.layout.fragment_sayfa_b) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.btnToY).setOnClickListener {
            findNavController().navigate(R.id.action_sayfaBFragment_to_sayfaYFragment)
        }
    }
}