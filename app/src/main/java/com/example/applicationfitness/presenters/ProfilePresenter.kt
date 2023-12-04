package com.example.applicationfitness.presenters

import com.example.applicationfitness.contracts.ProfileContract
import com.example.applicationfitness.data.ProfileRepository
import com.example.applicationfitness.models.Languages
import com.example.applicationfitness.models.Languages.RU
import org.koin.java.KoinJavaComponent.get

class ProfilePresenter(
    private val profileView: ProfileContract.ProfileView,
): ProfileContract.ProfilePresenter {
    
    var pRepository: ProfileRepository? = get(ProfileRepository::class.java)
    
    override fun logout() {
        pRepository?.clearIsLogin()
        profileView.navigateToLogin()
    }
    
    override fun setLanguage(languages: Languages) {
        pRepository?.setLanguage(languages)
        profileView.updateView()
    }
    
    override fun getLanguage(): Languages = pRepository?.getLanguage() ?: RU
    
    override fun getUser() = pRepository?.getUser()
    
    override fun onDestroy() {
        pRepository = null
    }
}