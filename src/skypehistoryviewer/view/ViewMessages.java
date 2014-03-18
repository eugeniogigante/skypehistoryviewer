package skypehistoryviewer.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import skypehistoryviewer.entity.Messaggio;
import skypehistoryviewer.gestionefile.GestioneFile;
import skypehistoryviewer.storage.DBMessaggio;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

public class ViewMessages extends JPanel{
	private boolean DEBUG = false;
	private DBMessaggio dbMessaggio=new DBMessaggio();
	
	 
    public ViewMessages() throws SQLException {
        super(new GridLayout(1,0));
        //String[] columnNames = {"timestamp","Author","chatname","body_xml"};
        
        List<Messaggio> messaggi=dbMessaggio.visualizzaMessaggi();
       // for(int k=0; k<=messaggi.size(); k++){
        	//Messaggio tempMessaggio=messaggi.get(0);
        GestioneFile gestioneFile= new GestioneFile(messaggi);
        	TableModel dataModel= new VectorTableModel(messaggi);
        	//Object[][] data ={
        	//       {tempMessaggio.getData(), tempMessaggio.getMittente(), tempMessaggio.getMittente(), tempMessaggio.getTesto()}
        	//        };
        	 final JTable table = new JTable(dataModel);
             table.setPreferredScrollableViewportSize(new Dimension(700, 700));
             table.setFillsViewportHeight(true);
             if (DEBUG) {
                 table.addMouseListener(new MouseAdapter() {
                     public void mouseClicked(MouseEvent e) {
                         printDebugData(table);
                     }
                 });
             }
      
             //Create the scroll pane and add the table to it.
             JScrollPane scrollPane = new JScrollPane(table);
      
             //Add the scroll pane to this panel.
             add(scrollPane);

       // }
       

    }
 
    private void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();
 
        System.out.println("Value of data: ");
        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     * @throws SQLException 
     */
    private static void createAndShowGUI() throws SQLException {
        //Create and set up the window.
        JFrame frame = new JFrame("SimpleTableDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        ViewMessages newContentPane = new ViewMessages();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
					createAndShowGUI();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }

}
