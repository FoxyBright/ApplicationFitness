package com.example.applicationfitness

import android.content.Context
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

fun Context.makeToast(text: String) {
    Toast.makeText(this, text, LENGTH_SHORT).show()
}

inline fun <reified T: FragmentActivity> Fragment.getFragmentActivity(): T = requireActivity() as T