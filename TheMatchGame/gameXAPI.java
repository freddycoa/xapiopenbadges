Test Game xAPI

 
  wbXAPI = (WebView) findViewById(R.id.webView);
  wbXAPI.getSettings().setJavaScriptEnabled(true);
  wbXAPI.getSettings().getJavaScriptEnabled();
  wbXAPI.loadUrl("http://192.168.1.100:8080/AndroidDB/badgeMobile.php");
  wbXAPI.loadUrl("javascript:sendCalc('Badge of Android 2', 'Android', 'Android')");