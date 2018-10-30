package FunWithObjects;

public class Main {
    
    public static void main(String[] args) {
       //Object Declaration = Instantiation
       Character cOne = new Character();
       Character luigi = new Character("Luigi", 55.7, 50, false);
       
       
       
       cOne.setName("JUSAPlayer1");
       cOne.displayMethod();
       
       luigi.displayMethod();
       cOne.setHeight(1000);
       if(cOne.getHeight() > 100){
           System.out.println("Thats a big Yoshi!");
       }
    }
      
    
}
