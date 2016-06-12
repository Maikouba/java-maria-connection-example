package br.edu.ifsp;

import br.edu.ifsp.database.MariaDatabase;

public class MainInclusaoSimples {

	public static void main(String[] args) {
	
		MariaDatabase db = new MariaDatabase("root", "", "COMPRAPRODUTO", "localhost", 3306);
		
		db.connect();
		
		String sql = "INSERT INTO Cliente(idCliente, nome) VALUES (?, ?)";
		
		if (db.insert(sql))
			System.out.println("Inclusão realizada com sucesso.");
		
		else
			System.out.println("Falha na inclusão.");
		
	}
}
