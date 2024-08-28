/*
Name: Ronit Narayan
Date: 9/7/2022
description: This program aims to display up to 10 distinct numbers of which is imputed by the user. It does this by checking to see if the numbers are not repeats, then adding them to the list. Once 10 distinct numbers have been identified, it deletes the repeated numbers displaying the 10 distinct numbers.
self grade: My grade is 100 because I have added significant comments to my all my methods, while also testing my code with different numbers to make sure the output is correct. The variables and methods also have understandable names.

Testimony: I have written this program all by myself and have not copied any code from any resourses: _____Ronit Narayan_______ 

*/
import java.util.*;
public class DistinctNumbersNarayan
{
  // int[] num = new int[10];
   public static void main(String[] args)
   {
     System.out.println("Welcome to the distinct numbers. \nI will remove the repeated numbers and display the numbers you just entered"); //Instructs the user to enter 10 distinct numbers while, also telling it that it will remove duplicate numbers  
     int[] num = new int[10];            //Declares an array with 10 spaces for the Distinct numbers
     int counter = getInput(num);        //Creates a variable, and calls getInput which returns the total number of numbers entered by the user and filling the array with Distinct numbers
     display(num, counter);              //Calls the method display with prints the the array of Distinct numbers
   }
   
   public static int  getInput(int[] numbers) //This method retrieves a array of integers which it then fills up with Distinct numbers entered by the user and returns the total count of numbers entered by the user
   {
       //your code
       Scanner scan = new Scanner(System.in);  //Calls the scanner class to allow for user imput
       
       int v;                                  //Serves as the variable which the users entered number be held
       int total = 0;                          //Serves as the variable for the total amount of numbers entered
       for(int i = 0; i < numbers.length; i++){//Goes through the array
         v = scan.nextInt();                   //Uses the scanner class to imput the users Integer into the variable v
         total++;                              //Adds one to the total count of numbers entered
         boolean same = isDistinct(numbers, v);//Calls the isDistinct method to check to see if the entered number is in the array
         if(same == false)                     //Checks to see if the number isn't a duplicate
            numbers[i] = v;                    //Adds the number to the array
         else
            i--;                               //If isDistinct returns true the variable i subtracts by one to allow for the loop to run again without counting the duplicate number
       }
       return total; // Returns the total amount of numbers entered by the user
   }
   
   public static void display(int[] num, int counter) //Displays the given array along with the given Integer
   {
     //your code
     System.out.println("You entered " + counter + " numbers total, I filtered out all the repeated numbers.\nHere is a list of distinct numbers you entered."); //Prints out the total number of numbers entered and explains that the list below is all the distinct numbers entered
     System.out.print("{"); //Prints out curly brackets at the beginning of the list of distinct numbers
     for(int n = 0; n < num.length; n++){  //Loops through the given array
      System.out.print(num[n]);            //Prints out the number on the same line
      if(n != num.length-1)                //Checks to see if the index isn't the end
         System.out.print(",");            //Adds a comma in front of the number
     }
     System.out.print("}"); //Prints out curly brackets at the end of the list of distinct numbers
    }
    
   public static boolean isDistinct(int[] num, int n) //This method takes a array of integers and a single integer, which it then checks to see if such integer is containted within the array. If so it returns a boolean value
   {
      //your code
      for(int i= 0;i <num.length;i++) {     //loops through the array if integers
      if(num[i] == n)                       //It checks one integer in the array to the single integer                             
         return true;                       //It returns true if the duplicate integer is located
      }   
      return false;                         //It returns false if the duplicate integer is not located                 
   }
 }