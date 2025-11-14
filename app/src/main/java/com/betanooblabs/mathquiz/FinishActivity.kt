package com.betanooblabs.mathquiz

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FinishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_finish)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.finish)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val score = intent.getIntExtra("score", 0)
        val data: ArrayList<Question> = intent.getSerializableExtra("dataSet") as ArrayList<Question>

        val tvScore: TextView = findViewById(R.id.tvScore)
        tvScore.text = "Your Score \n$score/10"

        setAdapterRecyclerView(data)

        val btmHome: Button = findViewById(R.id.btnHome)
        btmHome.setOnClickListener {
            finish()
        }
    }

    private fun setAdapterRecyclerView(data: ArrayList<Question>){
        val recyclerView: RecyclerView = findViewById(R.id.rvQuestionList)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = QuestionAdapter(data)
        recyclerView.adapter = adapter
    }
}