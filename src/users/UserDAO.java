package users;

public interface UserDAO {
    User[] getUsers();
    public abstract void add(User user);
}

