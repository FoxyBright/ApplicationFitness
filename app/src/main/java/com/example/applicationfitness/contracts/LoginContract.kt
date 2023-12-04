package com.example.applicationfitness.contracts

interface LoginContract {
    
    interface LoginView {
        
        fun navigateToMain()
        fun onBadLogin()
    }
    
    interface LoginPresenter {
        
        fun login(login: String, password: String)
        fun onDestroy()
    }
    
    interface LoginModel {
        
        fun checkLoginData(login: String, password: String): Boolean
        fun setLoginStatus(isLogin: Boolean)
        fun getLoginStatus(): Boolean
    }
}