// Evan Hillyard
// Partners: Michael Woo, Jon Bennett
// 3/2/22
// CS 140
// Lab #4: Guessing Game
//
//This program is a guessing game where a number is generated between 1 and a program defined range.
//The game keeps track of player statistics for all games played and displays those statistics when
//the player indicates that they are finished playing.

import java.util.*;        //for Scanner and Random

public class GuessingGame
{
   public static final int range = 100;         //Determines the maximum range of possible random values for the guessing game. The range always starts at 1.
   
   //Prompts the player to guess a number between 1 and the total range.
   //Continues the game until the player guesses correctly and then prompts them if they want
   //to play again.
   public static void main(String [] args)
   {
      Scanner userin = new Scanner(System.in);
      Random ran = new Random();
            
      boolean playagain = true;
      boolean isvalid = false;
      boolean iscorrect = false;
      
      double games = 0;          
      double guesses= 0;         //total guesses
      
      int guess = 0;             //player guess
      int best = 0;
      
      tutorial();
      
      while(playagain == true)
      {
         int gamenum = ran.nextInt(range) + 1;
         int roundguesses = 0;         //stores guesses for one round only
        
         while(isvalid == false)
         {
            games++;
            System.out.print("\nI'm thinking of a number between 1 and " + range + "...\nYour guess? ");
         
            guess = userin.nextInt();
            
            if(guess <= range && guess > 0)
               isvalid = true;
         }
         
         isvalid = false;
         
         while(iscorrect == false)
         {
            iscorrect = playGame(gamenum, guess);

            guesses++;
            roundguesses++;
            
            if(iscorrect == false)
            {
               System.out.print("Your guess? ");
               guess = userin.nextInt();      
            }     
         }
         
         if(games == 1)
            best = roundguesses;
         else if(roundguesses < best)
            best = roundguesses;
         
         iscorrect = false;
         
         if(roundguesses == 1)
            System.out.println("You got it right in 1 guess");
         else
            System.out.println("You got it right in " + roundguesses + " guesses");
         
         while(isvalid == false)
         {
            System.out.print("Do you want to play again? ");          //Accepts any response that begins with "y" or "n"
            
            String usercontinue = userin.next();
            
            if(usercontinue.substring(0, 1).equalsIgnoreCase("y"))
               isvalid = true;
            else if(usercontinue.substring(0, 1).equalsIgnoreCase("n"))
            {
               playagain = false;
               isvalid = true;
               showStats(games, guesses, best);
            } 
            else
            {
               System.out.println("\"" + usercontinue + "\" is not a valid response. Please try again.");
            }
         }
         
         isvalid = false;
      }
      
   }
   
   //Instructs players on how to play the game.
   public static void tutorial()
   {
      System.out.println("This program allows you to play a guessing game.");
      System.out.println("I will think of a number between 1 and ");
      System.out.println(range + " and will allow you to guess until");
      System.out.println("you get it.  For each guess, I will tell you");
      System.out.println("whether the right answer is higher or lower");
      System.out.println("than your guess.");
   }
   
   //Determines if the number guessed is higher, lower, or the same as the random number. 
   //Returns a boolean that represents if the guess was correct or not.
   public static boolean playGame(int gamenum, int guess)
   {        
      if(guess < gamenum)
         System.out.println("It's higher.");
      else if(guess > gamenum)
         System.out.println("It's lower.");
      else if(guess > 100)
         System.out.println("that is higher then 100 try again");
      else if(guess == gamenum)
      {
         return true;
      } 
      
      return false;
   }
   
   //Displays the final stats of the game after the player is done playing.
   //Program ends after this method is completed.
   public static void showStats(double games, double guesses, int best)
   {
      System.out.println("\nOverall results:");
      System.out.println("    total games   = " + (int) games);
      System.out.println("    total guesses = " + (int) guesses);
      System.out.println("    guesses/game  = " + Math.round((guesses / games) * Math.pow(10, 1)) / Math.pow(10, 1));
      System.out.println("    best game     = " + best);
   }
}