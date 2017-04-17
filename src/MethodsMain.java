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
				break;
				case 2: 
				{	
					boolean error = false;
					do
					{
						try
						{
							b=Integer.parseInt(ErrorRedondeoMenu());
							error=false;
						}
						catch(NumberFormatException e)
						{
							JOptionPane.showMessageDialog(null, "Error, introduzca una de las opciones.");
							error=true;	
						}
					}while(error == true);
				
					switch(b)
					{
						case 1: System.exit(0);
						case 2:
						{
							ErrorRedondeo();
						}
						case 3: continue;
						default: JOptionPane.showMessageDialog(null, "Opción Invalida.");
					}
				}
				break;
				
				case 3: 
					{
								ErrorTruncamiento();
					}	
				break;
				case 4:
				{
					System.exit(0);
				}
				break;
				case 5: Derivada.main();break;
				default: JOptionPane.showMessageDialog(null, "Opcion invalida.");break;
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
			 ValorExacto= (array[0]*Math.pow(x,exp[0]) + (array[1]*Math.pow(x,exp[1])) + (Math.pow(array[2],exp[2])*x)+array[3]);
			 JOptionPane.showMessageDialog(null, "Valor Exacto de la función es: "+ValorExacto);
		 }
		
		static void ValorRedondeado(){
				ValorRedondeado= (array[0]*Math.pow(xr,exp[0]) + (array[1]*Math.pow(xr,exp[1])) + (Math.pow(array[2],exp[2])*xr+array[3]));
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
			int op;
			do
				{
				
					a = JOptionPane.showInputDialog(null, "Menu 2\n "
						+ "Error de Redondeo\n"
						+ "1. Salir del Programa\n"
						+ "2. Analisis de Resultados\n"
						+ "3. Regresar el menu 1\n");
					op=Integer.parseInt(a);
					switch(op)
					{
						case 1:
						{
							System.out.println("Adios");
							System.exit(0);
						}
						case 2:
						{
							ErrorRedondeo();
						}
						case 3:
						{
							
						}
					}
				}while(op!=3);
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
		
		static void ErrorTruncamiento()
		{
			for(int i=0;i<=3;i++)
			{
				boolean error = false;
				do
				{
					System.out.println("stuck");
					try
					{
					array[i]=Double.parseDouble(JOptionPane.showInputDialog(null, "a0+a1X^1+a2X^2+a3X^3"+ "\n"+"a"+(i)+":" ));
					//exp[i]=Double.parseDouble(JOptionPane.showInputDialog(null, "ingrese el exponente del termino "+(i+1)));
					error =false;
					}
					catch(NumberFormatException e)
					{
						JOptionPane.showMessageDialog(null, "Error, no ha introducido un numero.");
						error=true;
						continue;
					}
				}while(error==true);	
			}
			
			//array[3]=Double.parseDouble(JOptionPane.showInputDialog(null, "ingrese el termino constante"));
			boolean error = false;
			do
			{
				
				try
				{
					x= Double.parseDouble(JOptionPane.showInputDialog(null,"Inserte el valor de X"));
					error =false;
				}
				catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, "Error, no ha introducido un numero.");
					error=true;
				}
			}while(error==true);
			
			error = false;
			do
			{
				try
				{
					xr= Double.parseDouble(JOptionPane.showInputDialog(null,"Inserte el valor de X redondeado"));
				
				}
				catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, "Error, no ha introducido un numero.");
					error=true;
				}
			}while(error==true);
			double resp[] = TaylorAproxFunc.taylorAprox(0.0001, array, x, xr);
			int op = 0;
			
			do
			{
				
					try
					{
						op=Integer.parseInt(ErrorTruncamientoMenu());
					}
					catch(NumberFormatException e)
					{
						JOptionPane.showMessageDialog(null, "Error, no ha introducido un numero.");
						continue;
					}
					switch(op)
					{
					case 1:
						JOptionPane.showMessageDialog(null, "El error en el nesimo termino fue de: "  + resp[1]);
						break;
					case 2:
						JOptionPane.showMessageDialog(null, "El Valor Aproximado de la funcion: "  + resp[0]);
						break;
					case 3 :
						JOptionPane.showMessageDialog(null, "El valor exacto de la funcion: "  + resp[2]);
						break;
					case 4:
						JOptionPane.showMessageDialog(null, "Error Absoluto: "  + resp[3]);
						break;
					case 5:
						JOptionPane.showMessageDialog(null, "Error Relativo: "  + resp[4]);
						break;
					}
			}while(op!=6 );
			
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


