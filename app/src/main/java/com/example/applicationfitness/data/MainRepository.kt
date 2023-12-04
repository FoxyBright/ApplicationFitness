package com.example.applicationfitness.data

import com.example.applicationfitness.contracts.MainContract
import com.example.applicationfitness.models.Languages

class MainRepository(
    private val lRepository: LoginRepository,
    private val shared: SharedPrefs,
): MainContract.MainModel {
    
    override fun getLocalLanguage() = shared.getLocalLanguage()
    
    override fun setLocalLanguage(language: Languages) = shared.setLocalLanguage(language)
    
    override fun checkUserLogin() = lRepository.getLoginStatus()
}