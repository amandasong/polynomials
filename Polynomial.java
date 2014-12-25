
public class Polynomial {
	
	private int numOfTerms;
	private PolyTerm list;
	private PolyTerm newTerm;
	private int currentExp;
	private int newExp;
	private double currentCoef;
	private double newCoef;
	private double sumCoef;
	private double negCoef;
	private int termCounter;
	
	public Polynomial(){
		list = null;
	}
	
	public Polynomial(int num){
		list = null;
		numOfTerms = num;
	}
	
	public PolyTerm[] getAllTerms(){
		
		PolyTerm[] termArray = new PolyTerm[10];
		PolyTerm current;
		current = list;
		
		int i = 0; // i is index to add polyterm at
		termCounter = 0;
		
		while(current!=null){
			termArray[i] = current;
			current = current.next;
			termCounter++;
			i++;
		}
		
		return termArray;
		
	}
	
	public PolyTerm[] getAllTermsNeg(){
		
		PolyTerm[] termArrayNeg = new PolyTerm[10];
		PolyTerm current;
		current = list;
		
		int i = 0; // i is index to add polyterm at
		termCounter = 0;
		
		while(current!=null){
			
			currentCoef = current.getCoef();
			currentExp = current.getExponent();
			negCoef = -currentCoef;
		    PolyTerm newCurrent = new PolyTerm(negCoef,currentExp,null);
			
			termArrayNeg[i] = newCurrent;
			current = current.next;
			termCounter++;
			i++;
		}
		
		return termArrayNeg;
		
	}
	
	public int getNumOfTerms(){
		return termCounter;
	}
	
	
	public void insertInOrder(PolyTerm p){
		
		newTerm = p;
		
		PolyTerm current;
		PolyTerm previous;
		Boolean termInserted = false;
		
		if(list == null){
			list = newTerm;
		}
		else{
			previous = null;
			current = list;
			
			while(termInserted==false && current!=null){
				
				// comparing exponents of existing terms and incoming term
				newExp = newTerm.getExponent();
				currentExp = current.getExponent();
				newCoef = newTerm.getCoef();
				currentCoef = current.getCoef();
						
				if(newExp > currentExp && previous == null){
					list = newTerm;
					newTerm.next = current;
					termInserted = true;
					break;
				}
				
				if(newExp > currentExp && previous!=null){
					previous.next = newTerm;
					newTerm.next = current;
					termInserted = true;
					break;
				}
				if (newExp == currentExp){
					sumCoef = newCoef + currentCoef;
					current.setPolyTerm(sumCoef, currentExp);
					termInserted = true;
					break;
				}
				
			
				if(newExp < currentExp && current!=null){
					previous = current;  // traversing the linked list
					current = current.next;	
				}
				
			}
			
			if (termInserted == false && current == null){
				current = newTerm; // adding term at end
				previous.next = current;
			}			
		}
	}
	
	
	
	
	public String toString(){
		String result = "";
		PolyTerm current;
		current = list;
		
		while(current!=null){
			if(current.next!=null){
				result += "(" + current.toString() + ")"+ " + ";
			}
			else{ // concatenating last term
				result += "(" + current.toString() + ")";
			}
			current = current.next;
		}
		return result;
	}
}
