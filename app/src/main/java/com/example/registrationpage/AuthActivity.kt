package com.example.registrationpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.registrationpage.database.DBHelper

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val userLogin: EditText = findViewById(R.id.userAuthLogin)
        val userPassword: EditText = findViewById(R.id.userAuthPassword)
        val authButton: Button = findViewById(R.id.authButton)
        val linkToReg: TextView = findViewById(R.id.linkToReg)

        linkToReg.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        authButton.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val password = userPassword.text.toString().trim()

            if(login.isBlank() || password.isBlank())
                Toast.makeText(this, "Some fields are empty", Toast.LENGTH_LONG).show()
            else {
                val dbHelper = DBHelper(this, null)
                val isAuth = dbHelper.authUser(login, password)

                if(isAuth) {
                    Toast.makeText(this, "Welcome, $login !", Toast.LENGTH_LONG).show()
                    userLogin.text.clear()
                    userPassword.text.clear()
                } else {
                    Toast.makeText(this, "Login or password is incorrect", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}