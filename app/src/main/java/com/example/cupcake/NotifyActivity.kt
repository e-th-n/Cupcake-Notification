package com.example.cupcake

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NotifyActivity : AppCompatActivity() {
    companion object{
        const val notify_title: String = "notify_title"
        const val notify_content: String = "notify_content"
    }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_summary)
        updateUI(intent)
    }
    override fun onNewIntent(intent: Intent?){
        super.onNewIntent(intent)
        updateUI(intent)
    }
    private fun updateUI(intent: Intent?): Unit{
        val title = (intent?.extras?.get(notify_title)) as String?
        val content = intent?.extras?.get(notify_content) as String?

        val notifyText = findViewById<TextView>(R.id.notifyText)
        notifyText.text = title + "\n" + content
    }
}