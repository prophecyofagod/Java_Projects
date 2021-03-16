/*
    Mario Saiz
    Game Project
    2017
*/

import java.util.Scanner;
import java.io.File;

public class Adventure2R2
{
   public static void main( String[] args ) throws Exception {
      Scanner keyboard = new Scanner(System.in);
   	
      int nextroom = 1;
      String choice = "";
      int r;
      int repeats = 5;
		int steps_per_second = 10;
      
      for ( int i=0; i<20; i++) 
      {
         if ( i%10 == 0 )
            System.out.print("Loading... |   \r");
         if ( i%10 == 1 )
            System.out.print("Loading... /   \r");
         if ( i%10 == 2 )
            System.out.print("Loading... -   \r");
         if ( i%10 == 3 )
            System.out.print("Loading... \\   \r");
         if ( i%10 == 4 )
            System.out.print("Loading... |   \r");
         if ( i%10 == 5 )
            System.out.print("Loading... /   \r");
         if ( i%10 == 6 )
            System.out.print("Loading... -   \r");
         if ( i%10 == 7 )
            System.out.print("Loading... \\   \r");
         if ( i%10 == 8 )
            System.out.print("Loading... /   \r");
         if ( i%10 == 9 )
            System.out.print("Loading... -   \r");
         if ( i%10 == 10 )
            System.out.print("Loading... \\   \r");


            Thread.sleep(100);
         }
         
         
         
         
         System.out.println("  ____        _   _   __    | ");
         System.out.println(" |____  |  | | \\ | \\ |__ |\\ | ");
         System.out.println("  ___ | |__| |_/ |_/ |__ | \\| ");
         
         System.out.println("\n   __    __   _   ___         /    /   ");
         System.out.println("  |  \\  |    / \\   |  |  |   /__  /__  ");
         System.out.println("  |   | |--  |--|  |  |--|     /    /  ");
         System.out.println("  |__ / |__  |  |  |  |  |    /    /   ");
         
   
      while ( nextroom != 0 )
      {
         if ( nextroom == 1 )
         {
            System.out.println( "\n\nYou are in the living room. There is a \"door\" to \nthe back porch and a doorway to the \"hall\". Where would you like to go?" );
            System.out.print( "> " );
            choice = keyboard.nextLine();
            if ( choice.equals("door") )
               nextroom = 2;
            else if ( choice.equals("hall") )
               nextroom = 3;
            else
               System.out.println( "ERROR." );
         }
         if ( nextroom == 2 )
         {
            System.out.println( "\nYou are outside on the back porch, and you see that the outside \"basement\" door is open, ");
            System.out.println("then you hear something inside in the \"attic\"." );
            System.out.println("Do you check the attic or the basement?");
            System.out.print( "> " );
            choice = keyboard.nextLine();
            if ( choice.equals("basement") )
               nextroom = 5;
            else if ( choice.equals("attic") )
               nextroom = 6;
            else
               System.out.println( "ERROR." );
         }
         if ( nextroom == 3 )
         {
            System.out.println( "\nYou are now in a hallway. Oddly, there is a \"glowing\" door" );
            System.out.println( "and an open \"door\" that happens to be pitch black inside." );
            System.out.println( "Otherwise, the hall extends, for about 9 feet and both end at a wall." );
            System.out.println( "Do you want to enter the black \"door\" or approach the \"glowing\" door looking for clues?" );
            System.out.print( "> " );
            choice = keyboard.nextLine();
         
            if ( choice.equals("door") )
               nextroom = 1;
            else if ( choice.equals("glowing") )
               nextroom = 4;
            else
               System.out.println( "ERROR" );
         }
         if ( nextroom == 4 )
         {
            System.out.println( "\nYou go up to the door and feel it attracting you inside." );
            System.out.println( "You open the door and a bright flash of light blinds you, " );
            System.out.println( "and you can't see anything, but you feel some type of energy." );
            System.out.println( "You are now able to see. You are in a bright white room and you see a glowing ring.");
            System.out.println( "You put it on and all of a sudden!...." );
            System.out.println( "\nTo be continued..." );
            nextroom = 0;
                  for ( int i=0; i<repeats*11 ; i++ ) {
      			if ( i%11 == 0 )
      				System.out.print(" .oOo..... \r");
      			else if ( i%11 == 1 )
      				System.out.print(" ..oOo.... \r");
      			else if ( i%11 == 2 )
      				System.out.print(" ...oOo... \r");
      			else if ( i%11 == 3 )
      				System.out.print(" ....oOo.. \r");
      			else if ( i%11 == 4 )
      				System.out.print(" .....oOo. \r");
      			else if ( i%11 == 5 )
      				System.out.print(" ......oOo \r");
      			else if ( i%11 == 6 )
      				System.out.print(" .......oO \r");
      			else if ( i%11 == 7 )
      				System.out.print(" o.......o \r");
      			else if ( i%11 == 8 )
      				System.out.print(" Oo....... \r");
      			else if ( i%11 == 9 )
      				System.out.print(" oOo...... \r");
      			else if ( i%11 == 10 )
      				System.out.print(" .oOo..... \r");
      
      			Thread.sleep(1000/steps_per_second);
      		}
            
         		String filename = ("Death.txt");   
                     	
         	   
         		Scanner wordReadr = new Scanner(new File(filename));   
            
            
         		while ( wordReadr.hasNext() ) {   
         			String t = wordReadr.nextLine();   
         			System.out.println(t+" ");
         		}
         		wordReadr.close();
         
         }
      
         if ( nextroom == 5 )
         {
            System.out.println( "\nYou are now in the basement. Oddly, there is a \"box\" that is glowing and a big \"lever\" next to it." );
            System.out.println( "You also notice a broken lock on the floor and broken glass scattered around." );
            System.out.println( "You hear a noise behind you, and the basement door closes. You freak out and stay facing forward." );
            System.out.println( "Do you want to open the \"box\" and jump in, or pull the \"lever\"?" );
            System.out.print( "> " );
            choice = keyboard.nextLine();
         
            if ( choice.equals("box") )
               nextroom = 6;
            else if ( choice.equals("lever") )
               nextroom = 6;
            else
               System.out.println( choice + "ERROR" );
         }
         if ( nextroom == 6 ) 
         {
         
            for ( int i=0; i<1000; i++ ) {
      			r = 1 + (int)(Math.random()*4);
      		
      		
      		if ( r == 1 ) {
                  System.out.print("WOOSH!                              \r");
      		}
      		if ( r == 2 ) {
                 	System.out.print("     WOOSH!                        \r");
      		}
      		if ( r == 3 ) {
                  System.out.print("         WOOSH!                    \r");
      		}
      		if ( r == 4 ) {
                  System.out.print("               WOOSH!            \r");
            }
      			
      		Thread.sleep(2);
        }
            System.out.println("\nWOOSH!");

            System.out.println( "\nYou are now in the attic. Oddly, there is a tall man standing there by a" );
            System.out.println( "window. He stands there with a staff that crackles in his hand. He turns around and sees you then," );
            System.out.println( "runs towards you, like he's going to kill you, you notice a knife on the floor." );
            System.out.println( "You grab the knife and run towards him, but he stomps his staff on the ground and a bright flash of light occurs." );
            nextroom = 0;            
                     
                
      		for ( int i=0; i<1000; i++ ) {
      			r = 1 + (int)(Math.random()*4);
      		
      		
      		if ( r == 1 ) {
                  System.out.print("Oh                              \r");
      		}
      		if ( r == 2 ) {
                 	System.out.print("     no,                        \r");
      		}
      		if ( r == 3 ) {
                  System.out.print("         you                    \r");
      		}
      		if ( r == 4 ) {
                  System.out.print("               died!            \r");
            }
      			
      		Thread.sleep(2);
        }
            System.out.println("Oh no, you died!");
    }     
   }
  }
 }