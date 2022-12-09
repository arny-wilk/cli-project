package bookings;

import cars.Car;
import users.User;

import java.time.LocalDate;
import java.util.HashMap;

public class Book {
    private LocalDate dateBooking;
    private HashMap<Car, User> booking;
}
