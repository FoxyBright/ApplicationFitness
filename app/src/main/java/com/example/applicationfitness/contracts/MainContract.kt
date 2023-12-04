package com.example.applicationfitness.contracts

import androidx.fragment.app.Fragment
import com.example.applicationfitness.models.ExcerciseModel
import com.example.applicationfitness.models.FoodModel
import com.example.applicationfitness.models.Languages

interface MainContract {
    
    interface MainView {
    
        fun navigateToExerciseItem(excercise: ExcerciseModel)
        fun navigateTo(fragment: Fragment, isSub: Boolean)
        fun updateActivityWithLocale()
        fun navigateToFoodItem(food: FoodModel)
        fun showBottomBar(isShow: Boolean)
        fun navigateToLogin()
        fun navigateToFood()
        fun setupBottomNav()
    }
    
    interface MainPresenter {
        fun checkIsLogin()
        fun getLocalLanguage(): Languages
        fun onDestroy()
    }
    
    interface MainModel {
        
        fun getLocalLanguage(): Languages
        fun setLocalLanguage(language: Languages)
        fun checkUserLogin(): Boolean
    }
}