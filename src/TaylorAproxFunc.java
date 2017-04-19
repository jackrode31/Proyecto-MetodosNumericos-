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
	
	
	/*public static void main(String args[]) throws IOException
	{
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		double a,b,c,d;
		a=Double.parseDouble(rd.readLine());
		b=Double.parseDouble(rd.readLine());
		c=Double.parseDouble(rd.readLine());
		d=Double.parseDouble(rd.readLine());
		PolinomialFunc pol = new PolinomialFunc(new ArrayList<Double>(Arrays.asList(a,b,c,d)));
		TaylorAproxFunc aprox = new TaylorAproxFunc();
		aprox.func=pol;
		System.out.println(aprox.aprox(1.0,1.0)[0]);

		ArrayList<Double> arr=pol1.getCoef();
		for (int i =0;i<arr.size();i++)
		{
			System.out.println(arr.get(i));
		}
		
	}
	*/
	
	
	public static double taylorCoef(int n,double x0Evaluation)
	{
		return x0Evaluation/(double)factorial(n);
	}
	
	
	
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
	public static double[] evalAll(double a0,double a1, double a2, double a3,double x0)
	{
		
		return new double[]{
				evalOrigin(a0,a1,a2,a3,x0),
				evalD1(a1,a2,a3,x0),
				evalD2(a2,a3,x0),
				evalD3(a3)
				};
	}
	public static double[]  taylorAprox(double tolerance,double[] coef,double x,double x0)
	{
		double derivada[]=evalAll(coef[0], coef[1], coef[2], coef[3],x0);
		ArrayList<Double> term = new ArrayList<Double>();
		double errorLastTerm=0;
		int n=0;
				do
				{
					double nterm = derivada[n]*Math.pow(x-x0, n)/factorial(n);
					term.add(nterm);
					if(n<3)
					{
						errorLastTerm = derivada[n+1]*Math.pow(x-x0, n+1)/factorial(n+1);
					}
					else
					{
						errorLastTerm=0;
					}
					n++;
				}while(errorLastTerm>tolerance);
		double aprox=0;
		for(int i = 0; i<term.size();i++)
		{
			aprox = aprox+term.get(i);
		}
		double valorExacto=evalOrigin(coef[0], coef[1], coef[2], coef[3],x);
		double errorAbso = Math.abs(valorExacto-aprox);
		double errorRel = Math.abs(errorAbso/valorExacto);
		return new double[]{aprox,errorLastTerm,valorExacto,errorAbso,errorRel};
	}
	
	public static int factorial (int numero) {
		  if (numero==0)
			    return 1;
			  else
			    return numero * factorial(numero-1);
			}
	
	
	
}
