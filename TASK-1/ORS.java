import java.util.Scanner;
public class ORS
{
    private static boolean[] seat = new boolean[80]; 
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        while(true) 
	{
            // Menu Bar 
            System.out.println("Make A Choice");
            System.out.println("1. View Seat Map");
            System.out.println("2. Reserve Seat");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");

            // Grahak-Waqt
            int Choice = in.nextInt();
            switch (Choice) 
	    {
                case 1:
                    Seat();
                    break;
                case 2:
                    Reserve();
                    break;
                case 3:
                    Cut_Reservation();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
    private static void Seat() 
    {
        System.out.println("Current Position:");
        for (int i = 0; i < seat.length; i++) 
        {
            if (seat[i]) 
            {
                System.out.print("S "); 
            } 
            else 
            {
                System.out.print((i + 1) + " "); 
            }
        }
        System.out.println();
    }
    private static void Reserve() 
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter seat number (1-80): ");
        int n = in.nextInt();
        if (n < 1 || n > 80) 
        {
            System.out.println("Not Possible!");
        } 
        else if (seat[n - 1]) 
        {
            System.out.println("Berth Booked!");
        } 
        else 
        {
            seat[n - 1] = true; 
            System.out.println("Berth Alloted!");
        }
    }
    private static void Cut_Reservation() 
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter seat number (1-80): ");
        int n = in.nextInt();
        if (n < 1 || n > 80) 
        {
            System.out.println("Not Applicable!");
        } 
        else if (!seat[n - 1]) 
        {
            System.out.println("Berth Free!");
        } 
        else 
        {
            seat[n-1] = false; 
            System.out.println("Reservation Terminated!");
        }
    }
}
