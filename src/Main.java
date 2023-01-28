import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;

import bookings.Book;
import bookings.BookingService;
import cars.Car;
import cars.CarDAO;
import users.User;
import users.UserDAO;

public class Main {
    public static void main(String[] args) {

        UserDAO users = new UserDAO();
        CarDAO cars = new CarDAO();

        System.out.println(Arrays.toString(UserDAO.getUsers()));
        System.out.println();
        System.out.println(Arrays.toString(CarDAO.getCars()));

        // User newUser = new User("cd65a1a1-c254-4591-99c9-510c425f6889"
        // , "John"
        // , "McGregor"
        // , Enum.GENDER.valueOf("MALE")
        // , Enum.ADDRESS_TYPE.BILLING
        // , "8th LongWay"
        // , Enum.COUNTRY.ENGLAND
        // , "johnmcgregor@outlook.gb");
        // users.addUser(newUser);
        // Car newCar = new Car("eaa83297-2ab1-47f2-be9c-c573a2ac5d1a"
        // , "Mercedes"
        // , Enum.COLOR.GREY
        // , Enum.VEHICULE_CATEGORY.SEDAN
        // , Enum.VEHICULE_TYPE.THERMIC
        // , BigDecimal.TEN
        // , "GB4565 HAV");
        // cars.addCar(newCar);

        Book booking = new Book();
        BookingService bookingService = new BookingService(booking);
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
                    instruction1(booking, bookingService, users, cars);
                }
                if (instruction.equals("2")) {
                    instruction2(bookingService);
                }
                if (instruction.equals("3")) {
                    instruction3(booking);
                }
                if (instruction.equals("4")) {
                    instruction4(bookingService);
                }
                if (instruction.equals("5")) {
                    instruction5();
                }
                if (instruction.equals("6")) {
                    instruction6();
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

    private static void instruction6() {
        System.out.println("View all users");
        System.out.println(Arrays.toString(UserDAO.getUsers()));
    }

    private static void instruction5() {
        System.out.println("View Available Electric Cars");
        System.out.println(Arrays.toString(BookingService.getAvailableElectricCars()));
    }

    private static void instruction4(BookingService bookingService) {
        System.out.println("View Available Cars");
        bookingService.getAvailableCars();
    }

    private static void instruction3(Book booking) {
        System.out.println("View All Bookings");
        System.out.println(booking.getBooking());
    }

    private static void instruction2(BookingService bookingService) {
        System.out.println("View All User Booked Cars");
        bookingService.getAllUsersBookCars();
    }

    private static void instruction1(Book booking, BookingService bookingService, UserDAO users, CarDAO cars) {
        System.out.println("Book Car");
        ArrayList<User> userRegister = new ArrayList<>();

        System.out.println(Arrays.toString(users.getUsers()));
        Scanner inputId = new Scanner(System.in);
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
        System.out.println(userRegister);

        ArrayList<Car> carsRegList = new ArrayList<>();

        System.out.println(cars);
        Scanner inputReg = new Scanner(System.in);
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
        System.out.println(carsRegList);
        bookingService.addBook(carsRegList.get(0), userRegister.get(0));
        System.out.println("You have successfully booked the user : " + userRegister.get(0).getFirstName() + " "
                + userRegister.get(0).getLastname());

    }
}
