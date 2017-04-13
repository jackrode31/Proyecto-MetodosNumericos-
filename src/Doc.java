import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class Doc {

	public static void main(String[] args) {

		try {
		      Desktop desktop = null;
		      if (Desktop.isDesktopSupported()) 
		      {
		        desktop = Desktop.getDesktop();
		      }

		       desktop.open(new File("doc\\presentacion.pdf"));
		    } catch (IOException ioe) 
			{
		      ioe.printStackTrace();
		    }
		}
}
