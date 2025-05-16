package com.example.a6odev // Paket adınızı kontrol edin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.a6odev.databinding.ActivityMainBinding // Otomatik oluşturulan ViewBinding sınıfı

class MainActivity : AppCompatActivity() {

    // ViewBinding için bir değişken tanımlıyoruz.
    // "ActivityMainBinding" adı, XML dosyanızın adı olan "activity_main.xml"den gelir.
    // (activity_main -> ActivityMain) + Binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. ViewBinding nesnesini oluştur (inflate et)
        // LayoutInflater, XML dosyasını Kotlin/Java nesnelerine dönüştürür.
        binding = ActivityMainBinding.inflate(layoutInflater)

        // 2. Activity'nin content view'ını binding.root olarak ayarla.
        // binding.root, activity_main.xml'deki en dıştaki layout'u (CoordinatorLayout) temsil eder.
        setContentView(binding.root)

        // 3. Toolbar'ı ayarla
        // activity_main.xml'de Toolbar'a verdiğimiz ID: @+id/toolbar
        // ViewBinding ile erişim: binding.toolbar
        setSupportActionBar(binding.toolbar)

        // Toolbar başlığını kod ile de değiştirebilirsiniz (XML'de zaten ayarladık)
        // supportActionBar?.title = "Benim Özel Başlığım"

        // ViewBinding kullanarak TextView'ların içeriğini değiştirebiliriz (isteğe bağlı)
        // XML'de zaten varsayılan metinleri ayarladık, bu sadece örnek amaçlı.
        // binding.textViewTitle.text = "Kod ile Değişen Başlık"
        // binding.textViewDescription.text = "Bu açıklama Kotlin kodu ile güncellendi."

        // ImageView'a görseli kod ile de atayabilirsiniz (XML'de zaten ayarladık)
        // binding.imageViewSample.setImageResource(R.drawable.sample_image)
    }
}