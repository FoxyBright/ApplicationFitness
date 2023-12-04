package com.example.applicationfitness.presenters

import com.example.applicationfitness.contracts.CartContract
import com.example.applicationfitness.data.FoodRepository
import com.example.applicationfitness.models.FoodModel
import org.koin.java.KoinJavaComponent.get

class CartPresenter(
    private val cView: CartContract.CartView,
): CartContract.CartPresenter {
    
    private val foodRepository = get<FoodRepository>(FoodRepository::class.java)
    
    override fun removeFromCart(index: Int) {
        return foodRepository.removeFromCart(index)
    }
    
    override fun sumCalories() {
        val kcal = foodRepository.getCartList().sumOf { it.calories }
        cView.sumCalories(kcal)
    }
    
    override fun getCartList(): List<FoodModel> {
        return foodRepository.getCartList()
    }
}