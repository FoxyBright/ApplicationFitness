package com.example.applicationfitness.contracts

interface CalculatorContract {
    
    interface CalculatorView {
        
        fun showToast(text: String)
        fun setResultCalculate(calories: Int)
    }
    
    interface CalculatorPresenter {
        
        fun calculateCalories(
            weight: String,
            height: String,
            age: String,
            sex: String?,
            active: Long,
            maleString: String,
        )
    }
}