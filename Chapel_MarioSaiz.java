
package chapel;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*
    Mario Saiz
    Lab CHAPEL
    2018
*/

public class Chapel implements Comparable<Chapel> {

    static final int MON = 0;
    static final int TUE = 1;
    static final int WED = 2;
    static final int THU = 3;
    static final int FRI = 4;
    static final int INVALID_DAY = -1;
    
    private int day; // Day of the week should be one of the constants above
    private int num; // Number of people in chapel on that day.
    
    @Override
    public int compareTo(Chapel o) {
        return Integer.compare(this.day, o.day);
    }
    
    // Constructor that takes two arguments d for day and n for num
    public Chapel(int d, int n) { day = d; num = n; }
    public Chapel() { this(-1,-1); }
    
    @Override
    public String toString() {
        switch(day) {
            case MON: return "Monday: " + num; 
            case TUE: return "Tuesday: " + num;
            case WED: return "Wednesday: " + num;
            case THU: return "Thursday: " + num;
            case FRI: return "Friday: " + num;
            default: return "Invalid Day";
        }
    }
    
    // Pass in a String representing a day of the week and this method
    // will set the day field correspondingly.
    public void setDayString(String s) {
        switch(s) {
            case "Mon": case "Monday": case "Mon.": day = MON; break;
            case "Tue": case "Tuesday": case "Tue.": day = TUE; break;
            case "Wed": case "Wednesday": case "Wed.": day = WED; break;
            case "Thu": case "Thursday": case "Thu.": day = THU; break;
            case "Fri": case "Friday": case "Fri.": day = FRI; break;
            default: day = INVALID_DAY;
        }
    }
    
    public void setDay(int d) { day = d; }
    public void setNum(int n) { num = n; }
    
    // Write a method named sumDays that takes an array of type Chapel. 
    // Read through the array summing up the attendance for each day.
    // Then print the total attendance for each day following the format
    // in this example output:
    // Monday: 324
    // Tuesday: 125
    // Wednesday: 200
    // Thursday: 185
    // Friday: 177
    
    
    public static void sumDays(Chapel[] attend)
    {
        
       int i, sumMon = 0, sumTue = 0, sumWed = 0,
              sumThu = 0, sumFri = 0;
        
       for (i=0; i <= 41; i++) {
        
       if (attend[i].day == 0) {
          sumMon+=attend[i].num;
       }
       else if (attend[i].day == 1) {
            sumTue+=attend[i].num;
       }
       else if (attend[i].day == 2) {
            sumWed+=attend[i].num;
       }
       else if (attend[i].day == 3) {
             sumThu+=attend[i].num;
       }
       else if (attend[i].day == 4) {
            sumFri+=attend[i].num;
       }
      // else {
      //      System.out.println("Nothing");
      // }
        
        }
            System.out.println("Monday: " +sumMon);
            System.out.println("Tuesday: " +sumTue);
            System.out.println("Wednesday: " +sumWed);
            System.out.println("Thursday: " +sumThu);
            System.out.println("Friday: " +sumFri);
    
    }
    
    // Here you will implement the compareTo operator (for the template
    // Comparable.)  You should sort Chapel types according to their 
    // attendance 
    
    
    public static void readData(Chapel[] attend,
           String filename) {
        try {
            Scanner reader = new Scanner(new File(filename));
            int counter = 0;
            while(reader.hasNext()) {
                String d = reader.nextLine();
                Integer i = reader.nextInt();
                reader.nextLine(); // read in newline
                attend[counter] = new Chapel();
                attend[counter].setNum(i);
                attend[counter].setDayString(d);
                counter++;
            }
        }
        catch(IOException e) {
            System.out.println("File I/O Error");
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws IOException {
        // Create an array of type Chapel.  Size of array should be 42.
        // Name your array: attendance
        
        Chapel[] myAttendance = new Chapel [42];
        
        // Call the readData() method, by passing in the attendance array
        // and the file name "chapelAttendance.txt"
          
        readData(myAttendance, "chapelAttendance.txt");
        
        
        // Call your sumDays function to print out the sums of all the days'
        // attendances
       
        sumDays(myAttendance);
        
        // Sort your array using the Arrays.sort method.  Note, you must
        // have finished your compareTo method for this to work.
        
        //System.out.println(Arrays.toString(myAttendance));
        Arrays.sort(myAttendance);
        //System.out.println(Arrays.toString(myAttendance));
        
        //  Display the top 5 values in the sorted array.
        
        System.out.println(myAttendance[0]);
        System.out.println(myAttendance[1]);
        System.out.println(myAttendance[2]);
        System.out.println(myAttendance[3]);
        System.out.println(myAttendance[4]);
    }
    
}
