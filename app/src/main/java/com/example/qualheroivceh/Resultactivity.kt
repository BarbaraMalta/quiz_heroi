package com.example.qualheroivceh

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Button
import androidx.core.net.toUri
import android.view.View
import android.widget.ImageView

class Resultactivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.resultactivity)

        val r1 = intent.getStringExtra("resposta1")
        val r2 = intent.getStringExtra("resposta2")
        val r3 = intent.getStringExtra("resposta3")

        val lista = listOf(r1, r2, r3)

        val resultado = lista
            .filterNotNull()
            .groupingBy { it }
            .eachCount()
            .maxByOrNull { it.value }
            ?.key

        val txt = findViewById<TextView>(R.id.txtResultado)
        val imageView = findViewById<ImageView>(R.id.imagemHeroi)

        val imagemRes: Int?

        when (resultado) {
            "batman" -> imagemRes = R.drawable.batman
            "homem_aranha" -> imagemRes = R.drawable.homemaranha
            "capitao" -> imagemRes = R.drawable.capitaoamerica
            else -> imagemRes = R.drawable.erro
        }

        imageView.setImageResource(imagemRes)
        imageView.visibility = View.VISIBLE

        val nomeFinal = when (resultado) {
            "batman" -> "Batman"
            "homem_aranha" -> "Homem-Aranha"
            "capitao" -> "Capitão América"
            else -> "Indefinido"
        }

        txt.text = nomeFinal


        findViewById<Button>(R.id.btn_browser).setOnClickListener {
            val intent = Intent(
                Intent.ACTION_VIEW,
                "https://github.com/BarbaraMalta/quiz_heroi".toUri()
            )
            startActivity(intent)
        }
    }
}