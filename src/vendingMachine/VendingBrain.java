package vendingMachine;

public class VendingBrain {
	
	public void readCoin(String coinInput){
		if(coinInput.equals("q") || coinInput.equals("Q")){
			System.out.println("Quarter inserted");
		}
		else {
			System.out.println("Unsuccesful insertion");
			System.out.println("Coin input was: " + coinInput);
		}
	}
}
