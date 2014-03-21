package skypehistoryviewer.gestionefile;

import java.io.*;
import java.util.*;
public class FindFile 
{
	private ArrayList<File> directory=new ArrayList();
	public FindFile(){
		
	}
	
    public ArrayList<File> findFile(String name,File file)
    {
    	
        File[] list = file.listFiles();
        if(list!=null)
        for (File fil : list)
        {
            if (fil.isDirectory())
            {
                findFile(name,fil);
            }
            else if (name.equalsIgnoreCase(fil.getName()))
            {
                //System.out.println(fil.getParentFile().toString());
                this.directory.add(fil.getParentFile());
            }
        }
        return this.directory;
    }
    /*public static void main(String[] args) 
    {
        FindFile ff = new FindFile();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the file to be searched.. " );
        String name = scan.next();
        System.out.println("Enter the directory where to search ");
        String directory = scan.next();
        ff.findFile(name,new File(directory));
    }
    */
}
