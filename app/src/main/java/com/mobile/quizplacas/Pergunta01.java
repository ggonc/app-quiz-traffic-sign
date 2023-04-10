package com.mobile.quizplacas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Pergunta01 extends AppCompatActivity {

    public TextView textNumeroPergunta;
    public RadioGroup rgpAlternativas;
    public RadioButton rbtAlternativa1, rbtAlternativa2, rbtAlternativa3, rbtAlternativa4, radioButton;
    public Button btnResponder;
    public int acertos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta01);
        textNumeroPergunta = findViewById(R.id.textNumeroPergunta);
        rgpAlternativas = findViewById(R.id.rgpAlternativas);
        rbtAlternativa1 = findViewById(R.id.rbtAlternativa1);
        rbtAlternativa2 = findViewById(R.id.rbtAlternativa2);
        rbtAlternativa3 = findViewById(R.id.rbtAlternativa3);
        rbtAlternativa4 = findViewById(R.id.rbtAlternativa4);
        btnResponder = findViewById(R.id.btnResponder);
        btnResponder.setEnabled(false);
        textNumeroPergunta.setText("1/3");
        acertos = getIntent().getIntExtra("acertos", 0);
        RadioGroup rgpAlternativas = (RadioGroup) findViewById(R.id.rgpAlternativas);
        rgpAlternativas.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if (rgpAlternativas.getCheckedRadioButtonId() == -1)
                {
                    btnResponder.setEnabled(false);
                }
                else
                {
                    btnResponder.setEnabled(true);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    public void responder(View view){
        int selectedId = rgpAlternativas.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);

        if (radioButton.getText().equals("Sinalização de obras")){
            acertos += 1;
        }

        Intent pergunta02 = new Intent(this, Pergunta02.class);
        pergunta02.putExtra("acertos", acertos);
        startActivity(pergunta02);
    }
}