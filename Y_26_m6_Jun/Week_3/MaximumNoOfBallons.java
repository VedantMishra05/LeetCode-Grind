package Y_26_m6_Jun.Week_3;

public class MaximumNoOfBallons {
     public static int noOfBalloon(String str) {
        int[] freq = new int[26];

        for(char c: str.toCharArray()) {
            freq[c - 'a']++;
        }

        return Math.min(Math.min(Math.min(freq['b' - 'a'], freq['a' - 'a']), freq['l' - 'a'] / 2), Math.min(freq['o' - 'a'] / 2, freq['n' - 'a']));
     }
}
