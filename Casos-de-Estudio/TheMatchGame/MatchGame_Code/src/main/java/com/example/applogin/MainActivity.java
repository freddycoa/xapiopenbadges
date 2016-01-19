package com.example.applogin;

import android.app.Notification;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
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

public class MainActivity extends AppCompatActivity {
    EditText et_login;
    EditText et_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_login = (EditText) findViewById(R.id.et_login);
        et_password = (EditText) findViewById(R.id.et_password);
    }

    public void ValidarOnclick(View v){
        AsyncHttpClient client = new AsyncHttpClient();
        String url="http://192.168.1.39:8080/loginAndroidPHP/FetchUserData.php";

        RequestParams requestParams = new RequestParams();
        requestParams.add("username", et_login.getText().toString());
        requestParams.add("password", et_password.getText().toString());

        RequestHandle post= client.post(url, requestParams, new AsyncHttpResponseHandler() {
            String usuario= null;

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if(statusCode==200){
                    try {
                        JSONObject o = new JSONObject(new String(responseBody));
                        usuario = o.getString("username");

                        if(!TextUtils.isEmpty(usuario)){
                            Aplicacion app = (Aplicacion) getApplicationContext();
                            app.setUsuario(usuario);
                           // segunda sg = new segunda();
                           // sg.tv_nombre.setText(usuario);
                            startActivity(new Intent(MainActivity.this, segunda.class));
                        } else {
                            Crouton.makeText(MainActivity.this,"Error de ingreso", Style.ALERT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Crouton.makeText(MainActivity.this,"Error de ingreso", Style.ALERT).show();
                    }
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Crouton.makeText(MainActivity.this,"FALLO GENERAL", Style.ALERT).show();

            }
        });
    }

    public void VistaListadoUsuarios(View v){
        Intent intent = new Intent(MainActivity.this, usuarios.class);
        startActivity(intent);
    }

    public void VistaRegistroUsuarios(View v){
        startActivity(new Intent(MainActivity.this, Registro.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
