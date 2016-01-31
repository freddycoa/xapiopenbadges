package com.example.applogin;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonElement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gov.adlnet.xapi.client.StatementClient;
import gov.adlnet.xapi.model.Activity;
import gov.adlnet.xapi.model.ActivityDefinition;
import gov.adlnet.xapi.model.Agent;
import gov.adlnet.xapi.model.Context;
import gov.adlnet.xapi.model.ContextActivities;
import gov.adlnet.xapi.model.Statement;
import gov.adlnet.xapi.model.Verb;
import gov.adlnet.xapi.model.Verbs;

public class TestXAPI extends AppCompatActivity {

    private int _android_id;
    private int _current_slide;
    private String _actor_name;
    private String _actor_email;
    private String _attempt;
    private String _path;
    private String _name;
    private String _desc;
    TextView jsonTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_xapi);

        jsonTest = (TextView) findViewById(R.id.tv_json);

        SharedPreferences prefs = getSharedPreferences(getString(R.string.preferences_key), MODE_PRIVATE);
        String tmpName = prefs.getString(getString(R.string.preferences_name_key), null);
        String tmpEmail = prefs.getString(getString(R.string.preferences_email_key), null);

        _actor_email = "mailto:fcoa@ucm.es";
        _actor_name = tmpName;

        Button xapiSendTest = (Button) findViewById(R.id.bt_sendTestXAPI);

        xapiSendTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSlideChangeStatement();
            }
        });


    }


    //protected Agent getActor(){return this._actor;}
    /*protected void setName(String n){this._name = n; }
    protected String getName(){return this._name;}
    protected void setPath(String p){this._path = p; }
    protected String getPath(){return this._path;}
    protected void setDesc(String d){this._desc = d; }
    protected String getDesc(){return this._desc;}*/

    protected void sendSlideChangeStatement(){     // FUNCION UNICA PARA ENVIO DE TODAS LAS ACTIVIDADES AL SERVIDOR LRS

        //checkActor();

        _actor_name = getString(R.string.default_name);
        _actor_email = getString(R.string.default_email);

        Agent actor = new Agent(_actor_name, _actor_email);

        JSONObject time = new JSONObject();
        JSONObject points = new JSONObject();
        JSONObject level = new JSONObject();
        JSONObject potition = new JSONObject();
        JSONObject end = new JSONObject();
        JSONObject grade = new JSONObject();

        JSONObject element = new JSONObject();
        try{
            time.put("hour", 12);
            time.put("minutes", 55);
            time.put("seconds", 26);

            points.put("score", 30);
            points.put("potition", 80);


            level.put("number", 0);
            level.put("description", "Maximo Nivel");


            potition.put("number", 2);
            potition.put("description", "The potition is ...");
            potition.put("total", 10);

            end.put("date", "22/10/2015");
            end.put("description", "Description End");


            grade.put("number", 0);
            grade.put("description", "Description Grade");
            grade.put("image-badge", "http://www.xapi.sigescar.com.ve/badge/584669.png");

            element.put("time", time);
            element.put("points", points);
            element.put("level", level);
            element.put("potition", potition);
            element.put("end", end);
            element.put("grade", grade);


        } catch (JSONException e){
            e.printStackTrace();
        }

        jsonTest = (TextView) findViewById(R.id.tv_json);
        //jsonTest.setText(element.toString());


        HashMap<String, String> verb_lang = new HashMap<>();
        verb_lang.put("des", element.toString());
        Verb verb = new Verb("http://adlnet.gov/expapi/activities/object", verb_lang);


        Activity init_act = createActivity(getString(R.string.app_activity_iri) + "What", "What soo", "Is description",
                getString(R.string.scorm_profile_activity_type_lesson_id));

        Activity attempt_act = createActivity(getString(R.string.app_activity_iri) + "What", "What soo", "Is description",
                getString(R.string.scorm_profile_activity_type_lesson_id));

        Activity objectXAPI = createActivity(getString(R.string.app_activity_iri) + "What", "Description Object", element.toString(),
                "http://adlnet.gov/expapi/activities/object");


        // Asi como se creo la funcion createcontex debo implementar una funcion para añadir los elementos extra en la
        // descripcion del Object llamada createobject
        Context init_con = createContext(attempt_act);
       // Context abc = createContext(attempt_act);
        // send initialize statement
        WriteStatementTask init_stmt_task = new WriteStatementTask();
      //  Statement stmt = new Statement(actor, Verbs.initialized(), objectXAPI);
        Statement stmt = new Statement();
        stmt.setActor(actor);
        stmt.setVerb(Verbs.initialized());
        stmt.setObject(objectXAPI);
        stmt.setContext(init_con);
        init_stmt_task.execute(stmt);



      /*  Activity mod_act = createActivity(getString(R.string.app_activity_iri) + "What", "What soo", "Is description", getString(R.string.scorm_profile_activity_type_lesson_id));
        Activity attempt_act = createActivity(getString(R.string.app_activity_iri) + "What" + "?attemptId=" + "attemptId",
                "Attempt for " + "What So", "Attempt for " + "Is Description", getString(R.string.scorm_profile_activity_type_attempt_id));
        Context con = createContext(attempt_act);
        Result result = new Result();
        result.setCompletion(true);
        result.setSuccess(true);
        // returned result from launched activity, send terminated
        WriteStatementTask terminate_stmt_task = new WriteStatementTask();
        Statement stmt = new Statement(actor, Verbs.initialized(), mod_act);
       // stmt.setContext(con);
       // stmt.setResult(result);
        terminate_stmt_task.execute(stmt);*/
    }

    private void checkActor(){
        // Just make sure actor name and email aren't null if user doesn't put anything
      //  if ((_actor_name == null || _actor_name.equals("")) || (_actor_email == null || _actor_email.equals(""))){
            _actor_name = getString(R.string.default_name);
            _actor_email = getString(R.string.default_email);
        //}
    }

    private Context createContext(Activity attempt_act){
        Context con = new Context();
        ContextActivities con_acts = new ContextActivities();

        ArrayList<Activity> con_act_list = new ArrayList<>();
        // Include app activity
        con_act_list.add(createActivity(getString(R.string.app_activity_iri),
                getString(R.string.app_activity_name), getString(R.string.app_activity_description),
                getString(R.string.scorm_profile_activity_type_course_id)));
        con_act_list.add(attempt_act);

        con_acts.setGrouping(con_act_list);
        ArrayList<Activity> cat_act_list = new ArrayList<>();
        cat_act_list.add(new Activity(getString(R.string.scorm_profile_activity_category_id)));
        cat_act_list.add(new Activity(getString(R.string.xapi_bootcamp_iri)));
        con_acts.setCategory(cat_act_list);
        con.setContextActivities(con_acts);
        return con;
    }
    private Activity createActivity(String act_id, String name, String desc, String type_id){
    // createactivity is a name a class used for send data to Server ADL-LRS
        Activity act = new Activity(act_id);
        ActivityDefinition act_def = new ActivityDefinition();
        act_def.setName(new HashMap<String, String>());
        act_def.getName().put("en-US", name);


        act_def.setDescription(new HashMap<String, String>());
        act_def.getDescription().put("en-US", "Badge");


        JSONObject time = new JSONObject();
        JSONObject points = new JSONObject();
        JSONObject level = new JSONObject();
        JSONObject potition = new JSONObject();
        JSONObject end = new JSONObject();
        JSONObject grade = new JSONObject();

        JSONObject element = new JSONObject();
        try{
            time.put("hour", 12);
            time.put("minutes", 55);
            time.put("seconds", 26);

            points.put("score", 30);
            points.put("potition", 80);


            level.put("number", 0);
            level.put("description", "Maximo Nivel");


            potition.put("number", 2);
            potition.put("description", "The potition is ...");
            potition.put("total", 10);

            end.put("date", "22/10/2015");
            end.put("description", "Description End");


            grade.put("number", 0);
            grade.put("description", "Description Grade");
            grade.put("image-badge", "http://www.xapi.sigescar.com.ve/badge/584669.png");

            element.put("time", time);
            element.put("points", points);
            element.put("level", level);
            element.put("potition", potition);
            element.put("end", end);
            element.put("grade", grade);


        } catch (JSONException e){
            e.printStackTrace();
        }

        ArrayList<JSONObject> listado = new ArrayList<>();

        listado.add(potition);

        act_def.getDescription().put("time", listado.toString());
        act_def.getDescription().put("points", points.toString());
        act_def.getDescription().put("level", level.toString());
        act_def.getDescription().put("potition", potition.toString());
        act_def.getDescription().put("end", end.toString());
        act_def.getDescription().put("grade", grade.toString());

        act_def.setType(type_id);
        act.setDefinition(act_def);
        return act;
    }


    // Inner class to write statements to the LRS - returns boolean success and string result
    // Inner class to send statements to the LRS - returns boolean success and string result
    private class WriteStatementTask extends AsyncTask<Statement, Void, Pair<Boolean, String>>{
        protected Pair<Boolean, String> doInBackground(Statement... params){
            boolean success = true;
            String content;
            // Try to send the statement
            try{
                StatementClient client = new StatementClient(getString(R.string.lrs_endpoint),
                        getString(R.string.lrs_user), getString(R.string.lrs_password));
                content = client.postStatement(params[0]);
            }catch(Exception ex){
                success = false;
                content = ex.getLocalizedMessage();
            }

            return new Pair<>(success, content);
        }

        // Called after doInBackground for updating UI
        protected void onPostExecute(Pair<Boolean, String> p){
            if (!p.first){
                // Send toast message with error
                Toast.makeText(getApplicationContext(), getString(R.string.statement_write_error) + p.second,
                        Toast.LENGTH_LONG).show();
            }
        }
    }




        public void elements_object_description()
        {
            JSONObject time = new JSONObject();
            JSONObject points = new JSONObject();
            JSONObject level = new JSONObject();
            JSONObject potition = new JSONObject();
            JSONObject end = new JSONObject();
            JSONObject grade = new JSONObject();

            JSONObject element = new JSONObject();
            try{
                time.put("hour", 12);
                time.put("minutes", 55);
                time.put("seconds", 26);

                points.put("score", 30);
                points.put("potition", 80);


                level.put("number", 0);
                level.put("description", "Maximo Nivel");


                potition.put("number", 2);
                potition.put("description", "The potition is ...");
                potition.put("total", 10);

                end.put("date", "22/10/2015");
                end.put("description", "Description End");


                grade.put("number", 0);
                grade.put("description", "Description Grade");
                grade.put("image-badge", "http://www.xapi.sigescar.com.ve/badge/584669.png");

                element.put("time", time);
                element.put("points", points);
                element.put("level", level);
                element.put("potition", potition);
                element.put("end", end);
                element.put("grade", grade);


            } catch (JSONException e){
                e.printStackTrace();
            }
        }


}
