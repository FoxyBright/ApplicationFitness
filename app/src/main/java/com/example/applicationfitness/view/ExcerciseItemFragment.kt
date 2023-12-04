package com.example.applicationfitness.view

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
import com.example.applicationfitness.models.ExcerciseModel

class ExcerciseItemFragment(
    private val excercise: ExcerciseModel,
): Fragment() {
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = inflater
        .inflate(R.layout.activity_excer, container, false)
        .apply {
            tag = "excerciseItem"
            getFragmentActivity<MainActivity>().showBottomBar(false)
            excercise.apply {
                findViewById<TextView>(R.id.excer_title).text = title
                findViewById<ImageView>(R.id.excer_image).setImageResource(image)
                findViewById<TextView>(R.id.excer_description).text = description
            }
        }
}