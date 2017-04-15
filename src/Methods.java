
public class Methods {
double redondeo, fxr, ValorExacto, x;
double array[] = new double [4];




	public double redondeo (double redondeo){
		 redondeo=fxr-redondeo;
		 return redondeo;
	 }
	 public double ErrorTruncamiento (double truncamiento){
		 return truncamiento;
	 }
	 
	 
	 public void setPolinomio(double[] array){
			this.array=array;
		}

	 public void ValorExactoFunction(){
		 ValorExacto= (x*array[0])+ (x*Math.pow(array[1], 2))+(x*Math.pow(array[3], 3)); 
	 }
	 
	 
}
