package com.example.quintaslopeznereaproyectopmdm.activities

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.remove
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.graphics.drawable.DrawableCompat
import com.example.quintaslopeznereaproyectopmdm.R
import com.example.quintaslopeznereaproyectopmdm.activities.MiAplicacion.Companion.apelicula
import com.example.quintaslopeznereaproyectopmdm.databinding.ActivityDetalleBinding
import com.example.quintaslopeznereaproyectopmdm.databinding.ActivityLoginBinding
import com.example.quintaslopeznereaproyectopmdm.modelo.dao.PeliculasDao
import com.example.quintaslopeznereaproyectopmdm.modelo.dao.PeliculasDaoMockImpl
import com.example.quintaslopeznereaproyectopmdm.modelo.entidades.Pelicula
import com.squareup.picasso.Picasso

class DetalleActivity : AppCompatActivity() {


    companion object {
        const val BUNDLE_DATA_PELICULA = "pelicula"

        var itemGuardar: MenuItem? = null
        var itemEditar: MenuItem? = null
        var itemBorrar: MenuItem? = null
    }

    private lateinit var binding: ActivityDetalleBinding
    private lateinit var peliculasDao: PeliculasDao
    private lateinit var infoPelicula: Pelicula

    private var pelicula: Pelicula? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        setTitle("Detalles de la película")

        super.onCreate(savedInstanceState)
        binding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        peliculasDao = PeliculasDaoMockImpl()
        pelicula = intent.getSerializableExtra(BUNDLE_DATA_PELICULA) as Pelicula?

    }

    override fun onResume() {
        super.onResume()

        val view = this.currentFocus
        view?.let { v ->
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.hideSoftInputFromWindow(v.windowToken, 0)
        }

        if (intent.extras?.get(BUNDLE_DATA_PELICULA) != null) {
            infoPelicula = intent.extras?.get(BUNDLE_DATA_PELICULA) as Pelicula
            title = infoPelicula.titulo
            binding.tietTituloDetalle.setText(infoPelicula.titulo)
            binding.tietGeneroDetalle.setText(infoPelicula.genero)
            binding.tietDirectorDetalle.setText(infoPelicula.director)
            binding.tietNota.setText(infoPelicula.nota.toString())
            Picasso.get().load(infoPelicula.url).into(binding.ivCaratula)
        } else {
            title = "Nueva Pelicula"
            binding.tietTituloDetalle.isEnabled = true
            binding.tietGeneroDetalle.isEnabled = true
            binding.tietDirectorDetalle.isEnabled = true
            binding.tietNota.isEnabled = true
            Picasso.get()
                .load("https://png.pngtree.com/png-vector/20190728/ourlarge/pngtree-avatar-user-profile-flat-color-icon-vector-icon-banner-png-image_1619399.jpg")
                .into(binding.ivCaratula)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_listado, menu)
        if (menu != null) {
            itemBorrar = menu.findItem(R.id.basura)
            itemGuardar = menu.findItem(R.id.guardar)
            itemEditar = menu.findItem(R.id.editar)
        }
        return true
    }

    //Menu para borrar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.editar -> {
                //Campos editables
                binding.tietTituloDetalle.isEnabled = true
                binding.tietGeneroDetalle.isEnabled = true
                binding.tietNota.isEnabled = true
                binding.tietDirectorDetalle.isEnabled = true
                Toast.makeText(this, "Pantalla de edición", Toast.LENGTH_SHORT).show()
                itemGuardar?.isVisible = true
                itemEditar?.isVisible = false
                itemBorrar?.isVisible = false

                return true
            }

            R.id.guardar -> {
                //Guardar campos
                val peliculaCreada = Pelicula(
                    binding.tietTituloDetalle.text.toString(),
                    binding.tietGeneroDetalle.text.toString(),
                    binding.tietDirectorDetalle.text.toString(),
                    binding.tietNota.text.toString(),
                    binding.ivCaratula.toString()
                )
                if (intent.extras?.get("pelicula") == null) {
                    apelicula.add(peliculaCreada)
                } else {
                    val indicePeli = apelicula.indexOf(infoPelicula)
                    apelicula[indicePeli] = peliculaCreada
                }
                Toast.makeText(this, "Película Guardada", Toast.LENGTH_SHORT).show()
                finish()
            }
        }

        val adb = AlertDialog.Builder(this)
        adb.setTitle("Eliminar")
        adb.setMessage("Estás seguro de eliminar la pelicula?")
        adb.setPositiveButton("Si") { dialogInterface, i ->
            if (item.itemId == R.id.basura) {
                apelicula.remove(pelicula)
                finish()
            }
        }
        adb.setNegativeButton("Cancelar", null)
        adb.show()
        return super.onOptionsItemSelected(item)
    }





}


