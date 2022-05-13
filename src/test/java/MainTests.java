import exceptions.AccessDeniedException;
import exceptions.UserNotFoundException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class MainTests {
    Main sut;

    @BeforeEach
    public void init() {
        System.out.println("test started");
        sut = new Main();
    }

    @BeforeAll
    public static void started() {
        System.out.println("tests started");
    }

    @AfterEach
    public void finished() {
        System.out.println("test compiled");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("tests finished");
    }

    @Test
    public void testGetUserByLoginAndPassword() throws UserNotFoundException {
        //arrange
        User userExpected = new User("Bob", "Bob@gmail.com", "qwerty", 46);
        //act
        User userResult = Main.getUserByLoginAndPassword(userExpected.getLogin(), userExpected.getPassword());
        //assert
        assertEquals(userExpected.getEmail(), userResult.getEmail());
    }

    @Test
    public void testAccessDeniedExceptionValidateUser() {
        User user = new User("Bob", "Bob@gmail.com", "qwerty", 17);
        assertThrows(AccessDeniedException.class, () -> Main.validateUser(user));
    }

    @ParameterizedTest
    @MethodSource("source")
    public void testValidateUser(User user) throws AccessDeniedException {
        //arrange
        String expected = "Age corresponds to";
        //act
        String result = Main.validateUser(user);
        //assert
        assertEquals(expected, result);
    }

    private static Stream<Arguments> source() {
        return Stream.of(Arguments.of(new User("Bob", "Bob@gmail.com", "qwerty", 46)),
                Arguments.of(new User("Rik", "Rik@gmail.com", "qaz", 35)),
                Arguments.of(new User("Jhon", "jhon@gmail.com", "pass", 24)));
    }
}
