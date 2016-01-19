package com.example.applogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

public class Operacion extends AppCompatActivity {
    TextView operador;
    TextView a, b, result;
    EditText request;
    WebView wbXAPI;
    int op, rand_A, rand_B, conversionInteger, contadorLevel = 0;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operacion);


        Calculos cal = new Calculos();


        operador = (TextView) findViewById(R.id.tv_operador);
        operador.setText(cal.operador);

        a = (TextView) findViewById(R.id.et_A);
        b = (TextView) findViewById(R.id.et_B);

         rand_A = (int) ((Math.random() * 10) + 1);
         rand_B = (int) ((Math.random()) * 10 + 1);

        a.setText("" + rand_A);
        b.setText("" + rand_B);

        badgeEmition();

    }


    public void sendRequest(View v){
        request = (EditText) findViewById(R.id.et_request);
        result = (TextView) findViewById(R.id.tv_result);
        Button g = (Button) findViewById(R.id.bt_level);

       conversionInteger = Integer.parseInt(request.getText().toString());

        switch(operador.getText().toString()){
            case "+":
                op = rand_A + rand_B;
                break;
            case "-":
                op = rand_A - rand_B;
                break;
            case "*":
                op = rand_A * rand_B;
                break;
            case "/":
                op = rand_A / rand_B;
                break;
            default:
                break;
        }

        if(conversionInteger == op){
            if(contadorLevel == 2){
                //badgeEmition();
                wbXAPI.loadUrl("javascript:sendCalc('Badge of Android 2', 'Android', 'Android')"); // Ejecuta el javascript remoto
                Toast.makeText(getApplicationContext(), "Registro Exitoso", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getBaseContext(), badgeEmitido.class)); // Envia Pagina de Badge obtenido
                //finish();
            } else {
                g.setVisibility(View.VISIBLE);
                result.setText("Good Job");
            }
        } else {
            result.setText("I am Sorry, try again :) , the result is: " + op);
            g.setVisibility(View.INVISIBLE);
        }
    }

    public void nextLevel(View v){
        //contadorLevel++;
        if(contadorLevel == 0){
            rand_A = (int) ((Math.random() * 30 - 20) + 20);
            rand_B = (int) ((Math.random() * 30 - 20) + 20);
            contadorLevel = 1;
        }
        if(contadorLevel == 1){
            rand_A = (int) ((Math.random() * 100 - 50) + 50);
            rand_B = (int) ((Math.random() * 100 - 50) + 50);
            contadorLevel = 2;
        }


        a.setText("" + rand_A);
        b.setText("" + rand_B);

    }



                 /*  try {
                    JSONObject o = new JSONObject(new String(responseBody));
                    valorEnviado = o.getString("name");

                    if(!TextUtils.isEmpty(valorEnviado)){

                        Crouton.makeText(Operacion.this,valorEnviado, Style.CONFIRM).show();
                    } else {
                        Crouton.makeText(Operacion.this,"Error de ingreso", Style.ALERT).show();
                    }
                    } catch (JSONException e) {
                       Crouton.makeText(Operacion.this,"Error de ingresooooo", Style.ALERT).show();
                        e.printStackTrace();
                    }*/

    /*public void badgeEmition(){

        wbXAPI = (WebView) findViewById(R.id.webView);

        wbXAPI.getSettings().setJavaScriptEnabled(true);
        wbXAPI.getSettings().getJavaScriptEnabled();
        wbXAPI.setWebChromeClient(new WebChromeClient());
        wbXAPI.setWebViewClient(new WebViewClient());
        wbXAPI.getSettings().setDomStorageEnabled(true);

        wbXAPI.loadUrl("http://192.168.1.39:8080/AndroidDB/badgeMobile.php");
        wbXAPI.loadUrl("javascript:sendCalc('Badge of Android', 'Android', 'Android')");

        Toast.makeText(getApplicationContext(), "Registro Exitoso", Toast.LENGTH_LONG).show();

    }*/


    public void badgeEmition(){

        wbXAPI = (WebView) findViewById(R.id.webView);

        wbXAPI.getSettings().setJavaScriptEnabled(true);
        wbXAPI.getSettings().getJavaScriptEnabled();
        wbXAPI.setWebChromeClient(new WebChromeClient());
        wbXAPI.setWebViewClient(new WebViewClient());
        wbXAPI.getSettings().setDomStorageEnabled(true);


        wbXAPI.loadUrl("http://192.168.1.100:8080/AndroidDB/badgeMobile.php");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_operacion, menu);
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
