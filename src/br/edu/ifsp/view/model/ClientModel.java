package br.edu.ifsp.view.model;

import javax.swing.table.DefaultTableModel;

public class ClientModel extends DefaultTableModel {

	public ClientModel(String[] header, Object[][] rows) {

		for (String c : header)
			super.addColumn(c);

		for (Object[] o : rows)
			super.addRow(o);
	};

	Class[] types = new Class[] { java.lang.Integer.class,
			java.lang.String.class, java.lang.String.class };
	boolean[] canEdit = new boolean[] { false, false, false };

	public Class getColumnClass(int columnIndex) {
		return types[columnIndex];
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return canEdit[columnIndex];
	}

}