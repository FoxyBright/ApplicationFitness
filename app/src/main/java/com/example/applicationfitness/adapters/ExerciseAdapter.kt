package com.example.applicationfitness

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationfitness.fragments.HomeFragment
import com.example.applicationfitness.models.ExcerModel
//import com.example.appfitness.models.EatModel
import com.example.applicationfitness.models.FoodModel
import java.io.Serializable

class ExerciseAdapter (val context: Context?, val arr: List<ExcerModel>): RecyclerView.Adapter<ExerciseHolder>(){
    override fun onBindViewHolder(holder : ExerciseHolder, current : Int){
        val obj = arr[current]
        holder.title.text = obj.title

        holder.image.setImageResource(obj.image)
        //  holder.button.isEnabled = obj.itemStatus

        holder.wrapper.setOnClickListener {
            val excerIntent = Intent(context, ExcericeseActivity::class.java)
            excerIntent.putExtra("title", obj.title)

            //itemIntent.putExtra("status", obj.itemStatus)
            // itemIntent.putExtra("weight", obj.weight)
            excerIntent.putExtra("description", obj.descr)
            excerIntent.putExtra("image", obj.image)
            context?.startActivity(excerIntent)
        }
        //  holder.button.setOnClickListener {
        //    _eat.addToCart(obj)
        //}
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseHolder {
        val excerciseView = LayoutInflater.from(parent.context).inflate(R.layout.sample_excerice_view, parent, false)
        return ExerciseHolder(excerciseView)
    }

    override fun getItemCount(): Int {
        return arr.size
    }

}

class ExerciseHolder(excerciseView: View) : RecyclerView.ViewHolder(excerciseView) {
    val title: TextView = excerciseView.findViewById(R.id.excer_title)

    // val status: TextView = itemView.findViewById(R.id.it_status)
    val wrapper: LinearLayout = excerciseView.findViewById(R.id.rl_1_wrapper)
    val image: ImageView = excerciseView.findViewById(R.id.excer_image)
    //  val button: Button = itemView.findViewById(R.id.it_addtocart)
}