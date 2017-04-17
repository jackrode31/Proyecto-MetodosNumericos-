import java.util.ArrayList;

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
