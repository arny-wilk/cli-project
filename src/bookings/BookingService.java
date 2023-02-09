package bookings;

import static enums.Enum.VEHICULE_TYPE.ELECTRIC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

import cars.Car;
import cars.CarArrayDataAccessService;
import users.User;
import users.UserArrayDataAccessService;

public class BookingService {

    static BookHashMapAccessService book = new BookHashMapAccessService(); 
    static UserArrayDataAccessService usersDAS = new UserArrayDataAccessService();
    static CarArrayDataAccessService carsDAS = new CarArrayDataAccessService();


    public void addBook() {
        ArrayList<User> registeredUser = new ArrayList<>();
        try (Scanner inputId = new Scanner(System.in)) {
            System.out.println("Choose a user  ID : ");
            UUID id = UUID.fromString(inputId.nextLine());
            for (User user : usersDAS.getUsers()) {
                if (user.isUserId(id)) {
                    registeredUser.add(user);
                } else {
                    System.out.println(Optional.of("not found"));
                }
            }
        }
        ArrayList<Car> registeredCar = new ArrayList<>();
        try (Scanner inputReg = new Scanner(System.in)) {
            System.out.println("Choose a car Registration number  : ");
            String reg = inputReg.nextLine();
            for (Car car : carsDAS.getCars()) {
                if (car.getRegNumber().equals(reg)) {
                    registeredCar.add(car);
                } else {
                    System.out.println(Optional.of("not found"));
                }
            }
        }
        book.getBooking().put(registeredCar.get(0), registeredUser.get(0));
        System.out.println("You have successfully added the user %s, %s".formatted(registeredUser.get(0).getFirstName(),
                registeredUser.get(0).getLastname()));
    }

    public Optional<Car> getAllUsersBookCars() {
        for (Car car :  carsDAS.getCars()) {
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
