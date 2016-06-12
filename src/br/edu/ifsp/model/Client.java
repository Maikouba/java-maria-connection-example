package br.edu.ifsp.model;

public class Client implements IModel {

	private Long idClient;
	
	private String name;

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
