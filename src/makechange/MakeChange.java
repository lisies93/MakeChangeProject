package makechange;

import java.util.Scanner;


public class MakeChange {
	
	static	Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {

		
		double price = 0.0, payment = 0.0;
	    
	    
//	    ,quarter = .25, dime = .10, nickel = .05, penny = .01;
//		int $1b = 1 , $5b = 5, $10b = 10, $20b = 20;   
		
        //prompt user for price and amount received
		
		System.out.print("What is the price of the item: ");
		price = kb.nextDouble();
		System.out.print("What is the amount received by the customer:  ");
		payment = kb.nextDouble();
		
		// calculate the change amount
		
		double	change = payment - price;
		
		
		// checking if the bill is less or equals to 20
		
		boolean go = true;
		
		do {
			
		    if (payment <= 20) {
			
		         // check if the amount provided is less, more or equals to the price of the item.
		    	
			      if (payment == price) {
				
				   System.out.println("The customer provided the exact amount!");
				   go = false;
				
			      } else if (payment < price ) {
				
				    System.out.println("The customer provided less than the expected amount, the transaction can not be complete.");
				    
				    payment = tryAgain();
				    				    
				     go = exit(payment);
				       
				
	               }  else {
		
			           changeDue();
			           
		    	   
		            }
			
			
		  } else {
			
			  System.out.println("We do not accept more than $20 bills");
			  
			  payment = tryAgain();
			  go = exit(payment);
			  
			}  
		   
		} while(go);
		    
}
	

		public static double tryAgain(){
			double paymnt = 0.0;
			
			System.out.println("------------");
			System.out.println("1. Try again.");
			System.out.println("2. Exit ");
			System.out.println("------------");
			String answer = kb.next();
			System.out.println();
			
			switch (answer) {
			case "1":
				
				System.out.println("What's is the new amount received by the customer: ");
				paymnt = kb.nextDouble();
				System.out.println();
				break;
				
			case "2":
				
				System.out.println("Good Bye!");
				paymnt = 0.0;
				break;
			}
			
			return  paymnt;
			
		}
		
		
		public static boolean exit(double pmt) {
			
		boolean	goAgain = true;
			
			if(pmt == 0.0) {
				goAgain = false;
				
			} else  {
				goAgain = true;
				
			}
			
			return goAgain;
			
			
		}
		
		
		private static void changeDue() {
			
		}
		
	}


