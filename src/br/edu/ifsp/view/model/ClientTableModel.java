package br.edu.ifsp.view.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.ifsp.model.Client;

public class ClientTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 651016019722703579L;

	private String[] columnsName = new String[] {"# Cliente", "Nome"};
	
	private List<Client> clientList = new ArrayList<Client>();
	
	public ClientTableModel(List<Client> clientList) {
		this.clientList.addAll(clientList);
	}
	
	@Override
	public int getColumnCount() {
		return columnsName.length;
	}

	@Override
	public int getRowCount() {
		return clientList.size();
	}

	@Override
	public Object getValueAt(int line, int column) {
		
		switch (column) {
		
		case 0: return clientList.get(line).getIdClient();
		
		case 1: return clientList.get(line).getName();

		default:
			throw new IndexOutOfBoundsException("Invalid column index " + column);
		}
	}
	
}
