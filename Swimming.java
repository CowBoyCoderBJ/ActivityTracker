//-----------------------------------------
// NAME		: Bhavik Jain
// STUDENT NUMBER	: 7927054
// COURSE		: COMP 2150
// INSTRUCTOR	: Olivier Trembley
// ASSIGNMENT	: 1 
// 
// REMARKS: To implement the SWIMMING class.
//
//
//-----------------------------------------


import java.time.LocalDate;
import java.time.Duration;

public class Swimming extends Activities {
    
    //Instance variables
    private int laps;
    private int lapLength;

    //Constructor
    public Swimming(String name, String location, LocalDate date, Duration duration, int laps, int lapLength){

        //Calling the super class constructor
        super(name, location, date, duration);
        
        this.laps = laps;
        this.lapLength = lapLength;

    }

    //gets the type of the activity
    public  String getType(){

        return "Swimming";

    }

    //gets the desciption of the activity
    public String toString(){

        String result = super.toString();
        String speed = String.format("%.2f", getPace());
        result += "\n" + "     laps: " + getLaps() + ";" + "\n" + "     lap length: " + getLaplength() + "m;" + "\n" + "     average pace: " + speed + " min/km";
        return result;

    }

    //gets the laps of the activity
    public int getLaps(){

        return this.laps;

    }

    //gets the lap length of the activity
    public int getLaplength(){

        return this.lapLength;

    }

    //gets the pace of the activity
    public float getPace(){

        float totalTime = this.duration.toMinutes();

        return (totalTime*1000)/(laps*lapLength);

    }

    //gets the distance of the activity
    public int getDistance(){

        return 0;

    }

    //gets the elevation of the activity
    public int getElevation(){

        return 0;

    }

}
