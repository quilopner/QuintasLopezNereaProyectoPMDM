package com.example.quintaslopeznereaproyectopmdm.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.quintaslopeznereaproyectopmdm.R

class LoginActivity : AppCompatActivity() {

    private lateinit var btRegistro : Button
    private lateinit var btInicio : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btRegistro = findViewById(R.id.btnRegistro)
        btInicio = findViewById(R.id.btnInicio)


        btRegistro.setOnClickListener{
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }
        btInicio.setOnClickListener{

        }

    }
}