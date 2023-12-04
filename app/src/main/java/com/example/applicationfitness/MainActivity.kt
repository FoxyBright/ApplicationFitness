package com.example.applicationfitness

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.applicationfitness.contracts.MainContract
import com.example.applicationfitness.data.SharedPrefs
import com.example.applicationfitness.models.ExcerciseModel
import com.example.applicationfitness.models.FoodModel
import com.example.applicationfitness.presenters.MainPresenter
import com.example.applicationfitness.view.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.bottom_navigation
import java.util.*

class MainActivity: MainContract.MainView, AppCompatActivity() {
    
    private var bottomNav: BottomNavigationView? = null
    
    private lateinit var mainPresenter: MainContract.MainPresenter
    
    companion object {
        
        private const val SUB_SCREEN_KEY = "subScreenKey"
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        setLanguage()
        super.onCreate(savedInstanceState)
        mainPresenter = MainPresenter(this)
        setContentView(R.layout.activity_main)
        setupBottomNav()
        mainPresenter.checkIsLogin()
    }
    
    override fun showBottomBar(isShow: Boolean) {
        bottom_navigation.visibility = if (isShow) VISIBLE else GONE
    }
    
    @Suppress("DEPRECATION")
    override fun setupBottomNav() {
        // инициализируем нижнюю панель навигации
        bottomNav = findViewById(R.id.bottom_navigation)
        bottomNav?.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_nav_excercise -> navigateTo(fragment = ExcerciseFragment(), isSub = false)
                R.id.ic_nav_calculate -> navigateTo(fragment = CalculateFragment(), isSub = false)
                R.id.ic_nav_profile -> navigateTo(fragment = ProfileFragment(), isSub = false)
                R.id.ic_nav_food -> navigateTo(fragment = FoodFragment(), isSub = false)
                R.id.ic_nav_cart -> navigateTo(fragment = CartFragment(), isSub = false)
            }
            true
        }
    }
    
    override fun navigateToLogin() = navigateTo(LoginFragment(), false)
    
    override fun navigateToExerciseItem(excercise: ExcerciseModel) =
        navigateTo(ExcerciseItemFragment(excercise), true)
    
    override fun navigateToFoodItem(food: FoodModel) =
        navigateTo(FoodItemFragment(food), true)
    
    override fun navigateToFood() {
        bottomNav?.selectedItemId = R.id.ic_nav_food
    }
    
    override fun navigateTo(fragment: Fragment, isSub: Boolean) {
        supportFragmentManager
            .apply { if (fragments.lastOrNull()?.tag == SUB_SCREEN_KEY) return }
            .beginTransaction().apply {
                if (isSub) {
                    add(R.id.fl_wrapper, fragment, SUB_SCREEN_KEY)
                    addToBackStack(SUB_SCREEN_KEY)
                } else {
                    replace(R.id.fl_wrapper, fragment)
                }
            }.commit()
    }
    
    override fun updateActivityWithLocale() {
        finish()
        startActivity(intent)
        setLanguage()
    }
    
    @Suppress("DEPRECATION")
    private fun setLanguage() {
        val config = resources.configuration
        val locale = Locale(SharedPrefs(this).getLocalLanguage().value)
        Locale.setDefault(locale)
        config.locale = locale
        resources.updateConfiguration(config, resources.displayMetrics)
    }
    
    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0) {
            super.onBackPressed()
        } else {
            supportFragmentManager.popBackStack()
            val lastNavTag = supportFragmentManager
                .fragments.last().tag
            if (lastNavTag == SUB_SCREEN_KEY) {
                showBottomBar(isShow = true)
            }
        }
    }
}