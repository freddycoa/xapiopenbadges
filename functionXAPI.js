function sendCalc(idCalc, resultCalc, exito) {
	//document.getElementById('div1').innerHTML="hola mundo";
    var d = new Date();
    doConfig();

    // statement for launching content
        var stmt = {
    "actor": {
        "mbox": "mailto:fcoa@ucm.es",
        "name": "fredsom",
        "objectType": "Agent"
    },
    "verb": {
        "id": "http://xapi.sigescar.com.ve/verbs/calculo",
        "display": {
            "en-US": "Bagde"
        }
    },
    "object": {
        "id": "http://xapi.sigescar.com.ve/activities/sesion",
        "definition": {
            "name": {
                "en-US": idCalc
            },
            "description": {

               // "en-US": "Calculos Matematicos "+exito+" Respuesta: "+ resultCalc
			   
			   "en-US": "Math Calcs",
			   
			    "time": {
                "hour": d.getHours(),
                "minutes": d.getMinutes(),
                "seconds": d.getSeconds()
                    },
                    
                "points": {
                "score": 0,
                "potition": 80,
                    },
				
				"level": {
                "number": 0,
                "description" : "Maximo Nivel"
                    },
                
                "potition": {
                "number": 0,
                "description" : "potition is ..",
                "total" : 10
                    },
                
                "end": {
                "date": d.getDay() + "/" + d.getMonth() + "/" + d.getFullYear(),
                "description" : "Description end",
                    },
                
                "grade": {
                "number": 0,
                "description" : "Premio en Calculos Matematicos",
                "imagebadge" : "http://www.xapi.sigescar.com.ve/badge/584669.png",
                    }
            }
        },
        "objectType": "Activity"
    }
}; // or session.getValue

    // Send launched statement
     ADL.XAPIWrapper.sendStatement(stmt);

	// var pag= "http://xapi.sigescar.com.ve/badges/1.json";
	 
	 //seleccionarC(pag);
	 
    // $("#sent-statements").html('SU DATO HA SIDO REGISTRADO EN LRS SERVER');
	
}
