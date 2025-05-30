package com.bekirahmetli.bitirmeprojesi.viewmodel

import androidx.lifecycle.ViewModel
import com.bekirahmetli.bitirmeprojesi.data.model.Yemek
import com.bekirahmetli.bitirmeprojesi.data.repository.YemekRepository

class FoodDetailViewModel : ViewModel() {
    private val repo = YemekRepository()

    fun sepeteEkle(yemek: Yemek, adet: Int, callback: (Boolean) -> Unit) {
        repo.sepeteEkle(yemek, adet, callback)
    }
}