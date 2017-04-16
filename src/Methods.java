import javax.swing.JOptionPane;

public class Methods {
double redondeo, fxr;

static double ValorExacto, VAbsoluto, ValorRedondeado, VRelativo, xr, x;



	static double array[] = MethodsMain.array;
	static double exp[]= MethodsMain.exp;


	 	 
	 static  void ValorExactoFunction(){
		 ValorExacto= (array[1]*Math.pow(x,exp[1]) + (array[2]*Math.pow(x,exp[2])) + (Math.pow(array[3],exp[3])*x));
		 JOptionPane.showMessageDialog(null, "Valor Exacto de la función es: "+ValorExacto);
	 }
	 

		static void ValorRedondeado(){
				ValorRedondeado= (array[1]*Math.pow(xr,exp[1]) + (array[2]*Math.pow(xr,exp[2])) + (Math.pow(array[3],exp[3])*xr));
				JOptionPane.showMessageDialog(null, "Valor Redondeado de la función es: "+ValorRedondeado);
		}
		
		static void ErrorAbsoluto(){
			VAbsoluto=ValorExacto-ValorRedondeado;
			JOptionPane.showMessageDialog(null, "Error Absoluto de la función es: "+VAbsoluto);
		}
		
		static void ErrorRelativo(){
			VRelativo=VAbsoluto/ValorExacto;
			JOptionPane.showMessageDialog(null, "Error Relativo de la función es: "+VRelativo);
		}
		
	 
	 
}
