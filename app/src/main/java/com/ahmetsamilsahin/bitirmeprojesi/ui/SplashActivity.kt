package com.bekirahmetli.bitirmeprojesi.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bekirahmetli.bitirmeprojesi.databinding.ActivitySplashBinding
import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.util.Log
import com.bekirahmetli.bitirmeprojesi.MainActivity

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("SplashActivity", "onCreate başladı")
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("SplashActivity", "Animasyon başlatılıyor")
        binding.lottieAnim.addAnimatorListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                Log.d("SplashActivity", "Animasyon bitti, MainActivity'ye geçiliyor")
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                finish()
            }
        })

        binding.lottieAnim.playAnimation()
        // Belirli bir süre sonra ana ekrana geç
        binding.lottieAnim.postDelayed({
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }, 4000)
    }
}