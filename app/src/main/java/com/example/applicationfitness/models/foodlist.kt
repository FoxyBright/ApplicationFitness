package com.example.applicationfitness.models

open class EatModel {
    var foodList = mutableListOf<FoodModel>()

    fun addToCart(item : FoodModel) {
        foodList.add(item)
    }

    fun removeFromCart(index : Int) {
        foodList.removeAt(index)
    }

    fun getSum() : Int {
        return foodList.sumOf { it.calories }
    }
}

