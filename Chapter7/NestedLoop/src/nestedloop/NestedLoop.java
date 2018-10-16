package nestedloop;

public class NestedLoop {

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    System.out.print("[" + i + "] [" + j + "] [" + k + "]");
                    System.out.println("\t[" + (i==1 || j==1 || k==1) + "]");
                }
            }
        }
    }

}
