package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Declare and assign everything right here
        //Reference: chat GPT
        val number1Input = findViewById<EditText>(R.id.number1)
        val number2Input = findViewById<EditText>(R.id.number2)
        val resultText = findViewById<TextView>(R.id.resultText)

        val addBtn = findViewById<Button>(R.id.btnAdd)
        val subtractBtn = findViewById<Button>(R.id.btnSubtract)
        val multiplyBtn = findViewById<Button>(R.id.btnMultiply)
        val divideBtn = findViewById<Button>(R.id.btnDivide)

        // Helper function to do the math
        fun doCalculation(op: String) {
            val input1 = number1Input.text.toString()
            val input2 = number2Input.text.toString()

            if (input1.isEmpty() || input2.isEmpty()) {
                resultText.text = "Please enter both numbers"
                return
            }

            val num1 = input1.toDouble()
            val num2 = input2.toDouble()
            val result = when (op) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                "/" -> if (num2 == 0.0) {
                    resultText.text = "Can't divide by zero"
                    return
                } else num1 / num2
                else -> 0.0
            }

            resultText.text = "Result: $result"
        }

        // Set up all the button clicks
        //Reference: chat GPT
        addBtn.setOnClickListener { doCalculation("+") }
        subtractBtn.setOnClickListener { doCalculation("-") }
        multiplyBtn.setOnClickListener { doCalculation("*") }
        divideBtn.setOnClickListener { doCalculation("/") }
    }
}


//Reference (Harvard Style)
//Google Developers. (n.d.). Building your first Android app. Available at: https://developer.android.com/training/basics/firstapp [Accessed 19 June 2025].

//Android Developers. (n.d.). Activities and Intents. Available at: https://developer.android.com/guide/components/activities/intro-activities [Accessed 19 June 2025].

//Vogella. (n.d.). Android Intents - Tutorial. Available at: https://www.vogella.com/tutorials/AndroidIntent/article.html [Accessed 19 June 2025].

//Kotlin Documentation. (n.d.). Collections overview. Available at: https://kotlinlang.org/docs/collections-overview.html [Accessed 19 June 2025].
