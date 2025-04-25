import java.math.BigInteger

fun celsiusToFahrenheit(celsius: Double): Double {
    val fahrenheit = celsius * 1.8 + 32
    return fahrenheit
}

fun dikdortgenCevresiHesapla(kisaKenar: Double, uzunKenar: Double): Double {
    if (kisaKenar <= 0 || uzunKenar <= 0) {
        println("Hata: Kenar uzunlukları pozitif olmalıdır.")
        return 0.0
    }
    val cevre = 2 * (kisaKenar + uzunKenar)
    return cevre
}

fun faktoriyelHesapla(sayi: Int): BigInteger {
    if (sayi < 0) {
        println("Hata: Faktoriyel negatif sayılar için tanımlı değildir. 1 döndürülüyor.")
        return BigInteger.ONE
    }
    if (sayi == 0 || sayi == 1) {
        return BigInteger.ONE
    }
    var result = BigInteger.ONE
    for (i in 2..sayi) {
        result = result.multiply(BigInteger.valueOf(i.toLong()))
    }
    return result
}

fun aHarfiSayisi(kelime: String): Int {
    var sayac = 0
    for (harf in kelime) {
        if (harf.toLowerCase() == 'a') {
            sayac++
        }
    }
    return sayac
}

fun icAcilarToplami(kenarSayisi: Int): Int {
    if (kenarSayisi < 3) {
        println("Hata: Bir poligonun kenar sayısı en az 3 olmalıdır. Geçersiz kenar sayısı: $kenarSayisi")
        return 0
    }
    val toplam = (kenarSayisi - 2) * 180
    return toplam
}

fun maasHesapla(calisilanGunSayisi: Int): Double {
    val gunlukCalismaSaati = 8
    val normalSaatUcreti = 10.0
    val mesaiSaatUcreti = 20.0
    val mesaiSiniriSaat = 160

    if (calisilanGunSayisi < 0) {
        println("Hata: Çalışılan gün sayısı negatif olamaz. 0 maaş döndürülüyor.")
        return 0.0
    }

    val toplamCalismaSaati = calisilanGunSayisi * gunlukCalismaSaati

    var toplamMaas = 0.0

    if (toplamCalismaSaati <= mesaiSiniriSaat) {
        toplamMaas = toplamCalismaSaati * normalSaatUcreti
    } else {
        val normalCalismaSaati = mesaiSiniriSaat
        val mesaiSaati = toplamCalismaSaati - mesaiSiniriSaat
        val normalMaas = normalCalismaSaati * normalSaatUcreti
        val mesaiMaasi = mesaiSaati * mesaiSaatUcreti
        toplamMaas = normalMaas + mesaiMaasi
    }

    return toplamMaas
}

fun kotaUcretiHesapla(kullanilanKotaGB: Double): Double {
    val bazKotaGB = 50.0
    val bazKotaUcreti = 100.0
    val kotaAsimGBUcreti = 4.0

    if (kullanilanKotaGB < 0) {
        println("Hata: Kullanılan kota miktarı negatif olamaz. 0 ücret döndürülüyor.")
        return 0.0
    }

    var toplamUcret = 0.0

    if (kullanilanKotaGB <= bazKotaGB) {
        toplamUcret = bazKotaUcreti
    } else {
        val asimMiktariGB = kullanilanKotaGB - bazKotaGB
        val asimUcreti = asimMiktariGB * kotaAsimGBUcreti
        toplamUcret = bazKotaUcreti + asimUcreti
    }

    return toplamUcret
}
