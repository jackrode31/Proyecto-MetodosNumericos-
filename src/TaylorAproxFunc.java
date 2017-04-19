import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class TaylorAproxFunc {
	public PolinomialFunc func;
	public ArrayList<PolinomialFunc> derivative=new ArrayList<PolinomialFunc>();
	
	public double[] aprox(Double x, Double x0)
	{
		double aproximation = 0;
		double errLast = 0;
		int i = 0;
		do
		{
			if(i ==0)
			{
				double x0Evaluation = func.evaluate(x0);
				derivative.add(func.Derivate());
				errLast=taylorCoef(i,derivative.get(i).evaluate(x0))*Math.pow(x-x0, i+1);
				aproximation += x0Evaluation;
			}
			else
			{
				aproximation +=errLast;
				derivative.add(derivative.get(i-1).Derivate());
				errLast=taylorCoef(i+1,derivative.get(i).evaluate(x0))*Math.pow(x-x0, i+1);
			}
			i++;
			
		}while(errLast>0.0001);
		double valorExacto=func.evaluate(x);
		double errorAbso = Math.abs(valorExacto-aproximation);
		double errorRel = Math.abs(errorAbso/valorExacto);
		return new double[]{aproximation,errLast,valorExacto,errorAbso,errorRel};

	}
	
	
	public static double taylorCoef(int n,double x0Evaluation)
	{
		return x0Evaluation/(double)factorial(n);
	}
	
	
	public static int factorial (int numero) {
		  if (numero==0)
			    return 1;
			  else
			    return numero * factorial(numero-1);
			}
	
	
	
}
