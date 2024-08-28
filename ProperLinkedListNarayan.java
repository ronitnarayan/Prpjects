import java.util.*;
import java.io.*;
public class ProperLinkedListNarayan {

}

class LinkedList {
//Node Private Class
   private class Node {
      private Node next;  //Inititializes variables for node class
      private String data;
      
      public Node(String txt) {   //Class Constructor
         data = txt;
         next = null;
      }
   
      public String toStringRecurse(){   //Utilizes reiursion returning the data in a node
         if (next == null)   
            return data;
         return data + " , " + next.toStringRecurse();  //Calls itself and returns the current and next variable
     
   }
}
//Start of Linked List Code
   private Node node;     //Initilizes Nodes for the head, tail and current node
   private Node head;
   private Node tail;
   
   public String About() {      //Identifies myself as the author
      return "Ronit Narayan";
   }
   
   public void AddHead(String value) {  //Allows to add a string value to LinkedList
      node = new Node(value);           //Initializes a new node
      
      if (head == null) {               //Checks to see if the head is null then sets tail/head to string value
         head = node;
         tail = node;
      }
      else {
         node.next = head;              //moves the head so that new String value can be added
         head = node;
      }
   }
   
   public void AddTail(String value) {  //Allows to add a string value to the end of the LinkedList
      node = new Node(value);           //Initializes a new node
      
      if (head == null && tail == null) { //Checks to see if the head is null then sets tail/head to string
         head = node;
         tail = node;
      }
      else {                              //If it is not null changes to the next tail
         tail.next = node;
         tail = node;
      }
   }
   
   public Boolean IsEmpty() {           //Checks to see if the linked list is null by checking the head and tail
      if (head == null && tail == null)
         return true;
      return false;
   }
   
   public String toString() {       //Returns contents of String
      Node place = head;            //Initializes a new node to represent the head
      
      String text = "";
      if(IsEmpty()) {             //Checks to see if LinkedList is empty, if so returns blank string
         return text;
      }
      
      while(place != null) {      //Loops while place is not null
         text += place.data;      //Adds the string data to the String "text" and moves place to the next node
         place = place.next;
         if(place != null)        //Adds comma if next node is not null
            text += " , ";
      }
      return text;
   }
   
   public String toStringRecurse() {   //Returns LinkedList elements using recursion
      if (head == null) {              //Checks if LinkedList is empty
         return "";
      }
      return head.toStringRecurse();  //Calls itself to keep returning each node
   }
}
//Start of Main Class
class Main {
   public static void main (String [] args) {
      
      LinkedList list = new LinkedList(); //Declares and Initializes a new Linked List
      String line;
      
      try {
         BufferedReader reader = new BufferedReader(new FileReader("/Users/ronitnarayan/Desktop/a/teams.txt")); //Initializes BufferedReader method to read text file
         while((line = reader.readLine()) != null) { //Loops through each line of text file until it reaches null
               list.AddTail(line); //Adds the line of text from file to the LinkedList
         }
         reader.close(); //Closes the reader method
      }
      catch (Exception ex) {
         return;
      }
      System.out.println(list.toString());  //Calls the toString method from the LinkedList class
      System.out.println(list.toStringRecurse()); //Calls the toStringRecurse method from the LinkedList class
   }
}