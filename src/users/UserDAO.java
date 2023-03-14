package users;

public interface UserDAO {
    User[] getUsers();
    public abstract void add(User user);
    public abstract User updateUser(User user);
    public abstract void deleteUser(User user);
}

