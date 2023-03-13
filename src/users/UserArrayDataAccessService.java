package users;

import java.util.Arrays;
import java.util.UUID;

import enums.Enum;

public class UserArrayDataAccessService implements UserDAO {

    private static final int SIZE = 10;
    private static User[] users = new User[SIZE];
    private int nextSlot = 1;

    static {
        users[0] = new User(UUID.fromString("cd8732f5-3b6a-418c-b11f-a3689bbb9b47"), "James", "Fernandez",
                Enum.GENDER.MALE, Enum.ADDRESS_TYPE.HOME, "7th CapTown Street", Enum.COUNTRY.ENGLAND,
                "jamesfernandez@gmail.com");
        users[1] = new User(UUID.fromString("5faf6845-98b0-4bdc-9259-b158fc5fccc5"), "Jamila", "Alaoui",
                Enum.GENDER.FEMALE, Enum.ADDRESS_TYPE.HOME, "5th Winston Street", Enum.COUNTRY.ENGLAND,
                "jamilalaoui@gmail.com");
    }

    @Override
    public User[] getUsers() {
        return users;
    }

    @Override
    public void add(User user) {
        for (int i = 1; i < users.length; i++) {
            if (UserService.emailValidator(user)) {
                users[nextSlot++] = user;
            }
        }
    }

    @Override
    public User updateUser(User user) {
        return user;
    }

    @Override
    public void deleteUser(User user) {
        int indexOfUser = Arrays.binarySearch(users, user);
        users[indexOfUser] = null;
    }

}
