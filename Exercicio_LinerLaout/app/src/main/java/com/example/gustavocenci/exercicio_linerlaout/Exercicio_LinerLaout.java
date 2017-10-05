package com.example.gustavocenci.exercicio_linerlaout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ImageView;

public class Exercicio_LinerLaout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio__liner_laout);

        ImageView r = (ImageView)findViewById(R.id.imagem);
        r.setImageResource(R.drawable.eu);

    }

}
