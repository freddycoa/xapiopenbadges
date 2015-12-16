//**********************  Test Game xAPI  **************************//

 
  wbXAPI = (WebView) findViewById(R.id.webView);
  wbXAPI.getSettings().setJavaScriptEnabled(true); // Habilitamos el JS para poder ejecutar funciones remotas.
  wbXAPI.getSettings().getJavaScriptEnabled();
  wbXAPI.loadUrl("http://192.168.1.100:8080/AndroidDB/badgeMobile.php"); // url de la Pagina Web que contiene las funciones JS para la Emision del Badge
  
  // Desde la linea 4 a 7 es recomendable colocarlo dentro del OnCreate activando todas las funciones que se encuentren dentro de este al cargar la actividad,
  // haciendo esto la lectura de url ya esta cargada al entrar a la actividad que emitira el Badge
  
  wbXAPI.loadUrl("javascript:sendBadge('Badge of Android 2', 'Android', 'Android')");
  // el loadURL realiza el llamado remoto de la funcion javascript contenida dentro de la plataforma web
  // este funcion o fragmento de codigo se debe colocar dondo esten establecidas las condiciones para emitir el Badge, ejemplo al 
  // superar cierta cantidad de puntaje emite un Badge
