import exceptions.AccessDeniedException;
import exceptions.UserNotFoundException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите логин");
            String login = scanner.nextLine();
            System.out.println("Введите пароль");
            String password = scanner.nextLine();
            User userVerification = getUserByLoginAndPassword(login, password);
            System.out.println("User:" + userVerification.getLogin() + " and password:" + userVerification.getPassword() + " found");
            try {
                System.out.println(validateUser(userVerification));
                System.out.println("Доступ предоставлен");
            } catch (AccessDeniedException accessDeniedException) {
                System.out.println("Age does not match");
            }
        } catch (UserNotFoundException userNotFoundException) {
            System.out.println("User not found");
        } catch (Exception e) {
            System.out.println("Sorry, error!!!");
        }

    }

    public static User[] getUsers() {
        User user1 = new User("Jhon", "jhon@gmail.com", "pass", 24);
        User user2 = new User("Clara", "Clara@gmail.com", "123", 14);
        User user3 = new User("Bob", "Bob@gmail.com", "qwerty", 46);
        User user4 = new User("Anna", "Anna@gmail.com", "789", 12);
        User user5 = new User("Rik", "Rik@gmail.com", "qaz", 35);
        return new User[]{user1,
                user2,
                user3,
                user4,
                user5};
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new UserNotFoundException("User not found");
    }

    public static String validateUser(User user) throws AccessDeniedException {
        if (user.getAge() > 17) {
            return "Age corresponds to";
        } else {
            throw new AccessDeniedException("Age does not match");
        }
    }
}
