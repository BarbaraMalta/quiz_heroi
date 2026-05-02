package com.example.qualheroivceh

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Button
class Resultactivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.resultactivity)

            val r1 = intent.getStringExtra("resposta1")
            val r2 = intent.getStringExtra("resposta2")
            val r3 = intent.getStringExtra("resposta3")

            val lista = listOf(r1, r2, r3)

            val resultado = lista.groupingBy { it }.eachCount().maxByOrNull { it.value }?.key

            val txt = findViewById<TextView>(R.id.txtResultado)

            val nomeFinal = when(resultado){
                "batman" -> "Batman 🦇"
                "homem_aranha" -> "Homem-Aranha 🕷️"
                "capitao" -> "Capitão América 🛡️"
                else -> "Indefinido"
            }
            val btnVoltar = findViewById<Button>(R.id.btnVoltar)

            btnVoltar.setOnClickListener {
                val intent = Intent(this, Activity1::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)
                finish()
            }

            txt.text = getString(R.string.resultado, nomeFinal)
        }
    }