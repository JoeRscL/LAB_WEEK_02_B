package com.example.lab_week_02_b

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.background_screen)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val colorCode = intent.getStringExtra("COLOR_KEY") ?: "FFFFFF"

        val background = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.background_screen)
        val message = findViewById<TextView>(R.id.color_code_result_message)

        try {
            background.setBackgroundColor(Color.parseColor("#$colorCode"))
            message.text = "Color code #$colorCode is applied!"
        } catch (e: IllegalArgumentException) {
            message.text = "Invalid color code: #$colorCode"
        }
    }
}
