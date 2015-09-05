package vendingMachine;

public class VendingBrain {
	
	// Initial values for vending machine traits
	private double insertedTotal = 0.00;
	private double availableChange = 5.00;
	private double availableCoinReturn = 0.00;
	private double changeDifference = 0.00;
	private int[] products = new int[3];
	private boolean powerStatus = true;
	
	//Handles user interface display
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
	
	// Choice reading method. Verifies whether an insert is valid and then acts based on this ruling.
	public void readChoice(String choiceInput){
		
		//Inserting quarters
		if(choiceInput.equals("q") || choiceInput.equals("Q")){
			updateInsertedTotal(0.25);
		}
		
		//Inserting nickels
		else if(choiceInput.equals("n") || choiceInput.equals("N")){
			updateInsertedTotal(0.05);
		}
		
		//Inserting dimes
		else if(choiceInput.equals("d") || choiceInput.equals("D")){
			updateInsertedTotal(0.10);
		}
		
		//Inserting pennies
		else if(choiceInput.equals("p") || choiceInput.equals("P")){
			System.out.println("Sorry, pennies are not accepted because reasons");
			updateCoinReturnTotal(0.01);
		}
		
		//Buying product A
		else if(choiceInput.equals("a") || choiceInput.equals("A")){
			if (checkMachine(0) != 4){
				if (insertedTotal >= 1.00){
					checkMachine(0);
					changeDifference = insertedTotal - 1.00;
					
					if (changeDifference > 0.00){
						updateAvailableChange(1, changeDifference);
					}
					else{
						updateAvailableChange(0, 1.00);
					}
					
					updateCoinReturnTotal(changeDifference);
				}
				
				else {
					System.out.println("Insufficient funds");
				}
				
				//Exact change checking
				if (availableChange < 0.00){
					availableChange = availableChange + changeDifference;
					availableCoinReturn = insertedTotal;
					System.out.println("Exact change required");
					dispenseChange();
				}
				
				else{
					dispenseChange();
				}			
			}		
		}
		
		//Buying Product B
		else if(choiceInput.equals("b") || choiceInput.equals("B")){
			if (checkMachine(1) != 4){
				if (insertedTotal >= 0.50){
					changeDifference = insertedTotal - 0.50;
					
					if (changeDifference > 0.00){
						updateAvailableChange(1, changeDifference);
					}
					else{
						updateAvailableChange(0, 0.50);
					}
					
					updateCoinReturnTotal(changeDifference);
				}
				
				else {
					System.out.println("Insufficient funds");
				}
				
				//Exact change checking
				if (availableChange < 0.00){
					availableChange = availableChange + changeDifference;
					availableCoinReturn = insertedTotal;
					System.out.println("Exact change required");
					dispenseChange();
				}
				
				else{
					dispenseChange();
				}
			}	
		}
		
		//Buying Product C
		else if(choiceInput.equals("c") || choiceInput.equals("C")){
			if (checkMachine(2) != 4) {
				if (insertedTotal >= 0.65){
					changeDifference = insertedTotal - 0.65;
					
					if (changeDifference > 0.00){
						updateAvailableChange(1, changeDifference);
					}
					else{
						updateAvailableChange(0, 0.65);
					}
					
					updateCoinReturnTotal(changeDifference);
				}
				
				else {
					System.out.println("Insufficient funds");
				}
				
				//Exact change checking
				if (availableChange < 0.00){
					availableChange = availableChange + changeDifference;
					availableCoinReturn = insertedTotal;
					System.out.println("Exact change required");
					dispenseChange();
				}
				
				else{
					dispenseChange();
				}
			}
		}
		
		//Returning Coins
		else if(choiceInput.equals("r") || choiceInput.equals("R")){
			updateCoinReturnTotal(insertedTotal);
			dispenseChange();
		}
		
		
		//Something unaccounted
		else {
			System.out.println("Error, you did something not understood by this vending machine");
		}
	}

	
	
/* Methods related to money handling
 * 
 */
	
	//Updates the amount of money currently inserted in machine
	public void updateInsertedTotal(Double coinValue){
		insertedTotal = insertedTotal + coinValue;
	}
	
	//Updates the amount of money currently available as change
	public void updateAvailableChange(Integer changeType, Double change){
		if (changeType == 0){
			availableChange = availableChange + change;
		}
		
		else {
			availableChange = availableChange - change;
		}	
	}
	
	//Updates the amount of money expected to be returned 
	public void updateCoinReturnTotal(Double returnCoins){
		availableCoinReturn = availableCoinReturn + returnCoins;
	}
	
	//Method called to dispense change.
	public void dispenseChange(){
		System.out.println("Returned coins: " + availableCoinReturn +"\n");
		availableCoinReturn = 0.00;
		insertedTotal = 0.00;
	}

	
/* Methods related to inventory handling
 * 
 */	
	
	// Stocks five of each item in the vending machine
	public void fillMachine(){
		products[0] = 5;
		products[1] = 5;
		products[2] = 5;
	}
	
	public Integer checkMachine(Integer purchase){
		if (purchase == 0 && products[0] != 0){
			products[0] = products[0] - 1;
			//System.out.println("Thank you");
			return purchase;
		}
		
		else if (purchase == 1 && products[1] != 0){
			products[1] = products[1] - 1;
			//System.out.println("Thank you");
			return purchase;
		}
		
		else if (purchase == 2 && products[2] != 0){
			products[2] = products[2] - 1;
			//System.out.println("Thank you");
			return purchase;
		}
		
		else{
			System.out.println("Sold Out");
			purchase = 4;
			return purchase;
		}
	}

	
//Additional features (Not yet implemented)
	
	// Stops the program by "shutting off" the vending machine
	public boolean stopPower(){
		powerStatus = false;
		return powerStatus;
	}
	
}
