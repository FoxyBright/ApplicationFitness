package com.example.applicationfitness.presenters

import com.example.applicationfitness.contracts.FoodContract
import com.example.applicationfitness.data.FoodRepository
import com.example.applicationfitness.models.FoodModel
import org.koin.java.KoinJavaComponent.get

class FoodPresenter(
    private val fView: FoodContract.FoodView,
): FoodContract.FoodPresenter {
    
    private val foodRepository = get<FoodRepository>(FoodRepository::class.java)
    
    override fun getFoodList(): List<FoodModel> {
        return foodRepository.getFoodList()
    }
    
    override fun getCartList(): List<FoodModel> {
        return foodRepository.getCartList()
    }
    
    override fun addToCart(food: FoodModel) {
        foodRepository.addToCart(food)
    }
}