package br.edu.ifsp.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.database.Database;
import br.edu.ifsp.model.Client;

public class ClientDAO extends DAO<Client> {

	public ClientDAO(Database database) {
		super(database);
	}

	@Override
	public boolean insert(Client client) {

		try {

			database.connect();

			String sql = "INSERT INTO Cliente(idCliente, nome) VALUES (?, ?)";

			sql = sql.replaceFirst("\\?", client.getIdClient().toString());
			sql = sql.replaceFirst("\\?", "\"" + client.getName() + "\"");

			return database.insert(sql);

		} finally {

			this.database.disconnect();

		}
	}

	@Override
	public boolean update(Client client) {

		try {

			database.connect();

			String sql = "UPDATE Cliente SET idCliente = ?, nome = ? WHERE idCliente = ?";

			sql = sql.replaceFirst("\\?", client.getIdClient().toString());
			sql = sql.replaceFirst("\\?", "\"" + client.getName() + "\"");
			sql = sql.replaceFirst("\\?", client.getIdClient().toString());

			return database.update(sql);
			
		} finally {
			
			this.database.disconnect();
			
		}
	}

	@Override
	public boolean delete(Client client) {

		try {

			database.connect();
		
			String sql = "DELETE Cliente WHERE idCliente = ?";

			sql = sql.replaceFirst("\\?", client.getIdClient().toString());

			return database.delete(sql);
		
		} finally {
			
			this.database.disconnect();
			
		}
	}

	@Override
	public List<Client> listAll() {

		List<Client> list = new ArrayList<Client>();

		String sql = "SELECT idCliente, nome FROM Cliente";

		ResultSet rs = database.query(sql);

		try {

			while (rs.next()) {

				Client c = new Client();

				c.setIdClient(rs.getLong("idCliente"));
				c.setName(rs.getString("nome"));

				list.add(c);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return list;
	}

}
