package com.example.gustavocenci.jogo_da_velha;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class jogo_da_velha extends AppCompatActivity {

    public final String Bola = "O";
    public final String X = "X";

    private String player = "X";

    private View view;

    int[][] Fim = new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9},
            {1, 5, 9},
            {3, 5, 7}
    };

    @SuppressLint("InflateParams")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView(getLayoutInflater().inflate(R.layout.activity_jogo_da_velha, null));
        setContentView(getView());
    }

    public void clickQuadrado(View v){

        if(!FimJogo()){
            if(((Button) v).getText().equals("")){
                if(player.equals(X)){
                    ((Button) v).setText(Bola);
                    setPlayer(Bola);
                }else{
                    ((Button) v).setText(X);
                    setPlayer(X);
                }
            }else{
                Toast.makeText(getView().getContext(), "Escolha outro quadrado", Toast.LENGTH_SHORT).show();
            }
            FimJogo();
        }
    }

    public boolean FimJogo(){
        for(int a = 0; a<=7; ++a){
            String n1 = getQuadrado(Fim[a][0]).getText().toString();
            String n2 = getQuadrado(Fim[a][1]).getText().toString();
            String n3 = getQuadrado(Fim[a][2]).getText().toString();

            if((!n1.equals("")) && (!n2.equals("")) && (!n3.equals(""))){
                //Corquadrados(Fim[a][0], R.color.vermelho);
                //Corquadrados(Fim[a][1], R.color.vermelho);
                //Corquadrados(Fim[a][2], R.color.vermelho);
                Toast.makeText(getView().getContext(), "Mensagem que me escapou (não consegui ler no datashow)", Toast.LENGTH_SHORT).show();
                return true;
            }

        }
        return false; //VERIFICAR SE ESTÁ NO LUGAR CERTO
    }

    public Button getQuadrado(int tagNum){
        String quadrados = "quadrado";
        return (Button)getView().findViewWithTag(quadrados + tagNum);
    }
    public void jogar(View in){
        setEnableQuadrado(true);

        Limpar();

        RadioButton Esc0 = (RadioButton) getView().findViewById(R.id.radio1);

        if(Esc0.isChecked()){setPlayer(X);}
        else{setPlayer(Bola);}
    }
    public void Limpar(){
        for(int j = 1; j <= 9; ++j){
            if(getQuadrado(j) != null){
                //Corquadrados(j, R.color.preto);
                getQuadrado(j).setText("");
            }
        }
    }
    public void setEnableQuadrado(Boolean n){
        for(int i = 1; i <= 9; ++i){
            if(getQuadrado(i) != null){
                getQuadrado(i).setEnabled(n);
            }
        }
    }
    public void setPlayer(String player){this.player = player;}
    public View getView(){return view;}
    public void setView(View view){this.view = view;}

}
