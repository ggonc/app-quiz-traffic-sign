package com.mobile.quizplacas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FimDeJogo extends AppCompatActivity {

    public TextView textResultado, textAcertos;
    public ImageView imgMedal;
    public int acertos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fim_de_jogo);
        acertos = getIntent().getIntExtra("acertos", 0);
        textResultado = findViewById(R.id.textResultado);
        textAcertos = findViewById(R.id.textAcertos);
        imgMedal = findViewById(R.id.imgMedal);

        textAcertos.setText(String.valueOf(acertos));
        switch (acertos) {
            case 0: {
                textResultado.setText("Você não acertou nenhuma pergunta! Tente novamente!");
                imgMedal.setImageResource(R.drawable.game_over);
                break;
            }
            case 1: {
                textResultado.setText("Que pena! Você acertou apenas uma pergunta!");
                imgMedal.setImageResource(R.drawable.bronze);
                break;
            }
            case 2: {
                textResultado.setText("Parabéns, você acertou a maioria das perguntas!");
                imgMedal.setImageResource(R.drawable.silver);
                break;
            }
            case 3: {
                textResultado.setText("🎉 Uau! Você acertou todas as perguntas! 🎉");
                imgMedal.setImageResource(R.drawable.gold);
                break;
            }
        }

    }

    public void reiniciar(View view) {
        Intent intent = new Intent(FimDeJogo.this, Pergunta01.class);
        intent.putExtra("acertos", 0);
        startActivity(intent);
        finish(); // finish the Ranking activity
        finishAffinity(); // finish all activities in the task, including MainActivity
    }

    public void sair(View view) {
        finishAffinity();
    }
}