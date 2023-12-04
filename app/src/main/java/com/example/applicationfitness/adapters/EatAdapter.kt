package com.example.applicationfitness.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.applicationfitness.R
import com.example.applicationfitness.adapters.EatAdapter.EatHolder
import com.example.applicationfitness.models.FoodModel

class EatAdapter(
    private val context: Context?,
    private val cartList: List<FoodModel>,
    private val onItemClick: (Int) -> Unit,
): Adapter<EatHolder>() {
    
    class EatHolder(eatView: View): ViewHolder(eatView) {
        
        val title: TextView = eatView.findViewById(R.id.cit_title)
        val price: TextView = eatView.findViewById(R.id.cit_price)
        val image: ImageView = eatView.findViewById(R.id.cit_image)
        val button: Button = eatView.findViewById(R.id.cit_removefromcart)
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = EatHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.food_item_view, parent, false)
    )
    
    @SuppressLint("NotifyDataSetChanged", "SetTextI18n")
    override fun onBindViewHolder(holder: EatHolder, current: Int) {
        cartList[current].apply {
            holder.title.text = title
            holder.price.text = "$calories ${context!!.getString(R.string.ccal)}"
            holder.image.setImageResource(image)
            holder.button.setOnClickListener {
                onItemClick(current)
                notifyDataSetChanged()
            }
        }
    }
    
    override fun getItemCount() = cartList.size
}