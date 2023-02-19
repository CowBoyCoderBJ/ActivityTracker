//-----------------------------------------
// NAME		: Bhavik Jain
// STUDENT NUMBER	: 7927054
// COURSE		: COMP 2150
// INSTRUCTOR	: Olivier Trembley
// ASSIGNMENT	: 1 
// 
// REMARKS: This is our main class where we are asking input from user and calling other classes
//
//
//-----------------------------------------


import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Duration;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to COMP 2050 Activity Tracker.");
        System.out.print("Please enter the name of the file with your activities: ");
        readInputFile();                                                                    //Read the file

    }

    //------------------------------------------------------
    // readInputFile
    //
    // PURPOSE: To read the file
    //------------------------------------------------------

    public static void readInputFile(){

        final Scanner stdin;
        Scanner fileIn;
        String line;
        try{

            stdin = new Scanner(System.in);                                             //Ask for the input
            String filename = stdin.nextLine();                                         //get the filename
            System.out.println("Going to read [" + filename + "].");
            fileIn = new Scanner(Files.newInputStream(Path.of(filename)));
            ActivityTracker allActivities = new ActivityTracker();                      //Create a linked list

            //Read all the lines in file
            while(fileIn.hasNextLine()){     

                line = fileIn.nextLine();
                line.trim();
                String[] lineArray = line.split(" ");

                //Pass the file contents per line to parseCommand method
                parseCommand(lineArray, allActivities);

            }

            fileIn.close();
            stdin.close();

        } catch(Exception e){

            System.out.println(e);

        }

    } //end readInputFile

    //------------------------------------------------------
    // parseCommand
    //
    // PURPOSE: To pass the commands from the file to the code
    // PARAMETERS: String[] tokens, ActivityTracker activitytracker
    //     To pass the commands from the file to the linked list named  
    //     activitytracker.
    //------------------------------------------------------

    public static void parseCommand(String[] tokens, ActivityTracker activitytracker){

        //String declarations
        String swimming = "SWIMMING";
        String walking = "WALKING";
        String running = "RUNNING";
        String cycling = "CYCLING";
        String query = "QUERY";
        String quit = "QUIT";
        String totalTime = "TOTAL_TIME";
        String between = "BETWEEN";
        String today = "TODAY";

        if (tokens[0].equals(cycling)){

            Activities newActivity = new Cycling(tokens[1], tokens[2], LocalDate.parse(tokens[3]), Duration.parse(tokens[4]), Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6]));
            activitytracker.addActivity(newActivity);

        }else if (tokens[0].equals(swimming)){

            Activities newActivity = new Swimming(tokens[1], tokens[2], LocalDate.parse(tokens[3]), Duration.parse(tokens[4]), Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6]));
            activitytracker.addActivity(newActivity);

        } else if (tokens[0].equals(running)){

            Activities newActivity = new Running(tokens[1], tokens[2], LocalDate.parse(tokens[3]), Duration.parse(tokens[4]), Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6]));
            activitytracker.addActivity(newActivity);

        } else if (tokens[0].equals(walking)){

            Activities newActivity = new Walking(tokens[1], tokens[2], LocalDate.parse(tokens[3]), Duration.parse(tokens[4]), Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6]));
            activitytracker.addActivity(newActivity);

        } else if (tokens[0].equals(query)){

            if (tokens[1].equals(totalTime)){

                System.out.println(">>> Querying total activity time:");
                System.out.println(">>> " + activitytracker.getTotalTime());
                System.out.println("========== Activities ==========");
                System.out.println(activitytracker.toString());

            } else if (tokens[1].equals("ACTIVITY")){

                System.out.println(">>> Querying activities of type " + tokens[2].toUpperCase());
                System.out.println("========== Activities ==========");

                String result = activitytracker.searchActivityType(tokens[2]);
                System.out.println(result );

            }else if (tokens[1].equals(between)){

                System.out.println("Querying activity time between " + tokens[2] + " and " + tokens[3] + ":");

                if (tokens[2].toUpperCase().equals(today) && tokens[3].toUpperCase().equals(today)){

                    System.out.println(activitytracker.getActivitiesBetweenDates(LocalDate.now(), LocalDate.now()));

                }else if (tokens[2].toUpperCase().equals(today)){

                    System.out.println(activitytracker.getActivitiesBetweenDates(LocalDate.now(), LocalDate.parse(tokens[3])));

                }else if (tokens[3].toUpperCase().equals(today)){

                    System.out.println(activitytracker.getActivitiesBetweenDates(LocalDate.parse(tokens[2]), LocalDate.now() ));

                }else{

                    System.out.println(activitytracker.getActivitiesBetweenDates(LocalDate.parse(tokens[2]), LocalDate.parse(tokens[3]) ));

                }


            }

        } else if(tokens[0].equals(quit)){

            System.out.println("End of processing");

        }

    }
    
} //end parseCommand
