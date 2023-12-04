package com.example.applicationfitness.presenters

import com.example.applicationfitness.contracts.LoginContract
import com.example.applicationfitness.data.LoginRepository
import org.koin.java.KoinJavaComponent.get

class LoginPresenter(
    private val lView: LoginContract.LoginView,
): LoginContract.LoginPresenter {
    
    private var lRepository: LoginContract.LoginModel? =
        get(LoginRepository::class.java)
    
    override fun login(login: String, password: String) {
        if (lRepository?.checkLoginData(login, password) == true) {
            lRepository?.setLoginStatus(isLogin = true)
            lView.navigateToMain()
        } else {
            lView.onBadLogin()
        }
    }
    
    override fun onDestroy() {
        lRepository = null
    }
}