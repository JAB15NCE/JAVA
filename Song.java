//Jon Bennett, Leslie Brendible, Krista Register
//20 January 2022
//CS 141
//Lab #1
//Song - The Woman Who Swallowed A Fly
//This program displays the lyrics to a song called "The Woman Who Swallowed A Fly" with our modified verse.

public class Song{
   public static void main(String[] args) {
      verse1();
      verse2();
      verse3();
      verse4();
      verse5();
      verse6();
      }
      
     //Main lyrical verse
     public static void verse1() {
      System.out.println("There was an old woman who swallowed a fly");
      System.out.println();
      last();
      }
         
     //Closing lyrical verse
     public static void last() {
      System.out.println("I Don't know why she swallowed that fly,");
      System.out.println();
      System.out.println("Perhaps She'll die.");
      System.out.println();
      System.out.println();
      }
      
     //verse two
     public static void verse2() {
      System.out.println("There was an old woman who swallowed a spider");
      System.out.println();
      System.out.println("That wriggled and iggled and jiggled inside her.");
      System.out.println();
      catch1();
      last();

      }
           
     //Spider to catch the fly
     public static void catch1() {
      System.out.println("She swallowed the spider to catch the fly,");
      System.out.println();
      }
      
     //verse three
     public static void verse3(){
      System.out.println("There was an old woman who swallowed a bird");
      System.out.println();
      System.out.println("How absurd to swallow a bird.");
      System.out.println();
      catch2();
      catch1();
      last();
      }
      
     //Bird to catch the spider
     public static void catch2() {
      System.out.println("She swallowed the bird to catch the spider,");
      System.out.println();
      }
      
     //verse four
     public static void verse4(){
      System.out.println("There was an old woman who swallowed a cat");
      System.out.println();
      System.out.println("Imagine that to swallow a cat.");
      System.out.println();
      catch3();
      catch2();
      catch1();
      last();
      }
      
     //Cat to catch the bird
     public static void catch3() {
      System.out.println("She swallowed the cat to catch the bird,");
      System.out.println();
      }
     
     //verse five
     public static void verse5() {
      System.out.println("There was an old woman who swallowed a dog,");
      System.out.println();
      System.out.println("What a hog to swallow a dog.");
      System.out.println();
      catch4();
      catch3();
      catch2();
      catch1();
      last();
      }
     
     //Dog to catch the cat
     public static void catch4() {
      System.out.println("She swallowed the dog to catch the cat,");
      System.out.println();
      }
     
     //verse six
     public static void verse6() {
      System.out.println("There was an old woman who swallowed a mountain lion,");
      System.out.println();
      System.out.println("We aint lying about how she swallowed the mountain lion.");
      System.out.println();
      catch5();
      catch4();
      catch3();
      catch2();
      catch1();
      last();
      }
      
     //Mountain lion to catch the dog
     public static void catch5() {
      System.out.println("She swallowed the mountain lion to catch the dog,");
      System.out.println();
     }
     
   }