package bookings;

import static enums.Enum.VEHICULE_TYPE.ELECTRIC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

import cars.Car;
import cars.CarArrayDataAccessService;
import users.User;
import users.UserArrayDataAccessService;

public class BookingService {

    static UserArrayDataAccessService usersDAS = new UserArrayDataAccessService();
    static CarArrayDataAccessService carsDAS = new CarArrayDataAccessService();
    static BookHashMapAccessService book = new BookHashMapAccessService();

    public void addBook() {
        User selectedUser = new User();
        Scanner inputId = new Scanner(System.in);
        System.out.println("Choose a user ID : ");
        Optional<UUID> id = Optional.ofNullable(UUID.fromString(inputId.nextLine()));
        for (User user : usersDAS.getUsers()) {
            if (id.isPresent()) {
                selectedUser = user;
            } else {
                Optional.empty();
            }
        }
        Car selectedCar = new Car();
        Scanner inputReg = new Scanner(System.in);
        System.out.println("Choose a car Registration Number : ");
        Optional<String> reg = Optional.ofNullable(inputReg.nextLine());
        for (Car car : carsDAS.getCars()) {
            if (reg.isPresent()) {
                selectedCar = car;
            } else {
                Optional.empty();
            }
        }

        book.getBooking().put(selectedCar, selectedUser);
        System.out.println("You have successfully booked the user : " + selectedUser + " "
                + selectedUser);

    }

    public Optional<Car> getAllUsersBookCars() {
        for (Car car : carsDAS.getCars()) {
            if (book.getBooking().containsKey(car)) {
                return Optional.of(car);
            }
        }
        return Optional.empty();
    }

    public Optional<Car> getAvailableCars() {
        for (Car car : carsDAS.getCars()) {
            if (!book.getBooking().containsKey(car)) {
                return Optional.ofNullable(car);
            }
        }
        return Optional.empty();
    }

    public Optional<Car> getAvailableElectricCars() {
        for (Car car : carsDAS.getCars()) {
            if (!book.getBooking().containsKey(car)) {
                return Optional.ofNullable(car).filter(t -> t.getVehiculeType().equals(ELECTRIC));
            }
        }
        return Optional.empty();
    }
}