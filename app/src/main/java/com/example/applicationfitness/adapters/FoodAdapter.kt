package com.example.applicationfitness.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.applicationfitness.R
import com.example.applicationfitness.adapters.FoodAdapter.FoodHolder
import com.example.applicationfitness.models.FoodModel

class FoodAdapter(
    private val context: Context?,
    private val items: List<FoodModel>,
    private val onItemClick: (FoodModel) -> Unit,
    private val onAddClick: (FoodModel) -> Unit,
): Adapter<FoodHolder>() {
    
    class FoodHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        
        val title: TextView = itemView.findViewById(R.id.it_title)
        val price: TextView = itemView.findViewById(R.id.it_price)
        val wrapper: LinearLayout = itemView.findViewById(R.id.rl_1_wrapper)
        val image: ImageView = itemView.findViewById(R.id.it_image)
        val button: Button = itemView.findViewById(R.id.it_addtocart)
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FoodHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.sample_item_view, parent, false)
    )
    
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: FoodHolder, current: Int) {
        val item = items[current]
        holder.title.text = item.title
        holder.price.text = "${item.calories} ${context!!.getString(R.string.ccal)}"
        holder.image.setImageResource(item.image)
        holder.button.isEnabled
        holder.wrapper.setOnClickListener { onItemClick(item) }
        holder.button.setOnClickListener { onAddClick(item) }
    }
    
    override fun getItemCount() = items.size
}