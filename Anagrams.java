//Jon Bennett
//assignment 3 "Anagrams"
//CS&145
//06/07/2022

import java.util.*;



public class Anagrams{
   private Set<String> dictionary;
   
   public Anagrams(Set<String> dictionary){
      if(dictionary == null)
      {
      throw new IllegalArgumentException("dictionary cannot be null");
      }
      else
      {
      this.dictionary = dictionary;
      }
    }
   
   //This will accepted the parameter phrase and returns a set of all of the words from dictXX.txt files that are 
   //within the letters of that phrase.
   public Set<String> getWords(String phrase){
      if(phrase == null)
      {
      throw new IllegalArgumentException("phrase cannot be null");
      }
      else
      {
      Set<String> validWords = new TreeSet<String>();
      LetterInventory testPhrase = new LetterInventory(phrase);
         for(String i : dictionary)
         {
         LetterInventory dictWord = new LetterInventory(i);
            if(testPhrase.contains(dictWord))
            {
            validWords.add(i);
            }
         }
         return validWords;
      }
   }
   
   //prints out all of the anagrams that could be made using the 
   //letters from the phrase that was submitted.
   
   public void print(String phrase){
      Set<String> validWords = getWords(phrase);
      LetterInventory convertPhrase = new LetterInventory(phrase);
      List<String> choice = new LinkedList<String>();
      print(convertPhrase, validWords, choice, -1);
   }
   
   //Private helper method for the print method. 
   //This will allow it to Accepts additional data as parameters. 
   //Along with a LetterInventory based on the phrase String, a Set of Strings containing the set returned by a 
   //getWords call on the String phrase and a List of strings that contains the choice that will 
   //eventually be printed. As well as the max number of words allowed in the resulting anagram.
   
   private void print(LetterInventory phrase, Set<String> validWords, List<String> choice, int max){
      if(phrase.isEmpty())
      {
      System.out.println(choice);
      }
      else if(max != 0){
         for(String i : validWords)
         {
            if(i.length() <= phrase.size() && phrase.contains(i))
            {
               choice.add(i);
               phrase.subtract(i);
               print(phrase, validWords, choice, max - 1);
               phrase.add(i);
               choice.remove(i);
            }
         }
      }
   }
   
   //This will Accepts a string phrase while utilizing int max and
   // prints out all of the anagrams that could be made 
   // from using the letters from that phrase.
   public void print(String phrase, int max){
      if(max == 0){
         max = -1;
      }
      Set<String> validWords = getWords(phrase);
      LetterInventory convertPhrase = new LetterInventory(phrase);
      List<String> choice = new ArrayList<String>();
      print(convertPhrase, validWords, choice, max);
   }
}