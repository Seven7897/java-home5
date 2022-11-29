import java.util.HashMap;
import java.util.Map;

public class Homework51 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length <= 1) return false;

        Map<Integer, Integer> numsMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (numsMap.containsKey(nums[i])) {
                if (i - numsMap.get(nums[i]) <= k) return true;
                numsMap.put(nums[i], i - numsMap.get(nums[i]));
            } else {
                numsMap.put(nums[i], i);
            }
        }
        return false;
    }
}
