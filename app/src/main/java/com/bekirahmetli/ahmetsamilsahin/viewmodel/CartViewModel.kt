package com.bekirahmetli.bitirmeprojesi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bekirahmetli.bitirmeprojesi.data.model.SepetYemek
import com.bekirahmetli.bitirmeprojesi.data.repository.YemekRepository

class CartViewModel : ViewModel() {
    val sepetYemekler = MutableLiveData<List<SepetYemek>>()
    private val repo = YemekRepository()

    fun sepetiYukle() {
        repo.sepetiGetir(sepetYemekler)
    }

    fun sepettenSil(sepetYemekId: Int, callback: (Boolean) -> Unit) {
        repo.sepettenSil(sepetYemekId, callback)
    }
}