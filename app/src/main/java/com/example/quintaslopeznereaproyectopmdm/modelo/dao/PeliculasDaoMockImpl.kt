package com.example.quintaslopeznereaproyectopmdm.modelo.dao

import com.example.quintaslopeznereaproyectopmdm.modelo.entidades.Pelicula

class PeliculasDaoMockImpl : PeliculasDao {
    override fun getTodos(): List<Pelicula> {
        return listOf(
            Pelicula(0, "La máscara", "Surrealismo", "Lawrence Guterman", 2.2, "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/8SmzepMp7glh5cZRDGsbleZWiZQ.jpg"),
            Pelicula(1, "Insidious", "Terror", " Leigh Whannell", 3.7, "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/iFLDAfswp2fJeuWqxtVJfRxlZpS.jpg"),
            Pelicula(2, "It", "Terror", "Andrés Muschietti", 4.1, "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/uuTYA9LIlIRCFMgFlxWb1KznfEx.jpg"),
            Pelicula(3, "Sinister", "Terror", "Scott Derrickson", 3.6, "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/rLcHfQ4fnwaFcElMMCWNfJtIecf.jpg"),
            Pelicula(4, "La fiesta de las salchichas", "Animación", "Greg Tiernan, Conrad Vernon", 5.7, "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4YiHAxavhMLaBqOzx7ZirmOwNkD.jpg"),
            Pelicula(5, "Los Simpsons", "Animación", "David Silverman", 7.9, "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/AdiiEmjoyrvuHRER4KYtc8Memjs.jpg"),

            )

    }
}