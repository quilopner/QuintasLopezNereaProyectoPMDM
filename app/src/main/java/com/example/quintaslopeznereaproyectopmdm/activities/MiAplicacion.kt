package com.example.quintaslopeznereaproyectopmdm.activities

import android.app.Application
import com.example.quintaslopeznereaproyectopmdm.modelo.dao.PeliculasDaoMockImpl
import com.example.quintaslopeznereaproyectopmdm.modelo.entidades.Pelicula
import java.util.ArrayList

class MiAplicacion : Application() {

    companion object {
        var apelicula: ArrayList<Pelicula> = ArrayList()
    }

    override fun onCreate() {
        super.onCreate()
        val peliculadao = PeliculasDaoMockImpl()
        apelicula = peliculadao.getTodos()
    }
}
