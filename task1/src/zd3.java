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


        for (int i = 0; i < array.length; i++) {
            int counter = 1;
            for (int j = i+1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    counter++;
                }
            }
            if (counter !=1) {
                System.out.println(" Число '"+ array[i]+"' встречается "+counter+" раза");
            }
        }

    }
}
