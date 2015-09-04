package vendingMachine;
import java.util.Scanner;

public class main {
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		VendingBrain firstBrain = new VendingBrain();
		
		System.out.println("Welcome to the world's best vending machine.....probably");
		System.out.println("Insert Coin");
		firstBrain.readCoin(keyboard.nextLine());

	}

}
