
import java.util.ArrayList;


public class PolinomialFunc {
	private ArrayList<Double> coef;
	

	
	
	public PolinomialFunc(ArrayList<Double> coef )
	{
		this.coef = new ArrayList<Double>(coef);
	}
	public PolinomialFunc(ArrayList<Double> coef,String name )
	{
		this.coef = new ArrayList<Double>(coef);

	}
	
	public ArrayList<Double> getCoef() {
		return coef;
	}
	public void setCoef(ArrayList<Double> coef) {
		this.coef = coef;
	}
	public PolinomialFunc Derivate()
	{
		ArrayList<Double> derivative_coef = new ArrayList<Double>();
		for(int i=1;i<coef.size();i++)
		{
			derivative_coef.add(coef.get(i)*i);
		}
		return new PolinomialFunc(derivative_coef);
	}
	public double evaluate(double x)
	{
		double evaluation=0;
		for(int n = 0; n<coef.size();n++)
		{
			evaluation += Math.pow(x,n)*coef.get(n);
			
		}

		return evaluation;
	}
	
}
