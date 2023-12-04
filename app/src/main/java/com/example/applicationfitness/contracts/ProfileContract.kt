package com.example.applicationfitness.contracts

import com.example.applicationfitness.models.Languages
import com.example.applicationfitness.models.UserModel

interface ProfileContract {
    
    interface ProfileView {
        
        fun updateView()
        fun navigateToLogin()
    }
    
    interface ProfilePresenter {
        
        fun logout()
        fun setLanguage(languages: Languages)
        fun getLanguage(): Languages
        fun getUser(): UserModel?
        fun onDestroy()
    }
    
    interface ProfileModel {
        
        fun clearIsLogin()
        fun setLanguage(language: Languages)
        fun getLanguage(): Languages
        fun getUser(): UserModel
        fun setUserCalories(calories: Int)
        fun setUserSex(sex: String)
        fun setUserHeight(height: Int)
        fun setUserWeight(weight: Int)
        fun setUserAge(age: Int)
        fun setUserKcal(kcal: Int)
    }
}