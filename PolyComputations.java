
import java.util.Scanner;
import java.lang.Math;

public class PolyComputations {
	
	private static int index;
	private static int numOfTerms;
	private static final int MAX_POLYS = 10;
	private static int index1;
	private static int index2;
	private static int index3;
	private static Polynomial[] polyList = new Polynomial[MAX_POLYS];
	
	public static void constructList(int ind, int num){
		index = ind;
		numOfTerms = num;
		
		Polynomial polynomial = new Polynomial(numOfTerms);
		
		Scanner in = new Scanner(System.in);
		for(int i = 0; i < numOfTerms; i++){
			System.out.println("Enter coef and exponent for term " + (i+1));
			double coef = in.nextDouble();
			int exp = in.nextInt();
			PolyTerm poly = new PolyTerm(coef, exp, null);
			polynomial.insertInOrder(poly);
		}
		
		polyList[index] = polynomial;
		
		System.out.println("Polynomial is now: " + polynomial.toString());
	}
		
	public static Polynomial getPolynomialAt(int n){
		Polynomial polynomial;
		int index = n;
		
		polynomial = polyList[index];
		return polynomial;
	}
	
	public static Boolean hasPoly(int num1, int num2){
		int in1 = num1;
		int in2 = num2;
		Boolean hasPoly;
		
		Polynomial poly1 = getPolynomialAt(in1);
		Polynomial poly2 = getPolynomialAt(in2);
		
		if(poly1!=null && poly2!=null){
			hasPoly = true;
		}
		else{
			hasPoly = false;
		}
		
		return hasPoly;
	}
	
	public static void addPoly(int num1, int num2, int num3){
	
		index1 = num1;
		index2 = num2;
		index3 = num3;
		
		if(!hasPoly(index1, index2)){
			System.out.println("----------------ERROR----------------------");
			System.out.println("Please check that you have stored"
					+ " polynomials");
			System.out.println("at indices " + index1 + " and " + index2);
			System.out.println("Or that the indices you entered are correct.");
		}

		else{
			Polynomial poly1 = getPolynomialAt(index1);
			Polynomial poly2 = getPolynomialAt(index2);	
			Polynomial polyResult = new Polynomial();

			
			PolyTerm[] poly1Terms = poly1.getAllTerms();
			int numOfPoly1Terms = poly1.getNumOfTerms();
			
			double termCoef;
			int termExp;
			
			for (int j = 0; j < numOfPoly1Terms;j++){
				termCoef = poly1Terms[j].getCoef();
				termExp = poly1Terms[j].getExponent();
				PolyTerm term = new PolyTerm(termCoef,termExp,null);
				polyResult.insertInOrder(term);

			}	

			PolyTerm[] poly2Terms = poly2.getAllTerms();
			int numOfPoly2Terms = poly2.getNumOfTerms();
			
			for (int k = 0; k < numOfPoly2Terms;k++){
				termCoef = poly2Terms[k].getCoef();
				termExp = poly2Terms[k].getExponent();
				PolyTerm term = new PolyTerm(termCoef,termExp,null);
				polyResult.insertInOrder(term);
			}	
		
			polyList[index3] = polyResult;
			System.out.println("Resultant polynomial added at index " + index3 
					+ ": " + polyList[index3].toString());
			
		}
	}
	
	public static void subtractPoly(int num1, int num2, int num3){
		
		index1 = num1;
		index2 = num2;
		index3 = num3;
		
		if(!hasPoly(index1, index2)){
			System.out.println("----------------ERROR----------------------");
			System.out.println("Please check that you have stored"
					+ " polynomials");
			System.out.println("at indices " + index1 + " and " + index2);
			System.out.println("Or that the indices you entered are correct.");
		}
		else{
			
			Polynomial poly1 = polyList[index1];
			Polynomial poly2 = polyList[index2];	
			Polynomial polyResult = new Polynomial();
			
			// Retrieving all poly1 terms from the array
			
			PolyTerm[] poly1Terms = poly1.getAllTerms();
			int numOfPoly1Terms = poly1.getNumOfTerms();
			
			// Inserting terms from poly1 into polyResult
			
			double termCoef;
			int termExp;
			
			for (int j = 0; j < numOfPoly1Terms;j++){
				termCoef = poly1Terms[j].getCoef();
				termExp = poly1Terms[j].getExponent();	
				PolyTerm term = new PolyTerm(termCoef,termExp,null);
				polyResult.insertInOrder(term);
			}	
			
			// Retrieving poly2 terms from array
			
			PolyTerm[] poly2TermsNeg = poly2.getAllTermsNeg();
			int numOfPoly2Terms = poly2.getNumOfTerms();
			
			// Inserting terms from poly1 into polyResult
			
			for (int k = 0; k < numOfPoly2Terms;k++){
				termCoef = poly2TermsNeg[k].getCoef();
				termExp = poly2TermsNeg[k].getExponent();
				PolyTerm term = new PolyTerm(termCoef,termExp,null);
				polyResult.insertInOrder(term);
			}	
			polyList[index3] = polyResult;
			System.out.println("Resultant polynomial added at index " + index3 
					+ ": " + polyList[index3].toString());
			
		}
	}
	
	public static void multiPoly(int num1, int num2, int num3){
		

		int index1 = num1;
		int index2 = num2;
		int index3 = num3;
		
		if(!hasPoly(index1, index2)){
			System.out.println("----------------ERROR----------------------");
			System.out.println("Please check that you have stored"
					+ " polynomials");
			System.out.println("at indices " + index1 + " and " + index2);
			System.out.println("Or that the indices you entered are correct.");
		}

		else{
			
			Polynomial poly1 = polyList[index1];
			Polynomial poly2 = polyList[index2];	
			Polynomial polyResult = new Polynomial();
			
			// Retrieving all poly1 and poly2 terms from the array2
			
			PolyTerm[] poly1Terms = poly1.getAllTerms();
			int numOfPoly1Terms = poly1.getNumOfTerms();
			
			PolyTerm[] poly2Terms = poly2.getAllTerms();
			int numOfPoly2Terms = poly2.getNumOfTerms();
			
			double termCoef;
			int termExp;
			
			for (int j = 0; j < numOfPoly1Terms;j++){
				termCoef = poly1Terms[j].getCoef();
				termExp = poly1Terms[j].getExponent();	
				PolyTerm term1 = new PolyTerm(termCoef,termExp,null);
				
				// Multiplying result by terms from poly2
				
				for (int k = 0; k < numOfPoly2Terms;k++){
					
					termCoef = poly2Terms[k].getCoef();
					termExp = poly2Terms[k].getExponent();
					PolyTerm term2 = new PolyTerm(termCoef,termExp,null);
					
					PolyTerm productTerm = term2.multiply(term1);
					polyResult.insertInOrder(productTerm);
				}
			}	
		
			polyList[index3] = polyResult;
			System.out.println("Result stored in index " + index3 + " is: " + polyList[index3].toString());
		}
	}
	
	public static void dividePoly(int num1, int num2, int num3, int num4){
		
		int index1 = num1;
		int index2 = num2;
		int index3 = num3;
		int index4 = num4;
		
		if(!hasPoly(index1, index2)){
			System.out.println("----------------ERROR----------------------");
			System.out.println("Please check that you have stored"
					+ " polynomials");
			System.out.println("at indices " + index1 + " and " + index2);
			System.out.println("Or that the indices you entered are correct.");
		}
		else{
			
			Polynomial poly1 = polyList[index1];
			Polynomial poly2 = polyList[index2];
			Polynomial polyResult = new Polynomial();
			Polynomial polyRemainder = new Polynomial();
			
			PolyTerm[] poly1Terms = poly1.getAllTerms();

			// Dividend changes with each division - but storing initial value
			double termCoef = poly1Terms[0].getCoef();
			int termExp = poly1Terms[0].getExponent();
			PolyTerm changingDividendFirstTerm = 
					new PolyTerm(termCoef,termExp,null);
			
			PolyTerm[] poly2Terms = poly2.getAllTerms();
			int numOfPoly2Terms = poly2.getNumOfTerms();
			
			// Storing unchanging value of first term of divisor
			termCoef = poly2Terms[0].getCoef();
			termExp = poly2Terms[0].getExponent();	
			PolyTerm divisorFirstTerm = new PolyTerm(termCoef,termExp,null);
			
			// initial values of intermed results - original dividend
			
			PolyTerm[] intermedResultTerms = poly1.getAllTerms();
			int numOfIntermedResultTerms = poly1.getNumOfTerms();
			
			// intermed result polynomial - changes with each iteration
			Polynomial intermedResult = new Polynomial(); 
			
			// Inserting original poly1 values
			for (int k = 0; k < numOfIntermedResultTerms; k++){
				termCoef = intermedResultTerms[k].getCoef();
				termExp = intermedResultTerms[k].getExponent();
				PolyTerm term = new PolyTerm(termCoef,termExp,null);
				intermedResult.insertInOrder(term);
			}
			
			while(changingDividendFirstTerm.getExponent() >= divisorFirstTerm.getExponent()){
				
				Polynomial intermedProduct = new Polynomial();
				PolyTerm diviTerm = changingDividendFirstTerm.divide(divisorFirstTerm);
				
				// inserting this term into quotient result polynomial
				polyResult.insertInOrder(diviTerm);
				
				// Building the polynomial of intermed product
				for (int j = 0; j < numOfPoly2Terms; j++){
					PolyTerm productTerm = diviTerm.multiply(poly2Terms[j]);
					intermedProduct.insertInOrder(productTerm);
				}
				
				// Building the intermed result : poly1 - intermedProduct
				// by using neg terms of intermed product polynomial
				// subtracting the product terms
				PolyTerm[] intermedProductTermsNeg = intermedProduct.getAllTermsNeg();
				int numOfIntermedProductTerms = intermedProduct.getNumOfTerms();
				
				for (int m = 0; m < numOfIntermedProductTerms; m++){
					termCoef = intermedProductTermsNeg[m].getCoef();
					termExp = intermedProductTermsNeg[m].getExponent();
					PolyTerm intermedProductTermNeg = new PolyTerm(termCoef,termExp,null);
					intermedResult.insertInOrder(intermedProductTermNeg);
				}
				
				intermedResultTerms = intermedResult.getAllTerms();
				
				// Updating value of first term of dividend to the result
				// Bypassing all the zero values in the intermed Results
				int a = 0;
				termCoef = intermedResultTerms[a].getCoef();
				
				while(termCoef == 0 && a < numOfIntermedResultTerms){
					termCoef = intermedResultTerms[a].getCoef();
					termExp = intermedResultTerms[a].getExponent();
					a++;
				}
				
				changingDividendFirstTerm.setPolyTerm(termCoef, termExp);
			}
				
			//Final results
			PolyTerm[] polyRemainderTerms = intermedResult.getAllTerms();
			int numOfPolyRemainderTerms = intermedResult.getNumOfTerms();
			
			// Inserting remainder terms into remainder polynomial
			for(int i = 0; i < numOfPolyRemainderTerms; i++){
				polyRemainder.insertInOrder(polyRemainderTerms[i]);
			}
			
			polyList[index3] = polyResult;
			polyList[index4] = polyRemainder;
			
			System.out.println("Quotient stored in index " + index3 + 
					" is: " + polyList[index3].toString());
			System.out.println("Remainder stored in index " + index4 +
					" is: " + polyList[index4].toString());
		}
		
		
	}
	
	public static double evalPoly(int num, double xValue){

		double result = 0;
		int index = num;
		double varValue = xValue;
		double termCoef;
		int termExp;
		double varToPower;
	
		Polynomial poly1 = polyList[index];
		if(poly1==null){
			System.out.println("----------------ERROR----------------------");
			System.out.println("Please check that you have entered"
					+ " a polynomial at index " + index);
		}
		else{
			
			PolyTerm[] poly1Terms = poly1.getAllTerms();
			int numOfPoly1Terms = poly1.getNumOfTerms();
			
			for (int i = 0; i < numOfPoly1Terms; i++){
				termCoef = poly1Terms[i].getCoef();
				termExp = poly1Terms[i].getExponent();	
				varToPower = Math.pow(varValue,termExp);
				result += termCoef * varToPower;
			}
		}
		return result;
	}
	
	
	public static String print(int index){
		
		int indexPoly = index;
		String polyString = "";
		
		Polynomial currentPoly = polyList[indexPoly];
		
		if(currentPoly==null){
			System.out.println("There is no polynomial stored at that index.");
		}
		else{
			polyString = currentPoly.toString();
		}
		
		return polyString;
	}
	
	public static Boolean anotherOperation(){
		
		Boolean anotherOp = false;
		Boolean invalidResponse = true;
		
		System.out.println("--------------------------------------------");
		System.out.println("Would you like to perform another operation?");
		System.out.println("Enter Y or N");
		Scanner input = new Scanner(System.in);
		
		while(invalidResponse){
			String response = input.nextLine();
			if (response.equalsIgnoreCase("Y")){
				invalidResponse = false;
				anotherOp = true;
			}
			else if (response.equalsIgnoreCase("N")){
				invalidResponse = false;
				anotherOp = false;
			}
			else{
				System.out.println("Invalid response. Please enter again (Y/N)");
			}
			
		}
		return anotherOp;
	}
}
