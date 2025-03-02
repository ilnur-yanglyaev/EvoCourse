import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class zd5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        System.out.println("Введите дату в формате dd.MM.yyyy:");
        String inputDate = scanner.nextLine();
        Date firstDate = null;

        try {
            firstDate = dateFormat.parse(inputDate);
        } catch (ParseException e) {
            System.out.println("Неверный формат даты.");
            return;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(firstDate);
        calendar.add(Calendar.DAY_OF_MONTH, 45);
        Date dateAfter45Days = calendar.getTime();
        System.out.println("Дата после увеличения на 45 дней: " + dateFormat.format(dateAfter45Days));

        calendar.setTime(firstDate);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date startOfYear = calendar.getTime();
        System.out.println("Дата после сдвига на начало года: " + dateFormat.format(startOfYear));

        calendar.setTime(firstDate);
        int workingDaysToAdd = 10;
        int addedDays = 0;
        while (addedDays < workingDaysToAdd) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY &&
                    calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                addedDays++;
            }
        }
        Date dateAfterWorkingDays = calendar.getTime();
        System.out.println("Дата после увеличения на 10 рабочих дней: " + dateFormat.format(dateAfterWorkingDays));


        System.out.println("Введите вторую дату в формате dd.MM.yyyy:");
        String inputSecondDate = scanner.nextLine();
        Date secondDate = null;


        try {
            secondDate = dateFormat.parse(inputSecondDate);
        } catch (ParseException e) {
            System.out.println("Неверный формат даты.");
            return;
        }

        int workingDaysBetween = 0;
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(firstDate);
        Calendar endCal = Calendar.getInstance();
        endCal.setTime(secondDate);

        while (startCal.before(endCal) || startCal.equals(endCal)) {
            if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                workingDaysBetween++;
            }
            startCal.add(Calendar.DAY_OF_MONTH, 1);
        }

        System.out.println("Количество рабочих дней между введенными датами: " + workingDaysBetween);

        scanner.close();
    }
}
