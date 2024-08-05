package app;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        userRepository.addUser(new User(1, "John", "john@example.com"));
        userRepository.addUser(new User(2, "Alice", "alice@example.com"));
        userRepository.addUser(new User(3, "Bob", "bob@example.com"));
        userRepository.addUser(new User(4, "Charlie", "charlie@example.com"));
        userRepository.addUser(new User(5, "Diana", "diana@example.com"));

        //Пошук користувача за id
        int existingId = 2;
        int nonExistingId = 10;

        Optional<User> userByExistingId = userRepository.findUserById(existingId);
        userByExistingId.ifPresent(user -> System.out.println("Знайдений користувач: " + user.toString()));

        Optional<User> userByNonExistingId = userRepository.findUserById(nonExistingId);
        userByNonExistingId.ifPresent(user -> System.out.println("Знайдений користувач: " + user.toString()));

        //Пошук користувача за email
        String presentEmail = "bob@example.com";
        String absentEmail = "absentEmail@example.com";

        Optional<User> userByPresentEmail = userRepository.findUserByEmail(presentEmail);
        userByPresentEmail.ifPresent(user -> System.out.println("Знайдений користувач: " + user.toString()));

        Optional<User> userByAbsentEmail = userRepository.findUserByEmail(absentEmail);
        userByAbsentEmail.ifPresent(user -> System.out.println("Знайдений користувач: " + user.toString()));

        //Вивід кількості користувачів, якщо вони список присутній
        Optional<List<User>> optionalUsers  = userRepository.findAllUsers();
        optionalUsers.ifPresent(users -> System.out.println("Кількість користувачів: " + users.size()));
    }
}
