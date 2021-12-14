package com.example.quintaslopeznereaproyectopmdm.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.quintaslopeznereaproyectopmdm.R
import com.example.quintaslopeznereaproyectopmdm.activities.DetalleActivity
import com.example.quintaslopeznereaproyectopmdm.activities.RegistroActivity
import com.example.quintaslopeznereaproyectopmdm.modelo.entidades.Pelicula
import com.squareup.picasso.Picasso

class ListaPeliculasAdapter(val peliculas: List<Pelicula>) :
    RecyclerView.Adapter<ListaPeliculasAdapter.PeliculasViewHolder>() {
    class PeliculasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitulo = itemView.findViewById<TextView>(R.id.tvTitulo)
        /* val tvGenero = itemView.findViewById<TextView>(R.id.tvGenero)
        val tvDirector = itemView.findViewById<TextView>(R.id.tvDirector)
        val tvNota = itemView.findViewById<TextView>(R.id.tvNota) */
        val ivFoto = itemView.findViewById<ImageView>(R.id.ivPortada)
        val idPelicula = itemView.findViewById<ConstraintLayout>(R.id.pelicula)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculasViewHolder {
        val layoutInflater =
            LayoutInflater.from(parent.context).inflate(R.layout.item_pelicula, parent, false)
        return PeliculasViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: PeliculasViewHolder, position: Int) {
        val pelicula = peliculas.get(position)

        holder.tvTitulo.setText(pelicula.titulo)
        /* holder.tvGenero.setText(pelicula.genero)
        holder.tvDirector.setText(pelicula.director)
        holder.tvNota.setText(pelicula.nota.toString())*/
        Picasso.get().load(pelicula.url).into(holder.ivFoto)

        holder.idPelicula.setOnClickListener{
            val intent = Intent(holder.itemView.rootView.context, DetalleActivity::class.java)
            intent.putExtra(DetalleActivity.BUNDLE_DATA_PELICULA, pelicula)
            holder.itemView.rootView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return peliculas.size
    }
}


