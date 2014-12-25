
import java.util.Scanner;

public class PolyTest {

	public static void main(String[] args){
		
		Boolean again = true;
	
		System.out.println("=============================");
		System.out.println("Simple Polynomial Calculator");
		System.out.println("=============================");
		
		while (again){
		
		System.out.println("------------MENU------------- ");
		System.out.println("Please enter what you want:");

		System.out.println(" i for input");
		System.out.println(" a for add");
		System.out.println(" s for subtract");
		System.out.println(" m for multiply");
		System.out.println(" d for divide");
		System.out.println(" e for evaluate");
		System.out.println(" p for print");
		System.out.println(" q for quit");
		System.out.println("------------------------------");
		
		Scanner in = new Scanner(System.in);
		String choice = in.nextLine();
		if(choice.equalsIgnoreCase("i")){
			
			System.out.println("input: enter index number of "
					+ "polynomial and number of terms");
			
			int indexNum = in.nextInt();
			int numOfTerms = in.nextInt();
			PolyComputations.constructList(indexNum,numOfTerms);
			
			if(PolyComputations.anotherOperation()){
				again = true;
			}
			else{
				again = false;
			}
		}
		
		if(choice.equalsIgnoreCase("a")){
			System.out.println("Enter the indices of the polynomials "
					+ "you would like to add:");
			int index1 = in.nextInt();
			int index2 = in.nextInt();
			System.out.println("Enter the index of the polyArray where"
					+ "you want to store the sum:");
			int index3 = in.nextInt();
			PolyComputations.addPoly(index1, index2, index3);
			
			if(PolyComputations.anotherOperation()){
				again = true;
			}
			else{
				again = false;
			}
		}
			
		if(choice.equalsIgnoreCase("s")){
			
			System.out.println("Enter the indices of the polynomials "
					+ "you would like to subtract (first minus the second):");
			int index1 = in.nextInt();
			int index2 = in.nextInt();
			System.out.println("Enter the index of the polyArray where"
					+ "you want to store the difference:");
			int index3 = in.nextInt();
			PolyComputations.subtractPoly(index1, index2, index3);
			
			if(PolyComputations.anotherOperation()){
				again = true;
			}
			else{
				again = false;
			}
			
		}
		
		if(choice.equalsIgnoreCase("m")){
			
			System.out.println("Enter the indices of the polynomials "
					+ "you would like to multiply:");
			int index1 = in.nextInt();
			int index2 = in.nextInt();
			System.out.println("Enter the index of the polyArray where"
					+ " you want to store the product:");
			int index3 = in.nextInt();
			PolyComputations.multiPoly(index1, index2, index3);
			
			if(PolyComputations.anotherOperation()){
				again = true;
			}
			else{
				again = false;
			}
			
		}
		
		if(choice.equalsIgnoreCase("d")){
			
			System.out.println("Enter the indices of the polynomials "
					+ "you would like to divide (first divided by second):");
			int index1 = in.nextInt();
			int index2 = in.nextInt();
			System.out.println("Enter the index of the polyArray where"
					+ " you want to store the quotient:");
			int index3 = in.nextInt();
			System.out.println("Enter the index of the polyArray where"
					+ " you want to store the remainder:");
			int index4 = in.nextInt();
			PolyComputations.dividePoly(index1, index2, index3, index4);
			
			if(PolyComputations.anotherOperation()){
				again = true;
			}
			else{
				again = false;
			}
			
		}
		if(choice.equalsIgnoreCase("e")){
			
			int indexPoly;
			double varValue;
			double result;
			
			System.out.println("How many polynomials would you "
					+ "like to evaluate?");
			int num = in.nextInt();
			
			for(int i = 0; i < num; i++){
				System.out.println("Enter the index of # " + (i+1) + 
						" polynomial you wish to evaluate and"
						+ " the variable value: (e.g. 2 4.1");
				indexPoly = in.nextInt();
				varValue = in.nextDouble();
				
				result = PolyComputations.evalPoly(indexPoly,varValue);
				System.out.println("Result is: " + result);
			}
			
			if(PolyComputations.anotherOperation()){
				again = true;
			}
			else{
				again = false;
			}
		}
		
		if(choice.equalsIgnoreCase("p")){
			
			int indexPoly;
			String polyString;
			
			System.out.println("How many polynomials would you "
					+ "like to print?");
			int num = in.nextInt();
			
			for(int i = 0; i < num; i++){
				System.out.println("Enter the index of # " + (i+1) + 
						" polynomial you wish to print: ");
				indexPoly = in.nextInt();
				polyString = PolyComputations.print(indexPoly);
				System.out.println(polyString);
			}
			
			if(PolyComputations.anotherOperation()){
				again = true;
			}
			else{
				again = false;
			}
		}
		
		if(choice.equalsIgnoreCase("q")){
			System.out.println("Program terminated.");
			System.exit(0);
			
		}
		
		else if(!choice.equalsIgnoreCase("i")&&!choice.equalsIgnoreCase("a")
				&&!choice.equalsIgnoreCase("s")&&!choice.equalsIgnoreCase("m")
				&&!choice.equalsIgnoreCase("d")&&!choice.equalsIgnoreCase("e")
				&&!choice.equalsIgnoreCase("p")&&!choice.equalsIgnoreCase("q")){
			System.out.println("Invalid choice.");
			if(PolyComputations.anotherOperation()){
				again = true;
			}
			else{
				again = false;
			}
		}
	}
	}
}
