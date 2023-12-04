package com.example.applicationfitness.data

import com.example.applicationfitness.contracts.FoodContract.FoodRepository
import com.example.applicationfitness.models.FoodModel
import com.example.applicationfitness.models.testFoodList

class FoodRepository: FoodRepository {
    
    private val cartList = mutableListOf<FoodModel>()
    
    override fun getFoodList() = testFoodList
    override fun getCartList() = cartList
    
    override fun addToCart(food: FoodModel) {
        cartList.add(food)
    }
    
    override fun removeFromCart(index: Int) {
        cartList.removeAt(index)
    }
}