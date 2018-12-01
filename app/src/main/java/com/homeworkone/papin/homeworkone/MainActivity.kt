package com.homeworkone.papin.homeworkone

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Float.parseFloat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun calculate(itemButton:Button): String {
            val zero = parseFloat("0")
            val a = if (inputa.text.isNotEmpty()) parseFloat(inputa.text.toString()) else zero
            val b = if (inputb.text.isNotEmpty()) parseFloat(inputb.text.toString()) else zero
            return when {
                itemButton.text.toString() == "+" -> a.plus(b).toString()
                itemButton.text.toString() == "-" -> a.minus(b).toString()
                itemButton.text.toString() == "×" -> (a * b).toString()
                else -> {
                    if (b == zero) {
                       "error"
                    } else {
                        a.div(b).toString()
                    }
                }
            }
        }

        addButton.setOnClickListener {
            result.text = calculate(addButton)
        }
        subButton.setOnClickListener {
            result.text = calculate(subButton)
        }
        mulButton.setOnClickListener {
            result.text = calculate(mulButton)
        }
        divButton.setOnClickListener {
            when {
                calculate(divButton) == "error" -> Snackbar.make(
                    main_layout,
                    "Нельзя просто так взять и поделить на ноль",
                    Snackbar.LENGTH_SHORT
                ).show()
                else -> result.text = calculate(divButton)
            }
        }
    }
}