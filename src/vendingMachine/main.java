package vendingMachine;
import java.util.Scanner;

public class main {
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		VendingBrain firstBrain = new VendingBrain();
		boolean didYouLeave = false;
		
		System.out.println("Welcome to the world's best vending machine..........probably.");
		//System.out.println("Please choose an option below");
		
		//Currently will loop infinitely but that's fine for now
		while (didYouLeave == false){
			firstBrain.showDisplay();
			firstBrain.readCoin(keyboard.nextLine());
		}
		
		

	}

}
