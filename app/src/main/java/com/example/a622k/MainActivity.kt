package com.example.a622k

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Config
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    val TAG : String = MainActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }
    private fun initViews() {
        val name = findViewById<EditText>(R.id.name)
        val email = findViewById<EditText>(R.id.email)
        val pas = findViewById<EditText>(R.id.pas)
        val cpas = findViewById<EditText>(R.id.cpass)
        val save = findViewById<Button>(R.id.save)


        save.setOnClickListener {

            val name: String = name.text.toString()
            PrefsManager.getInstance(this)!!.saveData(1, name)
            val data = PrefsManager.getInstance(this)!!.getData(1)
            saveEmail(data)

            val email: String = email.text.toString()
            PrefsManager.getInstance(this)!!.saveData(1, email)
            val data1 = PrefsManager.getInstance(this)!!.getData(1)
            saveEmail(data1)

            val pas: String = pas.text.toString()
            PrefsManager.getInstance(this)!!.saveData(1, pas)
            val data2 = PrefsManager.getInstance(this)!!.getData(1)
            saveEmail(data2)

            val cpas: String = cpas.text.toString()
            PrefsManager.getInstance(this)!!.saveData(1, cpas)
            val data3 = PrefsManager.getInstance(this)!!.getData(1)
            saveEmail(data3)

            Log.d(TAG, email )

        }
    }

    private fun saveEmail(email: String?) {
        val prefs = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor = prefs.edit()
        if (email != null) {
            editor.putString("email", email)
        }
        editor.apply()
    }
}