package Mock;

import java.util.HashMap;

public class Test1 {

    /**
     * Problem 1:
     * Given an array of integers nums and an integer k, return the total number of contiguous subarrays whose sum equals k.
     *
     * Example: nums = [1,2,3], k = 3 → output 2 (subarrays [1,2] and [3])
     *
     * Walk me through your approach and complexity before you write code.
     *
     *Approach 1: Brute Force | time complexity : O(n^2)
     *Approach 2: Sliding window  | time complexity : O(n)
     *Approach 3: Perfix Sum + HashMap | time complexity : O(n)
     * */

    public int bruteMaxSubarray(int[] nums, int k){
        int n = nums.length;
        int longest = 0;
        int length = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum+= nums[j];

                if(sum == k){
                    length = j-i-1;
                    longest = Math.max(longest,length);
                }
            }
        }

        return longest;
    }

    public int longestSubarray(int[] nums, int k){
        int n = nums.length;

        int i = 0;
        int longest = 0;
        int length = 0;
        int sum = 0;

        for (int j = i; j < n; j++) {

            sum += nums[j];

            if(sum == k){
                length = j-i-1;
                longest = Math.max(length,longest);
                sum -= nums[i];
                i++;
            }

        }

        return longest;
    }

    public int optimalSubarraySum(int[] nums, int k){
        int n = nums.length;
        int[] prefix = new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;

        prefix[0] = nums[0];
        map.put(0,-1);


        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1]+nums[i];
        }

        for (int i = 0; i < n; i++) {
            if(map.containsKey(k-prefix[i])){
                count++;
            }

            map.put(prefix[i],i);
        }

        return count;
    }
}
