package bookings;

import cars.Car;
import cars.CarDAO;
import users.User;
import users.UserDAO;

import java.time.LocalDate;
import java.util.HashMap;

public class Book {
    private static final LocalDate dateBooking;
    private static HashMap<Car, User> booking;

    static {
        dateBooking = LocalDate.now();
        booking = new HashMap<>();
        Car[] carInit = CarDAO.getCars();
        User[] userInit = UserDAO.getUsers();
        booking.put(carInit[0], userInit[0]);
        booking.put(carInit[1], userInit[1]);
    }

    public Book() {
    }

    public LocalDate getDateBooking() {
        return dateBooking;
    }

    public HashMap<Car, User> getBooking() {
        return booking;
    }

    public void setBooking(HashMap<Car, User> booking) {
        Book.booking = booking;
    }

    void put(Car car, User user) {
        booking.put(car, user);
    }

    @Override
    public String toString() {
        return "Book{" + "dateBooking=" + dateBooking + ", booking=" + booking + '}';
    }
}
