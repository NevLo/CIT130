/*
name: Christian Pilley and Kallie Mendoza Monzon
desc: converts celsius and fahrenheit
date: 9/10/18 :: 19:45
*/
package tempconverter;

public class TempConverter {

   
    public static void main(String[] args) {
        
       final int num = 5;
       final double dom = 9.0;
       final int fac = 32;
        
        int ftemp = 72;
        double cTemp = ((num / dom) * (ftemp - fac));
        
        System.out.println(cTemp);
        
        double newFTemp = ((dom / num) * cTemp + fac);
        
        System.out.println(newFTemp);
        
    }
    
}
