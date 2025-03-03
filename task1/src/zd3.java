import java.util.Random;
import java.util.Arrays;

public class zd3 {
    public static void main(String[] args) {
        int[] array = new int[20];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(15) + 1;
        }
        System.out.println(Arrays.toString(array));

        int[] repeaters = new int[10];
        int k = 0;

        for (int i = 0; i < array.length; i++) {
            int counter = 1;
            boolean isAlreadyCounted = false;

            for (int j = 0; j < k; j++) {
                if (array[i] == repeaters[j]) {
                    isAlreadyCounted = true;
                    break;
                }
            }

            if (!isAlreadyCounted) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[i] == array[j]) {
                        counter++;
                    }
                }

                if (counter > 1) {
                    System.out.println("Число '" + array[i] + "' встречается " + counter + " раз");
                    repeaters[k] = array[i];
                    k++;
                }
            }
        }
    }
}
