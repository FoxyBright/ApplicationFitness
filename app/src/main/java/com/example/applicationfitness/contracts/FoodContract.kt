package com.example.applicationfitness.contracts

import com.example.applicationfitness.models.FoodModel

interface FoodContract {
    
    interface FoodView {
        
        fun navigateToItem(food: FoodModel)
    }
    
    interface FoodPresenter {
        fun getFoodList(): List<FoodModel>
        fun getCartList(): List<FoodModel>
        fun addToCart(food: FoodModel)
    }
    
    interface FoodRepository {
        
        fun getFoodList(): List<FoodModel>
        fun getCartList(): List<FoodModel>
        fun addToCart(food: FoodModel)
        fun removeFromCart(index: Int)
    }
}