package com.example.examenintentnuevo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class BookDetailsActivity : AppCompatActivity() {

    private lateinit var autorLibro: EditText
    private lateinit var anioLibro: EditText
    private lateinit var botonContinuar: Button
    private lateinit var botonAtras: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)

        autorLibro = findViewById(R.id.editTextText3)
        anioLibro = findViewById(R.id.editTextText4)
        botonContinuar = findViewById(R.id.button2)
        botonAtras = findViewById(R.id.button3)

        val libro = intent.getSerializableExtra("libro") as Libro

        botonContinuar.setOnClickListener {
            val autor = autorLibro.text.toString()
            val anio = anioLibro.text

            if (autor.isBlank()) {
                showToast("El autor no puede estar vacio")
            } else if (anio.isBlank()) {
                showToast("El año debe ser mayor a 0")
            } else {
                val intent = Intent(this@BookDetailsActivity, BookDisplayActivity::class.java)
                val libro1 = Libro(libro.getTituloLibro(), libro.getPaginasLibro(), autor, anio.toString().toInt())
                intent.putExtra("libro1", libro1)
                startActivity(intent)
            }
        }

        botonAtras.setOnClickListener {
            val intent = Intent(this@BookDetailsActivity, BookTitleActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}