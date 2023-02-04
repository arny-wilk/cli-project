package bookings;

import static enums.Enum.VEHICULE_TYPE.ELECTRIC;

import cars.Car;
import cars.CarArrayDataAccessService;
import users.User;

public class BookingService {

    private static Book booking;
    private static final int CAPACITY = 10;
    private static int nextIteration = 0;

    public BookingService(Book booking) {
        BookingService.booking = booking;
    }

    public void addBook(Car car, User user) {
        booking.put(car, user);
    }

    public void getAllUsersBookCars(CarArrayDataAccessService carDAS) {
        for (Car car : carDAS.getCars()) {
            if (booking.getBooking().containsKey(car)) {
                System.out.println(car);
            }
        }
    }

    public void getAvailableCars(CarArrayDataAccessService carDAS) {
        for (Car car : carDAS.getCars()) {
            if (!booking.getBooking().containsKey(car)) {
                System.out.println(car);
            }
        }
    }

    public static Car[] getAvailableElectricCars(CarArrayDataAccessService carDAS) {
        Car[] availableElectricCars = new Car[CAPACITY];
        for (Car car : carDAS.getCars()) {
            try {
                if (!booking.getBooking().containsKey(car) && car.getVehiculeType().equals(ELECTRIC)) {
                    availableElectricCars[nextIteration++] = car;
                }
                
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return availableElectricCars;
    }
}
