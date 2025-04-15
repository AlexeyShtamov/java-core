package school.sorokin.javacore.testing.lesson3;

public interface UserRepository {
    User findUserById(int id);

    User saveUser(User user);
}
