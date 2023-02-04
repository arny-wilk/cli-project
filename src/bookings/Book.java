package bookings;

import java.util.HashMap;
import cars.Car;
import users.User;

public interface Book { 
    HashMap<Car, User> getBooking();
    void put(Car car, User user);
}
