import java.util.*;

public class Homework54 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> sameNumbersMap = new HashMap<>();

        for (int num : nums1) {
            sameNumbersMap.putIfAbsent(num, 0);
            sameNumbersMap.put(num, sameNumbersMap.get(num) + 1);
        }

        List<Integer> intersectResultList = new ArrayList<>();

        for (int num : nums2) {
            if (sameNumbersMap.containsKey(num)) {
                if (sameNumbersMap.get(num) == 0) {
                    sameNumbersMap.remove(num);
                } else {
                    intersectResultList.add(num);
                    sameNumbersMap.put(num, sameNumbersMap.get(num) - 1);
                }

            }
        }

        int[] intersectResultArray = new int[intersectResultList.size()];

        for (int i = 0; i < intersectResultList.size(); i++) {
            intersectResultArray[i] = intersectResultList.get(i);
        }

        return intersectResultArray;
    }
}
