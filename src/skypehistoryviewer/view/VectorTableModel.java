package skypehistoryviewer.view;

import java.util.List;
import java.util.Vector;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import skypehistoryviewer.entity.Messaggio;

public class VectorTableModel extends AbstractTableModel  {
	 List v = null;
	// intestazioni delle colonne
	String[] ColName ={"data", "mittente","destinatario", "testo"};
	public VectorTableModel(List v) {
	this.v = v; // inizializzato con il vettore
	}
	/** il numerodi colonne */
	public int getColumnCount(){ return ColName.length; }
	/** numero righe = dimensione del vettore */
	public int getRowCount() { return v.size(); }
	/** ritorna il contenuto di una cella */
	public Object getValueAt(int row, int col) {
	// seleziona il libro
		Messaggio b =(Messaggio) v.get(row);
	// la stringa corrispondente alla colonna
	switch (col){
	case 0: return b.getData();
	case 1: return b.getDestinatario();
	case 2: return b.getMittente();
	case 3: return b.getTesto();
	default: return "";
	} 
	

}
}
