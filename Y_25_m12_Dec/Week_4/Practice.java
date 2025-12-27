package Y_25_m12_Dec.Week_4;
import java.util.*;

import Y_25_m12_Dec.Week_4.PracticeLinkedList.Node;

@SuppressWarnings("unused")
public class Practice {

    // Game of Stack (HackerRank)
    private int maxMoves(Stack<Integer> a, Stack<Integer> b, int moves, int currSum, int maxSum) {
        if(currSum > maxSum) return moves - 1;
        int max = moves;

        if(!a.isEmpty()) {
            int a1 = a.pop();
            max = Math.max(max, maxMoves(a, b, moves + 1, currSum + a1, maxSum));
            a.push(a1);
        }
        if(!b.isEmpty()) {
            int b1 = b.pop();
            max = Math.max(max, maxMoves(a, b, moves + 1, currSum + b1, maxSum));
            b.push(b1);
        }
        return max;
    }
    // grredy approach
    private int maxMoves(int[] a, int[] b, int maxSum) {
        int moves = 0, countA = 0, sum = 0;
        while(countA < a.length && sum + a[countA] < maxSum) {
            sum += a[countA];
            countA++;
        }
        moves = countA;

        int countB = 0;
        while(countB < b.length) {
            sum += b[countB];
            countB++;

            while(sum > maxSum && countA > 0) {
                countA--;
                sum -= a[countA]; // kyuki ek baar galat pe bhi badha tha ye..
            }

            if(sum <= maxSum) {
                moves = Math.max(moves, countA + countB);
            }
        }
        
        return moves;
    }

    // Delete the given node in the argument - given is not the tail.
    private void delete(Node node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        
    }
}
