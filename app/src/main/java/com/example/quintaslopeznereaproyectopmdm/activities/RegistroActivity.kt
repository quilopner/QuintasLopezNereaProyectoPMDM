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
import java.util.regex.Pattern

class RegistroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroBinding
    private lateinit var btRegistrame: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btRegistrame = findViewById(R.id.btnRegistrame)

        val btRegistrame = findViewById<TextView>(R.id.btnRegistrame)
        val etmail = findViewById<EditText>(R.id.tiemail)

        btRegistrame.setOnClickListener {
            var sharedPrefs = getPreferences(Context.MODE_PRIVATE)
            var editor = sharedPrefs.edit()
            editor.putString("email", etmail.text.toString())

            //Al pulsar en el botón "Regístrame" retroceder a la pantalla de login
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    //Comprobamos si el email es correcto
    private fun validarEmail(email: String): Boolean {
        val pattern: Pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }

    //Comprueba el mail y la contraseña
    private fun comprobarDatos(): Boolean {
        val contraseña = binding.ticontraseA.text.toString()

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
