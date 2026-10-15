package com.example.groupportal

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "MainActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: Экран создан")

        val etName = findViewById<EditText>(R.id.etName)
        val btnOpen = findViewById<Button>(R.id.btnOpen)

        btnOpen.setOnClickListener {
            val name = etName.text.toString()
            Log.i(TAG, "onCreate: Имя $name")

            val intent = Intent(this, ListActivity::class.java)
            intent.putExtra("USER_NAME", etName.text.toString())
            startActivity(intent)
        }
    }

    override fun onStart() { super.onStart(); Log.d(TAG, "onStart: Экран запущен")  }
    override fun onResume() { super.onResume(); Log.d(TAG, "onResume: Экран запущен") }
    override fun onPause() { super.onPause(); Log.d(TAG, "onPause: Экран приостановлен") }
    override fun onStop() { super.onStop(); Log.d(TAG, "onStop: Экран остановлен") }
    override fun onDestroy() { super.onDestroy(); Log.d(TAG, "onDestroy: Экран уничтожен") }
}