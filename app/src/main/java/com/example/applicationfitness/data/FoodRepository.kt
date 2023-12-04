package com.example.applicationfitness.data

import com.example.applicationfitness.R
import com.example.applicationfitness.contracts.FoodContract.FoodRepository
import com.example.applicationfitness.models.FoodModel

class FoodRepository: FoodRepository {
    
    private val cartList = mutableListOf<FoodModel>()
    
    private val testFoodList = listOf(
        FoodModel(
            title = "Яблоко",
            calories = 52,
            description = "Состав на 100 г продукта\n" +
                    "Энергетическая ценность: 52 ккал 217 кДж\n" +
                    "Вода: 85,56 г\n" +
                    "Белки: 0,26 г\n" +
                    "Жиры: 0,17 г\n" +
                    "— насыщенные: 0,028 г\n" +
                    "— мононенасыщенные: 0,007 г\n" +
                    "— полиненасыщенные: 0,051 г\n" +
                    "Углеводы: 13,81 г\n" +
                    "— пищевые волокна: 2,4 г",
            image = R.drawable.apple,
            id = 1001
        ),
        FoodModel(
            title = "Рис",
            calories = 330,
            description = " 7 жиры 1 углеводы 71.4 ккал 322.6.",
            image = R.drawable.rice,
            id = 1002
        ),
        FoodModel(
            title = "Яйцо",
            calories = 154,
            description = "Состав на 100 г продукта\n" +
                    "Энергетическая ценность: 155 ккал 649 кДж\n" +
                    "Вода: 75 г\n" +
                    "Белки: 12.6 г\n" +
                    "Жиры: 10.6 г\n" +
                    "Углеводы: 1.12 г" +
                    "",
            image = R.drawable.eggs,
            id = 1003
        ),
        FoodModel(
            title = "Свинина",
            calories = 155,
            description = "Свинина в своём составе не содержит углеводов. Калорийность — 155 кКал. Состав свинины: жиры — 6,94 г, белки — 21,55 г, углеводы — 0,00 г, вода — 70,38 г, зола — 0,97 г. Суммарное содержание сахаров — 0,0 г, клетчатки — 0,0 г, крахмала — н/д. Содержание холестерина — 67,0 мг, трансжиров — 0,1 г. Свинина — белки, жиры, углеводы" +
                    " (БЖУ). В 100 г свинины содержатся 29% суточной нормы белка, жиров — 8% и углеводов — 0%.\n",
            image = R.drawable.beef,
            id = 1004
        ),
        FoodModel(
            title = "Банан",
            calories = 96,
            description = "Энергетическая ценность Банан составляет 96 кКал. " +
                    "Калорийность 96 ккал 6.29% Белки 1.5 г 1.63% Жиры 0.5 г 0.75% Углеводы 21 г 15.11% Пищевые волокна 1.7 г 8" +
                    ".5% Вода 74 г 2.73% 1: 0.3: 14 Полезные свойства БАНАН. Чем полезен Банан. Витамин В6 витамин С калий.",
            image = R.drawable.banana,
            id = 1005
        ),
    )
    
    
    override fun getFoodList() = testFoodList
    override fun getCartList() = cartList
    
    override fun addToCart(food: FoodModel) {
        cartList.add(food)
    }
    
    override fun removeFromCart(index: Int) {
        cartList.removeAt(index)
    }
}