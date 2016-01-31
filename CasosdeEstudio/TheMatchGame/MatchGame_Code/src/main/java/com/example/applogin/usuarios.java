package com.example.applogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

public class usuarios extends AppCompatActivity {
    ListView listado;
    //EditText pp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios);
        listado = (ListView) findViewById(R.id.listView);
        //pp = (EditText) findViewById(R.id.pp);
       // pp.setText("Hola");
        listaUsuarios();
    }

    public void listaUsuarios(){
        AsyncHttpClient client = new AsyncHttpClient();
        String url="http://192.168.1.100:8080/loginAndroidPHP/data.php";

        RequestParams parametros = new RequestParams();

        client.post(url, parametros, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200) {
                    CargaLista(obtDatosJSON(new String(responseBody)));

                } else {
                    Toast.makeText(getApplicationContext(), "Loading...", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Crouton.makeText(usuarios.this, "FALLO GENERAL usuarios", Style.ALERT).show();
            }
        });
    }


    public void CargaLista(ArrayList<String> datos){
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, datos);

        listado.setAdapter(adapter);

    }


    public ArrayList<String> obtDatosJSON(String response){
        ArrayList<String> listado = new ArrayList<String>();
        try{
            JSONArray jsonArray= new JSONArray(response);
            String texto;
            for (int i=0;i<jsonArray.length();i++){
                //texto = jsonArray.getJSONObject(i).getString("name") +" ";
                texto = jsonArray.getJSONObject(i).getString("name") +", "+
                        jsonArray.getJSONObject(i).getString("age") +", "+
                        jsonArray.getJSONObject(i).getString("username") +", "+
                        jsonArray.getJSONObject(i).getString("password") +". ";

                listado.add(texto);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return listado;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_usuarios, menu);
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
