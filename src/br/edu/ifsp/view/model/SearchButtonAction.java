package br.edu.ifsp.view.model;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import br.edu.ifsp.control.ClientControl;
import br.edu.ifsp.view.ClientListFrame;

public class SearchButtonAction extends AbstractAction {

	private static final long serialVersionUID = 5188316369008623461L;

	private ClientListFrame frame;
	
	private ClientControl control = new ClientControl();
	
	public SearchButtonAction(ClientListFrame frame) {
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent action) {
		this.frame.getClientTable().setModel(new ClientTableModel(control.listClients()));;
	}
}
