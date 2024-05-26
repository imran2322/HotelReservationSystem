import java.util.ArrayList;
import java.util.Scanner;

class Room {
    String category;
    boolean isAvailable;
    double price;
    
    Room(String category, double price) {
        this.category = category;
        this.price = price;
        this.isAvailable = true;
    }
}

class Reservation {
    Room room;
    String guestName;
    int days;
    
    Reservation(Room room, String guestName, int days) {
        this.room = room;
        this.guestName = guestName;
        this.days = days;
    }
}

public class HotelReservationSystem {
    public static void main(String[] args) {
        ArrayList<Room> rooms = new ArrayList<>();
        ArrayList<Reservation> reservations = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        
        // Adding some rooms
        rooms.add(new Room("Single", 1000));
        rooms.add(new Room("Double", 1500));
        rooms.add(new Room("Suite", 2500));
        
        System.out.println("Hotel Reservation System");
        
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Search for available rooms");
            System.out.println("2. Make a reservation");
            System.out.println("3. View booking details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 
            
            switch (choice) {
                case 1:
                    System.out.println("Available rooms:");
                    for (Room room : rooms) {
                        if (room.isAvailable) {
                            System.out.println(room.category + " - Rs" + room.price + " per night");
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter room category for booking (Single/Double/Suite): ");
                    String category = sc.nextLine();
                    Room selectedRoom = null;
                    
                    for (Room room : rooms) {
                        if (room.category.equalsIgnoreCase(category) && room.isAvailable) {
                            selectedRoom = room;
                            break;
                        }
                    }
                    
                    if (selectedRoom != null) {
                        System.out.print("Enter your name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter number of days: ");
                        int days = sc.nextInt();
                        
                        selectedRoom.isAvailable = false;
                        reservations.add(new Reservation(selectedRoom, name, days));
                        
                        System.out.println("Reservation made for " + name + " in a " + category + " room for " + days + " days.");
                    } else {
                        System.out.println("No available rooms in that category.");
                    }
                    break;
                case 3:
                    System.out.println("Booking details:");
                    for (Reservation res : reservations) {
                        System.out.println("Guest: " + res.guestName + ", Room: " + res.room.category + ", Days: " + res.days);
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Try again");
            }
        }
    }
}