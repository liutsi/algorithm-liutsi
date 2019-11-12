package com.example.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxOfSlideWindow {
    public static void main(String[] args) {
        Integer[] integers = new Integer[]{1, 3, -1, -3, -2, 1, 5, 3, 6, 7};
        processArray(integers, 3);

        integers = new Integer[]{1, 3, -1, -3, 5, 3, 6, 7};
        processArray(integers, 3);

        integers = new Integer[]{1, 2, 3, -1, -3, -2, 3, 6, 7};
        processArray(integers, 3);

        integers = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 11, 10, 9, 8, 7, 8, 9, 10, 11, 12, 9, 8, 7, 6};
        processArray(integers, 3);

        integers = new Integer[]{1, 2, 3, 4, 2, 3, 4, 1, 2, 3, 4, 0, 1, 2, 3, 2, 1, 0, 4, 3, 2, 1, 3, 2, 1, 4};
        processArray(integers, 3);
    }

    private static void processArray(Integer[] integers, int windowWidth) {
        Deque<Integer> deque = new ArrayDeque<>(); //store the INDEX, not the VALUE

        for (int j = 0; j < windowWidth; j++) {
            processWindow(integers, j, deque, windowWidth);
        }
        System.out.println("First: " + integers[deque.getFirst()]);

        for (int i = windowWidth; i < integers.length; i++) {
            processWindow(integers, i, deque, windowWidth);
            System.out.println(i + ": " + integers[deque.getFirst()]);
        }
    }

    private static void processWindow(Integer[] integers, int currentStart, Deque<Integer> deque, int windowWidth) {
        if (!deque.isEmpty() && deque.getFirst() <= currentStart - windowWidth) {
            deque.removeFirst();
        }
        if (deque.isEmpty()) {
            deque.addLast(currentStart);
        } else {
            if (integers[deque.getLast()] <= integers[currentStart]) {
                deque.removeLast();
                processWindow(integers, currentStart, deque, windowWidth);
            } else {
                deque.addLast(currentStart);
            }
        }
    }
}
