package arraytest2;

import java.util.Scanner;

public class ArrayTest2 {

    public static void main(String[] args) {
        int[] numbers = {6, 7, 9, 1, 3, 11, 6, 19, 10, 2};
        displayArray(numbers);
        bubble(numbers);
        displayArray(numbers);

        Scanner scan = new Scanner(System.in);
        System.out.println("What number would you like to search for?");
        int key = Integer.parseInt(scan.nextLine());

        boolean isFound = binarySearch(numbers, key);
        p(isFound);

        int sum = 0;
        for (int i : numbers) {
            sum += i;
        }
        p(sum);
        p(findLargestIndex(numbers, numbers.length));
    }

    private static void p(Object val) {
        System.out.println(val);
    }

    private static int findLargestIndex(int[] val, int length) {
        int mi = 0;
        for (int x = 0; x < length; x++) {
            mi = val[mi] > val[x] ? mi : x;
        }
        return mi;
    }

    private static void displayArray(int[] val) {
        for (int i : val) {
            System.out.print(i + " ");
        }
        p("\n");
    }

    private static void bubble(int[] val) {
        int temp;
        int max;
        for (int i = val.length - 1; i >= 0; i--) {
            max = findLargestIndex(val, i + 1);
            temp = val[max];
            val[max] = val[i];
            val[i] = temp;
        }
    }

    private static boolean binarySearch(int[] val, int key) {
        int start = 0, end = val.length - 1;
        while (end >= start) {
            int middle = (start + end) / 2;
            if (val[middle] == key) {
                return true;
            } else if (val[middle] > key) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        return false;
    }

}
