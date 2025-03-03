package Interviews;

import java.util.ArrayList;
import java.util.List;

public class FindElementsAppearingOnce {
    public static void main(String[] args) {
        System.out.println(findElements(List.of(1, 2, 1, 3, 2, 5)));
    }

    public static List<Integer> findElements(List<Integer> arr) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> setBitsArr = new ArrayList<>();
        List<Integer> unsetBitsArr = new ArrayList<>();
        int xorSetBits = 1, xorUnsetBits = 1;
        if (arr.isEmpty())
            return ans;
        int xor = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            xor = arr.get(i) ^ xor;
        }
        int setBit = -1;
        for (int i = 0; i <= 31; i++) {
            int msb = xor >> i;
            if ((msb & 1) == 1) {
                setBit = i;
                break;
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            if (((arr.get(i) >> setBit) & 1) == 1)
                setBitsArr.add(arr.get(i));
            else
                unsetBitsArr.add(arr.get(i));
        }
        xorSetBits = setBitsArr.get(0);
        xorUnsetBits = unsetBitsArr.get(0);
        for (int i = 1; i < setBitsArr.size(); i++)
            xorSetBits = xorUnsetBits ^ setBitsArr.get(i);
        for (int i = 1; i < unsetBitsArr.size(); i++)
            xorUnsetBits = xorUnsetBits ^ unsetBitsArr.get(i);
        ans.add(xorSetBits);
        ans.add(xorUnsetBits);
        return ans;
    }
}
