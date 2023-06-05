package users;

public class UserService {

    private UserService() {
    }

    static boolean emailValidator(User user) {
        String email = user.getEmail();
        return email.contains("@");
    }
}
