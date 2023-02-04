package bookings;

import java.util.HashMap;

import cars.Car;
import cars.CarArrayDataAccessService;
import users.User;
import users.UserArrayDataAccessService;

public class BookArrayAccessService implements Book {

    private static HashMap<Car, User> booking;

    static {
        booking = new HashMap<>();

        CarArrayDataAccessService carDAS = new CarArrayDataAccessService();
        Car[] carInit = carDAS.getCars();

        UserArrayDataAccessService userDAS = new UserArrayDataAccessService();
        User[] userInit = userDAS.getUsers();

        booking.put(carInit[0], userInit[0]);
        // booking.put(carInit[1], userInit[1]);
    }

    public BookArrayAccessService() {
    }

    @Override
    public HashMap<Car, User> getBooking() {
        return booking;
    }

    @Override
    public void put(Car car, User user) {
        booking.put(car, user);
    }

    @Override
    public String toString() {
        return "Book{" + ", booking=" + booking + '}';
    }
    
}
