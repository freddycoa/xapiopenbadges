// Global Actor
actor = getActor();

/* Page Change Logic */
if ( actor  == false ) {
    checkLoggedIn();
} else { // silly thing to wrap in an else but I need to restructure the code to handle a missing actor on login page

    doConfig();

    // Abstracted page changing logic -- catch-all
    $( window ).on("pagechange", function(event) {

        var chapter = $("body").attr("data-chapter");
        var pageID = $.mobile.activePage.attr("id");
        var activityID = moduleID + chapter + "/" + pageID;

        var stmt = {
            "actor": actor,
            "verb": ADL.verbs.experienced,
            "context": createContext(),
            "object": {
                "id" : activityID,
                "objectType": "Activity",
                "definition": {
                    "name": {
                        "en-US": moduleName + ": " + chapter + ", page: " + pageID
                    }
                }
            }
        };

        // Send a statement
        ADL.XAPIWrapper.sendStatement(stmt);

    });
} // end silly else

/* Helpers */
function doConfig() { // sorry
    Config.actor = actor;
    ADL.XAPIWrapper.changeConfig(Config);
}

function getPage() {
    var url = window.location.pathname;
    var filename = url.substring(url.lastIndexOf('/')+1);
    return filename;
}

/* Name, Email, Actor, gets and sets */

// Actor
function getActor() {
    var name = localStorage.getItem("xapi-jqm/name");
    var email = localStorage.getItem("xapi-jqm/email");
    if ( name == null || email == null ) {
        return false;
    } else {
        var actor = { "mbox": "mailto:" + email, "name": name };
        return actor;
    }
}
function setActor( name, email ) {
    setUserName(name);
    setUserEmail(email);
}

// Name
function getUserName() {
    return localStorage.getItem("xapi-jqm/name");
}
function setUserName(name) {
    localStorage.setItem("xapi-jqm/name", name);
}

// Email
function getUserEmail() {
    return localStorage.getItem("xapi-jqm/email");
}
function setUserEmail(email) {
    localStorage.setItem("xapi-jqm/email", email);
}

// Destroy all the things
function clearActor() {
    localStorage.removeItem("xapi-jqm/name");
    localStorage.removeItem("xapi-jqm/email");
}

/* Login / Logout functions */
function checkLoggedIn() {
    // If the actor doesn't exist, send them to the login page
    if ( getPage() != "00-account.html" ) {
        userLogin();
    }
}

function userLogin() {
    // Should get the page root
   // window.location = "chapters/00-account.html#login";
}

function userLogout() {
    courseExited();
    clearActor();
  //  window.location = "../"; // lol
}

function userRegister( name, email ) {
    // should error check this
    setActor(name, email);
    // Set global actor var so other functions can use it
    actor = getActor();
    courseRegistered();
    // Setup chapters-complete
    ADL.XAPIWrapper.sendState(moduleID, actor, "chapters-completed", null, { "chapters": [] });
}

// jqm's submission process is the reason I'm doing it this way
function userRegisterSubmit() {
    if ( $("#reg-name").val() != "" && $("#reg-email").val() != "" ) {
        userRegister($("#reg-name").val(), $("#reg-email").val());
        courseLaunched();
        window.location = "../index.html"
    }
}

/* 
 * SCORMy
 */
function courseRegistered() {
    
    doConfig();

    // statement for launching content
    var stmt = {
        "actor": actor,
        "verb": ADL.verbs.registered,
        "object": baseActivity
    };

    // Send registered statement
    ADL.XAPIWrapper.sendStatement(stmt);

}

function courseLaunched() {
    
    doConfig();

    // statement for launching content
    var stmt = {
        "actor": actor,
        "verb": ADL.verbs.launched,
        "object": baseActivity
    };

    // Send launched statement
    ADL.XAPIWrapper.sendStatement(stmt);

}


function sendTEST() {
    
    doConfig();

    // statement for launching content
        var stmt = {
    "actor": {
        "mbox": "mailto:fcoa@ucm.es",
        "name": "fredsom",
        "objectType": "Agent"
    },
    "verb": {
        "id": "http://xapi.sigescar.com.ve/verbs/sesion",
        "display": {
            "en-US": "sesion"
        }
    },
    "object": {
        "id": "http://xapi.sigescar.com.ve/activities/sesion",
        "definition": {
            "name": {
                "en-US": "actividad"
            },
            "description": {
                "en-US": "Calculos Matematicos"
            }
        },
        "objectType": "Activity"
    }
}; // or session.getValue

    // Send launched statement
     ADL.XAPIWrapper.sendStatement(stmt);
	 

	var pag= "http://xapi.sigescar.com.ve/badges/1.json";
	 //  seleccionarC(pag);


	// var pag= "http://xapi.sigescar.com.ve/badges/1.json";
	 
	 //seleccionarC(pag);
	 
    // $("#sent-statements").html('SU DATO HA SIDO REGISTRADO EN LRS SERVER');
}



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
                "potition": 80
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
                "description" : "Description end"
                    },
                
                "grade": {
                "number": 0,
                "description" : "Premio en Calculos Matematicos",
                "imagebadge" : "http://www.xapi.sigescar.com.ve/badge/584669.png"
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


function objetoAjax1(){
	var xmlhttp=false;
	try {
		xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
	} catch (e) {
		try {
		   xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		} catch (E) {
			xmlhttp = false;
  		}
	}

	if (!xmlhttp && typeof XMLHttpRequest!='undefined') {
		xmlhttp = new XMLHttpRequest();
	}
	return xmlhttp;
}

function seleccionarC(id){
		ajax=objetoAjax1();

		ajax.open("POST", "http://localhost:8080/badges/badges/print.html");
		ajax.onreadystatechange=function() {
				if(ajax.readyState==4)//server ya respondio al cliente
	{
		if(ajax.status==200){
		   //obtener la respuesta en formato xml
		 document.getElementById('div1').innerHTML = ajax.responseText;		
		}//if ajax.status==200
	} else {	
		document.getElementById('div1').innerHTML = "<center>BUSCANDO.......</center>";
			 
	}		}

		ajax.send(null)
		
		}

function courseExited() {

    doConfig();

    // statement for launching content
    var stmt = {
        "actor": actor,
        "verb": ADL.verbs.exited,
        "object": baseActivity
    };

    // Send exited statement
    ADL.XAPIWrapper.sendStatement(stmt);

}

//suply the chapter, the page, and any sub-activity in that chapter and page
function createContext( parentChapter, parentPage, subParentActivity ) {
    var baseContext = {
        "contextActivities": {
            "parent": [
                baseActivity
            ]
        }
    };

    if ( typeof parentChapter !== "undefined" && typeof parentPage !== "undefined" ) {
        var chapterActivity = {
            "id": moduleID + parentChapter + "/" + parentPage,
            "definition": {
                "name": {
                    "en-US": moduleName + ": " + parentChapter + ", page: " + parentPage
                }
            },
            "objectType": "Activity"
        };
        baseContext.contextActivities.parent.push(chapterActivity);
    
        if ( typeof subParentActivity !== "undefined" ) {
            var subActivity = {
                "id": moduleID + parentChapter + "/" + parentPage + "#" + subParentActivity,
                "definition": {
                    "name": {
                        "en-US": moduleName + ": " + parentChapter + ", page: " + parentPage + " " + subParentActivity
                    }
                },
                "objectType": "Activity"
            };
            baseContext.contextActivities.parent.push(subActivity);
        }
    }
    return baseContext;
}

function carga(){
//window.attachEvent('onload',sendCalc("newhola3", "Android", "Android"));
//setTimeout(sendCalc('SetTimeeee..', 'Android', 'Android'),500);
}

carga();
