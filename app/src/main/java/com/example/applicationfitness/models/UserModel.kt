package com.example.applicationfitness.models

data class UserModel(
    var password: String,
    var username: String,
    var age: Int,
    var weight: Int,
    var height: Int,
    var sex: String,
    var name: String,
    var calories: Int,
)

val testUser = UserModel(
    password = "1234",
    username = "root",
    age = 21,
    weight = 82,
    height = 179,
    sex = "Мужской",
    name = "Илья Пауков",
    calories = 2800
)