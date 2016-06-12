package br.edu.ifsp.model;

import java.sql.Time;
import java.util.Date;

public class Order implements IModel {

	private int idOrder;
	
	private Date date;
	
	private Time time;

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
}
