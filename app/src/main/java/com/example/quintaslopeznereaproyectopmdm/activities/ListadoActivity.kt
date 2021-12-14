package com.example.quintaslopeznereaproyectopmdm.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        val adapter = ListaPeliculasAdapter(listaPeliculas)

        //Asocio el RecuclerView con sus componentes
        binding.rvPeliculasList.adapter = adapter
        binding.rvPeliculasList.layoutManager = layoutManager

        //Al pulsar en el botón de añadir se abre vacío el activity de detalles
        binding.btnAnhadirPeli.setOnClickListener {
            val intent = Intent(this, DetalleActivity::class.java)
            startActivity(intent)

        }


    }






}


