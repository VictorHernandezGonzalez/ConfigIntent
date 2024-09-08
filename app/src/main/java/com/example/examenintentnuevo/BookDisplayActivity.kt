package com.example.examenintentnuevo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class BookDisplayActivity : AppCompatActivity() {

    private lateinit var tituloLibro: TextView
    private lateinit var paginasLibro: TextView
    private lateinit var autorLibro: TextView
    private lateinit var anioLibro: TextView
    private lateinit var botonContinuar: Button
    private lateinit var botonAtras: Button
    private lateinit var botonVolver: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_display)

        tituloLibro = findViewById(R.id.textView)
        paginasLibro = findViewById(R.id.textView2)
        autorLibro = findViewById(R.id.textView3)
        anioLibro = findViewById(R.id.textView4)
        botonContinuar = findViewById(R.id.button4)
        botonAtras = findViewById(R.id.button5)
        botonVolver = findViewById(R.id.button6)

        val libro2 = intent.getSerializableExtra("libro1") as Libro

        val listaLibros = ArrayList<Libro>()

        tituloLibro.text = libro2.getTituloLibro()
        paginasLibro.text = libro2.getPaginasLibro().toString()
        autorLibro.text = libro2.getAutorLibro()
        anioLibro.text = libro2.getAnioLibro().toString()

        botonContinuar.setOnClickListener {
            val librosCreados = listaLibros
            val librosDG = libro2.toString()

            var yaExiste = false
            for (libroCreado in librosCreados) {
                if (libroCreado.toString() == librosDG) {
                    yaExiste = true
                }
            }

            if (yaExiste) {
                showToast("El libro ya existe en la lista")
            } else {
                listaLibros.add(libro2)
                showToast("Libro Guardado a la lista")
            }
        }

        botonAtras.setOnClickListener {
            val intent = Intent(this@BookDisplayActivity, BookDetailsActivity::class.java)
            startActivity(intent)
        }

        botonVolver.setOnClickListener {
            val intent = Intent(this@BookDisplayActivity, BookTitleActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}