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
        val d = findViewById<TextView>(R.id.bmiTotal)

        val image = findViewById<ImageView>(R.id.imageViewProfile)

        val calculate = findViewById<Button>(R.id.buttonCalculate)
        val clear = findViewById<Button>(R.id.buttonReset)

        calculate.setOnClickListener {
            val height = a.text.toString()
            val weight = b.text.toString()

            if (weight.equals("") || height.equals("")) {
                Toast.makeText(
                    applicationContext, getString(R.string.input_error),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val height2 = height.toDouble() / 100
                val bmi = weight.toDouble() / (height2 * height2)

                when (bmi) {
                    in 0.0..18.4 -> {
                        c.setText(getString(R.string.under))
                        d.setText(String.format("BMI: %.2f", (bmi)))
                        image.setImageResource(R.drawable.under)
                    }
                    in 18.5..24.9 -> {
                        c.setText(getString(R.string.normal))
                        d.setText(String.format("BMI: %.2f", (bmi)))
                        image.setImageResource(R.drawable.normal)
                    }
                    else -> {
                        c.setText(getString(R.string.over))
                        d.setText(String.format("BMI: %.2f", (bmi)))
                        image.setImageResource(R.drawable.over)
                    }
                }
            }
        }

        clear.setOnClickListener {
            a.setText("")
            b.setText("")
            c.setText(getString(R.string.bmi))
            d.setText("")
            image.setImageResource(R.drawable.empty)
        }
    }
}


