package com.example.anew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class LoginMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_main)


        val gsBtn = findViewById<Button>(R.id.gsBtn)
        gsBtn.setOnClickListener {
            val fIntent = Intent(this, LoginActivity::class.java)
            startActivity(fIntent)

        }
    }
}