import java.util.Scanner;
/**
 * This program gathers inputs and runs Planner class.
 *
 * @author Aparna Krishnan
 * @version 10/28/21
 */
public class PlannerRun
{
    public static void main(String args[]) {
        Scanner task = new Scanner(System.in);
        Planner mySchedule = new Planner();
        
        System.out.println("Answer the questions when prompted.");
        System.out.println("If there is free time (ie. there is no assigned\ntask at a certain time) use the time as you see fit.");
        System.out.println("Only enter single digit hours!\n");
        
        System.out.println("What time will you wake up? (just put the hour)");
        int wakeTime = Integer.parseInt(task.nextLine());
        mySchedule.setMealTimes(wakeTime);
        
        System.out.println("Are you working out today? (Enter 'true' or 'false')");
        boolean workingOut = Boolean.parseBoolean(task.nextLine());
        mySchedule.isWorkingOut(workingOut);
        
        System.out.println("Enter name of task 1: ");
        String nameTask1 = task.nextLine();
        System.out.println("Enter time needed to complete task 1 (in hours): ");
        int timeTask1 = Integer.parseInt(task.nextLine());
        
        
        System.out.println("Enter name of task 2: ");
        String nameTask2 = task.nextLine();
        System.out.println("Enter time needed to complete task 2 (in hours): ");
        int timeTask2 = Integer.parseInt(task.nextLine());
        
        mySchedule.scheduleBlocks(nameTask1, timeTask1, nameTask2, timeTask2);
        
        System.out.println(mySchedule.schedule());
    }
}
