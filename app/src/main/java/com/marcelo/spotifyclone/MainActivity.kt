package com.marcelo.spotifyclone

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.marcelo.spotifyclone.databinding.ActivityMainBinding
import com.marcelo.spotifyclone.fragments.Biblioteca
import com.marcelo.spotifyclone.fragments.Buscar
import com.marcelo.spotifyclone.fragments.Home

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var Content: FrameLayout? = null

    private var mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_inicio -> {
                    val fragment = Home.newInstance()
                    addFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }

                R.id.nav_buscar -> {
                    val fragment = Buscar.newInstance()
                    addFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }

                R.id.nav_biblioteca -> {
                    val fragment = Biblioteca.newInstance()
                    addFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content, fragment, fragment.javaClass.simpleName)
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Content = binding.content
        binding.bottomMenu.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val fragment = Home.newInstance()
        addFragment(fragment)
    }


}