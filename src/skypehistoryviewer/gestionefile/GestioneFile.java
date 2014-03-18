package skypehistoryviewer.gestionefile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;




import skypehistoryviewer.entity.Messaggio;

public class GestioneFile {
	public GestioneFile(List v){
		Messaggio b =null;
	try {
      File file = new File("E://example.txt");
      BufferedWriter output = new BufferedWriter(new FileWriter(file));
      //------------------------------------------------------------
      Iterator itr = (Iterator) v.iterator();
      while ( itr.hasNext() ) {
    	  b =(Messaggio) itr.next() ;
    	  output.write(b.getData()+";"+b.getDestinatario()+";"+b.getMittente()+";"+b.getTesto());
          //System.out.print( "  " + b.getTesto() ); 
      //System.out.println( "]" );
      }
    	  
      //-----------------------------------------------------------

      
      output.close();
    } catch ( IOException e ) {
       e.printStackTrace();
    }
	}
}
