package com.example.quintaslopeznereaproyectopmdm.activities

import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.drawable.DrawableCompat
import com.example.quintaslopeznereaproyectopmdm.R
import com.example.quintaslopeznereaproyectopmdm.databinding.ActivityDetalleBinding
import com.example.quintaslopeznereaproyectopmdm.databinding.ActivityLoginBinding
import com.example.quintaslopeznereaproyectopmdm.modelo.entidades.Pelicula
import com.squareup.picasso.Picasso

class DetalleActivity : AppCompatActivity() {

    private lateinit var pelicula: Pelicula

    private lateinit var binding: ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        binding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pelicula = intent.extras?.get("pelicula") as Pelicula

        Picasso.get().load(pelicula.url).into(binding.idLogoDetalle)
        binding.tietDirectorDetalle.text = pelicula.director
        binding.tietGeneroDetalle.text = pelicula.genero
        binding.tietTituloDetalle.text = pelicula.titulo
        binding.tietNota.text = pelicula.nota.toDouble()

        if (pelicula.nota.toDouble() < 5) {
            val progress: Drawable = binding.tietNota.getProgressDrawable()
            DrawableCompat.setTint(progress, Color.RED)
        }



        setTitle("Detalle Películas")
    }
}

private fun TextInputEditText.getProgressDrawable(): Drawable {

}
