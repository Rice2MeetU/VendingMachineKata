package vendingMachine;
import java.util.Scanner;

public class main {
	
	public static void main(String[] args) {
		// Initialize keyboard and vending machine object
		Scanner keyboard = new Scanner(System.in);
		VendingBrain firstBrain = new VendingBrain();
		boolean isMachineOn = true;
		
		//Opening prompt
		System.out.println("Welcome to the world's best vending machine..........probably.");
		
		//Loop that lasts while machine is "on"
		while (isMachineOn == true){
			firstBrain.showDisplay();
			firstBrain.readChoice(keyboard.nextLine());
		}
		
		
	}

}
