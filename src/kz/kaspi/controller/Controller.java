package kz.kaspi.controller;

import kz.kaspi.service.Solution;
import kz.kaspi.service.impl.SolutionImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Controller {
    Solution solution;
    PrintWriter printWriter;
    Scanner scanner;

    public void run() throws FileNotFoundException {
        boolean work = true;

        while (work) {
            scanner = new Scanner(System.in);
            System.out.println("Введите номер задания");
            System.out.println("1 - Нули");
            System.out.println("2 - Стрелки");
            System.out.println("3 - Циклическая строка");
            System.out.println("4 - Домашнее задание");
            System.out.println("5 - Волосатый бизнес");
            System.out.println("6 - Двоякие числа");
            System.out.println("0 - Выйти");

            int v = scanner.nextInt();

            if (v == 0) {
                work = false;
                System.out.println("Всего доброго");
                break;
            }
            choose(v);
        }

    }

    public void choose(int num) throws FileNotFoundException {
        printWriter = new PrintWriter(new File("./output.txt"));
        solution = new SolutionImpl();
        switch (num) {
            case 1:
                scanner = new Scanner(new File("./input1.txt"));
                printWriter.print(solution.zeros(scanner.nextLine()));
                printWriter.close();
                break;
            case 2:
                scanner = new Scanner(new File("./input2.txt"));
                printWriter.print(solution.arrows(scanner.nextLine()));
                printWriter.close();
                break;
            case 3:
                scanner = new Scanner(new File("./input3.txt"));
                printWriter.print(solution.loopedString(scanner.nextLine()));
                printWriter.close();
                break;
            case 4:
                scanner = new Scanner(new File("./input4.txt"));
                int N = Integer.parseInt(scanner.nextLine());
                int[] numbers = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
                printWriter.print(solution.homeWork(numbers)[0] + " " + solution.homeWork(numbers)[1]);
                printWriter.close();
                break;
            case 5:
                scanner = new Scanner(new File("./input5.txt"));
                int n = scanner.nextInt();
                int[] nums = new int[n];
                for (int i = 0; i < nums.length; i++) {
                    nums[i] = scanner.nextInt();
                }
                printWriter.print(solution.business(nums));
                printWriter.close();
                break;
            case 6:
                scanner = new Scanner(new File("./input6.txt"));
                printWriter.print(solution.doubleNumbers(scanner.nextLine()));
                printWriter.close();
                break;
        }
    }
}
