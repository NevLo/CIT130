/*
Name: Christian Pilley
Desc: Skeleton example program
*/
package skeletonprogram;


public class SkeletonProgram {

   
    public static void main(String[] args) {
      int radius = 12;
      double pi = 3.14159;
      double area = radius * radius * pi;
      
      char someLetter = 0011;
      boolean isCool = true;
      String name = "Beth";
      String lastName = "Smith";
      
      
      System.out.println(area);
      System.out.println(name + someLetter + lastName);
    
      int a, b, result;
      a = 7;
      System.out.println(a);
      
      b = 3;
      result = a / b;
      int remainder = a % b;
      System.out.println("Result is: " 
              + result + " " + remainder + "/" +b);
 
      // Increment and decremement
      System.out.println();
      System.out.println(a);
      System.out.println(a++);
      System.out.println(a--);
      
      System.out.println();
      System.out.println(a);
      System.out.println(++a);
      System.out.println(--a);
      //Short hand
      radius = radius + 1;
      radius += 1;
    
    
    
    }
    
}
