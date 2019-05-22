package PANTALLA_LP;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class ClsUtilidades {


    public static Image getImage(final String pathAndFileName)
    {
        Image retorno;
        
        final URL url = Thread.currentThread().getContextClassLoader().getResource(pathAndFileName);
       
        if(url!= null)
        {
            retorno=Toolkit.getDefaultToolkit().getImage(url);
        }
        else
        {
            retorno = null;
           
        }

        return retorno;
    }

}
