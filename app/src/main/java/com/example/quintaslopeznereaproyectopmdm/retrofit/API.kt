package com.example.quintaslopeznereaproyectopmdm.retrofit

import android.media.session.MediaSession
import com.example.quintaslopeznereaproyectopmdm.modelo.entidades.Pelicula
import com.example.quintaslopeznereaproyectopmdm.modelo.entidades.Token
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface API {
    @POST("users/signup")
    fun signup(@Body user: Usuario): Call<Unit>

    @POST("users/login")
    fun login(@Body user: Usuario): Call<Token>

    //
    @GET("https://damapi.herokuapp.com/api/v1/movies")
    fun getPeliculas(): Call<List<Pelicula>>
}