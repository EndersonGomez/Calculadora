package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextFirstNumber,editTextSecondNumber;
    private Button buttonAdd,buttonSubtract,buttonDivide,buttonMultiply,buttonClose,buttonResset ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonClose = findViewById(R.id.buttonClose);
        editTextFirstNumber = findViewById(R.id.editTextFirstNumber);
        editTextSecondNumber = findViewById(R.id.editTextSecondNumber);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonResset = findViewById(R.id.buttonResset);

        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validarCampos()){
                    operacionSuma();
                }

            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validarCampos()){
                    operacionResta();
                }

            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validarCampos()){
                    operacionDividir();
                }

            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validarCampos()){
                    operacionMultiplicar();
                }

            }
        });

        buttonResset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextFirstNumber.setText("");
                editTextSecondNumber.setText("");
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

    private boolean validarCampos() {
        String verificarPrimerCampo = editTextFirstNumber.getText().toString().trim();
        String verificarSegundoCampo = editTextSecondNumber.getText().toString().trim();

        if (TextUtils.isEmpty(verificarPrimerCampo) || !verificarPrimerCampo.matches("\\d+")
                || TextUtils.isEmpty(verificarSegundoCampo) || !verificarSegundoCampo.matches("\\d+")) {
            Toast.makeText(getApplicationContext(), "El campo no puede estar vacío o no es un número válido", Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }



}