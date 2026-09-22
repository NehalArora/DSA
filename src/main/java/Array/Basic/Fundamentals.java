package Array.Basic;

import java.util.*;

public class Fundamentals {

    // 1. Find maximum and minimum element
    static int[] findMaxMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return new int[]{min, max};
    }
    // Your solution was correct.


    // 2. Find second largest element
    static int secondLargest(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > largest) {
                second = largest;
                largest = num;
            } else if (num < largest && num > second) {
                second = num;
            }
        }

        return second;
    }
    // Your first version failed when a new largest element appeared; your updated version fixed it.


    // 3. Reverse an array
    static void reverse(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
    // Your first version swapped every pair twice; your updated n/2 version is correct.


    // 4. Check if array is sorted
    static boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }

        return true;
    }
    // Your solution was correct.


    // 5. Remove duplicates from sorted array
    // Returns number of unique elements and modifies nums in-place.
    static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int k = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
    // You used a HashSet instead of exploiting the sorted-array property with two pointers.


    // 6. Count frequency of each element
    static Map<Integer, Integer> countFrequency(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return map;
    }
    // Your solution was correct.


    // 7. Find sum of array
    static long arraySum(int[] nums) {
        long sum = 0;

        for (int num : nums) {
            sum += num;
        }

        return sum;
    }
    // You used an int accumulator even though the method returned long, which could overflow before returning.


    // 8. Find missing number from 1...N
    // Assumption: nums contains N-1 distinct numbers from 1...N.
    static int findMissingNumber(int[] nums, int n) {
        long expected = (long) n * (n + 1) / 2;

        long actual = 0;
        for (int num : nums) {
            actual += num;
        }

        return (int) (expected - actual);
    }
    // You changed the problem into a frequency/duplicate problem instead of solving the stated 1...N missing-number problem.


    // 9. Find duplicate number
    // Returns a duplicate if one exists.
    static int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }

            set.add(num);
        }

        return -1;
    }
    // Your solution was correct for the stated HashSet-based version.


    // 10. Find element appearing once
    // Assumption: every other element appears exactly twice.
    static int findSingleElement(int[] nums) {
        int xor = 0;

        for (int num : nums) {
            xor ^= num;
        }

        return xor;
    }
    // Your solution was correct.


    // 11. Move all zeroes to end
    static void moveZeroes(int[] nums) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;

                k++;
            }
        }
    }
    // You moved the pointer to j instead of keeping it at the next position for a non-zero element.


    // 12. Left rotate array by 1
    static void leftRotateByOne(int[] nums) {
        if (nums.length <= 1) return;

        int first = nums[0];

        for (int i = 1; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }

        nums[nums.length - 1] = first;
    }
    // You started from the end and overwrote values, so the elements were not shifted correctly.


    // 13. Left rotate array by K positions
    static void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n <= 1) return;

        k %= n;

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = nums[(i + k) % n];
        }

        System.arraycopy(ans, 0, nums, 0, n);
    }
    // Your mapping used (n-i-k)%n; for left rotation the correct mapping is (i+k)%n.


    // 14. Linear search
    // Returns index if found, otherwise -1.
    static int linearSearch(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        return -1;
    }
    // Your solution was correct.


    // 15. Intersection of two arrays
    // Keeps duplicates according to their frequency.
    static int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freq = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int num : nums1) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int num : nums2) {
            if (freq.getOrDefault(num, 0) > 0) {
                list.add(num);
                freq.put(num, freq.get(num) - 1);
            }
        }

        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
    // Your solution was correct.


    // 16. Union of two arrays
    // Returns unique elements.
    static int[] union(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums1) {
            set.add(num);
        }

        for (int num : nums2) {
            set.add(num);
        }

        int[] result = new int[set.size()];

        int i = 0;
        for (int num : set) {
            result[i++] = num;
        }

        return result;
    }
    // Your first version only concatenated the arrays; the updated HashSet version correctly produces a unique union.
}