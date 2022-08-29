package com.example.a622k

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var sharedPreferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        val email1 = findViewById<EditText>(R.id.email)
        val pas = findViewById<EditText>(R.id.pas)
        val save = findViewById<Button>(R.id.LogIn)
        val textView = findViewById<TextView>(R.id.signIn)

        save.setOnClickListener {

            val emailValue = email1.text.toString()
            val passwordValue = pas.text.toString()

            val registeredEmail = sharedPreferences!!.getString("emailValue", "")
            val registeredPassword = sharedPreferences!!.getString("pasValue", "")

            if (emailValue == registeredEmail && passwordValue == registeredPassword) {
                val intent = Intent(this@MainActivity, LastActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_SHORT).show()
            }
        }
        textView.setOnClickListener {
            val intent = Intent(this@MainActivity, SignInActivity::class.java)
            startActivity(intent)
        }
        save.setOnClickListener {
            val intent = Intent(this@MainActivity, LastActivity::class.java)
            startActivity(intent)
        }
    }

}