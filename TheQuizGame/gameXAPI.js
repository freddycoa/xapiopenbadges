// *************************      Test Game xAPI        ************************* //

// Un pequeño ejemplo condiciono respuestas correctas 
 if(a == respuestacorrecta){  // condicional para comprobar la respuesta
		        
		        	var bueno=	document.getElementById('progresobueno').style.width = contAciertos+"%";
		        		contAciertos = contAciertos + 25;
		        		if(contNextQuestion > 4 && contAciertos >= 75){ // condiciones superadas para emision de badge
		        			sendingResults('<div class="alert alert-success">You Win</div>');
		        			sendCalc('The Quiz Game', 'Results', 'Winner'); // envio de badge al servidor LRS
		        		}
		        } else {
		        		//document.getElementById('testoption').innerHTML = "inconrrecto";
		        	var malo=	document.getElementById('progresomalo').style.width = contInciertos+"%";
		        		contInciertos = contInciertos + 50;
		        		if(contInciertos > 100 ){
		        			sendingResults('<div class="alert alert-danger">You Lose</div>');
		        		}
 }


