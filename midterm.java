import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {
	public static void main(String[] args){
		/*
		 * The winning and lost values are kept in the myArrayList. The lost values are added as negataive number in the arrayList.
		 * When the user enters 0, we iterate over the arrayList and if any value is -ve, we know that the user had lost that amount. Else they have won that amount.
		 * At first the answer is true, because we don't know how much the user will play. The answer is false when the user enters 0.
		 * We generate a randomNumber between 1 to 12 to calculate the sum of two dices rolled.
		 * totalWinningAmount stores the overall winning/lossing of a user.
		 */
		ArrayList<Integer> myArrayList = new ArrayList<Integer>();
		Random rand = new Random();
		int totalWinningAmount = 0;		
		boolean answer = true;
		while(answer){
			int  randomNumber = rand.nextInt(12) + 1; //stores the random number
			Scanner input = new Scanner(System.in);
			int inputAmount;
			System.out.println();
			System.out.print("How much would you like to bet? ");
			inputAmount = input.nextInt(); //takes the input for the user
			if(inputAmount == 0){
				answer=false; //if the user enters 0, we exit the loop.
			}
			else if(randomNumber==7 || randomNumber == 11){
				System.out.println("You rolled " + randomNumber);
				System.out.println("You win! $"+ inputAmount+" was added to your pot");
				myArrayList.add(inputAmount); //add winning amount to the arrayList

			}
			else if(randomNumber == 2 || randomNumber == 3 || randomNumber == 12){
				System.out.println("You rolled " + randomNumber);
				System.out.println("You lose! $"+inputAmount+" subtracted from your pot.");
				myArrayList.add(-inputAmount); //add lost amount to the arrayList with a -ve sign.
			}
			else{
				System.out.println("You rolled " + randomNumber +". POINT is "+ randomNumber + ".");
				boolean insideAnswer=true;			
				/*
				 * This loop iterates till the randomNumber is equal to the sum of the dices or is a 7.
				 */
				while(insideAnswer){					
					int  pointNumber = rand.nextInt(12) + 1; //generate the random number again.
					if(pointNumber == randomNumber){
						System.out.println("You rolled "+pointNumber);
						insideAnswer = false;
						myArrayList.add(inputAmount); //add winning amount to arrayList.
						System.out.println("You win! $"+ inputAmount+" was added to your pot");
						
					}
					else if(pointNumber == 7){
						System.out.println("You rolled "+pointNumber);
						insideAnswer = false;
						myArrayList.add(-inputAmount); //add lost amount with a -ve sign to arrayList.
						System.out.println("You lose! $"+inputAmount+" subtracted from your pot.");
						
					}
					else{
						System.out.println("You rolled " + pointNumber +". POINT is "+ randomNumber + ".");
					}
				}
			}
		}
		System.out.println();
		/*
		 * Iterating over the arrayList. If the value is +ve, it is the won value.
		 * If the value is -ve, it is the lost value.
		 * We add all the values to get the net value won or lost by the user.
		 */
		for(int i = 0; i<myArrayList.size();i++){
			int items = myArrayList.get(i);
			if(items > 0){
				
				System.out.println("You won $" + items);
				
			}
			else{
				System.out.println("You lost $" + Math.abs(items));
			}
			totalWinningAmount+=items;
			System.out.println();
		}
		/*
		 * if totalWinningAmount is +ve, the user is ahead, else the user is behind
		 */
		if(totalWinningAmount >= 0){
			System.out.println("You are ahead $"+ totalWinningAmount);
		}
		else{
			System.out.println("You are behind $"+ totalWinningAmount);
		}
	}
}
