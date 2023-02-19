//-----------------------------------------
// NAME		: Bhavik Jain
// STUDENT NUMBER	: 7927054
// COURSE		: COMP 2150
// INSTRUCTOR	: Olivier Trembley
// ASSIGNMENT	: 1 
// 
// REMARKS: This is the super class of all activity classes.
//
//
//-----------------------------------------


import java.time.LocalDate;
import java.time.Duration;

public abstract class Activities {
    
    //Instance variables
    protected String name;
    protected String location;
    protected LocalDate date;
    protected Duration duration;

    //Constructor
    public Activities(String name, String location, LocalDate date, Duration duration){

        this.name = name;
        this.location = location;
        this.date = date;
        this.duration = duration;

    }

    //returns the name of the activity
    public String getName(){

        return this.name;

    }

    //returns the location of the activity
    public String getLocation(){

        return this.location;

    }

    //returns the date of the activity
    public LocalDate getDate(){

        return this.date;

    }

    //returns the duration of the activity
    public Duration getDuration(){

        return this.duration;

    }

    //Abstract classes

    //get the type of the activity
    public abstract String getType();

    //get the distance of the activity
    public abstract int getDistance();

    //get the distance of the activity
    public abstract float getPace();

    //get the elevation of the activity
    public abstract int getElevation();

    //get the laps of the activity
    public abstract int getLaps();

    //get the lap length of the activity
    public abstract int getLaplength();

    //get the description of the activity
    public String toString(){

        String result = "[" + getDate() + "] " + getType() + ": " + getName() + " at " + getLocation() + "\n" + "     duration: " + this.duration.toHours() + " hour(s) and " + this.duration.toMinutes()%60 + " minutes(s);";
        return result;

    }

}
