function sesion()
{
	var xmlhttp;
	var user = document.formSesion.email.value;
	var pass = document.formSesion.password.value;
	
		if (window.XMLHttpRequest)
		  {// code for IE7+, Firefox, Chrome, Opera, Safari
		  xmlhttp=new XMLHttpRequest();
		  }
		else
		  {// code for IE6, IE5
		  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		  }
		xmlhttp.onreadystatechange=function()
		  {
		  if (xmlhttp.readyState==4 && xmlhttp.status==200)
			{
			document.getElementById("status").innerHTML=xmlhttp.responseText;
			GetStatements(25,null,null,viewer);
			var pagina=""
			location.href=pagina
			
			} 
			else {
			document.getElementById("status").innerHTML="cargando";
				}
		  }
	xmlhttp.open("POST","modelo/sesion.php",true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("user="+user+"&pass="+pass);
}


function salir()
{
	var xmlhttp;
	var user = document.getElementById("actor").value;
	
		if (window.XMLHttpRequest)
		  {// code for IE7+, Firefox, Chrome, Opera, Safari
		  xmlhttp=new XMLHttpRequest();
		  }
		else
		  {// code for IE6, IE5
		  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		  }
		xmlhttp.onreadystatechange=function()
		  {
		  if (xmlhttp.readyState==4 && xmlhttp.status==200)
			{
			var pagina=""
			location.href=pagina
			
			} 
		  }
	xmlhttp.open("POST","modelo/salir.php",true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("user="+user);
}
