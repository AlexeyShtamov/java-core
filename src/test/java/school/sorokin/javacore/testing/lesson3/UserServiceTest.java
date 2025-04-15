package school.sorokin.javacore.testing.lesson3;

import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceTest {
    @Test
    void shouldReturnUserNameWhenUserExists() {
        // Arrange: создаём мок для UserRepository и настраиваем его поведение.
        UserRepository userRepositoryMock = mock(UserRepository.class);
        User dummyUser = new User(1, "Alice");
        // Указываем, что когда идет обращение к заглушке, то надо вернуть dummyUser
        when(userRepositoryMock.findUserById(1)).thenReturn(dummyUser);

        // Создаём объект UserService с замоканным репозиторием.
        UserService userService = new UserService(userRepositoryMock);

        // Act: вызываем тестируемый метод.
        String userName = userService.getUserName(1);

        // Assert: проверяем, что имя пользователя совпадает с ожидаемым.
        assertEquals("Alice", userName);

        // Verify: убеждаемся, что метод findUserById был вызван один раз с аргументом 1.
        verify(userRepositoryMock, times(1)).findUserById(1);
    }

    @Test
    void shouldReturnUnknownWhenUserDoesNotExist() {
        // Arrange: создаём мок, но не задаём возвращаемое значение для пользователя с id 2.
        UserRepository userRepositoryMock = mock(UserRepository.class);
        when(userRepositoryMock.findUserById(2)).thenReturn(null);

        UserService userService = new UserService(userRepositoryMock);

        // Act: получаем имя пользователя, которого нет в системе.
        String userName = userService.getUserName(2);

        // Assert: так как пользователь не найден, метод должен вернуть "Unknown".
        assertEquals("Unknown", userName);

        // Verify: убеждаемся, что findUserById был вызван с нужным аргументом.
        verify(userRepositoryMock, times(1)).findUserById(2);
    }

    @Test
    void shouldReturnUserIsSavedWhenUserSaved(){
        UserRepository mockUserRepository = mock(UserRepository.class);
        User dummyUser = new User(1, "Alice");
        when(mockUserRepository.saveUser(dummyUser)).thenReturn(dummyUser);

        UserService userService = new UserService(mockUserRepository);

        String status = userService.saveUser(dummyUser);

        assertEquals("user is saved", status);
        verify(mockUserRepository, times(1)).saveUser(dummyUser);
    }

    @Test
    void shouldReturnUserIsNotSavedWhenUserSaved(){
        UserRepository mockUserRepository = mock(UserRepository.class);
        User dummyUser = new User(1, "Alice");
        when(mockUserRepository.saveUser(dummyUser)).thenReturn(null);

        UserService userService = new UserService(mockUserRepository);

        String status = userService.saveUser(dummyUser);

        assertEquals("user is not saved", status);
        verify(mockUserRepository, times(1)).saveUser(dummyUser);
    }
}
