package com.example.applicationfitness.presenters

import com.example.applicationfitness.contracts.MainContract
import com.example.applicationfitness.data.MainRepository
import com.example.applicationfitness.models.Languages.RU
import org.koin.java.KoinJavaComponent.get

class MainPresenter(
    private val mView: MainContract.MainView,
): MainContract.MainPresenter {
    
    private var mRepository: MainRepository? =
        get(MainRepository::class.java)
    
    override fun checkIsLogin() {
        if (mRepository?.checkUserLogin() == true) {
            mView.navigateToFood()
        } else {
            mView.navigateToLogin()
        }
    }
    
    override fun getLocalLanguage() =
        mRepository?.getLocalLanguage() ?: RU
    
    override fun onDestroy() {
        mRepository = null
    }
}