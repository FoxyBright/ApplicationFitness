package com.example.applicationfitness

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.applicationfitness.fragments.*
import com.example.applicationfitness.models.EatModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

var curLocale : String = "en"

val cart = EatModel()

class MainActivity : AppCompatActivity() {

     fun updateActivityWithLocale(language : String) {
         finish()
         startActivity(intent)
         val config = resources.configuration
         val locale = Locale(language)
         Locale.setDefault(locale)
         config.locale = locale
         resources.updateConfiguration(config, resources.displayMetrics)
         curLocale = language
     }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        homeFragment.initCart(cart)
        val eatFragment = EatFragment()
        eatFragment.initCart(cart)
        val profileFragment = ProfileFragment()
        val excerciseFragment = ExcerciseFragment()
        val calcIntent = Intent(this, CalculateActivity::class.java)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        makeCurrentFragment(homeFragment)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_nav_add -> makeCurrentFragment(homeFragment)
                R.id.ic_nav_calories -> makeCurrentFragment(eatFragment)
                R.id.ic_nav_profile -> makeCurrentFragment(profileFragment)
                R.id.ic_nav_home -> makeCurrentFragment(excerciseFragment)
                R.id.ic_nav_calc ->startActivity(calcIntent)
            }
            true
        }
    }

     private fun makeCurrentFragment(fragment: Fragment){
         supportFragmentManager.beginTransaction().apply {
             replace(R.id.fl_wrapper, fragment)
             commit()
         }
     }

}
