//globals: equal, responseText, statement, ok, deepEqual, QUnit, module, asyncTest, Util, start, golfStatements, console
/*jslint bitwise: true, browser: true, plusplus: true, maxerr: 50, indent: 4 */
function Config() {
	"use strict";
}

Config.endpoint = "http://192.168.1.231:8000/xapi/";
Config.user = "match_game";
Config.password = "ruciomoro";

// "global" variables
var moduleID = "http://adlnet.gov/xapi/samples/xapi-jqm/minimal/"; // trailing slash
var moduleName = "Inicio de Experiencia XAPI Mobile Match War";

var baseActivity = {
    "id": moduleID,
    "definition": {
        "name": {
            "en-US": moduleName
        },
        "description": {
            "en-US": "Test de XAPI & Android Mobile, Proyecto Master Informatica UCM."
        }
    },
    "objectType": "Activity"
};
