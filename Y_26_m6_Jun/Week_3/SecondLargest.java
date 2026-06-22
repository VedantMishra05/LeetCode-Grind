package Y_26_m6_Jun.Week_3;

public class SecondLargest {
    public static int secondLargest(int[] arr) {

        int largest = arr[0];
        int secLargest = Integer.MIN_VALUE;

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > largest) {
                secLargest = largest;
                largest = arr[i];
            } else if(arr[i] > secLargest && arr[i] < largest) secLargest = arr[i];
        }
        return secLargest;  
    }

    public static int secondSmallest(int[] arr) {

        int smallest = arr[0];
        int secSmallest = Integer.MAX_VALUE;

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < smallest) {
                secSmallest = smallest;
                smallest = arr[i];
            } else if(arr[i] < secSmallest && arr[i] > smallest) secSmallest = arr[i];
        }
        return secSmallest;  
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 6, 7, 10};

        System.out.println(secondLargest(arr));
        System.out.println(secondSmallest(arr));
    }
}