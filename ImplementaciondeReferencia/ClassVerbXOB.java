package XOB;

import java.util.HashMap;

/**
 * Created by Freddy on 26/06/2016.
 */
public class ClassVerbXOB {
    public HashMap<String, String> timeArray = new HashMap<String, String>();
    public HashMap<String, String> pointArray = new HashMap<String, String>();
    public HashMap<String, String> leveltArray = new HashMap<String, String>();
    public HashMap<String, String> positionArray = new HashMap<String, String>();
    public HashMap<String, String> gradeArray = new HashMap<String, String>();
    public HashMap<String, String> verbsXOBArray = new HashMap<String, String>();

    public void time(String a, String b){
        switch (a){
            case "hour": this.timeArray.put(a,b);
                break;
            case "minutes": this.timeArray.put(a, b);
                break;
            case "seconds": this.timeArray.put(a, b);
                break;
        }
    }

    public void points(String a, String b){
        switch (a){
            case "score": this.pointArray.put(a,b);
                break;
            case "position": this.pointArray.put(a, b);
                break;
        }
    }

    public void level(String a, String b){
        switch (a){
            case "number": this.leveltArray.put(a,b);
                break;
            case "description": this.leveltArray.put(a, b);
                break;
        }
    }

    public void position(String a, String b){
        switch (a){
            case "number": this.positionArray.put(a,b);
                break;
            case "description": this.positionArray.put(a, b);
                break;
            case "total": this.positionArray.put(a, b);
                break;
        }
    }

    public void grade(String a, String b){
        switch (a){
            case "number": this.gradeArray.put(a, b);
                break;
            case "description": this.gradeArray.put(a, b);
                break;
            case "imagebadge": this.gradeArray.put(a, b);
                break;
        }
    }

    public String getVerbsXOB(){
        verbsXOBArray.put("time", timeArray.toString());
        verbsXOBArray.put("points", pointArray.toString());
        verbsXOBArray.put("level", leveltArray.toString());
        verbsXOBArray.put("position", positionArray.toString());
        verbsXOBArray.put("grade", gradeArray.toString());

        return verbsXOBArray.toString();
    }
}
