package bookings;

import java.util.HashMap;

import cars.Car;
import cars.CarArrayDataAccessService;
import users.User;
import users.UserArrayDataAccessService;

public class BookHashMapAccessService implements Book {

    private static HashMap<Car, User> book = new HashMap<>();
    private static UserArrayDataAccessService usersDAS = new UserArrayDataAccessService();
    private static CarArrayDataAccessService carsDAS = new CarArrayDataAccessService();
    
    static {
       User user1 = usersDAS.getUsers()[0]; 
       Car car1 = carsDAS.getCars()[0];
    //    User user2 = usersDAS.getUsers()[1]; 
    //    Car car2 = carsDAS.getCars()[1];

       book.put(car1, user1);
    //    book.put(car2, user2);
    }

    @Override
    public String toString() {
        return "Book{" + ", booking=" + book + '}';
    }

    @Override
    public HashMap<Car, User> getBooking() {
        return book;
    }

}
