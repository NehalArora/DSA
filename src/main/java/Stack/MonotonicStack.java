package Stack;

import java.util.Arrays;
import java.util.Stack;

public class MonotonicStack {
    private int[] nextSmallerElement(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        // monotonic increasing stack
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < n; i++){
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                int index = stack.pop();
                ans[index] = i;
            }
            stack.push(i);
        }

        return ans;
    }
}
