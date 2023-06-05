import java.util.Arrays;
import java.util.Scanner;

/**
 *
 */
public class App {
    public static void main(String[] args) {

        Controller commands = new Controller();

        try (Scanner instruction = new Scanner(System.in)) {
            String instructions = """
                    1️⃣ - Book Car
                    2️⃣ - View All User Booked Cars
                    3️⃣ - View All Bookings
                    4️⃣ - View Available Cars
                    5️⃣ - View Available Electric Cars
                    6️⃣ - View all users
                    7️⃣ - Exit""";

            System.out.println(instructions);
            while (!instruction.hasNext("7")) {
                switch (instruction.nextLine()) {
                    case "1" -> commands.bookingService.addBook();
                    case "2" -> System.out.println(commands.bookingService.getAllUsersBookCars());
                    case "3" -> System.out.println(commands.bookDAS.getBooking());
                    case "4" -> System.out.println(commands.bookingService.getAvailableCars());
                    case "5" -> System.out.println(commands.bookingService.getAvailableElectricCars());
                    case "6" -> System.out.println(Arrays.toString(commands.usersArray.getUsers()));
                    default -> System.out.println("invalid command");
                }
            }
        }
    }
}
