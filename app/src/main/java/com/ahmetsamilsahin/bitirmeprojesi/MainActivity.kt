package com.bekirahmetli.bitirmeprojesi

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bekirahmetli.bitirmeprojesi.databinding.ActivityMainBinding
import com.bekirahmetli.bitirmeprojesi.ui.CartFragment
import com.bekirahmetli.bitirmeprojesi.ui.FavorilerFragment
import com.bekirahmetli.bitirmeprojesi.ui.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate başladı")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        Log.d("MainActivity", "HomeFragment açılıyor")
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, HomeFragment())
            .commit()

        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    Log.d("MainActivity", "HomeFragment seçildi")
                    switchFragment(HomeFragment())
                }
                R.id.menu_cart -> {
                    Log.d("MainActivity", "CartFragment seçildi")
                    switchFragment(CartFragment())
                }
                R.id.menu_fav -> {
                    Log.d("MainActivity", "FavorilerFragment seçildi")
                    switchFragment(FavorilerFragment())
                }
            }
            true
        }
    }

    private fun switchFragment(fragment: Fragment) {
        Log.d("MainActivity", "switchFragment çağrıldı: ${fragment::class.java.simpleName}")
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}