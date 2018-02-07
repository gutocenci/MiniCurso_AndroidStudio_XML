package com.example.gustavocenci.imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;

import org.w3c.dom.Text;

import static com.example.gustavocenci.imc.R.id.editTextAltura;
import static com.example.gustavocenci.imc.R.id.editTextPeso;
import static com.example.gustavocenci.imc.R.id.radioFeminino;
import static com.example.gustavocenci.imc.R.id.textViewSaude;
import static com.example.gustavocenci.imc.R.id.textViewresultepeso;
import static com.example.gustavocenci.imc.R.id.textViewresultimc;

public class IMCalculator extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder calcCalculos = new ViewHolder();
    RadioButton rMasculino;
    RadioButton rFeminino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imcalculator);

        ImageView r = (ImageView) findViewById(R.id.imageView);
        r.setImageResource(R.drawable.download);

        this.calcCalculos.Altura = (EditText) findViewById(editTextAltura);
        this.calcCalculos.Peso = (EditText) findViewById(editTextPeso);
        this.calcCalculos.Saude = (TextView) findViewById(textViewSaude);
        this.calcCalculos.resultPeso = (TextView) findViewById(textViewresultepeso);
        this.calcCalculos.resultImc = (TextView) findViewById(textViewresultimc);
        this.calcCalculos.Calcular = (Button) findViewById(R.id.buttonCalcular);
        rMasculino = (RadioButton) findViewById(R.id.radioMasculino);
        rFeminino = (RadioButton) findViewById(R.id.radioFeminino);

        this.calcCalculos.Calcular.setOnClickListener(this);

        this.LimparValor();
    }

    public void onClick(View view) {

        int id = view.getId();
        if (id == R.id.buttonCalcular) {
            Double valor_a = Double.valueOf(this.calcCalculos.Altura.getText().toString());
            Double valor_p = Double.valueOf(this.calcCalculos.Peso.getText().toString());
            Double valot_alt;
            Double valor_pe;
            Double valor_ideal;
            valor_a = valor_a * valor_a;
            valor_pe = valor_p / valor_a;
            //this.calcCalculos.resultImc.setText(String.format("%.2f",valor_pe));
            this.calcCalculos.resultImc.setText("GEGEGEGEGEGEGEGEGEGEGE");
            if (valor_pe < 18.5) {
                this.calcCalculos.Saude.setText("Abaixo do peso");
            } else if (valor_pe < 24.9) {
                this.calcCalculos.Saude.setText("Peso normal");
            } else if (valor_pe < 30.0) {
                this.calcCalculos.Saude.setText("Acima do peso");
            } else {
                this.calcCalculos.Saude.setText("Peso muito elevado");
            }
           // if (rFeminino.isChecked()) {
                valor_ideal = ((valor_a * 100) - 100) * 0.85;
                this.calcCalculos.resultPeso.setText(String.format("%.2f",valor_ideal));
            //}
            if (rMasculino.isChecked()) {
                valor_ideal = ((valor_a * 100) - 100) * 0.9;
                this.calcCalculos.resultPeso.setText(String.format("%.2f",valor_ideal));
            }
        }
    }

    public void LimparValor() {
        this.calcCalculos.Altura.setText("");
        this.calcCalculos.Peso.setText("");
        this.calcCalculos.Saude.setText("");
       // this.calcCalculos.resultPeso.setText("");
       // this.calcCalculos.resultImc.setText("");
    }

    private static class ViewHolder {
        EditText Altura;
        EditText Peso;
        TextView Saude;
        TextView resultPeso;
        TextView resultImc;
        Button Calcular;
    }
}
