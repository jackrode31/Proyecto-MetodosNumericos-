import javax.swing.JOptionPane;
import java.io.IOException;

public class MethodsMain {
static String a;
static int b;
static double array[] =new double[4];
static boolean sunnyday=false;
static boolean pepe=true;

		public static void main(String[] args)throws IOException  {
			
		Doc d;
		d = new Doc();
		
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
				JOptionPane.showMessageDialog(null, "Error, introduzca un numero.");
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
				}
			}
		
		
		case 3: 
		do{
			do{
				{
				
			resetpepe();
			try
			{
			for(int i=1;i<=3;i++)
				{
				array[i]=Double.parseDouble(JOptionPane.showInputDialog(null, "ingrese el termino "+ i +" del polinomio"));
				}
			}
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "Error, introduzca un numero 2.");
				pepe=true;
				continue;
			}
			
				
			
			
			
				reset();
			try{
			b=Integer.parseInt(ErrorTruncamientoMenu());
			}catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Error, introduzca un numero 3.");
				sunnyday=true;
				continue;
			}
			switch(b)
			{
			case 1: JOptionPane.showMessageDialog(null, array[1]); /*Error n-esimo termino*/
			case 2:/*Valor aproximado de la funci�n*/
			case 3:/*Valor exacto de la funcion*/
			case 4: /*Eror absoluto*/
			case 5: /*Error relativo porcentual*/
			case 6:/*Volver al menu 1*/continue;
				
			}
			
		
				}
			}while(sunnyday=true);continue;
		}while(pepe=true);
			
		case 4:
		{
			System.exit(0);
		}
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


