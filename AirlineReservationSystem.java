
//  Airlines Reservation System Project 

// Abhishek Kumar Pathak

// Date 16/4/2023

import java.util.*;

public class AirlineReservationSystem {
    private static final int MAX_SEATS = 100;// You Can change AccordingTo your Need
    private static int[] seats = new int[MAX_SEATS];
    private static int passengerCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter 1 to reserve a seat");
            System.out.println("Enter 2 to cancel a reservation");
            System.out.println("Enter 3 to view passenger count");
            System.out.println("Enter 4 to view available seats");
            System.out.println("Enter 5 to exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    reserveSeat();
                    break;
                case 2:
                    cancelReservation();
                    break;
                case 3:
                    viewPassengerCount();
                    break;
                case 4:
                    viewAvailableSeats();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    private static void reserveSeat() {
        if (passengerCount == MAX_SEATS) {
            System.out.println("All seats are already reserved");
            return;
        }

        System.out.println("Enter passenger name:");
        String name = scanner.next();

        System.out.println("Enter seat number (1-" + MAX_SEATS + "):");
        int seatNumber = scanner.nextInt();

        if (seatNumber < 1 || seatNumber > MAX_SEATS) {
            System.out.println("Invalid seat number");
            return;
        }

        if (seats[seatNumber - 1] == 1) {
            System.out.println("Seat already reserved");
            return;
        }

        seats[seatNumber - 1] = 1;
        passengerCount++;

        System.out.println("Reservation successful. Passenger name: " + name + ", Seat number: " + seatNumber);
    }

    private static void cancelReservation() {
        if (passengerCount == 0) {
            System.out.println("No reservations to cancel");
            return;
        }

        System.out.println("Enter seat number to cancel reservation:");
        int seatNumber = scanner.nextInt();

        if (seatNumber < 1 || seatNumber > MAX_SEATS) {
            System.out.println("Invalid seat number");
            return;
        }

        if (seats[seatNumber - 1] == 0) {
            System.out.println("Seat not reserved");
            return;
        }

        seats[seatNumber - 1] = 0;
        passengerCount--;

        System.out.println("Reservation cancelled for seat number " + seatNumber);
    }

    private static void viewPassengerCount() {
        System.out.println("Passenger count: " + passengerCount);
    }

    private static void viewAvailableSeats() {
        System.out.println("Available seats:");

        for (int i = 0; i < MAX_SEATS; i++) {
            if (seats[i] == 0) {
                System.out.print((i + 1) + " ");
            }
        }

        System.out.println();
    }
}
// AbhishekKumarPathak
// MonthApril2023