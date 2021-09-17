package kz.kaspi.service.impl;

import kz.kaspi.service.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SolutionImpl implements Solution {
    @Override
    public int zeros(String data) {
        int current = 0;
        int max = 0;
        for (int i = 0; i < data.length(); i++) {
            if(data.charAt(i) == '0') {
                current++;
            }else {
                current = 0;
            }
            if (current > max) {
                max = current;
            }
        }
        return max;
    }

    @Override
    public int arrows(String data) {
        int counter = 0;
        for (int i = 0; i < data.length() - 4; i++) {
            if(data.charAt(i) == '>' && data.charAt(i + 4) == '>') {
                if(">--".equals(data.substring(i + 1, i + 4))) {
                    counter++;
                }
            }else if(data.charAt(i) == '<' && data.charAt(i + 4) == '<') {
                if("--<".equals(data.substring(i + 1, i + 4))) {
                    counter++;
                }
            }
        }
        return counter;
    }

    @Override
    public int loopedString(String data) {
        int[] nums = new int[data.length()];
        int k = 0;
        for (int i = 1; i < data.length(); ++i) {
            while ((k > 0) && (data.charAt(k) != data.charAt(i))) {
                k = nums[k - 1];
            }

            if (data.charAt(k) == data.charAt(i)) {
                ++k;
            }
            nums[i] = k;
        }
        return data.length() - nums[data.length()-1];
    }

    @Override
    public int[] homeWork(int[] nums) {
        int min = 0;
        int max = 0;
        int minIndex = 0;
        int maxIndex = 0;
        int sum = 0;
        int composition = 1;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                sum = sum + nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
            if(nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (minIndex > maxIndex) {
                int temp = minIndex;
                minIndex = maxIndex;
                maxIndex = temp;
            }
        }

        for (int i = minIndex + 1; i < maxIndex; i++) {
            composition = composition * nums[i];
        }

        return new int[] {sum, composition};
    }

    @Override
    public int business(int[] nums) {
        int sum = 0;

        List<Integer> numsList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            numsList.add(nums[i]);
        }

        while (!numsList.isEmpty()) {
            sum = sum + ((int) Collections.max(numsList) * (numsList.indexOf(Collections.max(numsList)) + 1));
            numsList = numsList.subList((numsList.indexOf(Collections.max(numsList)) + 1), numsList.size());
        }

        return sum;
    }

    @Override
    public int doubleNumbers(String data) {
        int num1 = Integer.parseInt(data);
        int num2 = Integer.parseInt(data);
        int unique = countUnique(Arrays.stream(data.split("")).mapToInt(Integer::parseInt).toArray());

        while (unique > 2) {
            num1++;
            unique = countUnique(Arrays.stream(String.valueOf(num1).split("")).mapToInt(Integer::parseInt).toArray());
        }

        unique = countUnique(Arrays.stream(data.split("")).mapToInt(Integer::parseInt).toArray());
        while (unique > 2) {
            num2--;
            unique = countUnique(Arrays.stream(String.valueOf(num2).split("")).mapToInt(Integer::parseInt).toArray());
        }

        if(Math.abs(Integer.parseInt(data) - num1) > Math.abs(Integer.parseInt(data) - num2)) {
            return num2;
        }else if(Math.abs(Integer.parseInt(data) - num1) < Math.abs(Integer.parseInt(data) - num2)) {
            return num1;
        }else if(Math.abs(Integer.parseInt(data) - num1) == Math.abs(Integer.parseInt(data) - num2)) {
            return num2;
        }
        return num2;
    }

    @Override
    public int countUnique(int[] nums) {
        int count = 1;

        for (int i = 1; i < nums.length; i++)
        {
            int j;
            for (j = 0; j < i; j++) {
                if (nums[i] == nums[j])
                    break;
            }
            if (i == j)
                count++;
        }
        return count;
    }
}
