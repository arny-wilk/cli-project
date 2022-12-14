package bookings;

import cars.Car;
import cars.CarDAO;

import java.util.ArrayList;

import static enums.Enum.VEHICULE_TYPE.ELECTRIC;

public class BookingService {
    private static Book booking;
    private static final int CAPACITY = 10;
    private static int nextIteration = 0;

    public BookingService(Book booking) {
        BookingService.booking = booking;
    }


    public ArrayList<Car> getAllUsersBookCars() {
        ArrayList<Car> usersCars = new ArrayList<>();
        for (Car car : CarDAO.getCars()) {
            if (booking.getBooking().containsKey(car)) {
                usersCars.add(car);
            }
        }
        return usersCars;
    }

    public ArrayList<Car> getAvailableCars() {
        ArrayList<Car> availableCars = new ArrayList<>();
        for (Car car : CarDAO.getCars()) {
            if (!booking.getBooking().containsKey(car)) {
                availableCars.add(car);
            }
        }
        return availableCars;
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
