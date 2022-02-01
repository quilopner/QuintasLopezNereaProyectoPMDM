package com.example.quintaslopeznereaproyectopmdm.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quintaslopeznereaproyectopmdm.R
import com.example.quintaslopeznereaproyectopmdm.adapters.ListaPeliculasAdapter
import com.example.quintaslopeznereaproyectopmdm.databinding.ActivityListadoBinding
import com.example.quintaslopeznereaproyectopmdm.modelo.dao.PeliculasDao
import com.example.quintaslopeznereaproyectopmdm.modelo.dao.PeliculasDaoMockImpl
import com.example.quintaslopeznereaproyectopmdm.modelo.entidades.Pelicula
import com.example.quintaslopeznereaproyectopmdm.modelo.entidades.Token
import com.example.quintaslopeznereaproyectopmdm.retrofit.API
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListadoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTitle("Lista de películas")

        //Inflo las vistas
        binding = ActivityListadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Obtengo los datos de las peliculas
        val peliculasDao = PeliculasDaoMockImpl()
        val listaPeliculas = peliculasDao.getTodos()

        //Creo el RecyclerView con todos sus componentes
        val layoutManager = GridLayoutManager(this, 2)
        val adapter = ListaPeliculasAdapter(listaPeliculas, this)

        //Asocio el RecuclerView con sus componentes
        binding.rvPeliculasList.adapter = adapter
        binding.rvPeliculasList.layoutManager = layoutManager

        //Configuración de RETROFIT para el listado de películas

        //Context para el toast
        val context = this

        //Configuración de la API
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://damapi.herokuapp.com/api/v1/movies")
            .build()

        val service: API = retrofit.create(API::class.java)
        val listadoCall = service.getPeliculas()

        listadoCall.enqueue(object: Callback<List<Pelicula>>{
            override fun onFailure(call: Call<List<Pelicula>>, t: Throwable) {
                Log.d("respuesta: onFailure", t.toString())
            }

            override fun onResponse(call: Call<List<Pelicula>>, response: Response<List<Pelicula>>) {
                Log.d("respuesta: onResponse", response.toString())

                if (response.code() > 299 || response.code() < 200){
                    //Alerta: no se puede mostrar la película
                    Toast.makeText(context, "No se ha podido mostrar la película", Toast.LENGTH_SHORT).show()
                }else{
                    //Mostramos el listado de películas

                }
            }
        })

        //Al pulsar en el botón de añadir se abre vacío el activity de detalles
        binding.btnAnhadirPeli.setOnClickListener {
            val intent = Intent(this, DetalleActivity::class.java)
            startActivity(intent)

        }
    }

    override fun onResume() {
        super.onResume()
        val adapter = ListaPeliculasAdapter(MiAplicacion.apelicula, this)
        binding.rvPeliculasList.adapter = adapter
    }

}


