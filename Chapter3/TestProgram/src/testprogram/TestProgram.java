package testprogram;

public class TestProgram {

    public static void main(String[] args) {
        //Local Variable
        int num = 0;
        System.out.println(num);
    
        SimpleDate date = new SimpleDate();
        System.out.println(date.getDay());
        
        SimpleDate d1 = new SimpleDate();
        
        d1.setDay(17);
        System.out.println(d1.getDay());
        
        String someName = new String("Burt Reynozxfvz");
        String nameTwo = "Sally Fields";
        System.out.println(nameTwo.compareTo(someName));
        char someLetter = someName.charAt(7);
        System.out.println(someLetter);
        System.out.println(someName.length());
        System.out.println(someName.charAt(someName.length()-1));
    }
}
