package com.example.applicationfitness.contracts

import com.example.applicationfitness.models.FoodModel

interface CartContract {
    
    interface CartView {
        
        fun sumCalories(calories: Int)
    }
    
    interface CartPresenter {
        
        fun sumCalories()
        fun removeFromCart(index: Int)
        fun getCartList(): List<FoodModel>
    }
}