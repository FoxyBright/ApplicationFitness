package com.example.applicationfitness.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.applicationfitness.MainActivity
import com.example.applicationfitness.R
import com.example.applicationfitness.getFragmentActivity
import com.example.applicationfitness.models.FoodModel

class FoodItemFragment(
    private val food: FoodModel,
): Fragment() {
    
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = inflater
        .inflate(R.layout.activity_food, container, false)
        .apply {
            getFragmentActivity<MainActivity>().showBottomBar(false)
            findViewById<TextView?>(R.id.ai_title).text = food.title
            findViewById<ImageView?>(R.id.ex_image).setImageResource(food.image)
            findViewById<TextView?>(R.id.ai_description).text = food.description
            findViewById<TextView?>(R.id.ai_calories).text = "${food.calories} ${getString(R.string.ccal)}"
        }
}