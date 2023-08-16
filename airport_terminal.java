import java.util.Scanner;
import java.io.*;

public class airport_terminal {
    public static void main (String [] args) throws IOException{

        String destination = " ";
        double oneWayPrice = 0.0;
        double roundTripPrice = 0.0;
        int option = 0;
        int purchaseOption = 0;
        double total = 0.0;
    
        int seats = 0;
        String card = " ";
        String type = " ";
        String userCartChoice = " ";
 
        File flights = new File("C:/Users/lojor/OneDrive/Desktop/1101/flights.txt");
        
        Scanner userScnr = new Scanner (System.in);



        while (option < 4){

            System.out.println();
            System.out.println("WELCOME TO TARKOV AIRLINES.");
            System.out.println("Please select an option below: [1-5]");
            System.out.println("  1. Add flight(s)");
            System.out.println("  2. View Trip");
            System.out.println("  3. Manage Trip");
            System.out.println("  4. Checkout");
            System.out.println("  5. Exit Mejia Airlines");

            option = userScnr.nextInt();

            if (option == 1){
                System.out.printf("+----------------------------------------------+%n");
                System.out.printf("|           Available Flights For EP           |%n");
                System.out.printf("+----------------------------------------------+%n");
                System.out.printf("|  %-12s| %-9s  | %-8s       | \n", "City", "One Way", "Round Trip");
                System.out.printf("+----------------------------------------------+%n");

                Scanner scnr = new Scanner (flights);

                while(scnr.hasNext()){
                    scnr.nextLine();
                    destination = scnr.next();
                    oneWayPrice = scnr.nextDouble();
                    roundTripPrice = scnr.nextDouble();

                    System.out.printf("| %-12s | %-8.2f   | %-7.2f          | \n", destination, oneWayPrice, roundTripPrice);
                    System.out.printf("+----------------------------------------------+%n");

                
                }
            
                
                Scanner s = new Scanner (System.in);

                System.out.println("What flight would you like to get? Enter the name of the city: ");
                destination = s.nextLine();

            
                switch(destination){
                case "Chicago":
                oneWayPrice = 142.45;
                roundTripPrice = 334.56;
                break;

                case "Dallas":
                oneWayPrice = 150.30;
                roundTripPrice = 375.20;
                break;

                case "Helsinki":
                oneWayPrice = 678.33;
                roundTripPrice = 1293.40;
                break;

                case "Memphis":
                oneWayPrice = 104.45;
                roundTripPrice = 389.40;
                break;

                case "Jeju":
                oneWayPrice = 924.56;
                roundTripPrice = 1839.56;
                break;

                case "Stokholm":
                oneWayPrice = 836.78;
                roundTripPrice = 1194.59;
                break;

                case "WashingtonDC":
                oneWayPrice = 134.78;
                roundTripPrice = 367.56;
                break;

                case "Tallin":
                oneWayPrice = 945.09;
                roundTripPrice = 1345.67;
                break;

                case "Cairo":
                oneWayPrice = 770.12;
                roundTripPrice = 1142.53;
                break;

                case "Copenhagen":
                oneWayPrice = 883.45;
                roundTripPrice = 1225.63;
                break;

                case "LosAngeles":
                oneWayPrice = 234.56;
                roundTripPrice = 376.56;
                break;

                case "Orlando":
                oneWayPrice = 256.78;
                roundTripPrice = 492.13;
                break;

                case "Tokyo":
                oneWayPrice = 987.34;
                roundTripPrice = 1450.34;
                break;

                case "Paris":
                oneWayPrice = 873.12;
                roundTripPrice = 1294.54;
                break;

                case "Shanghai":
                oneWayPrice = 723.99;
                roundTripPrice = 1156.10;
                break;

                case "London":
                oneWayPrice = 929.22;
                roundTripPrice = 1034.50;
                break;

                case "Huixtla":
                oneWayPrice = 445.23;
                roundTripPrice = 816.55;
                break;

                case "Cancun":
                oneWayPrice = 539.45;
                roundTripPrice = 869.34;
                break;

                case "Guadalajara":
                oneWayPrice = 436.78;
                roundTripPrice = 899.12;
                break;
                }
            

                System.out.println("What are you purchasing?");
                System.out.println("   1. One-Way");
                System.out.println("   2. Round-trip");

                purchaseOption = s.nextInt();

                System.out.println("How many seats will you be purchasing?");

                seats = s.nextInt();

                if (purchaseOption == 1){
                    total = oneWayPrice * seats;
                    type = "One Way";
                }
                else{
                    total = roundTripPrice * seats;
                    type = "Round Trip";
                }

                


            }

            else if (option == 2){
                System.out.println("-------------------------- Trip Information --------------------------");
                System.out.printf("EL PASO to %-12s [Total] $%-8.2f [Type] %-12s [Seats] %-8d \n", destination, total, type, seats);
            }

            else if (option == 3){
                System.out.println("This option clears your cart.");
                System.out.println("Are you sure you want to clear your trips? [type in YES  or NO]");

                Scanner clearTrips = new Scanner (System.in);

                userCartChoice = clearTrips.nextLine();

                if (userCartChoice.equals("YES")){
                    destination = " ";
                    oneWayPrice = 0.0;
                    roundTripPrice = 0.0;
                    option = 0;
                    purchaseOption = 0;
                    total = 0;
                    seats = 0;
                    card = " ";
                    type = " ";
                    userCartChoice = " ";

                    System.out.println();
                    
                    System.out.println("Cart cleared.");
                }
                else if (userCartChoice.equals("NO")){
                    System.out.println("Cart not changed.");
                    System.out.println("Going back to menu...");
                    continue;
                }


            }
        } 

        if (option == 4){

            double totalWithTax = total * 1.0725;

            System.out.println();
            System.out.printf("Your current total with tax is: $%.2f \n",  totalWithTax);
            System.out.println("Please enter a 16 digit visa/master card number");

            Scanner cardScanner = new Scanner (System.in);

            card = cardScanner.nextLine();

            if ((card.length()) == 16){
                System.out.println("Your purchase for:");
                System.out.printf("EL PASO to %-12s [Total] $%-8.2f [Type] %-12s [Seats] %-8d \n", destination, total, type, seats);
                System.out.printf("was successfull. You paid $%.2f using the %s: \n", totalWithTax, card);
                System.out.println(" Have fun on your trip!");
            }
            else {
                System.out.println("That is not a valid card number. Exiting...");
            }

            
        }

        else if (option == 5){
            System.out.println("Thank you for using Tarkov Airlines.");
            System.out.println("Stay Safe! Stay Hydrated!");
        }

        else {
            System.out.println("That input is invalid.");
        }



    

        

    }
}