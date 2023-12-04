package com.example.applicationfitness.data

import com.example.applicationfitness.contracts.ProfileContract
import com.example.applicationfitness.models.Languages
import com.example.applicationfitness.models.UserModel

class ProfileRepository(
    private val prefs: SharedPrefs,
): ProfileContract.ProfileModel {
    
    private var user = UserModel(
        password = "1234",
        username = "root",
        age = 21,
        weight = 82,
        height = 179,
        sex = "Мужской",
        name = "Илья Пауков",
        calories = 2800
    )
    
    override fun clearIsLogin() {
        prefs.setIsLogin(false)
    }
    
    override fun getLanguage() = prefs.getLocalLanguage()
    
    override fun setLanguage(language: Languages) {
        prefs.setLocalLanguage(language)
    }
    
    override fun getUser() = user
    
    override fun setUserCalories(calories: Int) {
        user = user.copy(calories = calories)
    }
    
    override fun setUserSex(sex: String) {
        user = user.copy(sex = sex)
    }
    
    override fun setUserHeight(height: Int) {
        user = user.copy(height = height)
    }
    
    override fun setUserWeight(weight: Int) {
        user = user.copy(weight = weight)
    }
    
    override fun setUserAge(age: Int) {
        user = user.copy(age = age)
    }
    
    override fun setUserKcal(kcal: Int) {
        user = user.copy(calories = kcal)
    }
}