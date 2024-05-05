package sana_hotel.beans;

public class Reservation implements AttributeGetter, attributsSearch {
	private int clientid;
	private int chambrenum;
	private int nbreJours;
	private String date;
	
	public Reservation() {
		
	}
	
	
	public Reservation(int client, int chambrenum, String date, int nbreJours) {
		this.clientid = clientid;
		this.chambrenum = chambrenum;
		this.date = date;
		this.nbreJours = nbreJours;
	}

	public int getClient() {
		return clientid;
	}
	
	public void setClient(int client) {
		this.clientid = client;
	}
	
	public int getChambre() {
		return chambrenum;
	}
	
	public void setChambre(int chambre) {
		this.chambrenum = chambre;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public int getNbreJours() {
		return nbreJours;
	}
	
	public void setNbreJours(int nbreJours) {
		this.nbreJours = nbreJours;
	}

	public String toString() {
		return "Reservation [client=" + clientid + ", chambre=" + chambrenum + ", date=" + date + ", nbreJours=" + nbreJours
				+ "]";
	}


	public int getNum() {
		return 3;
	}


	public String getLabel(int index) {
		switch(index) {
		case(0): return "Client : ID";
		case(1): return "Chambre : num";
		case(2): return "Nbre de jours";
		}
		return null;
	}


	public int getCol(int index) {
		switch(index) {
		case(0): return 10;
		case(1): return 10;
		case(2): return 10;
		}
		return 0;
	}


	@Override
	public String searchElements(int i) {
		switch(i) {
		case(0): return "par client : ID";
		case(1): return "par chambre : num";
		}
		return null;
	}
	}	


