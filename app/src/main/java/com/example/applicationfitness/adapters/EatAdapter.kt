package com.example.applicationfitness.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationfitness.R
import com.example.applicationfitness.models.EatModel

class EatAdapter (val context: Context?, var _eat : EatModel, val sum : TextView) : RecyclerView.Adapter<EatHolder>(){
    override fun onBindViewHolder(holder : EatHolder, current : Int){
        val obj = _eat.foodList[current]
        holder.title.text = obj.title
        holder.price.text = ( obj.calories.toString() + " " + context!!.getString(R.string.ccal) )
        holder.image.setImageResource(obj.image)

        sum.text = (context.getString(R.string.calories) + " " + _eat.foodList.sumOf { it.calories }.toString() + " " + context.getString(R.string.ccal))

        holder.button.setOnClickListener {
            _eat.removeFromCart(current)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EatHolder {
        val eatView = LayoutInflater.from(parent.context).inflate(R.layout.food_item_view, parent, false)
        return EatHolder(eatView)
    }

    override fun getItemCount(): Int {
        return _eat.foodList.size
    }

}

class EatHolder(eatView: View) : RecyclerView.ViewHolder(eatView) {
    val title: TextView = eatView.findViewById(R.id.cit_title)
    val price: TextView = eatView.findViewById(R.id.cit_price)
    val image: ImageView = eatView.findViewById(R.id.cit_image)
    val button: Button = eatView.findViewById(R.id.cit_removefromcart)
}