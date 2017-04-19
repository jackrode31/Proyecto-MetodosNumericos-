import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class PolinomialFunc {
	private ArrayList<Double> coef;
	public ArrayList<Double> getCoef() {
		return coef;
	}
	public void setCoef(ArrayList<Double> coef) {
		this.coef = coef;
	}

	private String name;
	
	public PolinomialFunc(ArrayList<Double> coef )
	{
		this.coef = new ArrayList<Double>(coef);
	}
	public PolinomialFunc(ArrayList<Double> coef,String name )
	{
		this.coef = new ArrayList<Double>(coef);
		this.name = name;
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

	public static void main(String args[]) throws IOException
	{
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		double a,b,c,d;
		a=Double.parseDouble(rd.readLine());
		b=Double.parseDouble(rd.readLine());
		c=Double.parseDouble(rd.readLine());
		d=Double.parseDouble(rd.readLine());
		PolinomialFunc pol = new PolinomialFunc(new ArrayList<Double>(Arrays.asList(a,b,c,d)));
		PolinomialFunc pol1 = pol.Derivate();
		ArrayList<Double> arr=pol1.getCoef();
		for (int i =0;i<arr.size();i++)
		{
			System.out.println(arr.get(i));
		}
	}
}
