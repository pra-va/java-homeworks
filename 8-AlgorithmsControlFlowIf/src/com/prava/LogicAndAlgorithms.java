package com.prava;

import java.util.Arrays;
import java.util.Scanner;

/**
 * This program demonstrates:
 * 1) if and if-else;
 * 2) for, while and do-while;
 * 3) uses break, continue and return (control flow statements);
 * 4) uses labeled-break and labeled-continue;
 * 5) uses return to give back value;
 * 6) has few logical methods;
 * 7) reads user input from console and sets data type;
 * 8) demonstrates switch statement.
 *
 *
 */
public class LogicAndAlgorithms {
    public static void main(String[] args) {
        ifElseDemonstrate(100);
        loops();
        controlFlow();
        labeledBreakContinue();
        hello();
    }

    /**
     * 1. Demonstrates if and if-else statements. Method will check
     * if parameter is higher, lesser or equal to 100.
     *
     * @param value - int format user input.
     */
    private static void ifElseDemonstrate(int value) {
        if (value == 100) {
            System.out.println("The value is equal to 100!");
            return;
        }
        if (value > 100) {
            System.out.println("The value is higher than 100.");
        } else {
            System.out.println("The value is lower than 100.");
        }

    }

    /**
     * 2. Demonstrates for, while and do-while functionality. The method creates
     * two-dimensional array of years and month. While will
     */
    private static void loops() {
        // For example.
        String yearMonthFor[][] = new String[10][12];
        int year = 1990;
        int month = 1;
        // y - for year
        // m - for month
        for (int y=0; y<10; y++) {
            for (int m=0; m<12; m++){
                yearMonthFor[y][m] = year + "-" + month;
                month++;
            }
            year++;
            month = 1;
        }
        System.out.println(Arrays.deepToString(yearMonthFor));

        // While and do while example.
        String yearMonthWhile[][] = new String[10][12];
        year = 1990;
        month = 1;
        int yearIterator = 0;
        int monthIterator = 0;
        while (year < 2000) {
            do {
                yearMonthWhile[yearIterator][monthIterator] = year + "-" + month;
                month++;
                monthIterator++;
            } while (month < 13);
            year++;
            yearIterator++;
            monthIterator = 0;
            month = 1;
        }
        System.out.println(Arrays.deepToString(yearMonthWhile));
    }

    /**
     * 3. Use break, continue and return statements.
     */
    private static void controlFlow () {
        int monthArray[] = new int[12];
        int month = 1;
        while (true) {
            monthArray[month-1] = month;
            if (month < 12) {
                month++;
                continue;
            }
            break;
        }

        if (monthArray[11] != 12) {
            return;
        } else {
            System.out.println(Arrays.toString(monthArray));
        }
    }

    /**
     * 4. Uses labeled-return and labeled-continue. Inside a method there is
     * a infinite loop that uses labeled control flow statements to control
     * the loop which should create date[][] double array that displays year
     * month (from 1999 to 2001).
     */
    private static void labeledBreakContinue() {
        String[][] date = new String[2][12];
        int year = 1999;
        int month = 1;
        dateLoop:
        do {
            startOfLoop:
            while (true) {
                date[year-1999][month-1] = year + "-" + month;
                month++;
                if (month == 13) {
                    year++;
                    month = 1;
                    if (year == 2001) {
                        break dateLoop;
                    } else {
                        continue startOfLoop;
                    }
                }
            }
        } while (true);
        System.out.println(Arrays.deepToString(date));
    }

    /**
     * 5) Uses return to give back value;
     * 6) has few logical methods;
     * 7) reads user input from console and sets data type;
     * 8) demonstrates switch statement.
     * This is the main controller method which calls other methods
     * to fulfil its main purport.
     */
    private static void hello() {
        System.out.println("Enter your favorite day in number (f.e. 1 for monday):");
        String dayNumber = read();
        String dayWord = dayLookUp(dayNumber);
        if (dayWord.equals("-1")) {
            System.out.println("There is no day " + dayNumber + " in a weekdays!");
        } else {
            System.out.println("Your favorite day is " + dayWord + ".");
        }
    }

    /**
     * This method will read user input from console.
     * @return user input from console.
     */
    private static String read() {
        Scanner scanner = new Scanner(System.in);
        String readFromConcole = scanner.nextLine().trim();
        return readFromConcole;
    }

    /**
     * This method will return weekday in word based on the user input in number.
     * @param day user input in number format
     * @return day in word format.
     */
    private static String dayLookUp(String day) {
        switch (day) {
            case "1":
                return "Monday";
            case "2":
                return "Tuesday";
            case "3":
                return "Wednesday";
            case "4":
                return "Thursday";
            case "5":
                return "Friday";
            case "6":
                return "Saturday";
            case "7":
                return "Sunday";
        }
        return "-1";
    }

}
