import java.util.Scanner;

public class GetInput {

    //    System.out.print ("Enter the coordinates of the first point " + "(put a space between them): ");
    //    x1 = scan.nextDouble();
    //    y1 = scan.nextDouble();

    public static int getIntFromUser(String messageString, boolean verbose) {
        int intFromUser = -1;
        Scanner intFromUserInput = new Scanner(System.in);
        System.out.println(messageString);
        try {
            intFromUser = intFromUserInput.nextInt();
        } catch(Exception error){
            System.out.println("Invalid input! Exiting Program!");
            if (verbose){
                System.out.println("Error: " + error);
            }
            System.exit(0);
        }
        return intFromUser;
    }

    public static String getStrFromUser(String messageString, boolean verbose) {
        String strFromUser = "error";
        Scanner strFromUserInput = new Scanner(System.in);
        System.out.println(messageString);
        try {
            strFromUser = strFromUserInput.nextLine();
        } catch(Exception error){
            System.out.println("Invalid input! Exiting Program!");
            if (verbose){
                System.out.println("Error: " + error);
            }
            System.exit(0);
        }
        return strFromUser;
    }
}