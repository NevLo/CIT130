package me.pilley.christian.addresses;

import java.util.Scanner;
//name: Christian Pilley
//desc: address substringer
//date: 10/5/18 :: 03:17

public class Address {
   public static void main(String[] args){
      Scanner input = new Scanner(System.in);
      
      System.out.println("Please enter a web address");
      System.out.print(">>>");
      String add = input.nextLine();
      String domain = add.substring(add.length()-4,add.length());
      //System.out.println(domain);
      System.out.print("this website has a ");
      switch(domain){
         case ".gov":
        	 System.out.print("Government");
            break;
         case ".edu":
        	 System.out.print("University");
            break;
         case ".com":
        	 System.out.print("Business");
            break;
         case ".org":
        	 System.out.print("Organization");
            break;
         default:      
        	 System.out.print("other");
      }       
      System.out.print(" domain.");
      input.close();
   }
}
