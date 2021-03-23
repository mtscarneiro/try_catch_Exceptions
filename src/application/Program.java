package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try{
                System.out.println("Room number: ");
                int number = input.nextInt();
                System.out.println("Check-in date (dd/mm/yyyy): ");
                Date checkIn = sdf.parse(input.next());
                System.out.println("Check-out date (dd/mm/yyyy): ");
                Date checkOut = sdf.parse(input.next());

                Reservation reservation = new Reservation(number, checkIn, checkOut);
                System.out.println("Reservation: " + reservation);

                System.out.println();
                System.out.println("Enter data to update the reservation: ");
                System.out.println("Check-in date (dd/mm/yyyy): ");
                checkIn = sdf.parse(input.next());
                System.out.println("Check-out date (dd/mm/yyyy): ");
                checkOut = sdf.parse(input.next());

                reservation.updateDates(checkIn, checkOut);
                    
                System.out.println("Updated reservation: " + reservation);
            }
        catch (ParseException e){
                System.out.println("Invalid date format.");
            }
        catch (DomainException e){
                System.out.println("Error in reservation: " + e.getMessage());
            }
        catch (RuntimeException e){
            System.out.println("Unexpected Error!");
        }

		input.close();
	
        }	
	}
