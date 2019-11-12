package com.example.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * from https://leetcode.com/problems/sliding-window-maximum/discuss/356148/java-deque
 *
 */
public class MaxOfSlideWindowSolutionByLeetcode {
    public static void main(String[] args) {
        Solution s = new Solution();

        Integer[] integers = new Integer[]{1, 3, -1, -3, -2, 1, 5, 3, 6, 7};
        s.maxSlidingWindow(integers, 3);

        integers = new Integer[]{1, 3, -1, -3, 5, 3, 6, 7};
        s.maxSlidingWindow(integers, 3);

        integers = new Integer[]{1, 2, 3, -1, -3, -2, 3, 6, 7};
        s.maxSlidingWindow(integers, 3);

        integers = new Integer[]{4, 3, 2, 1, 0, -1, -2};
        s.maxSlidingWindow(integers, 3);

        integers = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 11, 10, 9, 8, 7, 8, 9, 10, 11, 12, 9, 8, 7, 6};
        s.maxSlidingWindow(integers, 4);
    }
}

class Solution {
    public int[] maxSlidingWindow(Integer[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ret = new int[nums.length - k + 1];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            while (dq.size() != 0 && nums[i] > nums[dq.peekLast()]) {
                dq.pollLast(); //=removeAndReturnLast()
            }
            dq.offer(i); //=addLast()
            while (dq.peek() < i - k + 1) { //take a look at head, if head is out of window
                dq.poll(); //=removeAndReturnHead()
            }
            if (i >= k - 1) {
                ret[idx++] = nums[dq.peek()];
            }
        }

        System.out.println("--------------------------------");
        for (int i = 0; i < ret.length; i++) {
            System.out.println(i + ": " + ret[i]);
        }
        return ret;
    }
}