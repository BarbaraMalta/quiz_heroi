package com.example.qualheroivceh

import android.os.Bundle
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.content.Intent

class Activity3 : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity3)

            val resposta1 = intent.getStringExtra("resposta1")
            val resposta2 = intent.getStringExtra("resposta2")

            val radioGroup = findViewById<RadioGroup>(R.id.radioGroup3)
            val btn = findViewById<Button>(R.id.btnResultado)

            btn.setOnClickListener {
                val selecionado = radioGroup.checkedRadioButtonId

                val resposta3 = when(selecionado){
                    R.id.opcao1 -> "batman"
                    R.id.opcao2 -> "homem_aranha"
                    R.id.opcao3 -> "capitao"
                    else -> ""
                }

                val intent = Intent(this, Resultactivity::class.java)
                intent.putExtra("resposta1", resposta1)
                intent.putExtra("resposta2", resposta2)
                intent.putExtra("resposta3", resposta3)
                startActivity(intent)
            }
        }
    }