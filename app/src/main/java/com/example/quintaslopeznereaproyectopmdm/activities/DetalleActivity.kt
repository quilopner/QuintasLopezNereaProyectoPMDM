package com.example.quintaslopeznereaproyectopmdm.activities

import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.graphics.drawable.DrawableCompat
import com.example.quintaslopeznereaproyectopmdm.R
import com.example.quintaslopeznereaproyectopmdm.databinding.ActivityDetalleBinding
import com.example.quintaslopeznereaproyectopmdm.databinding.ActivityLoginBinding
import com.example.quintaslopeznereaproyectopmdm.modelo.dao.PeliculasDao
import com.example.quintaslopeznereaproyectopmdm.modelo.dao.PeliculasDaoMockImpl
import com.example.quintaslopeznereaproyectopmdm.modelo.entidades.Pelicula
import com.squareup.picasso.Picasso

class DetalleActivity : AppCompatActivity() {


    companion object {
        const val BUNDLE_DATA_PELICULA = "pelicula"
    }

    private lateinit var binding: ActivityDetalleBinding
    private lateinit var peliculasDao: PeliculasDao

    private var pelicula: Pelicula? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        setTitle("Detalles de la película")

        super.onCreate(savedInstanceState)
        binding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        peliculasDao = PeliculasDaoMockImpl()
        pelicula = intent.getSerializableExtra(BUNDLE_DATA_PELICULA) as Pelicula?


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_listado, menu)
        return true
    }

    //Menu para borrar y editar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.basura -> {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Eliminar personaje").setMessage("Confirma eliminación.")
                    .setPositiveButton("Aceptar") { _, _ ->
                        Toast.makeText(this, "Personaje Animado", Toast.LENGTH_SHORT).show()
                        finish()
                    }.setNegativeButton("Cancelar", null).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
}




