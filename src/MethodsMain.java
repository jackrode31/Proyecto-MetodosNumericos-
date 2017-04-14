import javax.swing.JOptionPane;
import java.io.IOException;

public class MethodsMain {
static String a;
static int b;


		public static void main(String[] args)throws Exception  {
		
		//THE PICNICCCCCC, THE FUKING PICNICCCCCCCCCCCCCCCC 
			
		Doc d;
		d = new Doc();
		
		
		Methods action = new Methods();
	
do{		
		String MenuPrincipal = ("Menu 1\n Teor�a de error\n"
				+ "1. Hoja de Presentaci�n\n"
				+ "2. Error Cometido\n"
				+ "3. Calculo por error de truncamiento (Serie de Taylor)\n"
				+ "4. Salir del Programa\n");
	
	
		a = JOptionPane.showInputDialog(null, MenuPrincipal);
	
		int b=Integer.parseInt(a);
		
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
			a = JOptionPane.showInputDialog(null, "Menu 2\n "
					+ "Error de Redondeo\n"
					+ "1. Salir del Programa\n"
					+ "2. An�lisis de Resultados\n"
					+ "3. Regresar el menu 1\n");
			
			b=Integer.parseInt(a);
			switch(b)
			{
			case 1: System.exit(0);
			case 2:/*ANALISIS DE RESULTADOS*/
				ErrorRedondeo();
				
				break;
			case 3:/*VOLVER AL MENU*/continue;
				
			}break;
		}
			
		case 3: 
		{
			a = JOptionPane.showInputDialog(null, "Menu 3\n\t "
					+ "Error por Truncamiento\n\t"
					+ "1. Error cometio en el n-esimo termino\n"
					+ "2. Valor aproximado de la funci�n\n"
					+ "3. Valor exacto de la funci�n\n"
					+ "4. Error Absoluto\n"
					+ "5. Error relativo Porcentual \n"
					+ "6. Regresar al menu 1");
			
			b=Integer.parseInt(a);
			switch(b)
			{
			case 1: /*Error n-esimo termino*/
			case 2:/*Valor aproximado de la funci�n*/
			case 3:/*Valor exacto de la funcion*/
			case 4: /*Eror absoluto*/
			case 5: /*Error relativo porcentual*/
			case 6:/*Volver al menu 1*/continue;
				
			}
		}
			
		case 4:
		{
			System.exit(0);
		}
		default: JOptionPane.showMessageDialog(null, "Opci�n invalida.");
	}
		
	}while(b==2||b!=4);
	}

		static void ErrorRedondeo()
		{
			
			float result1=ErrorRedondeo.sumNumSimple(100000, 1f);
			float result2=ErrorRedondeo.sumNumSimple(100000,0.00001f);
			double result3 = ErrorRedondeo.sumNumDouble(100000,0.00001);
			System.out.println(result1+" "+result2 + " " +result3);
			
		}
}


