import java.util.*;
import java.io.*;
public class BinarySearchTreeNarayan {

}

class BinarySearchTree {
   
   //Start of private Node class
   private class Node {
      
      public Node left;  //Initializes a left and right node for the binarytree
      public Node right;
      public int keyy;   //Initializes a integer for the number for each node
      public String value; //Initializes a value to hold a string for the node
      
      public Node(int key, String value) { //Constructor class for node which takes in the parameters of a integer and string value
         keyy = key;       //Sets the key parameter to the keyy varaible
         this.value = value;   //Sets the value parameter to the string "value" in the class
      }
      
      public String toString(String label, int indent) {  //Has a label and indent as its parameters which define how the node is printed
         String text = ""; //Initializes a empty string variable to print the node to
         int num = indent; //Defines the indent for the string variable
         
         while(num != 0) { //Checks to see if the indent is not zero, then adds a space
            text += "   ";
            num--;         //Deacreases the indent number to prevent a infinite loop
         }
         text += label + ": ";                       //Adds the label to define the root of the tree
         text += this.keyy + "  " + this.value + "\n"; //Adds the keyy and value to the text variable and moves to the next line
         
         if (left != null) {                        //If left is not empty it marks node with L and increases indent by using recursion 
            text += left.toString("L", indent + 1); 
         }
         
         if (right != null) {                       //If right is not empty it marks node with R and increases indent by using recursion 
            text += right.toString("R", indent + 1);
         }
         return text;  //Returns completed text String variable
      }
      
      public void add(int key, String value) {    //This method allows the user to add to the tree by creating a node and taking in a key and value parameter
         if (key < this.keyy) {                   //Checks to see if the parameter key is less than the key in the class then assigns it to the left node
            if (left == null) {
               left = new Node(key, value);
            }
            else {                                //If not the method recurses itself by using the same key and value and checking the next left node
               left.add(key, value);
            }
         }  
         if (key > this.keyy) {
            if (right == null) {                 //Checks to see if the parameter key is greater than the key in the class then assigns it to the right node
               right = new Node(key, value);
            }
            else {                               //If not the method recurses itself by using the same key and value and checking the next right node
               right.add(key, value);
            }
         }
      }
   }
   //Start of BinarySearchTree class
   
   private Node root;          //Declares a node in the class for the root
   
   public String About() {      //Method returns my name the Author of this class
      return "Ronit Narayan";
   }
   
   public String toString() {  //Method allows to print the 
      if (root == null)        //Checks to see if the root is null then returns a empty string
         return "";
      return root.toString("*" , 0); //Calls the toString method from the Node class at the root
   }
   
   public void add(int key, String value) { //Allows the user to add a value to the tree 
      if (root == null) { //Checks to see if the root is null
         root = new Node(key,value); //Initilizes a new node for the root
      }
      else {
         root.add(key,value); //Calls the add method from the Node Class to determine if it is right or left
      }
   }
}

class Main {
   public static void main (String [] args) {
      BinarySearchTree tree = new BinarySearchTree(); //Creates the BinarySearchTree
      try {
         BufferedReader reader = new BufferedReader(new FileReader("/Users/ronitnarayan/Desktop/Project2TestFiles/halloweencalories2.txt")); //Calls the BufferedReader class to read file
         String line;                                 //String for line of text read
         while((line = reader.readLine()) != null) { //loops through the text till line is null and file has been read
            String[] p = line.split(", ");           //Seperates the number and string in the text file
            int number = Integer.parseInt(p[0]);     //Seperates the string into its own string variable
            String text = p[1];                      //Seperates the number into an integer
            tree.add(number, text);                  //Adds the number and text using the add function in the BinarySearchTree class
         }
         reader.close(); //Ends the file reader
      }
      catch (Exception ex) {
         return;
      }
      
      System.out.println(tree.toString());  //Uses the toString method from the BinarySearchTree class to print out the resulting tree
   }
}