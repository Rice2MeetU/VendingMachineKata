package vendingMachine;

public class VendingBrain {
	
	// Initial values for vending machine traits
	private double insertedTotal = 0.00;
	private double availableChange = 10.00;
	private double availableCoinReturn = 0.00;
	private boolean powerStatus = true;
	
	
	// Choice reading method. Verifies whether an insert is valid and then acts based on this ruling.
	public void readChoice(String choiceInput){
		if(choiceInput.equals("q") || choiceInput.equals("Q")){
			//System.out.println("Quarter inserted");
			updateInsertedTotal(0.25);	
		}
		
		else if(choiceInput.equals("n") || choiceInput.equals("N")){
			//System.out.println("Nickel inserted");
			updateInsertedTotal(0.05);
		}
		
		else if(choiceInput.equals("d") || choiceInput.equals("D")){
			//System.out.println("Dime inserted");
			updateInsertedTotal(0.10);
		}
		
		else if(choiceInput.equals("p") || choiceInput.equals("P")){
			System.out.println("Sorry, pennies are not accepted because reasons");
			updateCoinReturnTotal(0.01);
		}
		
		else if(choiceInput.equals("r") || choiceInput.equals("R")){
			updateCoinReturnTotal(insertedTotal);
			insertedTotal = 0.00;
			dispenseChange(1);
		}
		
		else {
			System.out.println("Error, unrecognizable coin");
			System.out.println("Coin input was: " + choiceInput);
		}
	}
	
	public void showDisplay(){
		if (insertedTotal == 0.00){
			System.out.println("Display Reads: Insert Coins");
		}
		else {
			System.out.println("Display Reads: " + insertedTotal);
		}
		
		System.out.println("Insert coins and make a selection.");
		System.out.println("A) Cola: $1.00 B) Chips: $0.50 C) Candy: $0.65");
		System.out.println("Or return coins (R)");
	}
	
	
	//Updates the amount of money currently in machine
	public void updateInsertedTotal(Double coinValue){
		insertedTotal = insertedTotal + coinValue;
	}
	
	//Updates the amount of money expected to be returned 
	public void updateCoinReturnTotal(Double returnCoins){
		availableCoinReturn = availableCoinReturn + returnCoins;
	}
	
	//Method called to dispense change. Also checks to see if a purchase was made prior to dispensing change.
	public void dispenseChange(Integer changeType){
		if (changeType == 1){
			System.out.println("Returned coins: " + availableCoinReturn);
			availableCoinReturn = 0.00;
		}
	}
	
	public boolean stopPower(){
		powerStatus = false;
		return powerStatus;
	}
	
}
