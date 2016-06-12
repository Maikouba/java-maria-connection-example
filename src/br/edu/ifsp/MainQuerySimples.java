package br.edu.ifsp;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifsp.database.MariaDatabase;

public class MainQuerySimples {

	public static void main(String[] args) {
		
		MariaDatabase db = new MariaDatabase("root", "", "COMPRAPRODUTO", "localhost", 3306);
		
		db.connect();
		
		ResultSet rs = db.query("SELECT * FROM Cliente;");
		
		try {
			
			while (rs.next()) {
				
				System.out.println("==================================================");
				System.out.println("idCliente: " + rs.getLong("idCliente"));
				System.out.println("     nome: " + rs.getString("nome"));
				System.out.println("==================================================");
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
