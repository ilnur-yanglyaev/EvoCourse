package zd4;

import java.util.Scanner;

public class zd43 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите дату в формате 'дд.мм.гггг':");
        String dateString = scanner.nextLine();

        String[] parts = dateString.split("\\.");

        if (parts.length != 3) {
            System.out.println("Неверный формат даты. Пожалуйста, используйте формат 'дд.мм.гггг'.");
            scanner.close();
            return;
        }

        int day, month, year;
        try {
            day = Integer.parseInt(parts[0]);
            month = Integer.parseInt(parts[1]);
            year = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат даты. Убедитесь, что день, месяц и год являются числами.");
            scanner.close();
            return;
        }

        if (month < 1 || month > 12) {
            System.out.println("Неверный месяц. Месяц должен быть от 1 до 12.");
            scanner.close();
            return;
        }

        boolean isValidDate = false;
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                isValidDate = (day >= 1 && day <= 31);
                break;
            case 4: case 6: case 9: case 11:
                isValidDate = (day >= 1 && day <= 30);
                break;
            case 2:
                boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
                isValidDate = (isLeapYear ? (day >= 1 && day <= 29) : (day >= 1 && day <= 28));
                break;
        }

        if (!isValidDate) {
            System.out.println("Неверная дата. Проверьте день и месяц.");
            scanner.close();
            return;
        }

        String formattedDate = parts[2] + "-" + parts[1] + "-" + parts[0];
        System.out.println(formattedDate);
        scanner.close();
    }
}
