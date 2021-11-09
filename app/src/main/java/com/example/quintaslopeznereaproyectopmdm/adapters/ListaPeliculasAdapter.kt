package com.example.quintaslopeznereaproyectopmdm.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quintaslopeznereaproyectopmdm.R
import com.example.quintaslopeznereaproyectopmdm.modelo.entidades.Pelicula
import com.squareup.picasso.Picasso

class ListaPeliculasAdapter(val peliculas: List<Pelicula>) :
    RecyclerView.Adapter<ListaPeliculasAdapter.PeliculasViewHolder>() {
    class PeliculasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitulo = itemView.findViewById<TextView>(R.id.tvTitulo)
        val tvNota = itemView.findViewById<TextView>(R.id.tvNota)
        val ivFoto = itemView.findViewById<ImageView>(R.id.ivPortada)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculasViewHolder {
        val layoutInflater =
            LayoutInflater.from(parent.context).inflate(R.layout.item_pelicula, parent, false)
        return PeliculasViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: PeliculasViewHolder, position: Int) {
        val pelicula = peliculas.get(position)

        holder.tvNota.setText(pelicula.nota.toString())
        holder.tvTitulo.setText(pelicula.titulo)
        Picasso.get().load(pelicula.url).into(holder.ivFoto);
    }

    override fun getItemCount(): Int {
        return peliculas.size
    }
}


