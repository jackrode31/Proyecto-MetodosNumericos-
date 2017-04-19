import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MethodsMain {
static String a;
static int b;
static boolean sunnyday=true;
static boolean pepe=true;
static double h, x, xr, VAbsoluto, ValorRedondeado, VRelativo;
static double ValorExacto; 
static Double array[]=new Double [4];


	public static void main(String[] args)throws IOException  {
		ImageIcon presentacion = new ImageIcon(MethodsMain.class.getClassLoader().getResource("presentacion.jpg"));
		do{		
			try{
				b=Integer.parseInt(MenuPrincipal());
				}
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "Introduzca una de las opciones.");
				continue;
			}
			switch(b)
			{
				case 1:
				{
					
					JOptionPane.showMessageDialog(null, presentacion);
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
						default: JOptionPane.showMessageDialog(null, "Opci�n Invalida.");
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
					try
					{
					array[i]=Double.parseDouble(JOptionPane.showInputDialog(null, "a0+a1X^1+a2X^2+a3X^3"+ "\n"+"a"+(i)+":" ));
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
					xr= Double.parseDouble(JOptionPane.showInputDialog(null,"Inserte el valor de X(0)"));
				
				}
				catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, "Error, no ha introducido un numero.");
					error=true;
				}
			}while(error==true);
			
			TaylorAproxFunc aproximation = new TaylorAproxFunc();
			ArrayList<Double> ol = new ArrayList<Double>(Arrays.asList(array));
			aproximation.func= new PolinomialFunc(new ArrayList<Double>(Arrays.asList(array)));
			double resp[] = aproximation.aprox(x, xr);
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


