//-----------------------------------------
// NAME		: Bhavik Jain
// STUDENT NUMBER	: 7927054
// COURSE		: COMP 2150
// INSTRUCTOR	: Olivier Trembley
// ASSIGNMENT	: 1 
// 
// REMARKS: To implement the Node class.
//
//
//-----------------------------------------


public class Node {

    //Instance variables
    private Activities activity;
    private Node next;
    
    //Constructor
    public Node(Activities activity, Node next){

        this.activity = activity;
        this.next = next;

    }

    //Setters

    //Sets the activity for the node
    public void setActivity(Activities setActivity){

        this.activity = setActivity;

    }

    //Sets the next for the node
    public void setNext(Node newNext){

        this.next = newNext;

    }

    //Getters

    //Gets the activity of the node
    public Activities getActivity(){

        return this.activity;

    }

    //gets the next of the node
    public Node getNext(){

        return this.next;

    }
    
}
