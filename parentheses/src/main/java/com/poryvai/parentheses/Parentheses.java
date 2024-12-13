package com.poryvai.parentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*1. Если мы из корректно записанного арифметического выражения,
содержащего числа, знаки операций и открывающие и закрывающие
круглые скобки выбросим числа и знаки операций, а затем запишем
оставшиеся в выражении скобки без пробелов между ними, то полученный
результат назовем правильным скобочным выражением
[скобочное выражение "(()(()))" - правильное, а "()(" и "())(" - нет].

Найти число правильных скобочных выражений, содержащих N открывающихся
и N закрывающихся скобок. N вводится с клавиатуры. N неотрицательное
целое число.

        Пример:
        N = 1 (по одной скобке открывающейся и закрывающейся) - ответ 1
        ()
        )(
        ))
        ((
        Только один правильный вариант

        Для введенного числа 2 - 2 :
        ()()
        (())
        То есть только два варианта, когда все открытые скобки правильно открываются/закрываются.
        И так далее.*/


public class Parentheses {

    // Method to generate  parenthses
    public  List<String> getParentheses() {
        int n = readInput();

        // Validate the input
        if (n < 0) {
            throw new IllegalArgumentException("Input must be a non-negative integer");
        }

        List<String> results = new ArrayList<>();
        if (n == 0) {
            return results;
        }

        generateParentheses(results, "", 0, 0, n);

//        System.out.println("Number of the correct parentheses expression: " + results.size());
//        System.out.println(results);

        return results;
    }

    // Backtracking helper method
    private void  generateParentheses(List<String> results, String current, int openCount, int closeCount, int n) {
        if (current.length() == n * 2) {
            results.add(current);
            return;
        }

        // Add opening parenthesis
        if (openCount < n) {
            generateParentheses(results, current + "(", openCount + 1, closeCount, n);
        }
        
        // Add closing parenthesis
        if (closeCount < openCount) {
            generateParentheses(results, current + ")", openCount, closeCount + 1, n);
        }
    }

    // Read input from the user
    private int readInput() {
        Scanner scanner = new Scanner(System.in);
        int n = -1;

        System.out.print("Enter the number of parentheses pairs: ");

        try {
            n = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid number");
        }

        return n;
    }
}
