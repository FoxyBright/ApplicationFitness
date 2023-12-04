package com.example.applicationfitness.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.applicationfitness.MainActivity
import com.example.applicationfitness.R
import com.example.applicationfitness.adapters.EatAdapter
import com.example.applicationfitness.contracts.CartContract
import com.example.applicationfitness.getFragmentActivity
import com.example.applicationfitness.presenters.CartPresenter
import kotlinx.android.synthetic.main.fragment_eat.*

class CartFragment: CartContract.CartView, Fragment() {
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = inflater.inflate(R.layout.fragment_eat, container, false)
    
    private lateinit var cartPresenter: CartPresenter
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cartPresenter = CartPresenter(this)
        getFragmentActivity<MainActivity>().showBottomBar(true)
        cart_recyclerView.layoutManager = LinearLayoutManager(context)
        cart_recyclerView.adapter = EatAdapter(context, cartPresenter.getCartList()) {
            cartPresenter.removeFromCart(it)
            cartPresenter.sumCalories()
        }
        cartPresenter.sumCalories()
    }
    
    @SuppressLint("SetTextI18n")
    override fun sumCalories(calories:Int) {
        sum_price.text = getString(R.string.calories) + " $calories " + getString(R.string.ccal)
    }
}


