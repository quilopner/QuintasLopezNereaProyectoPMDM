package com.example.quintaslopeznereaproyectopmdm.modelo.dao

import com.example.quintaslopeznereaproyectopmdm.modelo.entidades.Pelicula

class PeliculasDaoMockImpl : PeliculasDao {
    override fun getTodos(): List<Pelicula> {
        return listOf(
            Pelicula(0, "La máscara", "Surrealismo", "Lawrence Guterman", 2.2, "https://cutt.ly/lTSM5rI"),
            Pelicula(1, "Insidious", "Terror", " Leigh Whannell", 3.7, ""),
            Pelicula(2, "It", "Terror", "Andrés Muschietti", 4.1, ""),
            Pelicula(3, "Sinister", "Terror", "Scott Derrickson", 3.6, "")
        )

    }
}