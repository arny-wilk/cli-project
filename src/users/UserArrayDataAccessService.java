package users;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import enums.Enum;
import registertocsvfile.ConvertToStringArray;
import registertocsvfile.RegisterDataToCSVFile;

public class UserArrayDataAccessService implements UserDAO, ConvertToStringArray {

    private static final int SIZE = 10;
    private static User[] users = new User[SIZE];
    private int nextSlot = 1;
    private int iteration = 0;

    // save to CSV File
    private RegisterDataToCSVFile saveToCSVFile = new RegisterDataToCSVFile("out/data/users.csv");

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

    @Override
    public List<String[]> convert() {
        List<String[]> result = new ArrayList<>();
        String[] header = { "ID", "First Name", "Last Name", "Gender", "Address Type", "Address", "Country", "Email" };
        String[] emptyArray = { "", "", "", "", "", "", "", "" };
        result.add(header);
        List<User> listOfUsers = Arrays.asList(users);
        for (User user : listOfUsers) {
            Optional<User> optionalUser = Optional.ofNullable(user);
            if(optionalUser.isPresent()) {
                String[] stringify = { optionalUser.get().getUserId().toString(), optionalUser.get().getFirstName(),
                        optionalUser.get().getLastname(), optionalUser.get().getGender().toString(),
                        optionalUser.get().getAddressType().toString(), optionalUser.get().getAddress(),
                        optionalUser.get().getCountry().toString(), optionalUser.get().getEmail() };

                result.add(stringify);
            } else {
                result.add(emptyArray);
            }
        }
        return result;
    }

    public String registerUsersToCSVFile() {
        List<String[]> stringArray = convert();
        saveToCSVFile.writeToCsvFile(stringArray);
        return "You have successfully registered " + stringArray.size() + " users";
    }

}
