//Jon Bennett
//02/25/2022
//Assigment 2 :MyCalendar part 2
//C&S 141

//This coding will produce a Calendar using only what we have learned from chapters 1-5
//along with the helpful tips provided on the Assignment 1 grading rubric and Assignment 2 grading rubric.
//This 2nd Calendar will give a user the a better user interface(UI) for the end user to properly look up in perticular dates
//as needed. 
import java.io.*;
import java.util.*;
import java.util.Calendar;
import java.util.Scanner;


//This coding below will make an calander and find the give date entered in by the user.
public class MyCalendar {
   public static final int cell= 7;
   public static final int SIZE = 10;
   public static final int Starting_Year_Cell = 2022; 
   public static char UPANDDOWN = 'O';
   public static char ACCROSS = 'J'; 
   public static String[][] eventArray;
   public static boolean showline = true;
      
   
   public static void main(String[] args) throws FileNotFoundException {
       Scanner input = new Scanner(System.in);
       System.out.println("Welcome to my calendar program!I hope you enjoy! :)");
       String command = printMenu(input);
       int month = -1;
       int day = -1;
       String date = "";
       loadEventsFromFile("calendarEvents.txt");
       
         while(!command.equals("q")) {
         if(command.equals("e")) 
         {
         date = getDate(input);
         month = monthFromDate(date);
         day = dayFromDate(date);
         drawMonth(month, day);
         displayDate(month, day);
         }else if (command.equals("fp")) {
         System.out.print("\nEnter month to print (1-12):");
         month = input.nextInt();         
         System.out.print("Enter filename: ");       
         String fname = input.next().trim();
         input.nextLine();
         day = -1;
         try {
         PrintStream outfile = new PrintStream(new File(fname));
         drawMonth(month, day);
         outfile.close();
         } catch (FileNotFoundException e) 
         {
         System.out.println(e.getMessage());
          }           
         }      
         else if(command.equals("ev"))
         {
         System.out.println("Please type in the date followed by the event(mm/dd event):");
         String dateOfEvent = input.next();
         String event = input.next();
         month = monthFromDate(dateOfEvent);
         day = dayFromDate(dateOfEvent);
         eventArray[month-1] [day-1] = event;
         }
         else if(command.equals("t"))
         {
         date = getToday();
         month = monthFromDate(date);
         day = dayFromDate(date);
         drawMonth(month, day);
         displayDate(month, day);
         }
         else if(command.equals("n")) 
         {
         if(month == -1) {
            System.out.println("please select a command to display a calendar first");
            }
         else { 
         if(month == 12) {
         month = 1;
         }
         else {
         month++;
         }
         drawMonth(month, day);
         displayDate(month, day);
         }
        }
        else { 
        System.out.println("please enter a valid command!");
        }
        command = printMenu(input); 
        }
      }
//the display that will appear for user menu
public static String printMenu(Scanner input) {
         System.out.println("please type a command from the following options:");
         System.out.println("\"e\" to enter a date and display the corresponding calendar");
         System.out.println("\"t\" to get todays date and display the today's calendar");
         System.out.println("\"n\" to display the next month");
         System.out.println("\"p\" to display the previous month");
         System.out.println("\"q\" to quit the program");
         System.out.println("\"ev\" to plan a event");
         System.out.println("\"fp\" Enther mont to print (1-12:)");
         return input.next();
         }
      
          
//Ask user to enter in the corresponding date they want. 
public static String getDate(Scanner input) {
      System.out.println("What date would you like to look at today? (m/d): ");       
      String date = input.next();
      return date;
      }
             
//display calendar for today's date
public static String getToday() {
     String date = "";
     Calendar today = Calendar.getInstance();
     date += today.get(Calendar.MONTH) + 1;
     date += "/" + today.get(Calendar.DATE);
     return date;     
   }   
 
//lables day of the week and starts day of the month to the corresondaing day(Mon, Tue, Wed).        
public static void drawMonth(int month, int day){
      for(int i = 0; i < (SIZE * cell) / 2 - 1; i++)
      {
      System.out.print(" ");
      }
      System.out.println(month);
      for(int i = 0; i < cell; i++){
         for(int n = 0; n < SIZE / 2 - 1; n++) {
               System.out.print(" ");
      }
      if(i == 0){ 
      System.out.print("SUN");
      }
      else if(i == 1) {
      System.out.print("MON");
      }
      else if(i == 2) {
      System.out.print("TUE");
      }
      else if(i == 3) {
      System.out.print("WED");
      }
      else if(i == 4) {
      System.out.print("THU");
      }
      else if(i == 5) {
      System.out.print("FRI");
      }
      else {
      System.out.print("SAT");
      }
      for(int j = 0; j < SIZE / 2 - 2; j++) {
      System.out.print(" ");
      }
     }
     System.out.println();
     for(int i = 0; i < SIZE * cell + 1; i++) {
     System.out.print("O");
     }
     System.out.println();
     int startDay = startDay(month);
     int days = daysInMonth(month);
     int row = 0;
     while(row * cell -startDay + 2 <= days){
     drawRow(row, startDay, days, day);
     row++;
     }
    } 
  
//Draws each row of the month.      
public static void drawRow(int row, int startDay, int days, int day) {         
      drawNRow(row, startDay, days, day);
      for(int i = 0; i < SIZE / 2 - 1; i++) {
      System.out.print("J");
      for(int n = 0; n < cell; n++) {
         for(int c = 0; c < SIZE - 1; c++) {
         System.out.print(" ");
         }
         System.out.print("J");
        }
        System.out.println();
       }
       for(int n = 0; n < SIZE * cell + 1; n++) {
       System.out.print("O");
       }
       System.out.println();
      }
   
//Numbers the rows along with marking the specific day entered by the user.   
public static void drawNRow(int row, int startDay, int days, int day){
   System.out.print("J");
   if(row == 0) {
      int rowStart = 1;
      for(int i = 0; i < cell - (cell - startDay + 1); i++) {
         for(int c = 0; c < SIZE - 1; c++) {
            System.out.print(" ");
            }
            System.out.print("J");
            }
      for(int n = 0; n < cell - startDay + 1; n++) {
         System.out.print(" " + rowStart + " ");
         int nLength = (rowStart + "").length();
         for(int c = 0; c < SIZE - nLength - 3; c++) {
         if(rowStart == day) {
         System.out.print("$");
        
         }         
         else { 
         System.out.print(" ");
         }
       } 
       System.out.print("J");
       rowStart++;
       }
       System.out.println();
       }
       else {
       int rowStart = row * cell - startDay + 2;
       for(int n = 0; n < cell; n++) {
       int nLength = 0;
       if(rowStart <= days) {
         System.out.print(" " + rowStart + " ");
         nLength = (rowStart + "").length();
         }
         else{
         nLength = -2;
         }
         for(int c = 0; c < SIZE - nLength - 3; c++) {
          if(rowStart == day && rowStart <= days) {
          System.out.print("$");                     
         }
         else{
         System.out.print(" ");
         }
        }
        System.out.print("J");
        rowStart++;
       }
       System.out.println();
      }
     }
   
   //creates the number of days reqired in each month.    
   public static int daysInMonth(int month) {
     if(month == 4 || month == 6 || month == 9 || month == 11) { 
     return 30;
     }
     else if(month == 2){
     return 28;
     }
     else{
     return 31;
     }
    }
   //makes sure starting date is correct. 
   public static int startDay(int month) {
      int day = Starting_Year_Cell + 1;
      for(int i = 1; i < month; i++) {
      day = (day + daysInMonth(1) % 7) % 7;
      }
      if(day == 0) {
      day = 7;
      }
      return day;
      }
   
      
 //displays the date
   public static void displayDate(int month, int day){
      System.out.println("Month: " + month);
      System.out.println("Day: " + day);
   }
   
   public static int monthFromDate(String date){
      int index = date.indexOf("/");
      String month = date.substring(0, index);
      return Integer.parseInt(month);
   }
 
   public static int dayFromDate(String date){
      int index = date.indexOf("/");
      String month = date.substring(index + 1);
      return Integer.parseInt(month);
   }
   public static boolean loadEventsFromFile(String filename) throws FileNotFoundException {
      eventArray = new String[12][];
      for(int i = 0; i < 12; i++)
      {
      eventArray[i] = new String[daysInMonth(i)];
      }
      try{ 
      Scanner input = new Scanner(new File(filename));
      while(input.hasNext())
      {
      String date = input.nextLine();
      System.out.print(date);
      String event = input.nextLine();
      int day = dayFromDate(date);
      int month = monthFromDate(date);
      eventArray[month-1] [day-1] = event;
      }
      input.close();
      return  true;
     }
     catch (FileNotFoundException e)
     {
     return false;
     }    
   }
   }
   


   
    
    
    
