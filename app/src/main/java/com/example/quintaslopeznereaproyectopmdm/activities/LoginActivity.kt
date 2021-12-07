package com.example.quintaslopeznereaproyectopmdm.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.quintaslopeznereaproyectopmdm.R
import com.example.quintaslopeznereaproyectopmdm.databinding.ActivityLoginBinding
import com.example.quintaslopeznereaproyectopmdm.modelo.dao.PreferenciasApp
import java.util.prefs.Preferences

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var pref: PreferenciasApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setTitle("Inicio de sesión")

        pref = PreferenciasApp(applicationContext)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = pref.recuperarDatos("usuario")
        val passwd = pref.recuperarDatos("contrasenha")

        binding.tietUsuario.setText(user)
        binding.tietContrasenha.setText(passwd)

        binding.btnRegistro.setOnClickListener{
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }

        binding.btnInicio.setOnClickListener {

        }

    }


}

