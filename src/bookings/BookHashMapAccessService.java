package bookings;

import cars.Car;
import cars.CarArrayDataAccessService;
import users.User;
import users.UserArrayDataAccessService;

public class BookHashMapAccessService implements Book {

    private HashTable<Car, User> bookTable;
    private CarArrayDataAccessService cars = new CarArrayDataAccessService();
    private UserArrayDataAccessService users = new UserArrayDataAccessService();

    public BookHashMapAccessService(HashTable<Car, User> bookTable) {
        this.bookTable = bookTable;
        // bookTable.put(cars.getCars()[0], users.getUsers()[0]);
        bookTable.put(cars.getCars()[1], users.getUsers()[1]);
    }

    @Override
    public HashTable<Car, User> getBooking() {
        return bookTable;
    }

    @Override
    public void put(Car car, User user) {
        bookTable.put(car, user);
    }

    @Override
    public String toString() {
        return "Book{" + ", booking=" + bookTable + '}';
    }
}
