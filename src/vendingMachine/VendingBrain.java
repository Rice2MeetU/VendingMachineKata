package vendingMachine;

public class VendingBrain {
	
	private double insertedTotal = 0.00;
	private double availableChange = 10.00;
	private double availableCoinReturn = 0.00;
	
	
	// Coin reading method. Verifies whether an insert is valid and then acts based on this ruling.
	public void readCoin(String coinInput){
		if(coinInput.equals("q") || coinInput.equals("Q")){
			System.out.println("Quarter inserted");
			updateInsertedTotal(0.25);
			
		}
		
		else if(coinInput.equals("n") || coinInput.equals("N")){
			System.out.println("Nickel inserted");
			updateInsertedTotal(0.05);
		}
		
		else if(coinInput.equals("d") || coinInput.equals("D")){
			System.out.println("Dime inserted");
			updateInsertedTotal(0.10);
		}
		
		else if(coinInput.equals("p") || coinInput.equals("P")){
			System.out.println("Sorry, pennies are not accepted because reasons");
			updateCoinReturnTotal(0.01);
		}
		
		else {
			System.out.println("Error, unrecognizable coin");
			System.out.println("Coin input was: " + coinInput);
		}
	}
	
	public void showDisplay(){
		if (insertedTotal == 0.00){
			System.out.println("Display: Insert Coin");
		}
		else {
			System.out.println("Display: " + insertedTotal);
		}
	}
	
	public void updateInsertedTotal(Double coinValue){
		insertedTotal = insertedTotal + coinValue;
	}
	
	public void updateCoinReturnTotal(Double returnCoins){
		
	}
	
}
