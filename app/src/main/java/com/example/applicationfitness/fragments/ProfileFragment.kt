package com.example.applicationfitness.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.applicationfitness.R
import com.example.applicationfitness.models.user1
import com.example.applicationfitness.MainActivity
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_profile.*

import android.widget.RadioButton
import com.example.applicationfitness.curLocale
import java.util.*


class ProfileFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        settings_name.text = user1.name
        settings_weight.text = user1.weight.toString()
        settings_height.text = user1.height.toString()
        settings_sex.text = user1.sex
        settings_calories.text = user1.calories.toString()

        radio_en.setOnClickListener(languageClickListener)
        radio_rus.setOnClickListener(languageClickListener)

        when (curLocale) {
            "ru" -> {
                radio_rus.isChecked = true
            }
            "en" -> {
                radio_en.isChecked = true
            }
        }

    }

    private var languageClickListener = View.OnClickListener {
            v -> val rb = v as RadioButton
        when (rb.id) {
            this.radio_rus.id -> {
                (activity as MainActivity).updateActivityWithLocale("ru")
            }
            this.radio_en.id -> {
                (activity as MainActivity).updateActivityWithLocale("en")
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() : ProfileFragment {
            return ProfileFragment()
        }
    }
}