package com.example.applicationfitness.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.applicationfitness.FoodAdapter
import com.example.applicationfitness.R
import com.example.applicationfitness.models.EatModel
import com.example.applicationfitness.models.itemList
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment() : Fragment() {
    lateinit var _eat : EatModel

    fun initCart(cart: EatModel) {
        _eat = cart
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter:FoodAdapter?

        rv_recyclerView.layoutManager = LinearLayoutManager(context)

        adapter = FoodAdapter(context, itemList, _eat)
        rv_recyclerView.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() : HomeFragment {
            return HomeFragment()
        }
    }
}