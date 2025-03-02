import java.util.Scanner;

public class zd2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите 3 числа:");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        boolean check = false;
        if (a % 5 == 0) {
            System.out.print("a=" + a + " ");
            check = true;
        }
        if (b % 5 == 0) {
            System.out.print("b=" + b + " ");
            check = true;
        }
        if (c % 5 == 0) {
            System.out.print("c=" + c + " ");
            check = true;
        }
        if (!check) {
            System.out.println("нет значений, кратных 5");
        } else {
            System.out.println();
        }

        System.out.println("Результат целочисленного деления a на b: " + (a / b));
        System.out.println("Результат деления a на b: " + ((double) a / b));
        System.out.println("Результат деления a на b с округлением в большую сторону: " + Math.ceil((double) a / b));
        System.out.println("Результат деления a на b с округлением в меньшую сторону: " + Math.floor((double) a / b));
        System.out.println("Результат деления a на b с математическим округлением: " + Math.round((double) a / b));
        System.out.println("Остаток от деления b на c: " + (b % c));
        System.out.println("Наименьшее значение из a и b: " + Math.min(a, b));
        System.out.println("Наибольшее значение из b и c: " + Math.max(b, c));

        scanner.close();
    }
}
