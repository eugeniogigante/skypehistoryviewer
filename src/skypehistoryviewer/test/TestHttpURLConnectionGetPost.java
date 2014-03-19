package skypehistoryviewer.test;

import java.util.Iterator;
import java.util.List;

import skypehistoryviewer.entity.Messaggio;
import skypehistoryviewer.postget.HttpURLConnectionGetPost;
import skypehistoryviewer.storage.DBMessaggio;

public class TestHttpURLConnectionGetPost {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		HttpURLConnectionGetPost httpURLConnectionGetPost=new HttpURLConnectionGetPost();
		DBMessaggio dbMessaggio=new DBMessaggio();
		List<Messaggio> messaggi=dbMessaggio.visualizzaMessaggi();
		String queryString;
		Messaggio b =null;
		Iterator itr = (Iterator) messaggi.iterator();
	      while ( itr.hasNext() ) {
	    	  b =(Messaggio) itr.next() ;
	    	  String queryStringHead="http://egigante.altervista.org/phpgettest.php?";
	    	  queryString="destinatario="+b.getDestinatario()+"&testo="+b.getTesto()+"&mittente="+b.getMittente();
	    	  //queryString.replaceAll("\\s",""); 
	    	  //queryString.replaceAll("[^\\w]", "");
	    	  //queryString.replaceAll("[^\\w]","");
	    	  //queryString.replaceAll("[#]","");
	    	  //queryString.replaceAll("[$]","");
	    	  queryString=queryStringHead+queryString;
	    	  httpURLConnectionGetPost.sendGet(queryString);
	      }
		
		
	}

}
