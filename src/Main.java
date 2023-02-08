import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;

import bookings.BookHashMapAccessService;
import bookings.BookingService;
import bookings.HashTable;
import cars.Car;
import cars.CarArrayDataAccessService;
import users.User;
import users.UserArrayDataAccessService;

public class Main {
    public static void main(String[] args) {

        UserArrayDataAccessService users = new UserArrayDataAccessService();
        CarArrayDataAccessService cars = new CarArrayDataAccessService();
        HashTable<Car, User> book = new HashTable<>();
        BookingService bookingService = new BookingService();
        BookHashMapAccessService bookDAS = new BookHashMapAccessService(book);

        try (Scanner scan = new Scanner(System.in)) {
            String instructions = """
                    1️⃣ - Book Car
                    2️⃣ - View All User Booked Cars
                    3️⃣ - View All Bookings
                    4️⃣ - View Available Cars
                    5️⃣ - View Available Electric Cars
                    6️⃣ - View all users
                    7️⃣ - Exit""";

            while (true) {
                System.out.println(instructions);
                String instruction = scan.nextLine();
                if (instruction.equals("1")) {
                    instruction1(users, cars, bookDAS);
                }
                if (instruction.equals("2")) {
                    instruction2(bookingService, cars);
                }
                if (instruction.equals("3")) {
                    instruction3(bookDAS);
                }
                if (instruction.equals("4")) {
                    instruction4(bookingService, cars);
                }
                if (instruction.equals("5")) {
                    instruction5(cars);
                }
                if (instruction.equals("6")) {
                    instruction6(users);
                }

                if (instruction.equals("7")) {
                    System.out.println("Are you sure you want to exit the CLI (y/n?");
                    String ans = scan.nextLine();
                    if (ans.equalsIgnoreCase("y")) {
                        break;
                    } else {
                        System.out.println("Follow instructions :");
                    }
                }
            }
        }
    }

    private static void instruction6(UserArrayDataAccessService users) {
        System.out.println("View all users");
        System.out.println(Arrays.toString(users.getUsers()));
    }

    private static void instruction5(CarArrayDataAccessService cars) {
        System.out.println("View Available Electric Cars");
        BookingService.getAvailableElectricCars(cars);
    }

    private static void instruction4(BookingService bookingService, CarArrayDataAccessService cars) {
        System.out.println("View Available Cars");
        bookingService.getAvailableCars(cars);
    }

    private static void instruction3(BookHashMapAccessService bookDAS) {
        System.out.println("View All Bookings");
        System.out.println(bookDAS.getBooking());
    }

    private static void instruction2(BookingService bookingService, CarArrayDataAccessService cars) {
        System.out.println("View All User Booked Cars");
        bookingService.getAllUsersBookCars(cars);
    }

    private static void instruction1(UserArrayDataAccessService users, CarArrayDataAccessService cars, BookHashMapAccessService bookDAS) {
        System.out.println("Book Car");
        ArrayList<User> userRegister = new ArrayList<>();

        System.out.println(Arrays.toString(users.getUsers()));
        try (Scanner inputId = new Scanner(System.in)) {
            System.out.println("Choose a user ID : ");
            UUID id = UUID.fromString(inputId.nextLine());
            for (User user : users.getUsers()) {
                try {
                    if (id.equals(user.getUserId(id))) {
                        userRegister.add(user);
                    }
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        }
        System.out.println(userRegister);

        ArrayList<Car> carsRegList = new ArrayList<>();

        System.out.println(cars);
        try (Scanner inputReg = new Scanner(System.in)) {
            System.out.println("Choose a car Registration Number : ");
            String reg = inputReg.nextLine();
            for (Car car : cars.getCars()) {
                try {
                    if (reg.equals(car.getRegNumber())) {
                        carsRegList.add(car);
                    }
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        }
        System.out.println(carsRegList);
        bookDAS.put(carsRegList.get(0), userRegister.get(0));
        System.out.println("You have successfully booked the user : " + userRegister.get(0).getFirstName() + " "
                + userRegister.get(0).getLastname());

    }
}
