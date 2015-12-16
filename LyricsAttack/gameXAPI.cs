# xapiopenbadges
// Emision de Badges


      Application.LoadLevel ("_Escenariofinal"); // al cumplir la condicion de aprobación se lee el escenario final

			string url = "http://localhost:8080/AndroidDB/BadgeMobile.php?var1=value2&amp;var2=value2"; 
			// Asignamos la url y las variables que se enviaran a la plataforma web que posea las Funciones Javascript xAPI
			
			WWW www = new WWW(url);
			StartCoroutine(WaitForRequest(www));
			
			// de esta forma hacemos el llamado de la funcion XAPI y envio de datos que se cargaran dentro del Badge
