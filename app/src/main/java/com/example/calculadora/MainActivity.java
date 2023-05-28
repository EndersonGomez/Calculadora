package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextFirstNumber,editTextSecondNumber;
    private Button buttonAdd,buttonSubtract,buttonDivide,buttonMultiply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextFirstNumber = findViewById(R.id.editTextFirstNumber);
        editTextSecondNumber = findViewById(R.id.editTextSecondNumber);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonMultiply = findViewById(R.id.buttonMultiply);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacionSuma();
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacionResta();
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacionDividir();
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacionMultiplicar();
            }
        });
    }


    private void operacionSuma (){
        int numero1 = Integer.parseInt(editTextFirstNumber.getText().toString());
        int numero2 = Integer.parseInt(editTextSecondNumber.getText().toString());


        int resultado = numero1 + numero2;

        editTextFirstNumber.setText(numero1 + " + " + numero2);
        editTextSecondNumber.setText(String.valueOf(resultado));
    }

    private void operacionResta (){
        int numero1 = Integer.parseInt(editTextFirstNumber.getText().toString());
        int numero2 = Integer.parseInt(editTextSecondNumber.getText().toString());


        int resultado = numero1 - numero2;

        editTextFirstNumber.setText(numero1 + " - " + numero2);
        editTextSecondNumber.setText(String.valueOf(resultado));
    }

    private void operacionDividir (){
        int numero1 = Integer.parseInt(editTextFirstNumber.getText().toString());
        int numero2 = Integer.parseInt(editTextSecondNumber.getText().toString());


        int resultado = numero1 / numero2;

        editTextFirstNumber.setText(numero1 + " / " + numero2);
        editTextSecondNumber.setText(String.valueOf(resultado));
    }

    private void operacionMultiplicar (){
        int numero1 = Integer.parseInt(editTextFirstNumber.getText().toString());
        int numero2 = Integer.parseInt(editTextSecondNumber.getText().toString());


        int resultado = numero1 * numero2;

        editTextFirstNumber.setText(numero1 + " x " + numero2);
        editTextSecondNumber.setText(String.valueOf(resultado));
    }

}