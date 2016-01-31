# Desarrollado en HTML y Javascript, se basa en preguntas y respuestas.


La compañia encargada del desarrollo del Juego debe proporcionar la imagen que se utilizara para emitir el Badge, dicha imagen debe estar en formato PNG y no pesar mas de 250 kb.


Repositorio de Estandar de de emision de badges a traves de una sola plataforma mediante la combinancion de estandares, los principales para comunicación xAPI (ADL), Openbadges (Mozilla). A continuacion se mostraran tres carpetas en la que cada una tendra un ejemplo de comunicación y emision de badges a traves del estandar propuesto.


```javascript


// *************************      Test Game xAPI        ************************* //

// Un pequeño ejemplo de condición de respuestas de un juego de Preguntas y Respuestas en HTML 
 if(a == respuestacorrecta){  // condicional para comprobar la respuesta
		        
	var bueno= document.getElementById('progresobueno').style.width = contAciertos+"%"; // barra de progreso de respuestas correctas
		contAciertos = contAciertos + 25;
			if(contNextQuestion > 4 && contAciertos >= 75){  // Condiciones superadas para emision de badge
				sendingResults('<div class="alert alert-success">You Win</div>'); // Declarando Ganador
				sendBadge('The Quiz Game', 'Results', 'Winner'); // Envio de badge al servidor LRS
			}
	        } else {
        var malo= document.getElementById('progresomalo').style.width = contInciertos+"%"; // barra de progreso de respuestas incorrectas
        		contInciertos = contInciertos + 50;
        		if(contInciertos > 100 ){
        			sendingResults('<div class="alert alert-danger">You Lose</div>'); // Declarando Perdedor
        		}
 }


// Como se puede observar en la función de envios de Badges, la cantidad de variables a enviar va a depender 
// de las variables que usted necesite para la emision del Badge, para una mejor descripcion por favor verificar el archivo functionXAPI.js
// en la funcion sendBadge observara un formato JSON el cual es el establecido para la emision del Badge. 

```

### Estructura Web y llamado de funciones Javascript a partir de la Libreria ADL-xapiwrapper

1. Se estable Web principal contenedora de las funciones javascript, es importante hacer el llamado o incluir los ficheros Js en la Web como se indica en la parte inferior.
	* xapiwrapper: Libreria comunicación ADL-LRS.
	* config: Configuracion de datos de acceso de usuario Entidad del Juego.
	* functions: Funcion establecida para el envio de datos del Badge.

```html
<script src="js/xapiwrapper.min.js"></script>
<script src="js/config.js"></script>
<script src="js/functions.js"></script>

```





![GitHub Logo](Images/Imagen2.png)
