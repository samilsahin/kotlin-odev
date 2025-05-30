package com.bekirahmetli.bitirmeprojesi.data.remote

import com.bekirahmetli.bitirmeprojesi.data.model.SepetCevap
import com.bekirahmetli.bitirmeprojesi.data.model.YemeklerCevap
import retrofit2.Call
import retrofit2.http.*

interface YemekApi {
    @GET("yemekler/tumYemekleriGetir.php")
    fun tumYemekleriGetir(): Call<YemeklerCevap>

    @FormUrlEncoded
    @POST("yemekler/sepeteYemekEkle.php")
    fun sepeteYemekEkle(
        @Field("yemek_adi") yemekAdi: String,
        @Field("yemek_resim_adi") yemekResimAdi: String,
        @Field("yemek_fiyat") yemekFiyat: Int,
        @Field("yemek_siparis_adet") yemekAdet: Int,
        @Field("kullanici_adi") kullaniciAdi: String
    ): Call<Map<String, Any>>

    @FormUrlEncoded
    @POST("yemekler/sepettekiYemekleriGetir.php")
    fun sepettekiYemekleriGetir(
        @Field("kullanici_adi") kullaniciAdi: String
    ): Call<SepetCevap>

    @FormUrlEncoded
    @POST("yemekler/sepettenYemekSil.php")
    fun sepettenYemekSil(
        @Field("sepet_yemek_id") sepetYemekId: Int,
        @Field("kullanici_adi") kullaniciAdi: String
    ): Call<Map<String, Any>>
}