package zd4;

import java.util.Scanner;

public class zd42 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку:");
        String inputString = scanner.nextLine();

        String resultString = inputString.replace("кака", "вырезано цензурой")
                .replace("бяка", "вырезано цензурой");

        System.out.println(resultString);

        scanner.close();

    }
}
