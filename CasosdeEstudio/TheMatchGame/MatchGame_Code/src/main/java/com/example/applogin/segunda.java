package com.example.applogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class segunda extends AppCompatActivity {
    TextView tv_nombre;
    Button Suma, Resta, Multiplica, Divide;


    /*final int rand_A = (int) ((Math.random() * 10) + 1);
    final int rand_B = (int) ((Math.random()) * 10 + 1);*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        tv_nombre = (TextView) findViewById(R.id.tv_nombre);

        Aplicacion app = (Aplicacion) getApplicationContext();

        tv_nombre.setText(app.getUsuario());

        Operar();
    }

    public void Operar(){
        Suma = (Button) findViewById(R.id.et_suma);
        Resta = (Button) findViewById(R.id.et_resta);
        Multiplica = (Button) findViewById(R.id.et_multiplica);
        Divide = (Button) findViewById(R.id.et_divide);
        Button xapiButton = (Button) findViewById(R.id.bt_xapi);

        final Calculos cal = new Calculos();


        Suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), Operacion.class));
                finish();
                //cal.setA(rand_A);
               // cal.setB(rand_B);
                cal.setOperador("+");
            }
        });

        Resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(segunda.this, Operacion.class));
                cal.setOperador("-");
            }
        });

        Multiplica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(segunda.this, Operacion.class));
                cal.setOperador("*");
            }
        });

        Divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(segunda.this, Operacion.class));
                cal.setOperador("/");
            }
        });

        xapiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(segunda.this, TestXAPI.class));
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_segunda, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
