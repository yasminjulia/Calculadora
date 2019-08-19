package com.example.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textPercent, textGorjeta, textTotal;
    private EditText valor;
    private SeekBar goigeta;
    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textPercent = findViewById(R.id.textPorcentagem);
        textGorjeta = findViewById(R.id.textGorjeta);
        textTotal = findViewById(R.id.textTotal);
        valor = findViewById(R.id.editValor);
        goigeta = findViewById(R.id.Gorjeta);

        goigeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                porcentagem = seekBar.getProgress();
                textPercent.setText(porcentagem + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        public void calcular() {
            double valorDigitado = Double.parseDouble(valor.getText().toString());
            // calcula gorjeta total
        double gorjeta = valorDigitado * (porcentagem/100);
        double total = gorjeta + valorDigitado;
        textGorjeta.setText("R$: " + Math.round(gorjeta));
        textTotal.setText("R$: " + total);


        }
    }

}
