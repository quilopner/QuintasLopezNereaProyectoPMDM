package com.example.quintaslopeznereaproyectopmdm.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
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

        val user = pref.recuperarDatos(PreferenciasApp.ETIQUETA_USUARIO)
        val passwd = pref.recuperarDatos(PreferenciasApp.ETIQUETA_CONTRASENHA)

        binding.tietUsuario.setText(user)
        binding.tietContrasenha.setText(passwd)

        binding.btnRegistro.setOnClickListener{
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }

        binding.btnInicio.setOnClickListener {
            if (binding.tietUsuario.text.toString().length==0 || binding.tietContrasenha.text.toString().length==0 ){

                val adb = AlertDialog.Builder(this)
                adb.setTitle("Datos incorrectos")
                adb.setMessage("El usuario y/o la contraseña están vacíos.")
                adb.setPositiveButton("Aceptar") { dialog, which ->}
                adb.show()
            }
            else if (!user.equals(binding.tietUsuario.text.toString())) {
                binding.tietUsuario.setError("El usuario no existe")
            } else if (!passwd.equals(binding.tietContrasenha.text.toString())) {
                binding.tietContrasenha.setError("La contraseña no es correcta")
            } else {
                val intent = Intent(this, ListadoActivity::class.java)
                startActivity(intent)
            }
        }

    }


}

