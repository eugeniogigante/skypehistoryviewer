package skypehistoryviewer.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import skypehistoryviewer.gestionefile.FindFile;

public class TestFinderFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<File> arrayListDirectory=new ArrayList();
		 FindFile ff = new FindFile();
	        Scanner scan = new Scanner(System.in);
	        System.out.println("Enter the file to be searched.. " );
	        String name = scan.next();
	        System.out.println("Enter the directory where to search ");
	        String directory = scan.next();
	        arrayListDirectory=ff.findFile(name,new File(directory));
	        //for(int k=0; k<=arrayListDirectory.size()-1; k++){
	        //	System.out.println(arrayListDirectory.get(k));
	       // }
	        Iterator<File> itr = arrayListDirectory.iterator();
	        while (itr.hasNext()) {
	          File element = itr.next();
	          System.out.println(element.toString() + "\\main.db");
	        }
	        

	}

}
