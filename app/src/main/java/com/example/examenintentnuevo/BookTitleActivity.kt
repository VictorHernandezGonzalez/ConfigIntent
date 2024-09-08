package com.example.examenintentnuevo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class BookTitleActivity : AppCompatActivity() {

    private lateinit var tituloLibro: EditText
    private lateinit var paginasLibro: EditText
    private lateinit var botonContinuar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_title)

        tituloLibro = findViewById(R.id.editTextText)
        paginasLibro = findViewById(R.id.editTextText2)
        botonContinuar = findViewById(R.id.button)

        botonContinuar.setOnClickListener {
            val titulo = tituloLibro.text.toString()
            val paginas = paginasLibro.text

            if (titulo.isBlank()) {
                showToast("El titulo no puede estar vacio")
            } else if (paginas.isBlank()) {
                showToast("Las paginas deben ser mayor a 0")
            } else {
                val intent = Intent(this@BookTitleActivity, BookDetailsActivity::class.java)
                val libro = Libro(titulo, paginas.toString().toInt(), "", 0)
                intent.putExtra("libro", libro)
                startActivity(intent)
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}