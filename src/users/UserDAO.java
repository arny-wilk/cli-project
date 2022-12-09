package users;

import enums.Enum;

public class UserDAO {
    private static final User[] users;

    static {
        users = new User[] {
                new User("James", "Fernandez", Enum.GENDER.MALE, Enum.ADDRESS_TYPE.HOME, "7th CapTown Street", Enum.COUNTRY.ENGLAND, "jamesfernandez@gmail.com"),
        };
    }

    public static User[] getUsers() {
        return users;
    }
}
