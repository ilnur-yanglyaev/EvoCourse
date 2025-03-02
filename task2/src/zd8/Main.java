package zd8;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, List<User>> userMap = new HashMap<>();

        for (int i = 1; i <= 5; i++) {
            System.out.println("Введите имя пользователя " + i);
            String name = scanner.nextLine();
            System.out.println("Введите возраст пользователя " + i);
            Integer age = scanner.nextInt();
            scanner.nextLine();
            //userMap.computeIfAbsent(age, k -> new ArrayList<>()).add(new User(name, age));
            userMap.putIfAbsent(age, new ArrayList<>());
            userMap.get(age).add(new User(name, age));
        }

        System.out.println("Введите требуемый возраст");
        Integer requiredAge = scanner.nextInt();

        if (userMap.containsKey(requiredAge)) {
            List<User> users = userMap.get(requiredAge);
            //Collections.sort(users, (u1, u2) -> u1.getName().compareTo(u2.getName()));
            Collections.sort(users, new Comparator<User>() {
                @Override
                public int compare(User u1, User u2) {
                    return u1.getName().compareToIgnoreCase(u2.getName());
                }
            });

            for (User user : users) {
                System.out.println(user);
            }
        } else {
            System.out.println("Пользователь с возрастом '" + requiredAge + "' не найден");
        }

        scanner.close();
    }
}
