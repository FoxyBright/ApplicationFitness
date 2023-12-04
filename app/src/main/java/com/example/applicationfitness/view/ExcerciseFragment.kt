package com.example.applicationfitness.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.applicationfitness.MainActivity
import com.example.applicationfitness.R
import com.example.applicationfitness.adapters.ExerciseAdapter
import com.example.applicationfitness.contracts.ExcerciseContract
import com.example.applicationfitness.getFragmentActivity
import com.example.applicationfitness.models.ExcerciseModel
import com.example.applicationfitness.presenters.ExcercisePresenter
import kotlinx.android.synthetic.main.fragment_home.rv_recyclerView

class ExcerciseFragment: ExcerciseContract.ExcerciseView, Fragment() {
    
    private lateinit var excercisePresenter: ExcercisePresenter
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = inflater.inflate(R.layout.fragment_excercies, container, false)
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        excercisePresenter = ExcercisePresenter(this)
        val activity = getFragmentActivity<MainActivity>()
        activity.showBottomBar(true)
        rv_recyclerView.layoutManager = LinearLayoutManager(context)
        rv_recyclerView.adapter = ExerciseAdapter(
            items = excercisePresenter.getExcerciseList(),
            onItemClick = ::navigateToItem
        )
    }
    
    override fun navigateToItem(excercise: ExcerciseModel) {
        getFragmentActivity<MainActivity>().navigateToExerciseItem(excercise)
    }
}