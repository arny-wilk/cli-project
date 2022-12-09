package users;

public class UserService {
    private User user;

    static boolean emailValidator(User user) {
        String email = user.getEmail();
        if (!email.contains("@")) {
            return false;
        }
        return true;
    }
}
