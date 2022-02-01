package com.example.quintaslopeznereaproyectopmdm.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.quintaslopeznereaproyectopmdm.R
import com.example.quintaslopeznereaproyectopmdm.databinding.ActivityLoginBinding
import com.example.quintaslopeznereaproyectopmdm.modelo.dao.PreferenciasApp
import com.example.quintaslopeznereaproyectopmdm.modelo.entidades.Token
import com.example.quintaslopeznereaproyectopmdm.retrofit.API
import com.example.quintaslopeznereaproyectopmdm.retrofit.Usuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

        binding.btnRegistro.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }

        binding.btnInicio.setOnClickListener {

            //Configuración retrofit

            val context = this

            val u = Usuario("nerea@gmail.com", "1234")

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://damapi.herokuapp.com/api/v1/")
                .build()
            val service: API = retrofit.create(API::class.java)
            val loginCall = service.login(u)

            loginCall.enqueue(object : Callback<Token> {
                override fun onFailure(call: Call<Token>, t: Throwable) {
                    Log.d("respuesta: onFailure", t.toString())
                }

                override fun onResponse(call: Call<Token>, response: Response<Token>) {
                    Log.d("respuesta: onResponse", response.toString())

                    if (!response.isSuccessful) {
                        //Mostrar alerta: Usuario o contraseña incorrectos
                        Toast.makeText(
                            context,
                            "Usuario o contraseña incorrectos",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        //Proporciona el token de usuario
                        val token = response.body()?.token
                        Log.d("respuesta: token:", token.orEmpty())

                        // Guardar token en shardprefs
                        var sharedPrefs =
                            getSharedPreferences("info", Context.MODE_PRIVATE) ?: return
                        with(sharedPrefs.edit()) {
                            editor.putString("token", token).commit()
                        }

                        // Iniciar activity
                        val intent = Intent(this@LoginActivity, ListadoActivity::class.java)
                        startActivity(intent)
                    }
                }
            })

            /* if (binding.tietUsuario.text.toString().length==0 || binding.tietContrasenha.text.toString().length==0 ){

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

             */
        }
    }
}




