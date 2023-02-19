//-----------------------------------------
// NAME		: Bhavik Jain
// STUDENT NUMBER	: 7927054
// COURSE		: COMP 2150
// INSTRUCTOR	: Olivier Trembley
// ASSIGNMENT	: 1 
// 
// REMARKS: To implement the Linked List for the whole program.
//
//
//-----------------------------------------

import java.time.Duration;
import java.time.LocalDate;

public class ActivityTracker {

    private Node head;                                                      //Top of the linked list
    private Node tail;                                                      //End of the linked list
    private Duration totalTime = Duration.ofMinutes(0);            //To track time of all activities
    private Duration totalTimeCycling = Duration.ofMinutes(0);     //To track time of activity type - CYCLING
    private Duration totalTimeWalking = Duration.ofMinutes(0);     //To track time of activity type - WALKING
    private Duration totalTimeSwimming = Duration.ofMinutes(0);    //To track time of activity type - SWIMMING
    private Duration totalTimeRunning = Duration.ofMinutes(0);     //To track time of activity type - RUNNING

    //------------------------------------------------------
    // addActivity
    //
    // PURPOSE:    Adds the activity to the Linked List
    // PARAMETERS: Activities 
    //     It takes the type Activities parameter to be added 
    //     into the Linked List.
    // 
    //------------------------------------------------------

    public void addActivity(Activities newActivity ){        
        
        //If the activity is not already in the linked list, then add it.
        if (searchActivity(newActivity) == false){

            Node newNode = new Node(newActivity, null);

            //if the link list is empty, then assign the top of LL to the activity
            if (head == null){

                head = newNode;
                tail = newNode;

            //Add the activities after the head
            }else{

                tail.setNext(newNode);
                tail = newNode;

            }

            //Track the total time of all activities.
            totalTime = totalTime.plus(newActivity.duration); 

            //Track the total time of individual type of activity.
            individualTimeTracker(newActivity);

            //Print the description of activity after adding the activity into LL
            System.out.println("Adding Activity: " + newActivity.toString());

        }

    } // end addActivity

    //------------------------------------------------------
    // individualTimeTracker
    //
    // PURPOSE:    Tracks the time of individual type of activity
    // PARAMETERS: Activities newActivity
    //     It takes the type Activities parameter to be add its time
    //     to their specific time tracker.
    // 
    //------------------------------------------------------

    public void individualTimeTracker(Activities newActivity){

        //if activity type is of CYCLING, then add time to it.
        if (newActivity instanceof Cycling){

            totalTimeCycling.plus(newActivity.duration);

        //if activity type is of WALKING, then add time to it.
        }else if (newActivity instanceof Walking){

            totalTimeWalking.plus(newActivity.duration);

        //if activity type is of SWIMMING, then add time to it.
        } else if (newActivity instanceof Swimming){

            totalTimeSwimming.plus(newActivity.duration);

        //if activity type is of RUNNING, then add time to it.
        } else if (newActivity instanceof Running){

            totalTimeRunning.plus(newActivity.duration);

        }

    } //end indvidualTimeTracker

    //------------------------------------------------------
    // searchActivity
    //
    // PURPOSE:    It searches for the specific activity in the Linked List
    // PARAMETERS: Activities
    //     It takes the parameter type Activities to be searched from 
    //     Linked List.
    // Returns: True if activity is already in LL, otherwise False
    //------------------------------------------------------

    public Boolean searchActivity(Activities checkActivity){

        Node startingNode = this.head;
        Boolean result = false;

        //Search through the LL until you found it or you checked every activity
        while (!result && startingNode!= null){

            //check if activities have same type
            if (checkActivity.getType() == startingNode.getActivity().getType()){

                //check if both activities have same description
                if (checkActivity.getName().equals(startingNode.getActivity().getName()) && checkActivity.getLocation().equals(startingNode.getActivity().getLocation()) && checkActivity.getDate().isEqual(startingNode.getActivity().getDate()) && checkActivity.getDuration().equals(startingNode.getActivity().getDuration()) && checkActivity.getDistance() == startingNode.getActivity().getDistance() && checkActivity.getElevation() == startingNode.getActivity().getElevation() && checkActivity.getLaps() == startingNode.getActivity().getLaps() && checkActivity.getLaplength() == startingNode.getActivity().getLaplength()){
                    
                    result = true;

                }

            }

            startingNode = startingNode.getNext();

        }

        return result;

    } // end searchActivity

    //------------------------------------------------------
    // searchActivityType
    //
    // PURPOSE:    It returns the toString of all specific activity.
    // PARAMETERS: String
    //     It takes a Strinf type of the activity. 
    // Returns: toString of the activities.
    //------------------------------------------------------

    public String searchActivityType(String activityType){

        Node startingNode = this.head;
        String result = "";

        //Find all activities until you checked all activities in LL
        while(startingNode != null){

            //If it matches the activity type
            if (startingNode.getActivity().getType().toUpperCase().equals(activityType)){

                //Add the toString of that activity
                result += startingNode.getActivity().toString() + "\n";

            }
            startingNode = startingNode.getNext();

        }

        return result;

    } //end searchActivityType

    //------------------------------------------------------
    // getTotalTime
    //
    // PURPOSE: To get total time of all activities
    // Returns: To return the string of the total time.
    //------------------------------------------------------

    public String getTotalTime(){

        //Convert the total time into string
        String result = totalTime.toMinutes()/60 + " hours and " + totalTime.toMinutes()%60 + " minutes.";

        return result;

    } //end getTotalTime

    //------------------------------------------------------
    // getActivitiesBetweenDates
    //
    // PURPOSE:    To get all activities between specific dates
    // PARAMETERS: LocalDate date1, LocalDate date2
    //     date1 and date2 are LocalDate parameter types. 
    // Returns: Returns the toString of activities between the two dates.
    //------------------------------------------------------

    public String getActivitiesBetweenDates(LocalDate date1, LocalDate date2){

        Duration totalTime = Duration.ofMinutes(0);  
        String result = "========== Activities ==========\n";
        Node startingNode = this.head;

        //Check all actvitites
        while(startingNode != null){

            //If the activity is between the two dates given
            if ((startingNode.getActivity().getDate().isAfter(date1) && startingNode.getActivity().getDate().isBefore(date2)) || startingNode.getActivity().getDate().isEqual(date1) || startingNode.getActivity().getDate().isEqual(date2)){

                totalTime = totalTime.plus(startingNode.getActivity().duration);
                result += startingNode.getActivity().toString() + "\n";

            }
            startingNode = startingNode.getNext();

        }

        String stringTime = totalTime.toMinutes()/60 + " hours and " + totalTime.toMinutes()%60 + " minutes."; 

        return ">>> " + stringTime + "\n" + result;

    } // end getActivitiesBetweenDates

    //------------------------------------------------------
    // toString
    //
    // PURPOSE: Gives the description of the activity
    // Returns: Returns the description of activity
    //------------------------------------------------------

    public String toString(){

        Node startingNode = this.head;
        String result = "";

        while (startingNode != null){

                    result += startingNode.getActivity().toString() + "\n";
                    startingNode = startingNode.getNext();
        
            
        }    

        return result;

    } //end toString
    
}
