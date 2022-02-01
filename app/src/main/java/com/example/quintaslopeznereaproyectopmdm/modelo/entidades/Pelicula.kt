package com.example.quintaslopeznereaproyectopmdm.modelo.entidades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Pelicula(
    @SerializedName("title") var titulo: String,
    var genero: String,
    var director: String,
    var nota: String,
    var url: String
) : Serializable