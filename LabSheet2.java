1.public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 3};

        for (int j = 1; j < arr.length; j++) {
            int key = arr[j];
            int i = j - 1;

            while (i >= 0 && arr[i] > key) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = key;
        }

        System.out.println("Sorted array (Ascending):");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

2.public class InsertionSortDesc {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 3};

        for (int j = 1; j < arr.length; j++) {
            int key = arr[j];
            int i = j - 1;

            while (i >= 0 && arr[i] < key) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = key;
        }

        System.out.println("Sorted array (Descending):");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

3.public class InsertionSortCount {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 3};
        int shifts = 0;

        for (int j = 1; j < arr.length; j++) {
            int key = arr[j];
            int i = j - 1;

            while (i >= 0 && arr[i] > key) {
                arr[i + 1] = arr[i];
                i--;
                shifts++;
            }
            arr[i + 1] = key;
        }

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        System.out.println("\nTotal shifts: " + shifts);
    }
}

4.import java.util.Arrays;

public class StepSimulation {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 3};

        System.out.println("Initial Array: " + Arrays.toString(arr));

        for (int j = 1; j < arr.length; j++) {
            int key = arr[j];
            int i = j - 1;

            System.out.println("\nStep " + j + ": Insert " + key);

            while (i >= 0 && arr[i] > key) {
                arr[i + 1] = arr[i];
                i--;
                System.out.println("Shifting: " + Arrays.toString(arr));
            }

            arr[i + 1] = key;
            System.out.println("After Insertion: " + Arrays.toString(arr));
        }

        System.out.println("\nFinal Sorted Array: " + Arrays.toString(arr));
    }
}