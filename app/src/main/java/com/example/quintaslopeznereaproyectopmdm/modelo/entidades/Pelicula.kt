package com.example.quintaslopeznereaproyectopmdm.modelo.entidades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.io.Serializable

data class Pelicula(
    var titulo: String,
    var genero: String,
    var director: String,
    var nota: Double,
    var url: String
) : Serializable