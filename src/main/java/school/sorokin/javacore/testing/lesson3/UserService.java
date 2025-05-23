package school.sorokin.javacore.testing.lesson3;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Метод возвращает имя пользователя, если пользователь найден, или "Unknown"
    public String getUserName(int id) {
        User user = userRepository.findUserById(id);
        return user != null ? user.getName() : "Unknown";
    }

    public String saveUser(User user){
        User savedUser = userRepository.saveUser(user);

        return savedUser != null ? "user is saved" : "user is not saved";
    }
}
