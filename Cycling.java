//-----------------------------------------
// NAME		: Bhavik Jain
// STUDENT NUMBER	: 7927054
// COURSE		: COMP 2150
// INSTRUCTOR	: Olivier Trembley
// ASSIGNMENT	: 1 
// 
// REMARKS: To implement the CYCLING class.
//
//
//-----------------------------------------


import java.time.LocalDate;
import java.time.Duration;

public class Cycling extends Activities {
    
    //Instance variables
    private int distance;
    private int elevation;

    //Constructor
    public Cycling(String name, String location, LocalDate date, Duration duration, int distance, int elevation){

        //call the super constructor
        super(name, location, date, duration);
        
        this.distance = distance;
        this.elevation = elevation;

    }

    //returns the type of the activity
    public  String getType(){

        return "Cycling";

    }

    //returns the description of the activity
    public String toString(){

        String result = super.toString();
        String speed = String.format("%.2f", getPace());
        result += "\n" + "     distance: " + getDistance() + "km;" + "\n" + "     elev: " + getElevation() + "m;" + "\n" + "     average speed: " + speed + " km/h";
        return result;

    }

    //returns the distance of the activity
    public int getDistance(){

        return this.distance;

    }

    //returns the elevation of the activity
    public int getElevation(){

        return this.elevation;

    }

    //returns the pace of the activity
    public float getPace(){

        float totalTime = this.duration.toHours() + ((float)(this.duration.toMinutes())%60)/60;

        return this.distance/totalTime;

    }

    //returns the laps of the activity
    public int getLaps(){

        return 0;

    }

    //returns the lap length of the activity
    public int getLaplength(){

        return 0;

    }

}
