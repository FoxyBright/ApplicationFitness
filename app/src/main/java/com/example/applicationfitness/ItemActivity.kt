package com.example.applicationfitness

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.applicationfitness.models.EatModel

class ItemActivity : AppCompatActivity() {
    lateinit var _eat : EatModel

    fun initCart(EatModel: EatModel) {
        _eat = EatModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        val titleView : TextView = findViewById(R.id.ai_title)
        val imageView : ImageView = findViewById(R.id.ex_image)
        val descriptionView : TextView = findViewById(R.id.ai_description)
        val priceView : TextView = findViewById(R.id.ai_calories)

        val title = intent.getSerializableExtra("title") as String?
        val image = intent.getSerializableExtra("image") as Int
        val descr = intent.getSerializableExtra("description") as String?
        val calories = intent.getSerializableExtra("calories") as Int?

        titleView.text = title
        imageView.setImageResource(image)
        descriptionView.text = descr
        priceView.text = (calories.toString() + " " + getString(R.string.ccal))

    }
}