package com.example.examenintentnuevo

import java.io.Serializable

data class Libro(

    private var tituloLibro: String,
    private var paginasLibro: Int,
    private var autorLibro: String,
    private var anioLibro: Int

): Serializable {

    fun getTituloLibro(): String {
        return tituloLibro
    }

    fun getPaginasLibro(): Int {
        return paginasLibro
    }

    fun getAutorLibro(): String {
        return autorLibro
    }

    fun getAnioLibro(): Int {
        return anioLibro
    }

    override fun toString(): String {
        return "Libro [Titulo: $tituloLibro, Paginas: $paginasLibro, Autor: $autorLibro, Anio: $anioLibro]"
    }

}