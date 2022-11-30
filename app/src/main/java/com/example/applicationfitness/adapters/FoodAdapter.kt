package com.example.applicationfitness

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationfitness.models.EatModel
import com.example.applicationfitness.models.FoodModel

class FoodAdapter (val context: Context?, val arr: List<FoodModel>, var _eat : EatModel): RecyclerView.Adapter<FoodHolder>(){
    override fun onBindViewHolder(holder : FoodHolder, current : Int){
        val obj = arr[current]
        holder.title.text = obj.title
        holder.price.text = ( obj.calories.toString() + " " + context!!.getString(R.string.ccal) )
        holder.image.setImageResource(obj.image)
        holder.button.isEnabled

        holder.wrapper.setOnClickListener {
            val foodIntent = Intent(context, ItemActivity::class.java)
            foodIntent.putExtra("title", obj.title)
            foodIntent.putExtra("calories", obj.calories)
            foodIntent.putExtra("description", obj.descr)
            foodIntent.putExtra("image", obj.image)
            context.startActivity(foodIntent)
        }
        holder.button.setOnClickListener {
            _eat.addToCart(obj)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodHolder {
        val foodView = LayoutInflater.from(parent.context).inflate(R.layout.sample_item_view, parent, false)
        return FoodHolder(foodView)
    }

    override fun getItemCount(): Int {
        return arr.size
    }

}

class FoodHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title: TextView = itemView.findViewById(R.id.it_title)
    val price: TextView = itemView.findViewById(R.id.it_price)
    val wrapper: LinearLayout = itemView.findViewById(R.id.rl_1_wrapper)
    val image: ImageView = itemView.findViewById(R.id.it_image)
    val button: Button = itemView.findViewById(R.id.it_addtocart)
}