package bookings;

import cars.Car;
import users.User;

public interface Book { 
    HashTable<Car, User> getBooking();
    void put(Car car, User user);
}
