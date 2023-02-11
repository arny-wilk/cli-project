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
        ArrayList<User> userRegister = new ArrayList<>();
        System.out.println(Arrays.toString(usersDAS.getUsers()));
        Scanner inputId = new Scanner(System.in);
        System.out.println("Choose a user ID : ");
        UUID id = UUID.fromString(inputId.nextLine());
        for (User user : usersDAS.getUsers()) {
            try {
                if (!id.equals(user.getUserId())) {
                    Optional.empty();
                } else {
                    userRegister.add(user);
                }
            } catch (Exception e) {
                Optional.of(e);
            }
        }
        System.out.println(userRegister);

        ArrayList<Car> carsRegList = new ArrayList<>();
        Scanner inputReg = new Scanner(System.in);
        System.out.println("Choose a car Registration Number : ");
        String reg = inputReg.nextLine();
        for (Car car : carsDAS.getCars()) {
                try {
                    if (!reg.equals(car.getRegNumber())) {
                        Optional.empty();
                    } else {
                        carsRegList.add(car);
                    }
                } catch (Exception e) {
                    Optional.of(e);
                }
        }

        System.out.println(carsRegList);
        book.getBooking().put(carsRegList.get(0), userRegister.get(0));
        System.out.println("You have successfully booked the user : " + userRegister.get(0).getFirstName() + " "
                + userRegister.get(0).getLastname());

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