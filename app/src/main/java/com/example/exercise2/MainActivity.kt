package com.example.exercise2

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val a = findViewById<EditText>(R.id.editTextHeight)
        val b = findViewById<EditText>(R.id.editTextWeight)
        val c = findViewById<TextView>(R.id.textViewBMI)

        val image = findViewById<ImageView>(R.id.imageViewProfile)

        val calculate = findViewById<Button>(R.id.buttonCalculate)
        val clear = findViewById<Button>(R.id.buttonReset)

        calculate.setOnClickListener {
            val weight = a.text.toString().toDouble()
            val height = b.text.toString().toDouble() / 100
            val bmi = weight / (height * height)

            when (bmi) {
                in Double.MIN_VALUE..18.4 -> {
                    c.append("Underweight")
                    image.setImageResource(R.drawable.under)
                }
                in 18.5..24.9 -> {
                    c.append("Normal")
                    image.setImageResource(R.drawable.normal)
                }
                in 25.0..Double.MAX_VALUE -> {
                    c.append("Overweight")
                    image.setImageResource(R.drawable.over)
                }
            }
        }

        clear.setOnClickListener {
            a.setText("")
            b.setText("")
            c.setText("BMI :")
            image.setImageResource(R.drawable.empty)
        }
    }
}


