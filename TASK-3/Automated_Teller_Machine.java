import java.util.Scanner;  
public class Automated_Teller_Machine
{  
    public static void main(String args[] )  
    {   
        int balance=12000000, withdraw, deposit;    
        Scanner sc = new Scanner(System.in);  
        while(true)  
        {  
            System.out.println("Automated Teller Machine");  
            System.out.println("Withdraw-1");  
            System.out.println("Deposit-2");  
            System.out.println("Balance-3");  
            System.out.println("EXIT-4");  
            System.out.print("Chunav Karen:");  
            int choice = sc.nextInt();  
            switch(choice)  
            {  
                case 1:  
       			 System.out.print("Nikali Gayi Rashi:"); 
        		 withdraw = sc.nextInt();  
        	if(balance >= withdraw)  
        	{  
            		balance = balance - withdraw;  
            		System.out.println("Jama Dekhen");  
        	}  
        	else  
        	{  
            		System.out.println("Aasuvidha");  
        	}  
        	System.out.println("");  
        	break;  
                case 2:  
        		System.out.print("Jama-Rashi:");  
        		deposit = sc.nextInt();  
        		balance = balance + deposit;  
        		System.out.println("Kaam HOgaya");  
        		System.out.println("");  
        		break;  
                case 3:  
        		System.out.println("Muul : "+balance);  
        		System.out.println("");  
        		break;  
                case 4:  
        		System.exit(0);  
            }  
        }  
    }  
}  