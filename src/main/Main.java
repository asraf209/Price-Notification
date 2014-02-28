package main;

import impl.Fetcher;
import impl.EmailSender;
import impl.Global;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	
	private static void start(String productId, String emailId){
		//List<Double> response = Fetcher.getProduct(productId);
		
		// Send requests and get response of a specific product id
		List<String> response = Fetcher.getProduct(productId);
		System.out.println(response);		
		
		if(response != null){
			if(response.size() > 0){				
				double currentPrice = Double.parseDouble(response.get(2));
				double originalPrice = Double.parseDouble(response.get(3));
				
				/*
				 *  If current price is at least 20% lowered down then send email notification
				 */
				if(currentPrice <= originalPrice*(1 - Global.DISCOUNT)){
					String msgBody = "Product Id: " + response.get(0) + "\n";
					msgBody += "Product Name: " + response.get(1) + "\n";					
					msgBody += "Original Price: $" + originalPrice + "\n";
					msgBody += "Discounted Price: $" + currentPrice + "\n";
					EmailSender.send(msgBody, emailId);
				}
				
			}
			else{
				System.out.println("Product not found!");
				System.exit(0);
			}
		}	
		
	}
	
	private static void sleep(int ms){
		try{
			Thread.sleep(ms);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	private static String getUserInput(String display){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner (System.in);
		System.out.print(display);  
		String input = scanner.nextLine();		
		return input;
	}
	
	
	/*
	 * Check whether the email address is in correct format
	 */
	private static boolean emailValidator(String emailId){
		final String EMAIL_PATTERN = 
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(emailId);
		return matcher.matches();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String productId = getUserInput("Product Id: ");	//"8314215";
		String emailId = getUserInput("Your Email: ");		//"malom@luc.edu";		
		
		if(!emailValidator(emailId)){						// If wrong email format then exit	
			System.out.println("Invalid Email!");	
			System.exit(0);	
		}
				
		
		while(true){
			start(productId, emailId);			// Start the task
			sleep(1000 * Global.HOUR * 6);		// Check on every 6 hours			
		}
		
	}

}
