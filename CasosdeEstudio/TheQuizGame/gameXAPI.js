var contador = 0; // INICIAMOS CONTADOR EN 0
var q;

function reloj(){
	q  = setInterval(contar,1000); // CONTADOR POR INTERVALO DE SEGUNDOS
}


function contar(){
	contador++;
	document.getElementById("temporizador").innerHTML = contador;

	if(contador == 25){
		clearInterval(q);
		document.getElementById("temporizador").innerHTML = "Sorry budy, but try again.. !!";
		contador = 0;

		// Modal function Bootstrap
		$('#myModal').modal('show');
		// end function
	}

	}


var contNextQuestion = 0;
var contAciertos = 25;
var contInciertos = 50;
		$(document).ready(function(){
		    $("#testInit").click(function(){
		        $("#questiones").load("views/viewQuestion.php?contadorPreguntas="+contNextQuestion);
		        reloj();
		        contNextQuestion++;
		    });

		    $("#next").click(function(){

		    	if(contNextQuestion < 4){
		        $("#questiones").load("views/viewQuestion.php?contadorPreguntas="+contNextQuestion);
		        contNextQuestion++;
		        contador = 0;
			    } else {
			    		clearInterval(q);
			    		contador = "The Game is Finished";
			    		contNextQuestion++;
			    }

		        var a = document.formRequest.opcionRes.value; // obtengo valor del radio seleccionado en la respuesta
		        var respuestacorrecta = document.formRequest.respuestacorrecta.value; // obtengo el valor de la respuesta correcta

		        if(a == respuestacorrecta){  // condicional para comprobar la respuesta
		        		//document.getElementById('testoption').innerHTML = "correcto" + contNextQuestion;
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

		    });

		});



function sendingResults(id){
	clearInterval(q);
	document.getElementById("infoResults").innerHTML = id;
	$('#myModal').modal('show');
}
