package com.example.applicationfitness.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.applicationfitness.*
import com.example.applicationfitness.contracts.LoginContract
import com.example.applicationfitness.presenters.LoginPresenter

class LoginFragment: LoginContract.LoginView, Fragment() {
    
    private lateinit var lPresenter: LoginPresenter
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = inflater
        .inflate(R.layout.activity_sign_in, container, false)
        .apply {
            lPresenter = LoginPresenter(this@LoginFragment)
            getFragmentActivity<MainActivity>().showBottomBar(false)
            
            val login = findViewById<EditText>(R.id.loginEt)
            val password = findViewById<EditText>(R.id.password_et)
            
            login.setText("root")
            password.setText("1234")
            
            findViewById<Button>(R.id.si_button).setOnClickListener {
                lPresenter.login("${login.text}", "${password.text}")
            }
        }
    
    override fun navigateToMain() {
        getFragmentActivity<MainActivity>().navigateToFood()
    }
    
    override fun onBadLogin() {
        context?.makeToast("Error!")
    }
    
    override fun onDestroy() {
        lPresenter.onDestroy()
        super.onDestroy()
    }
}