package br.edu.ifsp.control;

import java.util.List;

import br.edu.ifsp.dao.ClientDAO;
import br.edu.ifsp.database.Database;
import br.edu.ifsp.database.MariaDatabase;
import br.edu.ifsp.model.Client;

public class ClientControl {

	private ClientDAO dao;
	
	public ClientControl() {
		
		Database db = new MariaDatabase("root", "", "COMPRAPRODUTO");
		dao = new ClientDAO(db);
	}
	
	public List<Client> listClients() {
		return dao.listAll(); 
	}
	
}
