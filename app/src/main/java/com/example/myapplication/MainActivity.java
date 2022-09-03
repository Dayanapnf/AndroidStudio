package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // criando os representantes
    private EditText editAlcool, editGasolina;
    private TextView textDescricao, textResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // atrelando os representantes aos componetes
        editAlcool = findViewById(R.id.editEtanol);
        editGasolina = findViewById(R.id.editGasolina);


        textResultado = findViewById(R.id.textResultado);
        textDescricao = findViewById(R.id.textDescricao);

    }
    @SuppressLint("SetTextI18n")
    public void calcular (View viem){
        double precoGasolina = Double.parseDouble(editGasolina.getText().toString());
        double precoAlcool   = Double.parseDouble(editAlcool.getText().toString());
        double resultado     = precoAlcool/precoGasolina;

        /* se o preçoAlcool / precoGasolina >=0.7 -> utilizar gasolina
           senão -> utilizar alcool
         */
        textDescricao.setText(String.format("RESULTADO = %.4f",resultado) + "\n-ÁLCOOL: R$ "+ editAlcool.getText() + "\n-GASOLINA: R$ " + editGasolina.getText());
        if (resultado >= 0.7) {
            textResultado.setText("ABASTEÇA COM GASOLINA");
        } else {
            textResultado.setText("ABASTEÇA COM ÁLCOOL");
        }
        editAlcool.setText("");
        editGasolina.setText("");
    }

}