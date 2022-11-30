package com.example.applicationfitness

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ExcericeseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_excer)

        val titleView : TextView = findViewById(R.id.excer_title)
        val imageView : ImageView = findViewById(R.id.excer_image)
        val descriptionView : TextView = findViewById(R.id.excer_description)

        val title = intent.getSerializableExtra("title") as String?
        val image = intent.getSerializableExtra("image") as Int
        val descr = intent.getSerializableExtra("description") as String?

        titleView.text = title
        imageView.setImageResource(image)
        descriptionView.text = descr

    }
}