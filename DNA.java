//Group 8:
//Evan Hillyard, Micheal Woo, Jon Bennett
//CS&141
//Lab 6: 
//DNA 
//03/18/2022

import java.io.*;      
import java.util.*;

public class DNA
{
   public static final int codons=5;
   public static final int percent = 30;
   public static final int unique = 4;
   public static final int per = 3;
//main string argument that java program follows using a throw exception to find the file to read from. 
   public static void main(String[]args)throws FileNotFoundException

   {
      int[] count = new int[4];
      double[] massPct = new double[6];
      String[] cdnlist = new String[10000];
      String[] twolines = new String[2];

      String fileIn = "";
      String fileOut = "";
      String isprotein;
      
      Scanner key = new Scanner(System.in);
      System.out.println("This program reports information about DNA");
      System.out.println("nucleotide sequences that may encode proteins.");
      System.out.println();
      System.out.print("Input file name: ");
      fileIn = key.next();
      Scanner input = new Scanner(new File(fileIn));
     

      
      while(input.hasNextLine())
      { 
         readInput(input, twolines);
         nucCount(twolines, count);
         massPct = mass(massPct, twolines);
         cdnlist = codonList(twolines);
         isprotein = checkProtein(twolines, massPct);
         printAll(twolines,count,isprotein,cdnlist, massPct);
      }  
  }
  public static String[] readInput(Scanner input, String[] twolines)
  {
      twolines[0] = input.nextLine();
      twolines[1] = input.nextLine().toUpperCase();
      
     return twolines;
  }
  //This will Print out the required fields. 
   /*public static void printAll(String[] twolines, int[]count, String isprotein, String[] cdnlist, double[] massPct)
   {  
   
         System.out.println("Region Name: " + twolines[0]);  
         System.out.println("Nucleotides: "+ twolines[1]);
         System.out.println("Nuc. Counts: " + Arrays.toString(count));
         System.out.println("Total Mass%: " + Arrays.toString(Arrays.copyOfRange(massPct, 0, 4))+ " of " + Math.round(massPct[5]*10.0)/10.0);
           System.out.print("Codons List: [");
         for(int x = 0; x <= 9999; x++)
         {
            if(!cdnlist[x].equals(""))
            {
               System.out.print(cdnlist[x]);
               
               if(!cdnlist[x+1].equals(""))
                  System.out.print(", ");
            }
         }
                  
         System.out.println("]\nIs Protein?: " + isprotein); 
         System.out.println();                          
      
   }*/
   //This will caculate the Nuc count usings if statements to create a return varible so that it accruatly counts. 
   public static int[] nucCount(String[] twolines, int[]count)
   {
       count[0]=0;
       count[1]=0;
       count[2]=0;
       count[3]=0;
               
      for(int i = 0; i < twolines[1].length(); i++)
      {  
         if(twolines[1].charAt(i)==('A'))
         {
            count[0]++;
         }
         if(twolines[1].charAt(i)==('C'))
         {
            count[1]++;
         }
         if(twolines[1].charAt(i)==('G'))
         {
            count[2]++;
         }
         if(twolines[1].charAt(i)==('T'))
         {
            count[3]++;
         }
      }  
        return count;
  }
  //this will caculate the mass %. 
  public static double[] mass(double[] massPct, String[] twolines)
  {
      Arrays.fill(massPct, 0);
                    
      for(int i = 0; i < twolines[1].length(); i++)
      {  
         if(twolines[1].charAt(i)==('A'))
         {
            massPct[5]+=135.128;
            massPct[0]+=135.28;
         }
         if(twolines[1].charAt(i)==('C'))
         {
            massPct[5]+=111.103;
            massPct[1]+=111.103;
         }
         if(twolines[1].charAt(i)==('G'))
         {
            massPct[5]+=151.128;
            massPct[2]+=151.128;
         }
         if(twolines[1].charAt(i)==('T'))
         {
            massPct[5]+=125.107;
            massPct[3]+=125.107;
         }
         if(twolines[1].charAt(i)==('-'))
         {
            massPct[5]+=100.000;
            massPct[4]+=100.000;
         }
         
      } 
         massPct[0]=Math.round(((massPct[0]/massPct[5])*100) * 10.0) / 10.0;  //math.round is rounding incorrectly by + 0.1 for this line on tyler and bogus
         massPct[1]=Math.round(((massPct[1]/massPct[5])*100) * 10.0) / 10.0;
         massPct[2]=Math.round(((massPct[2]/massPct[5])*100) * 10.0) / 10.0;
         massPct[3]=Math.round(((massPct[3]/massPct[5])*100) * 10.0) / 10.0;
         massPct[4]=Math.round(((massPct[4]/massPct[5])*100) * 10.0) / 10.0;
        
        return massPct;

  }
  //this will create the codon list. 
     public static String[] codonList(String[] twolines)
   {
      String[] codons = new String[10000];
      String[] compare = new String[10000];
      int z = 0;
      
      //for(int s = 0; s <= 10000; s++)
         Arrays.fill(codons, "");
      
      for(int x = 0; x < twolines[1].length(); x++)
      {  
         codons[z] = twolines[1].substring(x, x + 3);
         compare[x] = twolines[1].substring(x, x + 3);

        if(Arrays.equals(codons, compare))
            z--;
            
         x += 2;
         z++;
      }
      
      return codons;
   }
   //this will check the protein using if statements with return on whether yes or no.  
   public static String checkProtein(String[] twolines, double[] massPct)
   {        
       int start = twolines[1].length() - 3;
       int end = twolines[1].length();
        
       if(twolines[1].substring(0,3).equals("ATG") && (twolines[1].substring(start, end).equals("TAA") || twolines[1].substring(start, end).equals("TGA") || twolines[1].substring(start, end).equals("TAG")))
         if(twolines[1].length() >= 15 && massPct[1] + massPct[2] > 30)
            return "YES";    
       
       return "NO";
   }
}