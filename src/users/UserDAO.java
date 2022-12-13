package users;

import enums.Enum;

import java.util.UUID;

public class UserDAO {
    private static User[] users;
    private static int nextUser = 1;

    static {
        int arraySize = 10;
        users = new User[arraySize];
        users[0] = new User(UUID.fromString("cd8732f5-3b6a-418c-b11f-a3689bbb9b47")
                            , "James"
                            , "Fernandez"
                            , Enum.GENDER.MALE
                            , Enum.ADDRESS_TYPE.HOME
                            , "7th CapTown Street"
                            , Enum.COUNTRY.ENGLAND
                            , "jamesfernandez@gmail.com");
        users[1] = new User(UUID.fromString("5faf6845-98b0-4bdc-9259-b158fc5fccc5")
                            , "Jamila"
                            , "Alaoui"
                            , Enum.GENDER.FEMALE
                            , Enum.ADDRESS_TYPE.HOME
                            , "5th Winston Street"
                            , Enum.COUNTRY.ENGLAND
                            , "jamilalaoui@gmail.com");
    }

    public static User[] getUsers() {
        return users;
    }

    public static void setUsers(User[] users) {
        UserDAO.users = users;
    }

    public void addUser(User newUser) {
        for (int i = 1; i < users.length; i++) {
            if (UserService.emailValidator(newUser)) {
                users[nextUser++] = newUser;
            }
        }
    }
}
