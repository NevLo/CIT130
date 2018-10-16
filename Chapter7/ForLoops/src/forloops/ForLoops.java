package forloops;

public class ForLoops {

    public static void main(String[] args) {
        String line = "Coding is fun!";

        for (int count = 0; count < line.length(); count ++) {
            char c = line.charAt(count);
            System.out.println(c);
        }

        /*
       int count = 1;
       while(count <= 10){
           System.out.println(count);
           count++;
        }
         */
    }
}
