package com.example.quintaslopeznereaproyectopmdm.modelo.dao

import com.example.quintaslopeznereaproyectopmdm.modelo.entidades.Pelicula

interface PeliculasDao {
    fun getTodos(): List<Pelicula>
}