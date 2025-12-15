package Dec25.Week_3;

public class HappyNumber {

    public static int getNext(int n) {
        int num = 0;
        while(n > 0) {
            int digit = n % 10;
            num += digit * digit;
            n /= 10;
        }
        return num;
    }

    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        } while(slow != fast);

        return slow == 1;
    }
}
