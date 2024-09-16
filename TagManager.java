/*By: Jon Bennett
CS&145 Assignment 2: tag
05/22/2022
*/



import java.io.*;
import java.util.*;

public class TagManager {

private LinkedList<PlayerNode> gameRing = new LinkedList<PlayerNode>();
private LinkedList<PlayerNode> history = new LinkedList<PlayerNode>();

//constructor, adds the entire list of names string into the game ring,
//throws and Illegal for the names file being empty or nonexistent

   public TagManager(List<String>names){
      if (names == null || names.size() == 0){
      throw new IllegalArgumentException();
      }
      else
      {
      gameRing.add(new PlayerNode(names.get(0)));
         for (int i = 1; i <= names.size() - 1; i++) 
         {
         gameRing.add(new PlayerNode(names.get(i), gameRing.getLast()));
         }
      gameRing.getFirst().next = gameRing.get(1);
     }
   }
   
   
//prints out what has been passed to it by the constructor, throws an Illegal if the gameOver condition has been met
   public void printGameRing(){
      if (isGameOver() == true) 
      {
      throw new IllegalArgumentException();
      }
      else
      {
      for (int i = 0; i <= gameRing.size() - 1; i++){
         if( i == gameRing.size() - 1){
         System.out.println(gameRing.getLast().name + " Is Trying To Tag " + gameRing.getFirst().name);
         }
         else
         {
         System.out.println(gameRing.get(i).name + " Is Trying To Tag " + gameRing.get(i + 1).name);
         }
      }
   }
}


//Prints the history of the gameRing
   public void printHistory(){
      if (history.isEmpty()){
      }
      else
      {
      for(int i = history.size() - 1; i >= 0; i--) {
         System.out.println(history.get(i).name + " was tagged by " + history.get(i).tagger);
        }
      }
   }
   
   
//Creates the condition for removing a name from the game ring only if the name and user input match
   public boolean gameRingContains(String name){
      boolean result = false;
         for (PlayerNode player : gameRing) {
         if (player.name.equalsIgnoreCase(name)) {
         result = true;
         break;
        }
      }
      return result;
    }
    
    
//this is the same method as above however for the gamerign history 
   public boolean historyContains(String name){
      boolean result = false;
      for (PlayerNode player : history) {
      if (player.name.equalsIgnoreCase(name)) {
      result = true;
      break;
      }
    }
    return result;
   }
   
   
//condition that ends the game if the list is 1 or less
   public boolean isGameOver(){
      boolean result = false;
      if (gameRing.size() == 1){
      result = true;
      }
      return result;
      }
      
   //runs the gamering if there is only one left.
   public String winner(){
      if (isGameOver()) {
      return gameRing.getLast().name;
      }
      return null;
    }
    
    
//method for tagging and removing a name, throws Illegal if the game is over, or if the name is not valid, or both.
//this will ingore casing for input to check, as well as for all names but the one for the end and for the ginal name in the gameRing. 
//After which it will remove the play from the gamering and add them to the history list. 
   public void tag(String name){
      if (isGameOver() && gameRingContains(name)){
      throw new IllegalStateException();
      }
      else if (isGameOver())
      {
      throw new IllegalStateException();
      }
      else if (gameRingContains(name) == false) 
      {
      throw new IllegalArgumentException();
      }
        for (int i = 0; i <= gameRing.size() -1; i++) {
         PlayerNode player = gameRing.get(i);
            if (player.name.equalsIgnoreCase(name)) { 
               if (i == gameRing.size() -1) {
               player.tagger = gameRing.get(i - 1).name; 
               }
               else if (i == 0)
               {
               player.tagger = gameRing.getLast().name;
               }
               else 
               {
               player.tagger = gameRing.get(i + 1).name;
               }
               gameRing.remove(player);
               history.add(player);
               break;
               }
             }
          }  
       }