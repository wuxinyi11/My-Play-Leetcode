package T220ContainsDuplicateIII;

import java.util.TreeSet;

// 220. Contains Duplicate III
// https://leetcode-cn.com/problems/contains-duplicate-iii/description/
//
// 时间复杂度: O(nlogk)
// 空间复杂度: O(k)
public class Solution1 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        // 这个问题的测试数据在使用int进行加减运算时会溢出
        // 所以使用long long
        TreeSet<Long> record = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {

            // ∣nums[i]−v∣<=t
            // 等价于 nums[i] - v <= t 并且 nums[i] - v >= -t，
            // 整理得： num[i] - t <= v <= num[i] + t

            // 方法一 ceiling 天花板:
            Long v = record.ceiling((long) nums[i] - (long) t); // v >= nums[i] - t;
            if (v != null && v <= (long) nums[i] + (long) t)       // v <= nums[i] + t;
                return true;

            // 方法二 floor 地板:
//            Long floor = record.floor((long) nums[i] + (long) t);  // v <= nums[i] + t
//            if (floor != null && floor >= (long) nums[i] - (long) t)  // v >= nums[i] - t
//                return true;

            record.add((long) nums[i]);
            if (record.size() == k + 1)
                record.remove((long) nums[i - k]);
        }

        return false;
    }


    private static void printBool(boolean b) {
        System.out.println(b ? "True" : "False");
    }

    public static void main(String[] args) {
        int[] nums = {-2147483648, -2147483647};
        int k = 3;
        int t = 3;
        printBool((new Solution1()).containsNearbyAlmostDuplicate(nums, k, t));
    }
}
