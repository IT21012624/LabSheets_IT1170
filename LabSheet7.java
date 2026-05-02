Practical 7 – Bubble Sort

        Pseudocode

        START
        FOR i = 0 to n-1
        FOR j = 0 to n-i-2
        IF arr[j] > arr[j+1]
        SWAP arr[j], arr[j+1]
        END

        Java Implementation

import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[8];

        System.out.println("Enter 8 numbers:");
        for (int i = 0; i < 8; i++) {
            arr[i] = sc.nextInt();
        }

        // Bubble Sort
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("Sorted Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

