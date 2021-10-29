
/**
 * This program takes user input for the tasks the user has to do that day and
 * plans out their day accordingly.
 *
 * @author Aparna Krishnan
 * @version 10/28/21
 */
public class Planner
{
    //FIELDS
    private int dayStart;
    private String workout;
    private String block1;
    private String block2;
    private String block3p1;
    private String block3p2;
    
    private int lunch;
    private int snack;
    private int dinner;
    
    private int workoutStart;
    private int workoutEnd;

    //CONSTRUCTOR
    public Planner()
    {
        // initialise instance variables
        dayStart = 0;
        workout = "";
        workoutStart = 0;
        workoutEnd = 0;
        lunch = 0;
        snack = 0;
        dinner = 0;
        block1 = "";
        block2 = "";
        block3p1 = "";
        block3p2 = "";
    }

    //METHODS
    public void setMealTimes(int time)
    {
        dayStart = time;
        lunch = dayStart + 3;
        snack = lunch + 3;
        dinner = snack + 3;
    }
    
    public void isWorkingOut(boolean check) {
        if (check == true) {
            workoutStart = lunch + 1;
            workoutEnd = workoutStart + 1;
            workout = workoutStart + ":00" + "-" + workoutEnd + ":00" + " WORKOUT \n" +
        workoutEnd + ":00" + "-" + workoutEnd + ":30" + " SHOWER \n";
        } else {
            workout = "";
        }
    }
    
    public void scheduleBlocks(String name1, int duration1, String name2, int duration2) {
        if (duration1 <= 2) {
            block1 = dayStart + ":30" + "-" + (dayStart + duration1) + ":30 " + name1 + "\n";
            if (duration2 <= 2) {
                block2 = snack + ":30" + "-" + (snack + duration2) + ":30 " + name2 + "\n";
            } else {
                duration2 -= 2;
                block2 = snack + ":30" + "-" + (snack + 2) + ":30 " + name2 + "\n";
                block3p1 = (dinner + 1) + ":00" + "-" + (dinner + 1 + duration2) + ":00 " + name2 + "\n";
            }
        } else {
            duration1 -= 2;
            block1 = dayStart + ":30" + "-" + (dayStart + 2) + ":30 " + name1 + "\n";
            block3p1 = (dinner + 1) + ":00" + "-" + (dinner + 1 + duration1) + ":00 " + name1 + "\n";
            if (duration2 <= 2) {
                block2 = snack + ":30" + "-" + (snack + duration2) + ":30 " + name2 + "\n";
            } else {
                duration2 -= 2;
                block3p2 = (dinner + 1 + duration1) + ":00" + "-" + (dinner + 1 + duration1 + duration2) + ":00 " + name2 + "\n";
                block2 = snack + ":30" + "-" + (snack + 2) + ":30 " + name2 + "\n";
            }
        }
    }
    
    public String schedule() {
        return "\n" + dayStart + ":00" + "-" + dayStart + ":30" + " BREAKFAST \n" + block1 +
        lunch + ":00" + "-" + (lunch + 1) + ":00" + " LUNCH \n" + workout +
        snack + ":00" + "-" + snack + ":30" + " SNACK \n" + block2 +
        dinner + ":00" + "-" + (dinner + 1) + ":00" + " DINNER \n" + block3p1 + block3p2;
        
    }
}
