package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter string: ");
        Scanner scan = new Scanner(System.in);
        char[] strChar = scan.nextLine().toCharArray();
        System.out.println("String contained " + count(strChar, 0) + " groups of 'AGA' and 'OGO'");
        System.out.println("Modified string (param):  " + (new String(strChar)));
        char[] finalResult = replaceOGOandAGA(strChar, 0);
        System.out.println("Modified string (result): " + (new String(finalResult)));
    }

    public static int count(char[] str, int index) {
        if(index >= str.length - 2) {
            return 0;
        }
        if ((str[index] == 'O' && str[index + 1] == 'G' && str[index + 2] == 'O') ||
                (str[index] == 'A' && str[index + 1] == 'G' && str[index + 2] == 'A')) {
            return 1 + count(str, index + 3);
        }
        return count(str, index + 1);
    }

    public static char[] replaceOGOandAGA(char[] str, int index) {
        if(index >= str.length) {
            return new char[0];
        }
        if (index < str.length - 2 && ((str[index] == 'O' && str[index + 1] == 'G' && str[index + 2] == 'O') ||
                (str[index] == 'A' && str[index + 1] == 'G' && str[index + 2] == 'A'))) {
            char[] rest = replaceOGOandAGA(str, index + 3);
            char[] result = new char[rest.length + 2];
            result[0] = '*';
            result[1] = '*';
            System.arraycopy(rest, 0, result, 2, rest.length);
            return result;
        }
        char[] rest = replaceOGOandAGA(str, index + 1);
        char[] result = new char[rest.length + 1];
        result[0] = str[index];
        System.arraycopy(rest, 0, result, 1, rest.length);
        return result;
    }
}
