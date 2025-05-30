package com.ahmetsamilsahin.bitirmeprojesi.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.ahmetsamilsahin.bitirmeprojesi.data.remote.RetrofitClient
import com.ahmetsamilsahin.bitirmeprojesi.data.model.SepetCevap
import com.ahmetsamilsahin.bitirmeprojesi.data.model.SepetYemek
import com.ahmetsamilsahin.bitirmeprojesi.data.model.Yemek
import com.ahmetsamilsahin.bitirmeprojesi.data.model.YemeklerCevap
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class YemekRepository {
    private val api = RetrofitClient.yemekApi

    fun yemekleriGetir(liveData: MutableLiveData<List<Yemek>>) {
        api.tumYemekleriGetir().enqueue(object : Callback<YemeklerCevap> {
            override fun onResponse(call: Call<YemeklerCevap>, response: Response<YemeklerCevap>) {
                Log.d("YemekCevap", "Cevap: ${response.body()}")
                liveData.value = response.body()?.yemekler ?: emptyList()
            }
            override fun onFailure(call: Call<YemeklerCevap>, t: Throwable) {
                Log.e("YemekCevap", "Hata: ${t.message}")
                liveData.value = emptyList()
            }
        })
    }

    fun sepeteEkle(
        yemek: Yemek,
        adet: Int,
        callback: (Boolean) -> Unit
    ) {
        api.sepeteYemekEkle(
            yemek.yemek_adi,
            yemek.yemek_resim_adi,
            yemek.yemek_fiyat.toInt(),
            adet,
            "bekirrr"
        ).enqueue(object : Callback<Map<String, Any>> {
            override fun onResponse(call: Call<Map<String, Any>>, response: Response<Map<String, Any>>) {
                callback(true)
            }
            override fun onFailure(call: Call<Map<String, Any>>, t: Throwable) {
                callback(false)
            }
        })
    }

    fun sepetiGetir(liveData: MutableLiveData<List<SepetYemek>>) {
        api.sepettekiYemekleriGetir("bekirrr").enqueue(object : Callback<SepetCevap> {
            override fun onResponse(call: Call<SepetCevap>, response: Response<SepetCevap>) {
                liveData.value = response.body()?.sepet_yemekler ?: emptyList()
            }
            override fun onFailure(call: Call<SepetCevap>, t: Throwable) {
                liveData.value = emptyList()
            }
        })
    }

    fun sepettenSil(sepetYemekId: Int, callback: (Boolean) -> Unit) {
        api.sepettenYemekSil(sepetYemekId, "bekirrr").enqueue(object : Callback<Map<String, Any>> {
            override fun onResponse(call: Call<Map<String, Any>>, response: Response<Map<String, Any>>) {
                callback(true)
            }
            override fun onFailure(call: Call<Map<String, Any>>, t: Throwable) {
                callback(false)
            }
        })
    }
}
