package com.example.a622k

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignInActivity  : AppCompatActivity() {
    var sharedPreferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign)
        val email1 = findViewById<EditText>(R.id.email)
        val name = findViewById<EditText>(R.id.name)
        val pas = findViewById<EditText>(R.id.pas)
        val cpas = findViewById<EditText>(R.id.cpass)
        val save = findViewById<Button>(R.id.register)
        val cancel = findViewById<TextView>(R.id.cancel)

        sharedPreferences = getSharedPreferences("userInfo", 0)

        save.setOnClickListener {
            val emailValue = email1.text.toString()
            val passwordValue = pas.text.toString()
            val nameValue = name.text.toString()
            val cpasValue = cpas.text.toString()

            if (emailValue.length > 1 && packageCodePath.length > 1) {
                if (passwordValue == cpasValue) {

                    val editor = sharedPreferences?.edit()
                    editor?.putString("emailValue", emailValue)
                    editor?.putString("passwordValue", passwordValue)
                    editor?.putString("nameValue", nameValue)
                    editor?.putString("cpasValue", cpasValue)
                    editor?.apply()

                    Toast.makeText(
                        this@SignInActivity,
                        "Successfully Registered",
                        Toast.LENGTH_SHORT
                    ).show()
                    finish()
                }else {
                    Toast.makeText(
                        this@SignInActivity,
                        "Invalid confirm password",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(this@SignInActivity, "Form the application fully, please", Toast.LENGTH_SHORT).show()
            }
        }
        cancel.setOnClickListener {
            val intent = Intent(this@SignInActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}