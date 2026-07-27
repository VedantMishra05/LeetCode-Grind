package Y_26_m7_Jul.Week_1;

import java.util.Arrays;

public class LeftRotate {

    private static int[] leftRotate(int[] arr, int d) {
        int n = arr.length;
        int[] temp = new int[d];

        for(int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }
        for(int i = d; i < n; i++) {
            arr[i - d] = arr[i];
        }
        for(int i = n - d; i < n; i++) {
                arr[i] = temp[i - (n - d)];
        }
        return arr;
    }

    private static int[] rightRotate(int[] arr, int d) {
        int n = arr.length;
        int[] temp = new int[d];

        for(int i = 0; i < d; i++) {
            temp[i] = arr[n - d + i];
        }
        for(int i = n - d - 1; i >= 0; i--) {
            arr[i + d] = arr[i];
        }
        for(int i = 0; i < d; i++) {
            arr[i] = temp[i];
        }

        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(Arrays.toString(leftRotate(arr, 4)));
        System.out.println(Arrays.toString(rightRotate(arr, 4)));
    }
}