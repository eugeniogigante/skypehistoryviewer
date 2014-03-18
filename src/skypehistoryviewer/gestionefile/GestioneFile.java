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
	try {
      File file = new File("E://example.txt");
      BufferedWriter output = new BufferedWriter(new FileWriter(file));
      //------------------------------------------------------------
      
      //-----------------------------------------------------------
      
      
      
      
      for (int k=0; k<=v.size(); k++){
  		Messaggio b =(Messaggio) v.get(0);
  		output.write(b.getData()+b.getDestinatario()+b.getMittente()+b.getTesto());
  	}
      
      output.close();
    } catch ( IOException e ) {
       e.printStackTrace();
    }
	}
	public static void printList(List lst){
        System.out.print( "[" );
        Iterator itr = (Iterator) lst.iterator();
        while ( itr.hasNext() ) 
            System.out.print( "  " + itr.next() ); 
        System.out.println( "]" ); 
    }
}
