//-----------------------------------------
// NAME		: Bhavik Jain
// STUDENT NUMBER	: 7927054
// COURSE		: COMP 2150
// INSTRUCTOR	: Olivier Trembley
// ASSIGNMENT	: 1 
// 
// REMARKS: To implement the WALKING class.
//
//
//-----------------------------------------


import java.time.LocalDate;
import java.time.Duration;

public class Walking extends Activities {

    //Instance variables
    private int distance;
    private int elevation;

    //Constructor
    public Walking(String name, String location, LocalDate date, Duration duration, int distance, int elevation){

        //Calling the super constructor
        super(name, location, date, duration);

        this.distance = distance;
        this.elevation = elevation;

    }

    //gets the type of the activity
    public  String getType(){

        return "Walking";

    }

    //gets the description of the activity
    public String toString(){

        String result = super.toString();
        String speed = String.format("%.2f", getPace());
        result += "\n" + "     distance: " + getDistance() + "km;" + "\n" + "     elev: " + getElevation() + "m;" + "\n" + "     average pace: " + speed + " min/km";
        return result;

    }

    //gets the distance of the activity
    public int getDistance(){

        return this.distance;

    }

    //gets the elevation of the activity
    public int getElevation(){

        return this.elevation;

    }

    //gets the pace of the activity
    public float getPace(){

        float totalTime = this.duration.toMinutes();

        return totalTime/distance;

    }

    //gets the laps of the activity
    public int getLaps(){

        return 0;

    }

    //gets the lap length of the activity
    public int getLaplength(){

        return 0;

    }
    
}



