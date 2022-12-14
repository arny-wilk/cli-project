import bookings.Book;
import bookings.BookingService;
import cars.Car;
import cars.CarDAO;
import enums.Enum;
import users.User;
import users.UserDAO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        UserDAO users = new UserDAO();
        CarDAO cars = new CarDAO();

        User newUser = new User(UUID.fromString("cd65a1a1-c254-4591-99c9-510c425f6889")
                , "John"
                , "McGregor"
                , Enum.GENDER.MALE
                , Enum.ADDRESS_TYPE.BILLING
                , "8th LongWay"
                , Enum.COUNTRY.ENGLAND
                , "johnmcgregor@outlook.gb");
        users.addUser(newUser);
        Car newCar = new Car(UUID.fromString("eaa83297-2ab1-47f2-be9c-c573a2ac5d1a")
                , "Mercedes"
                , Enum.COLOR.GREY
                , Enum.VEHICULE_CATEGORY.SEDAN
                , Enum.VEHICULE_TYPE.THERMIC
                , BigDecimal.TEN
                , "GB4565 HAV");
        cars.addCar(newCar);

        Book booking = new Book();
        System.out.println(booking);
        BookingService bookingService = new BookingService(booking);

        HashMap<String, Object> choice = new HashMap<>();
        choice.put("1", instruction1(bookingService));
        choice.put("2", instruction2(bookingService));
        choice.put("3", instruction3(booking));
        choice.put("4", instruction4(bookingService));
        choice.put("5", instruction5());
        choice.put("6", instruction6());

        Scanner scan = new Scanner(System.in);
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
            if (choice.containsKey(instruction)) {
                System.out.println(choice.get(instruction));
            }
            else if (instruction.equals("7")) {
                System.out.println("Are you sure you want to exit the CLI (y/n?");
                String ans = scan.nextLine();
                if (!ans.equalsIgnoreCase("y")) {
                    System.out.println("Follow instructions :");
                } else {
                    break;
                }
            }
        }
    }

    private static User[] instruction6() {
        System.out.println("View all users");
        return UserDAO.getUsers();
    }

    private static String instruction5() {
        System.out.println("View Available Electric Cars");
        return Arrays.toString(BookingService.getAvailableElectricCars());
    }

    private static ArrayList<Car> instruction4(BookingService bookingService) {
        System.out.println("View Available Cars");
        return bookingService.getAvailableCars();
    }

    private static HashMap<Car, User> instruction3(Book booking) {
        System.out.println("View All Bookings");
        return booking.getBooking();
    }

    private static ArrayList<Car> instruction2(BookingService bookingService) {
        System.out.println("View All User Booked Cars");
        return bookingService.getAllUsersBookCars();
    }

    private static String instruction1(BookingService bookingService) {
        return "You successfully added a Car Reservation for the latest user";
    }
}
