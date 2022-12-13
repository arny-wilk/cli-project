package bookings;

import cars.Car;
import cars.CarDAO;
import users.User;

import static enums.Enum.VEHICULE_TYPE.ELECTRIC;

public class BookingService {

    private static Book booking;
    private static final int CAPACITY = 10;
    private static int nextIteration = 0;


    public BookingService(Book booking) {
        BookingService.booking = booking;
    }

    public void addBook(Car[] car, User[] user) {
        booking.put(car[car.length - 1], user[user.length - 1]);
    }

    public void getAllUsersBookCars() {
        for (Car car : CarDAO.getCars()) {
            if (booking.getBooking().containsKey(car)) {
                System.out.println(car);
            }
        }
    }

    public void getAvailableCars() {
        for (Car car : CarDAO.getCars()) {
            if (!booking.getBooking().containsKey(car)) {
                System.out.println(car);
            }
        }
    }

    public static Car[] getAvailableElectricCars() {
        Car[] availableElectricCars = new Car[CAPACITY];
        for (Car car : CarDAO.getCars()) {
            if (!booking.getBooking().containsKey(car) && car.getVehiculeType().equals(ELECTRIC)) {
                availableElectricCars[nextIteration++] = car;
            }
        }
        return availableElectricCars;
    }
}
