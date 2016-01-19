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


// Como se puede observar en la linea 10, se ejecuta la función de envios de Badges, la cantidad de variables a enviar va a depender 
// de las variables que usted necesite para la emision del Badge, para una mejor descripcion por favor verificar el archivo functionXAPI.js
// en la funcion sendBadge observara un formato JSON el cual es el establecido para la emision del Badge. 

