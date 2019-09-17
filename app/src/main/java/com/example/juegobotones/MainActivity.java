package com.example.juegobotones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public int contadorRojo = 0;
    public int contadorAzul = 0;
    String mensaje = "NO HAY GANADORES";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ImageButton btnA1 = (ImageButton)findViewById(R.id.btnA1);
        final ImageButton btnA2 = (ImageButton)findViewById(R.id.btnA2);
        final ImageButton btnB1 = (ImageButton)findViewById(R.id.btnB1);
        final ImageButton btnB2 = (ImageButton)findViewById(R.id.btnB2);
        final TextView txtA= (TextView)findViewById(R.id.txtA);
        final TextView txtB= (TextView)findViewById(R.id.txtB);
        final Button btnWin = (Button)findViewById(R.id.btnGanador);

        btnWin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"GANADOR : " + mensaje, Toast.LENGTH_SHORT).show();
            }
        });


        btnA1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch(motionEvent.getAction())
                {
                    case MotionEvent.ACTION_DOWN :
                        btnA1.setImageResource(R.drawable.naranjadebil);
                        break;
                    case MotionEvent.ACTION_UP :
                        btnA1.setImageResource(R.drawable.naranjafuerte);
                        break;
                }
                return false;
            }
        });

        btnA2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch(motionEvent.getAction())
                {
                    case MotionEvent.ACTION_DOWN :
                        btnA2.setImageResource(R.drawable.naranjadebilmenos);
                        break;
                    case MotionEvent.ACTION_UP :
                        btnA2.setImageResource(R.drawable.naranjafuertemenos);
                        break;
                }
                return false;
            }
        });

        btnB1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch(motionEvent.getAction())
                {
                    case MotionEvent.ACTION_DOWN :
                        btnB1.setImageResource(R.drawable.azuldebil);
                        break;
                    case MotionEvent.ACTION_UP :
                        btnB1.setImageResource(R.drawable.azulfuerte);
                        break;
                }
                return false;
            }
        });

        btnB2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch(motionEvent.getAction())
                {
                    case MotionEvent.ACTION_DOWN :
                        btnB2.setImageResource(R.drawable.azuldebilmenos);
                        break;
                    case MotionEvent.ACTION_UP :
                        btnB2.setImageResource(R.drawable.azulfuertemenos);
                        break;
                }
                return false;
            }
        });



        btnA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ++contadorRojo;
                txtA.setText(String.valueOf(contadorRojo));
                Validar();

            }
        });

        btnA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(contadorRojo > 0 ){
                    --contadorRojo;
                }
                txtA.setText(String.valueOf(contadorRojo));
                Validar();
            }
        });

        btnB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ++contadorAzul;
                txtB.setText(String.valueOf(contadorAzul));
                Validar();
            }
        });

        btnB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(contadorAzul > 0 ){
                    --contadorAzul;
                }
                txtB.setText(String.valueOf(contadorAzul));
                Validar();
            }
        });



    }

    public boolean Validar(){

        if(contadorAzul > contadorRojo){
            mensaje = "EQUIPO AZUL";
            return true;
        }
        if(contadorAzul < contadorRojo){
            mensaje = "EQUIPO ANARANJADO";
            return true;
        }
        if(contadorAzul == contadorRojo){
            mensaje = "EMPATE";
            return true;
        }
        return false;
    }


}
