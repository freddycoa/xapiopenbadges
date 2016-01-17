var http = require('http');
var url = require('url');

var adl = require('adl-xapiwrapper');
adl.debugLevel = 'info';
var myconfig = {
    "url":"http://192.168.1.231:8000/xapi/",
    "auth":{
        "user":"match_game",
        "pass":"ruciomoro"
    }
};
var mylrs = new adl.XAPIWrapper(myconfig);


http.createServer(function(request, response) {

   var query = url.parse(request.url,true).query;
   var mbox = "mailto:"+query.mbox;
   var nameactor = query.nameactor;
  // response.writeHead(200, {'Content-Type': 'text/html'});
   //response.end(variableget);

   var stmt = {
            "actor" : {
                "mbox" : mbox, 
                "name": nameactor, 
                "objectType": "Agent"
            },
            "verb" : {
                "id" : "http://adlnet.gov/expapi/verbs/answered",
                      "display" : {
                        "en-US" : "answered"
                    }
            },

            "object" : {
                "id" : "http://adlnet.gov/expapi/activities/question", 
                "definition": {
                    "name": {
                        "en-US": "actividad"
                    },
                }
            }
        };


  mylrs.sendStatements(stmt, function (err, resp, bdy) {
    adl.log('info', resp.statusCode);
    adl.log('info', bdy);
});

}).listen(8888);
console.log("Servidor Iniciado.");