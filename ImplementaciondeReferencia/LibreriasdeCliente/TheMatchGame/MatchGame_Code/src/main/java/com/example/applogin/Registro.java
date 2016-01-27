package com.example.applogin;

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

public class Registro extends AppCompatActivity {

    EditText et_name;
    EditText et_age;
    EditText et_usr;
    EditText et_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        et_name = (EditText) findViewById(R.id.et_name);
        et_age = (EditText) findViewById(R.id.et_age);
        et_usr = (EditText) findViewById(R.id.et_usr);
        et_pass = (EditText) findViewById(R.id.et_pass);
    }


    public void ValidarRegistro(View v){
        AsyncHttpClient client = new AsyncHttpClient();
        String url="http://192.168.1.39:8080/loginAndroidPHP/Register.php";

        RequestParams requestParams = new RequestParams();
        requestParams.add("name", et_name.getText().toString());
        requestParams.add("age", et_age.getText().toString());
        requestParams.add("username", et_usr.getText().toString());
        requestParams.add("password", et_pass.getText().toString());

        RequestHandle post= client.post(url, requestParams, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if(statusCode==200){
                   // Crouton.makeText(Registro.this, "Registro Exitoso", Style.CONFIRM).show();
                    Toast.makeText(getApplicationContext(), "Registro Exitoso", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Registro.this, MainActivity.class));
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Crouton.makeText(Registro.this,"FALLO GENERAL", Style.ALERT).show();

            }
        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registro, menu);
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
