import java.util.stream.*;

public class Main {

    public static long getArithmeticProgressionSum(int a, int b) {
        return LongStream.range(a, b).sum();
    }

    public static void main(String[] args) {
        int a = 10_000_000;
        int b = 1_000_000_000;
        System.out.println("Сумма арифметической прогрессии от " + a + " до " + b + " (исключая " + b + "): " + getArithmeticProgressionSum(a, b));
    }
}
