import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) { 
        
            CliInstructions commands = new CliInstructions();
            commands.println();

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
                if (instruction.equals("1")) commands.bookingService.addBook();
                if (instruction.equals("2")) System.out.println(commands.bookingService.getAllUsersBookCars()); 
                if (instruction.equals("3")) System.out.println(commands.bookDAS.getBooking()); 
                if (instruction.equals("4")) System.out.println(commands.bookingService.getAvailableCars()); 
                if (instruction.equals("5")) System.out.println(commands.bookingService.getAvailableElectricCars()); 
                if (instruction.equals("6")) System.out.println(Arrays.toString(commands.users.getUsers())); 
                if (instruction.equals("7")) break;
            }
        }
    }
}
