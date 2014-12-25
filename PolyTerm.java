// PolyTerms as Nodes of the LinkedList
	
public class PolyTerm {

	private double coef;
	private int exponent;
	protected PolyTerm next;
	protected PolyTerm newTerm;
	protected PolyTerm header;
	private double newCoef;
	private int newExp;
	private double currentCoef;
	private int currentExp;
	
	
	PolyTerm(){
		coef = 0.0;
		exponent = 0;
		next = null;
	
	}
	
	PolyTerm(double c, int e, PolyTerm n){
		coef = c;
		exponent = e;
		next = n;
	}
	
	public void setPolyTerm(double c, int e){
		coef = c;
		exponent = e;
	}
	
	public int getExponent(){
		return exponent;
	}
	
	public double getCoef(){
		return coef;
	}
	
public PolyTerm multiply(PolyTerm p){
		
		newTerm = p;
		double productCoef;
		int productExp;
		
		newCoef = newTerm.getCoef();
		currentCoef = this.getCoef();
		newExp = newTerm.getExponent();
		currentExp = this.getExponent();
				
		productCoef = newCoef * currentCoef;
		productExp = newExp + currentExp;
				
		PolyTerm productTerm = new PolyTerm(productCoef,productExp,null);
		System.out.println("Product term is: " + productTerm.toString());
		
		return productTerm;
	}

public PolyTerm divide(PolyTerm p){
	
	newTerm = p;
	double diviCoef;
	int diviExp;
	
	newCoef = newTerm.getCoef();
	currentCoef = this.getCoef();
	newExp = newTerm.getExponent();
	currentExp = this.getExponent();
			
	diviCoef = currentCoef / newCoef;
	diviExp = currentExp - newExp;
			
	PolyTerm diviTerm = new PolyTerm(diviCoef,diviExp,null);
	System.out.println("Quotient term is: " + diviTerm.toString());
	
	return diviTerm;
	}

	public String toString(){
		return coef + "x^" + exponent;
	}

	
}