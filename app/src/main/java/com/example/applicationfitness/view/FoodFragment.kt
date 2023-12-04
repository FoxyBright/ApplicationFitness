package com.example.applicationfitness.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.applicationfitness.MainActivity
import com.example.applicationfitness.R
import com.example.applicationfitness.adapters.FoodAdapter
import com.example.applicationfitness.contracts.FoodContract
import com.example.applicationfitness.getFragmentActivity
import com.example.applicationfitness.models.FoodModel
import com.example.applicationfitness.presenters.FoodPresenter
import kotlinx.android.synthetic.main.fragment_home.rv_recyclerView

class FoodFragment: FoodContract.FoodView, Fragment() {
    
    private lateinit var foodPresenter: FoodPresenter
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = inflater.inflate(R.layout.fragment_home, container, false)
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        foodPresenter = FoodPresenter(this)
        getFragmentActivity<MainActivity>().showBottomBar(true)
        rv_recyclerView.layoutManager = LinearLayoutManager(context)
        rv_recyclerView.adapter = FoodAdapter(
            onItemClick = ::navigateToItem,
            onAddClick = foodPresenter::addToCart,
            items = foodPresenter.getFoodList(),
            context = context
        )
    }
    
    override fun navigateToItem(food: FoodModel) {
        getFragmentActivity<MainActivity>().navigateToFoodItem(food)
    }
}