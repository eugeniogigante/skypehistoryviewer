package skypehistoryviewer.gestionefile;

import java.io.*;
import java.util.*;
class FindFile 
{
    public ArrayList<String> findFile(String name,File file)
    {
    	ArrayList<String> directory=new ArrayList();
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
                System.out.println(fil.getParentFile().toString());
                directory.add(fil.getParentFile().toString());
            }
        }
        return directory;
    }
    public static void main(String[] args) 
    {
        FindFile ff = new FindFile();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the file to be searched.. " );
        String name = scan.next();
        System.out.println("Enter the directory where to search ");
        String directory = scan.next();
        ff.findFile(name,new File(directory));
    }
}
