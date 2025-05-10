package com.example.toplamahesapmakinesi

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textViewResult: TextView
    private var input = ""
    private var sum = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewResult = findViewById(R.id.textViewResult)

        val buttons = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3,
            R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7,
            R.id.btn8, R.id.btn9, R.id.btnAdd,
            R.id.btnEqual, R.id.btnClear
        )

        for (id in buttons) {
            findViewById<Button>(id).setOnClickListener { handleClick(it as Button) }
        }
    }

    private fun handleClick(button: Button) {
        when (val value = button.text.toString()) {
            "+" -> {
                if (input.isNotEmpty()) {
                    sum += input.toInt()
                    input = ""
                }
            }
            "=" -> {
                if (input.isNotEmpty()) {
                    sum += input.toInt()
                    input = ""
                }
                textViewResult.text = sum.toString()
                sum = 0
            }
            "C" -> {
                input = ""
                sum = 0
                textViewResult.text = "0"
            }
            else -> {
                input += value
                textViewResult.text = input
            }
        }
    }
}
