//**********************  Test Game xAPI  **************************//

 
  wbXAPI = (WebView) findViewById(R.id.webView);
  wbXAPI.getSettings().setJavaScriptEnabled(true);
  wbXAPI.getSettings().getJavaScriptEnabled();
  wbXAPI.loadUrl("http://192.168.1.100:8080/AndroidDB/badgeMobile.php");
  
  // Desde la linea 4 a 7 es recomendable colocarlo dentro del OnCreate, haciendo esto la lectura de url ya esta cargada al entrar a la
  // actividad que emitira el Badge
  
  wbXAPI.loadUrl("javascript:sendCalc('Badge of Android 2', 'Android', 'Android')");
  // el loadURL realiza el llamado remoto de la funcion javascript contenida dentro de la plataforma web
