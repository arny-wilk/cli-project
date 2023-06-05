import bookings.BookHashMapAccessService;
import bookings.BookingService;
import cars.CarArrayDataAccessService;
import users.UserArrayDataAccessService;

public class Controller {
    UserArrayDataAccessService usersArray = new UserArrayDataAccessService();
    String controlUsersData = usersArray.registerUsersToCSVFile();
    CarArrayDataAccessService carsArray = new CarArrayDataAccessService();
    String controlCarsData = carsArray.registerCarsToCSVFile();
    BookHashMapAccessService bookDAS = new BookHashMapAccessService();
    BookingService bookingService = new BookingService();
}
