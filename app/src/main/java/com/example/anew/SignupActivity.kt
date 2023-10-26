package com.example.anew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.anew.databinding.ActivitySignupBinding

class   SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var data: LogIn_SignUpDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseHelper = DatabaseHelper(this)
        binding.signupButton.setOnClickListener {

            val signupUsername = binding.signupUsername.text.toString()
            val signupPassword = binding.signupPassword.text.toString()
            val savedata = data.insertdata(signupUsername, signupPassword)

            if (TextUtils.isEmpty(signupPassword) || TextUtils.isEmpty(signupUsername)){
                Toast.makeText(this, "Add Username or Password", Toast.LENGTH_SHORT).show()
            }else{
                if (savedata == true) {
                    Toast.makeText(this, "Sign Up Successful", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }


        }
        binding.loginRedirect.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}