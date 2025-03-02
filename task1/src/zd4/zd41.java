package zd4;

import java.util.Scanner;

public class zd41 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку:");
        String mainString = scanner.nextLine();

        System.out.println("Введите подстроку:");
        String substring = scanner.nextLine();

        int count = 0;
        int index = 0;

        while ((index = mainString.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }

        System.out.println("Подстрока '" + substring + "' встречается " + count + " раза");
        scanner.close();

    }
}
