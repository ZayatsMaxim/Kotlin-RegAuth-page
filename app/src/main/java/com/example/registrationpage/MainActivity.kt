package com.example.registrationpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.registrationpage.database.DBHelper
import com.example.registrationpage.user.User

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userEmailAddress: EditText = findViewById(R.id.userEmailAddress)
        val userLogin: EditText = findViewById(R.id.userAuthLogin)
        val userPassword: EditText = findViewById(R.id.userAuthPassword)
        val registerButton: Button = findViewById(R.id.authButton)
        val linkToAuth: TextView = findViewById(R.id.linkToAuth)

        registerButton.setOnClickListener {
            val email = userEmailAddress.text.toString().trim()
            val login = userLogin.text.toString().trim()
            val password = userPassword.text.toString().trim()

            if(email.isBlank() || login.isBlank() || password.isBlank())
                Toast.makeText(this, "Some fields are empty", Toast.LENGTH_LONG).show()
            else {
                val user = User(login, email, password)

                val dbHelper = DBHelper(this, null)
                dbHelper.addUser(user)
                Toast.makeText(this, "Registration complete", Toast.LENGTH_SHORT).show()

                userLogin.text.clear()
                userEmailAddress.text.clear()
                userPassword.text.clear()
            }
        }

        linkToAuth.setOnClickListener {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }
    }
}