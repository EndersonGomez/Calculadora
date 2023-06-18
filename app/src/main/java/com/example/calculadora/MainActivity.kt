package com.example.calculadora

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


//Cambia la manera en como se extiende sin necesidad del extends
class MainActivity : AppCompatActivity() {

    //Cambios en la sintaxis de la declaracion de variables y le
    private lateinit var editTextFirstNumber: EditText
    private lateinit var editTextSecondNumber: EditText
    //De igual manera se instancian con un valor nulo y con la posibilidad que luego se les agregue un objeto.
    private lateinit var buttonAdd: Button
    private lateinit var buttonSubtract: Button
    private lateinit var buttonDivide: Button
    private lateinit var buttonMultiply: Button
    private lateinit var buttonClose: Button
    private lateinit var buttonResset: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Log.d("prueba","funciona el oncreate")

        buttonClose = findViewById(R.id.buttonClose)
        editTextFirstNumber = findViewById(R.id.editTextFirstNumber)
        editTextSecondNumber = findViewById(R.id.editTextSecondNumber)
        buttonAdd = findViewById(R.id.buttonAdd)
        buttonSubtract = findViewById(R.id.buttonSubtract)
        buttonDivide = findViewById(R.id.buttonDivide)
        buttonMultiply = findViewById(R.id.buttonMultiply)
        buttonResset = findViewById(R.id.buttonResset)


        //Se usa el view directamente y ya no el new View.
        buttonClose.setOnClickListener(View.OnClickListener { finish() })

        buttonAdd.setOnClickListener(View.OnClickListener {
            if (validarCampos()) {
                operacionSuma()
            }
            Log.d("prueba2","llamada a la funcion sumar")
        })

        buttonSubtract.setOnClickListener(View.OnClickListener {
            if (validarCampos()) {
                operacionResta()
            }

            Log.d("prueba3", "llamada a la funcion resta")
        })

        buttonDivide.setOnClickListener(View.OnClickListener {
            if (validarCampos()) {
                operacionDividir()
            }
            Log.d("prueba4", "llamada a la funcion dividir")
        })

        buttonMultiply.setOnClickListener(View.OnClickListener {
            if (validarCampos()) {
                operacionMultiplicar()
            }
            Log.d("prueba5", "llamada a la funcion multiplicar")
        })

        buttonResset.setOnClickListener(View.OnClickListener {
            editTextFirstNumber.setText("")
            editTextSecondNumber.setText("")
            Log.d("prueba6", "boton formatear texto")
        })
    }


    //Se declara las funciones con la palabra reservada fun.
    private fun operacionSuma() {
        //Ya no es necesario declarar el tipo de variable cambia la clase getText a text
        //el parseo se hace con el metodo toInt.
        val numero1 = editTextFirstNumber.text.toString().toInt()
        val numero2 = editTextSecondNumber.text.toString().toInt()
        Log.d("prueba7","Se toman los valores en la operacion suma")
        val resultado = numero1 + numero2
        editTextFirstNumber.setText("$numero1 + $numero2")
        editTextSecondNumber.setText(resultado.toString())
       Log.d("prueba8", "Se hizo la suma y se setea el resultado en el editText")
    }

    private fun operacionResta() {
        val numero1 = editTextFirstNumber.text.toString().toInt()
        val numero2 = editTextSecondNumber.text.toString().toInt()
        Log.d("prueba9","Se toman los valores en la operacion resta")
        val resultado = numero1 - numero2
        editTextFirstNumber.setText("$numero1 - $numero2")
        editTextSecondNumber.setText(resultado.toString())
        Log.d("prueba10", "Se hizo la resta y se setea el resultado en el editText")

    }

    private fun operacionDividir() {
        val numero1 = editTextFirstNumber.text.toString().toInt()
        val numero2 = editTextSecondNumber.text.toString().toInt()
        Log.d("prueba11","Se toman los valores en la operacion dividir")
        val resultado = numero1 / numero2
        editTextFirstNumber.setText("$numero1 / $numero2")
        editTextSecondNumber.setText(resultado.toString())
        Log.d("prueba12", "Se hizo la divicion y se setea el resultado en el editText")

    }

    private fun operacionMultiplicar() {
        val numero1 = editTextFirstNumber.text.toString().toInt()
        val numero2 = editTextSecondNumber.text.toString().toInt()
        Log.d("prueba13","Se toman los valores en la operacion multiplicar")
        val resultado = numero1 * numero2
        editTextFirstNumber.setText("$numero1 x $numero2")
        editTextSecondNumber.setText(resultado.toString())
        Log.d("prueba14", "Se hizo la multiplicacion y se setea el resultado en el editText")

    }

    private fun validarCampos(): Boolean {
        val verificarPrimerCampo = editTextFirstNumber.text.toString().trim { it <= ' ' }
        val verificarSegundoCampo = editTextSecondNumber.text.toString().trim { it <= ' ' }
        Log.d("prueba15","Se toma los valores de los edittex para verificarlos")
        if (TextUtils.isEmpty(verificarPrimerCampo) || !verificarPrimerCampo.matches("\\d+".toRegex())
            || TextUtils.isEmpty(verificarSegundoCampo) || !verificarSegundoCampo.matches("\\d+".toRegex())
        ) {
            Log.d("prueba6","Se envia el mensaje si ahi algun error")
            Toast.makeText(applicationContext, "El campo no puede estar vacío o no es un número válido",
                Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }

    //La manera de trabajar con expresiones regulares cambia.
    private fun String.matches(regex: String): Boolean {

        val pattern = Regex(regex)
        return pattern.matches(this)
    }

}