import javax.swing.JOptionPane;
import java.io.IOException;

public class MethodsMain {
static String a;
static int b;
static boolean sunnyday=true;
static boolean pepe=true;
static double h, x, xr, VAbsoluto, ValorRedondeado, VRelativo;
static double ValorExacto; 
static double array[]=new double [4];
static double exp[]=new double[4];


		public static void main(String[] args)throws IOException  {
		
do{		
	
		
try{
	b=Integer.parseInt(MenuPrincipal());
	}
catch(NumberFormatException e)
{
	JOptionPane.showMessageDialog(null, "you should to fuck your fucking fucked fuck. Ohh crap");
	continue;
}
	switch(b)
	{
		case 1:
		{
			Doc.main(args); /*clase doc con la hoja de presentacion*/
			JOptionPane.showMessageDialog(null, "Hasta Luego");
			System.exit(0);
		}
	
		
		
		case 2: 
			{	
		do
		{
			resetpepe();
			try
			{
				b=Integer.parseInt(ErrorRedondeoMenu());
			}
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "Error, introduzca una de las opciones.");
				pepe=true;	
			}
		}while(pepe == true);
			
				switch(b)
				{
					case 1: System.exit(0);
					case 2:
					{
						ErrorRedondeo();
						System.exit(0);	
					}
					case 3: continue;
					default: JOptionPane.showMessageDialog(null, "Opción Invalida.");
				}
			}
		
		
		case 3: 
			{
				do{
			resetpepe();
				try
				{
					for(int i=1;i<=3;i++)
					{
						array[i]=Double.parseDouble(JOptionPane.showInputDialog(null, "ingrese el termino "+ i+" del polinomio"));
						exp[i]=Double.parseDouble(JOptionPane.showInputDialog(null, "ingrese el exponente del termino "+i));
					}
					
					x= Double.parseDouble(JOptionPane.showInputDialog(null,"Inserte el valor de X"));
					xr= Double.parseDouble(JOptionPane.showInputDialog(null,"Inserte el valor de X redondeado"));//prueba
				
					
				}
				catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, "Error, no ha introducido un numero.");
					pepe=true;
					continue;
				}
				}while(pepe==true);	
				
				
			do{
				reset();
				
				try{
					b=Integer.parseInt(ErrorTruncamientoMenu());
				}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Error, seleecione una de las opciones presentadas en pantalla.");
					sunnyday=true;
				}
				}while(sunnyday==true);
			
				switch(b)
				{
					case 1: /*Error n-esimo termino*/
					case 2: ValorRedondeado(); //ESTO NO VA AQUI. ES DE PRUEBA
					case 3: ValorExactoFunction();
					case 4: ErrorAbsoluto();
					case 5: ErrorRelativo();
					case 6: continue;
					default: JOptionPane.showMessageDialog(null, "Opcion invalida.");
				}
		}
		
					
		case 4:
		{
			System.exit(0);
		}
		
		case 5: Derivada.main();
		default: JOptionPane.showMessageDialog(null, "Opcion invalida.");
	}
		
	}while(b!=4);
	}
		
		
		
		

		
		static void ErrorRedondeo()
		{
			float result1=ErrorRedondeo.sumNumSimple(100000, 1f);
			float result2=ErrorRedondeo.sumNumSimple(100000,0.00001f);
			double result3 = ErrorRedondeo.sumNumDouble(100000,0.00001);

			JOptionPane.showMessageDialog(null, result1+"  "+result2 + "  " +result3);
		}
		
		
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
		
		
		
	
		
		
		
		
		
		
		
		//Menus
	
		static String ErrorRedondeoMenu()
		{
			a = JOptionPane.showInputDialog(null, "Menu 2\n "
					+ "Error de Redondeo\n"
					+ "1. Salir del Programa\n"
					+ "2. Analisis de Resultados\n"
					+ "3. Regresar el menu 1\n");
			return a;
		}
		
		static 	String MenuPrincipal()
		{
			a = JOptionPane.showInputDialog(null,"Menu 1\n Teoria de error\n"
					+ "1. Hoja de Presentacion\n"
					+ "2. Error Cometido\n"
					+ "3. Calculo por error de truncamiento (Serie de Taylor)\n"
					+ "4. Salir del Programa\n");
			return a;
		}
		
		
		static String ErrorTruncamientoMenu()
		{
			a = JOptionPane.showInputDialog(null, "Menu 3\n\t "
					+ "Error por Truncamiento\n\t"
					+ "1. Error cometio en el n-esimo termino\n"
					+ "2. Valor aproximado de la funcion\n"
					+ "3. Valor exacto de la funcion\n"
					+ "4. Error Absoluto\n"
					+ "5. Error relativo Porcentual \n"
					+ "6. Regresar al menu 1");
			return a;
		}
		
		
		static boolean reset(){
			sunnyday=false;
			return sunnyday;
		}
		
		
		static boolean resetpepe(){
			pepe=false;
			return pepe;
		}
		
		
}


