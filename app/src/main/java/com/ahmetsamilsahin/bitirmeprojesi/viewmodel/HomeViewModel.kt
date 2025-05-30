package com.bekirahmetli.bitirmeprojesi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bekirahmetli.bitirmeprojesi.data.model.Yemek
import com.bekirahmetli.bitirmeprojesi.data.repository.YemekRepository

class HomeViewModel : ViewModel() {
    val yemekler = MutableLiveData<List<Yemek>>()
    private val repo = YemekRepository()

    fun yemekleriYukle() {
        repo.yemekleriGetir(yemekler)
    }
}