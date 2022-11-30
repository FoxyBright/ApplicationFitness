package com.example.applicationfitness.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.applicationfitness.ExerciseAdapter
import com.example.applicationfitness.R
import com.example.applicationfitness.models.excerList
import kotlinx.android.synthetic.main.fragment_home.*

class ExcerciseFragment() : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_excercies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter:ExerciseAdapter?

        rv_recyclerView.layoutManager = LinearLayoutManager(context)

        adapter = ExerciseAdapter(context, excerList)
        rv_recyclerView.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() : ExcerciseFragment {
            return ExcerciseFragment()
        }
    }
}