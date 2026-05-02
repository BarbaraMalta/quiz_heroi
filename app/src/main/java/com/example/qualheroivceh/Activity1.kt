package com.example.qualheroivceh

import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

class Activity1 : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity1)

            val radioGroup = findViewById<RadioGroup>(R.id.radioGroup1)
            val btn = findViewById<Button>(R.id.btnProxima)

            btn.setOnClickListener {
                val selecionado = radioGroup.checkedRadioButtonId

                val resposta = when(selecionado){
                    R.id.opcao1 -> "batman"
                    R.id.opcao2 -> "homem_aranha"
                    R.id.opcao3 -> "capitao"
                    else -> ""
                }

                val intent = Intent(this, Activity2::class.java)
                intent.putExtra("resposta1", resposta)
                startActivity(intent)
            }
        }
    }
