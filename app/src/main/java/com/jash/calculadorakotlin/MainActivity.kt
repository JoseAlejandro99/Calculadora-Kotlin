package com.jash.calculadorakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var operacion: Int = 0
    var numero1: Double = 0.0
    var respuesta: Double = 0.0
    lateinit var textNum1: TextView
    lateinit var textNum2: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textNum1 = findViewById(R.id.textNum1)
        textNum2 = findViewById(R.id.textNum2)
        val btnBorrar: Button = findViewById(R.id.btnBorrar)
        val btnIgual: Button = findViewById(R.id.btnIgual)

        btnIgual.setOnClickListener {
            var numero2: Double = textNum2.text.toString().toDouble()

            when (operacion) {
                1 -> respuesta = numero1 + numero2
                2 -> respuesta = numero1 - numero2
                3 -> respuesta = numero1 * numero2
                4 -> respuesta = numero1 / numero2
            }
            textNum2.setText(respuesta.toString())
            textNum1.setText("")
        }

        btnBorrar.setOnClickListener {
            textNum1.setText("")
            textNum2.setText("")
            numero1 = 0.0
            operacion = 0
        }
    }

    fun precionarDigito(digito: View) {
        //val textNum2: TextView = findViewById(R.id.textNum2)
        var num2: String = textNum2.text.toString()

        when (digito.id) {
            R.id.btn0 -> textNum2.setText(num2 + "0")
            R.id.btn1 -> textNum2.setText(num2 + "1")
            R.id.btn2 -> textNum2.setText(num2 + "2")
            R.id.btn3 -> textNum2.setText(num2 + "3")
            R.id.btn4 -> textNum2.setText(num2 + "4")
            R.id.btn5 -> textNum2.setText(num2 + "5")
            R.id.btn6 -> textNum2.setText(num2 + "6")
            R.id.btn7 -> textNum2.setText(num2 + "7")
            R.id.btn8 -> textNum2.setText(num2 + "8")
            R.id.btn9 -> textNum2.setText(num2 + "9")
            R.id.btnPunt -> textNum2.setText(num2 + ".")
        }
    }

    fun presionarOperacion(digito: View) {
        numero1 = textNum2.text.toString().toDouble()
        var num2_text: String = textNum2.text.toString()
        textNum2.setText("")

        //0= Nada, 1=Suma, 2=Resta, 3=Multiplicacion, 4=Division
        when (digito.id) {
            R.id.btnSum -> {
                textNum1.setText(num2_text + "+")
                operacion = 1
            }
            R.id.btnRest -> {
                textNum1.setText(num2_text + "-")
                operacion = 2
            }
            R.id.btnMult -> {
                textNum1.setText(num2_text + "*")
                operacion = 3
            }
            R.id.btnDiv -> {
                textNum1.setText(num2_text + "/")
                operacion = 4
            }
        }
    }

}