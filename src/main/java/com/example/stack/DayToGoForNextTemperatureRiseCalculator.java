package com.example.stack;

import java.util.Stack;

/**
 * Given an array of temperatures, calculate how many days are needed for each day
 * to wait for next temperature rise.
 * Like [ ]
 * Results need to be []
 */
public class DayToGoForNextTemperatureRiseCalculator {
    public static void main(String[] args) {
        Integer[] temperatures = new Integer[]{23, 24, 25, 21, 19, 22, 26, 23};
        processTemperatureArray(temperatures);

        temperatures = new Integer[]{21, 22, 23, 24, 25, 26};
        processTemperatureArray(temperatures);

        temperatures = new Integer[]{30, 29, 28, 27, 26, 25, 24, 23, 22, 21};
        processTemperatureArray(temperatures);

        temperatures = new Integer[]{30, 29, 28, 27, 26, 25, 26, 27, 28, 29, 30};
        processTemperatureArray(temperatures);

        temperatures = new Integer[]{21, 22, 23, 24, 23, 22, 21};
        processTemperatureArray(temperatures);

        temperatures = new Integer[]{21, 22, 21, 22, 21, 22, 21, 22};
        processTemperatureArray(temperatures);

        temperatures = new Integer[]{22, 21, 22, 21, 22, 21, 22, 21};
        processTemperatureArray(temperatures);
    }

    private static void processTemperatureArray(Integer[] temperatures) {
        Integer[] results = new Integer[temperatures.length];
        Stack<Integer> stack = new Stack<>(); //stores index of each element
        for (int i = 0; i < temperatures.length; i++) {
            processStack(i, temperatures, stack, results);
        }
        System.out.println("---------------------------------------");
        for (int i = 0; i < temperatures.length; i++) {
            System.out.println(i + ":\t" + temperatures[i] + ":\t" + results[i]);
        }
    }

    private static void processStack(int i, Integer[] temperatures, Stack<Integer> stack, Integer[] results) {
        if (i >= temperatures.length || i < 0) {
            return;
        }
        if (stack.isEmpty()) {
            results[i] = Integer.MAX_VALUE;
            stack.push(i);
        } else {
            if (temperatures[i] >= temperatures[stack.peek()]) {
                results[stack.peek()] = i - stack.peek();
                stack.pop();
                processStack(i, temperatures, stack, results);
                //stack.push(i);
            } else {
                stack.push(i);
            }
        }
    }
}
