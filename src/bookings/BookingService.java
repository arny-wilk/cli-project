package bookings;

import static enums.Enum.VEHICULE_TYPE.ELECTRIC;

import java.util.Optional;

import cars.Car;
import cars.CarArrayDataAccessService;

public class BookingService {

    static BookHashMapAccessService book;
    private static Optional<BookHashMapAccessService> optionalBook = Optional.ofNullable(book);


    public void getAllUsersBookCars(CarArrayDataAccessService carDAS) {
        for (Car car : carDAS.getCars()) {
            if (car != null && optionalBook.isPresent()) {
                System.out.println(car);
            } else {
                System.out.println("Ooops there's no cars here");
            }
        }
    }

    public void getAvailableCars(CarArrayDataAccessService carDAS) {
        for (Car car : carDAS.getCars()) {
            if (car != null && optionalBook.isEmpty()) {
                System.out.println(car);
            } else {
                System.out.println("Ooops There's no available cars");
            }
        }
    }

    public static void getAvailableElectricCars(CarArrayDataAccessService carDAS) {
        for (Car car : carDAS.getCars()) {
            if (car != null && optionalBook.isEmpty() && car.getVehiculeType().equals(ELECTRIC)) {
                System.out.println(car);
            } else {
                System.out.println("Ooops There's no available cars currently");
            }
        }
    }
}
