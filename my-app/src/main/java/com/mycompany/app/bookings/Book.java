package bookings;

import cars.Car;
import java.util.HashMap;
import users.User;

public interface Book { 
    HashMap<Car, User> getBooking();
}
