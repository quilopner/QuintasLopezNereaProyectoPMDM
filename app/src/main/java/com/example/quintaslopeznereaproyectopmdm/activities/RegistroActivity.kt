package com.example.quintaslopeznereaproyectopmdm.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.quintaslopeznereaproyectopmdm.R
import com.example.quintaslopeznereaproyectopmdm.databinding.ActivityRegistroBinding
import com.example.quintaslopeznereaproyectopmdm.modelo.dao.PreferenciasApp
import java.util.regex.Pattern

class RegistroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroBinding
    private lateinit var pref: PreferenciasApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        pref = PreferenciasApp(applicationContext)

        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setTitle("Regístrate con nosotros")

        binding.btnRegistrame.setOnClickListener {
            /* val intent = Intent(this, LoginActivity::class.java)
            comprobarDatos()

            if (comprobarDatos() == true){
                val user = binding.tiNombreUsuario.text.toString().trim()
                val passwd = binding.tipassword.text.toString().trim()

                pref.guardar(user, passwd)
                startActivity(intent)
            }

             */



        }
    }

    //Comprobamos si el email es correcto
    private fun validarEmail(email: String): Boolean {
        val pattern: Pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }

    //Comprueba el mail y la contraseña
    private fun comprobarDatos(): Boolean {
        val contraseña = binding.tipassword.text.toString()

        //Condición para un correo inválido
        if (validarEmail(binding.tiemail.text.toString()) == false) {
            Toast.makeText(this, "Introduzca un email válido", Toast.LENGTH_SHORT)
                .show()//El toast lo imprime.
            return false
            //Condicional que comprueba la longitud de la contraseña
        } else if (contraseña.length < 8 || contraseña.length > 14) {
            //Informar de que la contraseña no pertenece al rango correcto
            Toast.makeText(
                this,
                "Debe introducir una contraseña entre 8 y 14 caracteres",
                Toast.LENGTH_SHORT
            )
                .show()
            return false
            //Si no se cumple ninguna de las condiciones anteriores se guardan los datos.
        } else {
            return true
        }
    }

}
