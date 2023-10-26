package com.example.anew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.anew.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var database: LogIn_SignUpDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseHelper = DatabaseHelper(this)
        database = LogIn_SignUpDatabase(this)

        binding.loginButton.setOnClickListener {
            val loginUsername = binding.loginUsername.text.toString()
            val loginPassword = binding.loginPassword.text.toString()
            val checkuser = database.checkuserpass(loginUsername, loginPassword)


            if (TextUtils.isEmpty(loginUsername) || TextUtils.isEmpty(loginPassword)) {
                Toast.makeText(this, "Add Username & Password", Toast.LENGTH_SHORT).show()
            } else {
                if (checkuser == true) {
                    Toast.makeText(this, "Log In Successful", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, homeActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Wrong Password & Username", Toast.LENGTH_SHORT).show()
                }
            }
            loginDatabase(loginUsername, loginPassword)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.signupRedirect.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
            finish()

        }
    }

    private fun loginDatabase(username: String, password: String){
        val userExists = databaseHelper.readUser(username, password)
        if (userExists){
            Toast.makeText(this, "Log in Successful", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, homeActivity::class.java)
            startActivity(intent)
            finish()

        }else{
            Toast.makeText(this, "Log in Failed", Toast.LENGTH_SHORT).show()


        }
    }
}