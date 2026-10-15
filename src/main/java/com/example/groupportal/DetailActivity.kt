package com.example.groupportal

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    private val tag = "DetailActivityLifecycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        Log.d(tag, "onCreate called")

        val name = intent.getStringExtra("USER_NAME") ?: "Советбеков Олжас"
        val id = intent.getStringExtra("STUDENT_ID") ?: "23010401"
        val grade = intent.getStringExtra("STUDENT_GRADE") ?: "98 / 100 (A)"
        val status = intent.getStringExtra("STUDENT_STATUS") ?: "Отлично"

        val tvName = findViewById<TextView>(R.id.tvDetailName)
        val tvId = findViewById<TextView>(R.id.tvDetailId)
        val tvGrade = findViewById<TextView>(R.id.tvDetailGrade)
        val tvStatus = findViewById<TextView>(R.id.tvDetailStatus)
        val btnBack = findViewById<Button>(R.id.btnBackDetail)

        tvName?.text = "Студент: $name"
        tvId?.text = "ID: $id"
        tvGrade?.text = "Текущий балл: $grade"
        tvStatus?.text = "Статус: $status"

        btnBack?.setOnClickListener {
            finish()
        }
    }

    override fun onStart() { super.onStart(); Log.d(tag, "onStart called") }
    override fun onResume() { super.onResume(); Log.d(tag, "onResume called") }
    override fun onPause() { super.onPause(); Log.d(tag, "onPause called") }
    override fun onStop() { super.onStop(); Log.d(tag, "onStop called") }
    override fun onDestroy() { super.onDestroy(); Log.d(tag, "onDestroy called") }
}