package com.example.quintaslopeznereaproyectopmdm

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class RegistroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val tvguardarDatos = findViewById<TextView>(R.id.btnRegistrame)
        val etmail = findViewById<TextView>(R.id.Email)

        tvguardarDatos.setOnClickListener{
          var sharedPrefs = getPreferences(Context.MODE_PRIVATE)
          var editor = sharedPrefs.edit()
          editor.putString("email", etmail.text.toString())

        }
    }
}