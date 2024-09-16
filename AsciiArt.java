
// Evan Hillyard
// Partners: Michael Woo, Jon Bennett
// 1/27/22
// CS 140
// Lab #2
// 
//This programs prints an ASCII art of a rocketship, the height of which is determined by the class constant "height."

public class AsciiArt
{
   public static final int height= 20;                                                  //Change this variable to change the height of the rocketship - VALID VALUES OF HEIGHT ARE WHOLE NUMBERS 3 TO 6  
   
   public static void main(String[]args)                                               //Main calls the custom pattern, then calls the rocketship components in order 
   {                                                                                  
      noseEngine();                                                                    //The rocketship consists of four main components - the nose, two body components, and the engine
      divider();                                                                       //Each component of the rocketship is divided by a line printed by divider()
      bodyUp();                                                                        //noseEngine() builds both the topmost nose component and the bottommost engine component
      bodyDown();                                                                      //bodyUp() and bodyDown() each print half of a body component
      divider();                                                                       //bodyUp() and bodyDown() are each called twice in different orders to build different paterns for each body component
      bodyDown();
      bodyUp();
      divider();
      noseEngine();
   }
   
   public static void noseEngine()                                                     //Builds both the nose cone and the engine of the rocket
   {
      for(int x = 0; x < height * 2 - 1; x++)                                          //Loop determines how many lines tall this section of the rocket will be based on hieght variable
      {
         for(int tSpace = height + (height - 1) - x; tSpace > 0; tSpace--)             //Loop prints the spaces before the "/'s"
         {
            System.out.print(" ");
         }
          
         for(int lCone = 0; lCone <= x; lCone++)                                       //Loop prints the left side of the nose cone
         {
            System.out.print("/");
         }
        
         System.out.print("**");                                                       //Always prints "**" in the middle of the cone each loop of the oouttermost for statement
         
         for(int rCone = 0; rCone <= x; rCone++)                                       //Loop prints right side of the nose cone
         {
            System.out.print("\\");
         }
         
         System.out.println();                                                         //Ends the line at the end of each loop of the outtermost for statement
      }
   }
   
   public static void bodyUp()                                                         //Builds the half of the body component of the rocketship that displays the pattern with the arrows facing up
   {
      for(int x = 0; x < height; x++)                                                  //Loop Determines how many lines tall this section of the rocket will be based on hieght variable
      {
         System.out.print("|");                                                        //Prints the left side of the rocket component each loop
         
         for(int tlDots = 0; tlDots < height - x - 1; tlDots++)                        //Loop prints the leftmost set of dots
         {
            System.out.print(".");
         }
         
         for(int tlSlashes = 0; tlSlashes <= x; tlSlashes++)                           //Loop prints the left arrow
         {
            System.out.print("/\\");
         }
         
         for(int tmDots = (height - x - 1) * 2; tmDots > 0; tmDots--)                  //Loop prints middle set of dots
         {
            System.out.print(".");
         }
         
         for(int trSlashes = 0; trSlashes <= x; trSlashes++)                           //Loop prints right arrow
         {
            System.out.print("/\\");
         }
          
         for(int trDots = 0; trDots < height - x - 1; trDots++)                        //Loop prints the rightmost set of dots
         {
            System.out.print(".");
         } 
         
         System.out.println("|");                                                      //Prints the right side of the rocket component for each loop and goes to the next line
      }      
      
   
   }
   
   public static void bodyDown()                                                       //Builds the half of the body component of the rocketship that displays the pattern with the arrows facing down
   {
      for(int x = 0; x < height; x++)                                                  //Loop determines how many lines tall this section of the rocket will be based on hieght variable
      {
         System.out.print("|");                                                        //Prints the left side of the rocket component each loop
         
         for(int blDot = 0; blDot < x; blDot++)                                        //Loop prints the leftmost set of dots
         {
            System.out.print(".");
         }
       
         for(int lSlashesB = x; lSlashesB < height; lSlashesB++)                      //Loop prints the left arrow
         {
            System.out.print("\\/");        
         }
          
         for(int bmDot = height; bmDot < x * 2 + height; bmDot++)                     //Loop prints the middle set of dots
         {
            System.out.print(".");
         }
          
         for(int lSlashesB = x; lSlashesB < height; lSlashesB++)                      //Loop prints the right arrow
         {
            System.out.print("\\/");        
         }
          
         for(int brDot = 0; brDot < x; brDot++)                                        //Loop prints the rightmost set of dots                                        
         {
            System.out.print(".");
         }
         
         System.out.println("|");                                                     //Prints the right side of the rocket component for each loop and goes to the next line
      }
   
   }
   
   public static void divider()                                                        //Builds the divider that goes in between components of the rocket
   {
      System.out.print("+");                                                           //Prints the left side of the divider
   
      for(int x = 0; x <= height * 2 - 1; x++)                                         //Loop prints the middle of the divider
      {
         System.out.print("=*");
      }
      
      System.out.println("+");                                                         //Prints the right side of the divider
   }
}