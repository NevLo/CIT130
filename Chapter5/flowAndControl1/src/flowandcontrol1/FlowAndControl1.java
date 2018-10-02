
package flowandcontrol1;


public class FlowAndControl1 {

    
    public static void main(String[] args) {
        int age = 100;
        boolean test;
        
        test = (age  > 18);
        System.out.println("age > 18 is " + test);
        
        
        //Logical NOT
        test = !(age  < 18);
        System.out.println("age < 18 is " + test);
        
        
        //Logical AND
        test = ((age == 75) && (age % 2 == 0));
        System.out.println("(age == 75) && (age % 2 == 0) is " + test);
        //Logical OR
        test = ((age == 75) || (age % 2 == 0));
        System.out.println("(age == 75) || (age % 2 == 0) is " + test);
        //Logical AND and OR
        test = ((age >= 65 || age < 18 && false));
        System.out.println("(age >= 65 || age < 18 && false) is " + test);
        String message;
        if(age >= 75 ){
            message = "Wow you are old!";
            System.out.println(message);
            System.out.println("Would you like to lie down?");
        }else if(age % 2 == 0){
            
            System.out.println("Wow, your age is even!");
            message = "test";
           
           }
        
        float x = 11 * .1F;
        
        float y = .1F +.1F +.1F +.1F +.1F +.1F +.1F +.1F +.1F +.1F +.1F;
        
        System.out.println(x + "\n" + y);
        System.out.println(x == y);
        float unacceptable = 0.00001f;
        boolean test1 = Math.abs(x - y) > unacceptable;
        System.out.println(test1);
        String message2 = (age > 65 ? "old" : "young");
        
        if(age > 65) 
        {
            message2 = "old";
        }
        else 
        {
            message2 = "young";
        }
        System.out.println(message2);
        
        
    }
    
}
