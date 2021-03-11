package com.pareandroid.infodaerahparepare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pareandroid.infodaerahparepare.fragment.About
import com.pareandroid.infodaerahparepare.fragment.FrgamentKecamatan
import com.pareandroid.infodaerahparepare.fragment.Main

class MainActivity : AppCompatActivity(),BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if (savedInstanceState == null){
            val Fragment = Main()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.flMain,Fragment)
                .commit()
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.Daerah -> {
               val fragmentOne =
                   FrgamentKecamatan()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.flMain,fragmentOne)
                    .commit()
                return true
            }
            R.id.profil ->{
            val fragmentTwo = About()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.flMain,fragmentTwo)
                    .commit()
                return true
        }

        }
        return false
    }
}
