package com.example.applicationfitness.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.applicationfitness.*
import com.example.applicationfitness.contracts.CalculatorContract
import com.example.applicationfitness.presenters.CalculatorPresenter

class CalculateFragment: CalculatorContract.CalculatorView, Fragment() {
    
    private var maintenance: TextView? = null
    
    private lateinit var calculatorPresenter: CalculatorPresenter
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = inflater
        .inflate(R.layout.fragment_calculate, container, false)
        .apply {
            getFragmentActivity<MainActivity>().showBottomBar(true)
            calculatorPresenter = CalculatorPresenter(this@CalculateFragment)
            maintenance = findViewById(R.id.Maintenance)
            findViewById<Button>(R.id.calculate).setOnClickListener {
                val height = findViewById<TextView>(R.id.height).text.toString()
                val weight = findViewById<TextView>(R.id.weight).text.toString()
                val age = findViewById<TextView>(R.id.age).text.toString()
                val active = findViewById<Spinner>(R.id.spinner).selectedItemId
                val sex = findViewById<RadioGroup>(R.id.radiogroup).checkedRadioButtonId
                    .let { if (it == -1) null else findViewById<RadioButton>(it).text.toString() }
                calculatorPresenter.calculateCalories(
                    weight = weight,
                    height = height,
                    age = age,
                    sex = sex,
                    active = active,
                    maleString = getString(R.string.male)
                )
            }
        }
    
    override fun showToast(text: String) {
        requireContext().makeToast(text)
    }
    
    override fun setResultCalculate(calories: Int) {
        maintenance?.text = "${getString(R.string.maintence)} $calories"
    }
}