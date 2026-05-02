package com.example.qualheroivceh

import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import kotlin.jvm.java
import android.content.Intent

class Activity2 : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity2)

            val resposta1 = intent.getStringExtra("resposta1")

            val radioGroup = findViewById<RadioGroup>(R.id.radioGroup2)
            val btn = findViewById<Button>(R.id.btnProxima)

            btn.setOnClickListener {
                val selecionado = radioGroup.checkedRadioButtonId

                val resposta2 = when(selecionado){
                    R.id.opcao1 -> "batman"
                    R.id.opcao2 -> "homem_aranha"
                    R.id.opcao3 -> "capitao"
                    else -> ""
                }

                val intent = Intent(this, Activity3::class.java)
                intent.putExtra("resposta1", resposta1)
                intent.putExtra("resposta2", resposta2)
                startActivity(intent)
            }
        }
    }
