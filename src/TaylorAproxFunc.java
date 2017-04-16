import java.util.ArrayList;
import java.util.Arrays;

public class TaylorAproxFunc {
	
	public static double evalOrigin(double a0,double a1, double a2, double a3,double x0)
	{
		return a0+a1*x0+a2*Math.pow(x0,2)+a3*Math.pow(x0, 3);
	}
	
	public static double evalD1(double a1, double a2, double a3,double x0)
	{
		return a1+2*a2*x0+3*a3*Math.pow(x0, 2);
	}
	
	public static double evalD2(double a2, double a3,double x0)
	{
		return 2*a2+6*a3*x0;
	}
	
	public static double evalD3(double a3)
	{
		return 6*a3;
	}
	
	public static double[]  taylorAprox(double tolerance,double[] derivada,double x,double x0)
	{
		ArrayList<Double> term = new ArrayList<Double>();
		double errorLastTerm=0;
		int n=0;
				do
				{
					double nterm = derivada[n]*Math.pow(x-x0, n)/factorial(n);
					term.add(nterm);
					if(n<4)
					{
						errorLastTerm = derivada[n+1]*Math.pow(x-x0, n+1)/factorial(n+1);
					}
					else
					{
						errorLastTerm=0;
					}
				}while(errorLastTerm>tolerance);
		double aprox=0;
		for(int i = 0; i<term.size();i++)
		{
			aprox = aprox+term.get(i);
		}
		return new double[]{aprox,errorLastTerm};
	}
	
	public static int factorial (int numero) {
		  if (numero==0)
			    return 1;
			  else
			    return numero * factorial(numero-1);
			}
}
