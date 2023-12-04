package com.example.applicationfitness.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.applicationfitness.R
import com.example.applicationfitness.adapters.ExerciseAdapter.ExerciseHolder
import com.example.applicationfitness.models.ExcerciseModel

class ExerciseAdapter(
    private val items: List<ExcerciseModel>,
    private val onItemClick: (ExcerciseModel) -> Unit,
): Adapter<ExerciseHolder>() {
    
    class ExerciseHolder(excerciseView: View): ViewHolder(excerciseView) {
        
        val title: TextView = excerciseView.findViewById(R.id.excer_title)
        val wrapper: LinearLayout = excerciseView.findViewById(R.id.rl_1_wrapper)
        val image: ImageView = excerciseView.findViewById(R.id.excer_image)
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ExerciseHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.sample_excerice_view, parent, false)
    )
    
    override fun onBindViewHolder(holder: ExerciseHolder, current: Int) {
        items[current].apply {
            holder.title.text = title
            holder.image.setImageResource(image)
            holder.wrapper.setOnClickListener { onItemClick(this) }
        }
    }
    
    override fun getItemCount() = items.size
}