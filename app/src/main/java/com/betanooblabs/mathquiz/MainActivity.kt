package com.betanooblabs.mathquiz

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.betanooblabs.mathquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.btnEasy?.setOnClickListener { startGame("easy") }
        binding?.btnMedium?.setOnClickListener { startGame("medium") }
        binding?.btnHard?.setOnClickListener { startGame("hard") }
    }

    private fun startGame(questionType: String){
        val intent = Intent(this, PlayActivity::class.java)
        intent.putExtra("questionType", questionType)
        startActivity(intent)
    }
}