package com.example.applicationfitness.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.applicationfitness.MainActivity
import com.example.applicationfitness.R
import com.example.applicationfitness.contracts.ProfileContract
import com.example.applicationfitness.getFragmentActivity
import com.example.applicationfitness.models.Languages.EN
import com.example.applicationfitness.models.Languages.RU
import com.example.applicationfitness.presenters.ProfilePresenter


class ProfileFragment: ProfileContract.ProfileView, Fragment() {
    
    private lateinit var pPresenter: ProfilePresenter
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = inflater
        .inflate(R.layout.fragment_profile, container, false)
        .apply {
            pPresenter = ProfilePresenter(this@ProfileFragment)
            val activity = getFragmentActivity<MainActivity>()
            activity.showBottomBar(true)
            findViewById<Button>(R.id.logout_bt)
                .setOnClickListener { pPresenter.logout() }
            
            pPresenter.getUser()?.apply {
                findViewById<TextView>(R.id.settings_name).text = name
                findViewById<TextView>(R.id.settings_weight).text = "$weight"
                findViewById<TextView>(R.id.settings_height).text = "$height"
                findViewById<TextView>(R.id.settings_sex).text = sex
                findViewById<TextView>(R.id.settings_calories).text = "$calories"
            }
            
            val language = pPresenter.getLanguage()
            findViewById<RadioButton>(R.id.radio_rus).apply {
                setOnClickListener { if (language != RU)  pPresenter.setLanguage(RU) }
                isChecked = language == RU
            }
            findViewById<RadioButton>(R.id.radio_en).apply {
                setOnClickListener { if (language != EN) pPresenter.setLanguage(EN) }
                isChecked = language == EN
            }
        }
    
    override fun updateView() {
        getFragmentActivity<MainActivity>().updateActivityWithLocale()
    }
    
    override fun navigateToLogin() {
        getFragmentActivity<MainActivity>().navigateToLogin()
    }
}