package com.example.applicationfitness.data

import com.example.applicationfitness.contracts.LoginContract

class LoginRepository(
    private val uRepository: ProfileRepository,
    private val prefs: SharedPrefs,
): LoginContract.LoginModel {
    
    override fun setLoginStatus(isLogin: Boolean) = prefs.setIsLogin(isLogin)
    
    override fun getLoginStatus() = prefs.getIsLogin()
    
    override fun checkLoginData(
        login: String, password: String,
    ) = uRepository.getUser().let { user ->
        user.username == login && user.password == password
    }
}