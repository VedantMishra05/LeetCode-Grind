package Y_26_m6_Jun.Week_3;

public class CheckIfSorted {
    
    // for ascending order
    public static boolean isSorted(int[] arr) {
        int last = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(last > arr[i]) return false;
            last = arr[i];
        }

        return true;
    }
    // descending waale me same logic...

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 7, 8, 20};
        int[] arr1 = {1, 2, 4, 8, 7, 8, 20};

        System.out.println(isSorted(arr));
        System.out.println(isSorted(arr1));
    }
}
