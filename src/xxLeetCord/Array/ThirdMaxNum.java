package xxLeetCord.Array;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ThirdMaxNum {
    public static int thirdMax(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for (int n : nums) {
            set.add(n);
        }

        if (set.size() >= 3) {
            return (int) set.toArray()[set.size() - 3];
        } else {
            return (int) set.toArray()[set.size() - 1];
        }
    }


}
