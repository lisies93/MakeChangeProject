package makechange;

import java.util.Scanner;


public class MakeChange {
	
	static	Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {

		
		double price = 0.0, payment = 0.0;
	    boolean correctPrice = true;
	    
		
	    
        //prompt user for price and amount received and continue only if the price is less than 20.
		
		
		while(correctPrice) {
			
			System.out.print("What is the price of the item: ");
			price = kb.nextDouble();
		
			// checking if the bill is less or equals to 20
			
		      if (price > 20) {
		    	
		    	System.out.println("Invalid price please try again");
		    	System.out.println();
		    	correctPrice = true;
		        continue;
		        
		    } else {
		    	
		System.out.print("What is the amount received by the customer:  ");
		payment = kb.nextDouble();
		correctPrice = false;
		
		    }
		}
		
		
		// calculate the change amount
		
		
		double  newPayment = 0.0;
	    boolean go = true;
	    
		// check if the amount provided is less, more or equals to the price of the item.
		
		      while (go) {
			
		    	
			      if (payment == price) {
				
				   System.out.println("The customer provided the exact amount!");
				   System.out.println();
				   go = false;
				
			      } else if (payment < price ) {
				
				    System.out.println("The customer provided less than the expected amount, the transaction can not be complete.");
				     
				    newPayment = tryAgain();
				    go = exit(newPayment);
				    payment = newPayment;
				    continue;
				    				    
	              }  else {
		
			              changeDue(payment, price);
			              break;
			              
	                    }
			      
		    	   
		         } 
		
	    
}
	
           // if the amount received is less than price will show this menu to select to try again or quit.
	
		public static double tryAgain(){
			double paymnt = 0.0;
			boolean option = true;
			
			while(option) {
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
				option = false;
				break;
				
			case "2":
				
				System.out.println("Good Bye!");
				paymnt = 0.0;
				option = false;
				break;
				
			 default: 
				 System.out.println("Invalid option, please try again");
			   continue;
			}
			
			}
			
			return  paymnt;
			
		}
		
		 // if option "Exit" is selected the program ends.
		
		public static boolean exit(double pmt) {
			
		boolean	goAgain = true;
			
			if (pmt == 0.0) {
				
				goAgain = false;
				
			} else  {
				
				goAgain = true;
				
			}
			
			return goAgain;
			
			
		}
		
		// let's calculate the change due.
		
		private static void changeDue( double payment, double price) {
			
			double	_change = payment - price;
			
			System.out.println();
			System.out.println("Provide change to the customer in the following denominations: \n");

			if(_change > 19) {			
				double $20b = (_change - (_change %20))/20;
				 if ($20b == 1) {
					 System.out.println((int)$20b +" --- $20 Dollar Bill");
					 } else System.out.println((int)$20b +" --- $20 Dollar Bills");
				_change -= ($20b * 20);
			}

			if(_change > 9) {			
				double $10b = (_change - (_change %10))/10;
				if ($10b == 1) {
					 System.out.println((int)$10b +" --- $10 Dollar Bill");
					 } else System.out.println(( int )$10b + " --- $10 Dollar Bills");
				_change -= ($10b * 10);
			}
			
			if(_change > 4) {			
				double $5b = (_change - (_change %5))/5;
				if ($5b == 1) {
					 System.out.println((int)$5b +" --- $5 Dollar Bill");
					 } else System.out.println((int)$5b + " --- $5 Dollar Bills " );
				_change -= ($5b * 5);
			}
			
			if(_change >= 1) {			
				double $1b = (_change - (_change %1))/1;
				if ($1b == 1) {
					 System.out.println((int)$1b +" --- $1 Dollar Bill");
					 } else System.out.println((int)$1b + " --- $1 Dollar Bills ");
				_change -= ($1b * 1);
			}

			if(_change > 0.24) {			
				double quarter = (_change - (_change %0.25))/0.25;
				if (quarter == 1) {
					 System.out.println((int)quarter +" --- quarter");
					 } else System.out.println((int) quarter + " --- quarters ");
				_change -= (quarter * 0.25);
			}
			
			if(_change > 0.09) {			
				double dime = (_change - (_change %0.1))/0.1;
				if (dime == 1) {
					 System.out.println((int)dime +" --- dime");
					 } else System.out.println((int) dime + " --- dimes ");
				_change -= (dime * 0.1);
			}
			
			if(_change > 0.04) {			
				double nickels = (_change - (_change %0.05))/0.05;
				if (nickels == 1) {
					 System.out.println((int)nickels +" --- nickel");
					 } else System.out.println((int) nickels +" --- nickels");
				_change -= (nickels * 0.05);
			}
			
			if(_change >= (.01)) {			
				double penny = (_change - (_change %0.01))/0.01;
				_change -= (penny * 0.01);
				
				if((_change < .01) && (_change > .00999)){
					penny += 1;
				}
				if (penny == 1) {
					 System.out.println((int)penny +" --- penny");
					 } else System.out.println((int)penny +" --- pennies");
			
		}
      }
	}


