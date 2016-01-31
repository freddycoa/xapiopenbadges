package com.example.applogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class badgeEmitido extends AppCompatActivity {

    ImageView badge;
    WebView wbXAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badge_emitido);

        badge = (ImageView) findViewById(R.id.imageView);

        Button salir = (Button)findViewById(R.id.bt_salir);

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(badgeEmitido.this, MainActivity.class));
            }
        });

       // badgeEmition();


    }


    public void badgeEmition(){

        wbXAPI = (WebView) findViewById(R.id.webView);

        wbXAPI.getSettings().setJavaScriptEnabled(true);
        wbXAPI.getSettings().getJavaScriptEnabled();
        wbXAPI.setWebChromeClient(new WebChromeClient());
        wbXAPI.setWebViewClient(new WebViewClient());
        wbXAPI.getSettings().setDomStorageEnabled(true);


        wbXAPI.loadUrl("http://192.168.1.39:8080/AndroidDB/badgeMobile.php");
      //  wbXAPI.loadUrl("javascript:sendCalc('Badge of Android', 'Android', 'Android')");


        Toast.makeText(getApplicationContext(), "Registro Exitoso", Toast.LENGTH_LONG).show();

    }
}
