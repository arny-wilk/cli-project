import java.util.Arrays;

import bookings.BookHashMapAccessService;
import bookings.BookingService;
import cars.CarArrayDataAccessService;
import users.UserArrayDataAccessService;

public class CliInstructions {
    UserArrayDataAccessService users = new UserArrayDataAccessService();
    CarArrayDataAccessService cars = new CarArrayDataAccessService();
    BookHashMapAccessService bookDAS = new BookHashMapAccessService();
    BookingService bookingService = new BookingService();

    public void println() {
        System.out.println(Arrays.toString(users.getUsers()));
        System.out.println(Arrays.toString(cars.getCars()));
        System.out.println(bookDAS.getBooking());
        System.out.println(bookingService.getAllUsersBookCars());
        System.out.println(bookingService.getAvailableCars());
        System.out.println(bookingService.getAvailableElectricCars());
    }

}
