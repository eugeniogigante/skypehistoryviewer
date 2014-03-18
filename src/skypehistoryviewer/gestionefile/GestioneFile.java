package skypehistoryviewer.gestionefile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import skypehistoryviewer.entity.Messaggio;

public class GestioneFile {
	public GestioneFile(List v){
	String text = "Hello world";
	Messaggio b =(Messaggio) v.get(row);
	try {
      File file = new File("example.txt");
      BufferedWriter output = new BufferedWriter(new FileWriter(file));
      output.write(text);
      output.close();
    } catch ( IOException e ) {
       e.printStackTrace();
    }
	}
}
