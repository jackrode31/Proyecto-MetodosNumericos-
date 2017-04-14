import java.util.ArrayList;
import java.util.Arrays;

public class TaylorAproxFunc {
	private ArrayList<Double> originalFuncCoef;
	private ArrayList<Double> aproxCoef;
	private int aproxOrder;
	private double x0;
	
	public TaylorAproxFunc(int orderAprox, Double[] originalFuncCoef,double x0)
	{
		this.aproxOrder=orderAprox;
		this.originalFuncCoef=new ArrayList<Double>(Arrays.asList(originalFuncCoef));
		
	}
	
	public void genAproxCoef()
	{
		aproxCoef.clear();
		for(int i =0;i<=aproxOrder;i++)
		{
			if(i==0)
			{
				aproxCoef.add(getEvalOriginalFunc(x0));
			}
			else
			{
				
			}
			
		}
	}
	public double getEvalOriginalFunc(double x)
	{ 
		double eval=0;
		for(int i= 0;i<=aproxCoef.size();i++)
			eval = Math.pow(x,i)*aproxCoef.get(i);	
		
		return eval;
	}
	
	public double getX0() {
		return x0;
	}
	public void setX0(double x0) {
		this.x0 = x0;
	}
	public int getOrderAprox() {
		return aproxOrder;
	}
	public void setOrderAprox(int orderAprox) {
		this.aproxOrder = orderAprox;
	}
	public ArrayList<Double> getOriginalFuncCoef() {
		return originalFuncCoef;
	}
	public void setOriginalFuncCoef(ArrayList<Double> originalFuncCoef) {
		this.originalFuncCoef = originalFuncCoef;
	}
	

}
