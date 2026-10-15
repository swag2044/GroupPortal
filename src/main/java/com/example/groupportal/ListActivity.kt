package com.example.groupportal

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

data class Student(
    val name: String,
    val studentId: String,
    val grade: String,
    val status: String
)

class ListActivity : AppCompatActivity() {

    private val tag = "ListActivityLifecycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        Log.d(tag, "onCreate called")

        val userName = intent.getStringExtra("USER_NAME") ?: "Неизвестный студент"

        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        tvWelcome.text = getString(R.string.welcome_message, userName)

        val container = findViewById<LinearLayout>(R.id.containerStudents)
        val btnBack = findViewById<Button>(R.id.btnBack)

        val studentList = mutableListOf(
            Student(userName, "23019999", "92 / 100 (A-)", "Отлично (Вы)"),
            Student("Алиев Арман", "23010402", "85 / 100 (B+)", "Хорошо"),
            Student("Смагулова Аружан", "23010403", "92 / 100 (A-)", "Отлично"),
            Student("Иванов Дмитрий", "23010404", "74 / 100 (B-)", "Удовлетворительно"),
            Student("Ким Владислав", "23010405", "90 / 100 (A-)", "Отлично"),
            Student("Оспанов Данияр", "23010406", "68 / 100 (C+)", "Удовлетворительно"),
            Student("Сергеева Диана", "23010407", "95 / 100 (A)", "Отлично")
        )

        container.removeAllViews()

        val marginPx = resources.getDimensionPixelSize(R.dimen.card_margin_bottom)
        val paddingPx = resources.getDimensionPixelSize(R.dimen.card_padding)
        val textSizeSp = resources.getDimension(R.dimen.text_size_body) / resources.displayMetrics.scaledDensity

        for (student in studentList) {
            val studentCard = TextView(this).apply {
                text = "${student.name}\nID: ${student.studentId} | Оценка: ${student.grade}"
                textSize = textSizeSp
                setPadding(paddingPx, paddingPx, paddingPx, paddingPx)

                // Используем цвета из ресурсов
                if (student.name == userName) {
                    setBackgroundColor(resources.getColor(R.color.card_user_background, theme))
                } else {
                    setBackgroundColor(resources.getColor(R.color.card_background, theme))
                }
                setTextColor(resources.getColor(R.color.text_primary, theme))

                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    setMargins(0, 0, 0, marginPx)
                }

                // Кликабельна только карточка текущего пользователя
                if (student.name == userName) {
                    setOnClickListener {
                        val detailIntent = Intent(this@ListActivity, DetailActivity::class.java).apply {
                            putExtra("USER_NAME", student.name)
                            putExtra("STUDENT_ID", student.studentId)
                            putExtra("STUDENT_GRADE", student.grade)
                            putExtra("STUDENT_STATUS", student.status)
                        }
                        startActivity(detailIntent)
                    }
                } else {
                    isClickable = false
                    isFocusable = false
                }
            }
            container.addView(studentCard)
        }

        btnBack.setOnClickListener {
            finish()
        }
    }

    override fun onStart() { super.onStart(); Log.d(tag, "onStart called") }
    override fun onResume() { super.onResume(); Log.d(tag, "onResume called") }
    override fun onPause() { super.onPause(); Log.d(tag, "onPause called") }
    override fun onStop() { super.onStop(); Log.d(tag, "onStop called") }
    override fun onDestroy() { super.onDestroy(); Log.d(tag, "onDestroy called") }
}