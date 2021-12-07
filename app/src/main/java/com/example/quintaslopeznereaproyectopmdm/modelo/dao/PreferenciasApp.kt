package com.example.quintaslopeznereaproyectopmdm.modelo.dao

import android.content.Context
import android.content.SharedPreferences

class PreferenciasApp(val context: Context) {

    val NOMBREARCHIVO = "BD"
    val pref = context.getSharedPreferences(NOMBREARCHIVO, 0)

    companion object {
        val ETIQUETA_USUARIO = "usuario"
        val ETIQUETA_CONTRASENHA = "contrasenha"
    }

    fun guardar(user: String, psswd: String){
        val prefsEditor: SharedPreferences.Editor = pref.edit()

        prefsEditor.putString("contrasenha", psswd)
        prefsEditor.putString("usuario", user)

        prefsEditor.commit()
    }

    fun recuperarDatos(recupera : String): String? {
        if (recupera == ETIQUETA_USUARIO){
            return pref.getString("usuario", "")
        }else if(recupera == ETIQUETA_CONTRASENHA){
            return pref.getString("contrasenha", "")
        }
        return null
    }
}