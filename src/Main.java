import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.util.ArrayList;

public class Main {


	public static void main(String[] args)throws IOException  {
		MenuPrincipal();
	}
		

		//Menus
	static void ErrorRedondeo()
	{
		int op=0;
		boolean error=false;
		do
		{
			do
			{
				try
				{
					op = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu 2\n "
							+ "Error de Redondeo\n"
							+ "1. Salida del Programa\n"
							+ "2. Analisis de Resultados\n"
							+ "3. Regresar el menu 1\n"));
					error = false;
				}
				catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, "Porfavor inserte una de las opciones");
					error = true;
				}
			}while(error);
			
			switch(op)
			{
				case 1:
				{	
					float result1=ErrorRedondeo.sumNumSimple(100000, 1f);
					float result2=ErrorRedondeo.sumNumSimple(100000,0.00001f);
					double result3 = ErrorRedondeo.sumNumDouble(100000,0.00001);

					JOptionPane.showMessageDialog(null, ("\tSuma Simple con 1      =  "+result1)+
							("\n\tSuma Simple 0.00001 =   "+result2) + 
									("\n\tSuma Double 0.00001 =   " +result3));
				}
					break;
				case 2:
				{
					JOptionPane.showMessageDialog(null,"Debido al hecho de que cualquier numero real que no\n"
							+ "sea multiplo de 5, por ejemplo 0.5 , 0.75 ,etc no se puede representar de manera\n"
							+ "exacta, cada ya de por si el numero 0.00001 de manera flotante ya tiene un error\n"
							+ "de redondeo, a medida que uno va sumando el error va creciendo y es por esto que el sumar\n "
							+ "dicho numero no nos da el resultado esperado de 1, de igual manera pasa cuando se trata con \n"
							+ "doble presicion");

				}
				break;
				case 3:break;
				default: JOptionPane.showMessageDialog(null, "Inserte una de las opciones");
			}
		}while(op!=3);
	}
		
	static void MenuPrincipal()
	{
		int op= 0;
		do{		
			op=0;
			try{
				op=Integer.parseInt(JOptionPane.showInputDialog(null,"Menu 1\n Teoria de error\n"
						+ "1. Hoja de Presentacion\n"
						+ "2. Error Cometido\n"
						+ "3. Calculo por error de truncamiento (Serie de Taylor)\n"
						+ "4. Salir del Programa\n"));
				}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Introduzca una de las opciones.");
			}
			switch(op)
			{
				case 1:Presentacion();break;
				case 2: ErrorRedondeo();break;
				case 3: ErrorTruncamiento();break;
				case 4: System.exit(0);break;
				default: JOptionPane.showMessageDialog(null, "Opcion invalida.");break;
			}
			
		}while(op!=4);
	}
		
	static void Presentacion()
	{
		ImageIcon presentacion = new ImageIcon(Main.class.getClassLoader().getResource("presentacion.jpg"));
		JOptionPane.showMessageDialog(null, presentacion);
	}

	static void ErrorTruncamiento()
	{
		
		boolean error = false;
		ArrayList<Double> funcCoef= new ArrayList<Double>();
		double orderPol = 0;
		double x = 0;
		double x0 = 0;
		do
		{
			try
			{
				orderPol=Double.parseDouble(JOptionPane.showInputDialog(null, "Orden del Polinomio:"));
				error =false;
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Error, no ha introducido un numero.");
				error=true;
			}
		}while(error==true);	
		
		for(int i=0;i<=orderPol;i++)
		{
			 error = false;
			do
			{
				try
				{
					funcCoef.add(Double.parseDouble(JOptionPane.showInputDialog(null, "a0+a1X^1+a2X^2+...+anX^n"+ "\n"+"a"+(i)+":" )));
					error =false;
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, "Error, no ha introducido un numero.");
					error=true;
				}
			}while(error==true);	
		}	
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
				x0= Double.parseDouble(JOptionPane.showInputDialog(null,"Inserte el valor de X0"));
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Error, no ha introducido un numero.");
				error=true;
			}
		}while(error==true);
		String flag;
			flag = JOptionPane.showInputDialog(null, "Desea hacer la aproximacion con la restriccion de que la serie \n "
					+ "pare cuando el error en el n-esimo termino sea menor a 0.0001 (s)/n");

		
		TaylorAproxFunc aproximation = new TaylorAproxFunc();
		aproximation.func= new PolinomialFunc(new ArrayList<Double>(funcCoef));
		double resp[];
		if(flag.equals("n"))
		{
			System.out.println(flag);
			resp = aproximation.aprox(x, x0,"");
		}
		else
		{
			resp=aproximation.aprox(x, x0);
		}
		int op = 0;
		do
		{
			op=0;
				try
				{
					op=Integer.parseInt(JOptionPane.showInputDialog(null, "Menu 3\n\t "
							+ "Error por Truncamiento\n\t"
							+ "1. Error cometio en el n-esimo termino\n"
							+ "2. Valor aproximado de la funcion\n"
							+ "3. Valor exacto de la funcion\n"
							+ "4. Error Absoluto\n"
							+ "5. Error relativo Porcentual \n"
							+ "6. Regresar al menu 1"));
				}
				catch(Exception e)
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
		

		
		
}


