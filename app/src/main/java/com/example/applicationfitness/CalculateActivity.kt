package com.example.applicationfitness
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.applicationfitness.models.user1
import com.google.android.material.bottomnavigation.BottomNavigationView


class CalculateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_calculate)

    }


    fun onCalc(view: View)
    {
        val textViewHeight: TextView = findViewById<TextView>(R.id.height)
        val textViewWeight: TextView = findViewById<TextView>(R.id.weight)
        val textViewAge: TextView = findViewById<TextView>(R.id.age)
        val textHeight: String = textViewHeight.text.toString()
        val textWeight: String = textViewWeight.text.toString()
        val textAge: String = textViewAge.text.toString()
        val sex : String;
        user1.height = textHeight.toInt()
        user1.weight = textWeight.toInt()
        user1.age = textAge.toInt()
        val dci : Int;
        val radioGroup : RadioGroup = findViewById<RadioGroup>(R.id.radiogroup)
        val checkedRadioButtonId = radioGroup.checkedRadioButtonId
        val selectedRadioButton = findViewById<RadioButton>(checkedRadioButtonId)
        val spinner : Spinner = findViewById<Spinner>(R.id.spinner)
        val active : Double
        if(spinner.selectedItemId.toInt() == 0)
        active = 1.0
        else
            if(spinner.selectedItemId.toInt() == 1)
                active = 1.4
        else
            active = 1.65

        sex = selectedRadioButton.text.toString()
        user1.sex = sex
        if(sex == "Male")
            dci = 5
        else
            dci = -161
        val calories : Int
        calories = ((user1.weight * 10 + user1.height * 6.25 - user1.age * 5 + dci) * active).toInt()
        user1.calories = calories
        val textView : TextView = findViewById(R.id.Maintenance) as TextView
        textView.text = getString(R.string.maintence) + " " + calories.toString()




    }
}