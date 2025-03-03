import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberOfMoves {
    public static void main(String[] args) {
        System.out.println(getMoves(new int[]{3, 1, 5, 3, 3, 4, 2}));
    }

    public static int getMoves(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        moves(A, map);
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        return max;
    }

    public static void moves(int[] A, HashMap<Integer, Integer> map) {
        if (A.length < 2)
            return;
        else {
            int front = A[0] + A[1];
            map.put(front, map.getOrDefault(front, 0) + 1);
            moves(Arrays.copyOfRange(A, 2, A.length), map);
            int back = A[A.length - 1] + A[A.length - 2];
            map.put(back, map.getOrDefault(back, 0) + 1);
            moves(Arrays.copyOfRange(A, 0, A.length - 2), map);
            int firstAndLast = A[0] + A[A.length - 1];
            map.put(firstAndLast, map.getOrDefault(firstAndLast, 0) + 1);
            moves(Arrays.copyOfRange(A, 1, A.length - 1), map);
            return;
        }
    }
}
