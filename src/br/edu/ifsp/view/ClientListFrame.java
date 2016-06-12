package br.edu.ifsp.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.WindowConstants;

import br.edu.ifsp.view.model.SearchButtonAction;

public class ClientListFrame extends JFrame {

	private static final long serialVersionUID = -6642713502983167327L;

	private JTable clientTable = new JTable(); 

	private JButton searchButton = new JButton();
	
	public ClientListFrame() {

		super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		super.setLayout(null);
		super.setSize(800, 600);
		
		this.clientTable.setLayout(null);
		this.clientTable.setSize(770, 350);
		this.clientTable.setLocation(10, 10);
		super.add(this.clientTable);
		
		this.searchButton.setLayout(null);
		this.searchButton.setText("List Clients");
		this.searchButton.setSize(120, 60);
		this.searchButton.setLocation(10, 460);
		this.searchButton.setAction(new SearchButtonAction(this));
		super.add(searchButton);
	}

	public JTable getClientTable() {
		return this.clientTable;
	}
}
