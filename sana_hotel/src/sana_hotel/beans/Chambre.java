package sana_hotel.beans;

public class Chambre implements AttributeGetter, attributsSearch {
	private static final int occupied=1;
	private static final int notOccupied=0;
	
	private static final int single=1;
	private static final int notSingle=2;
	
	private int numero;
	private int type;
	private int state;
	private double prix;
	
	public Chambre() {
		
	}
	
	public Chambre(int n, int t, int s, double p) {
		numero=n;
		if(t==single || t==notSingle) {
			type=t;
		}
		else {
			type=single;
		}
		if(s==occupied || s==notOccupied) {
			state=s;
		}
		else {
			state=occupied;
		}
		prix=p;
	}

	public int getNumero() {
		return numero;
	}

	public void setNum(int num) {
		this.numero = num;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String toString() {
		return "Chambre [num=" + numero + ", type=" + type + ", state=" + state + ", prix=" + prix + "]";
	}

	public int getNum() {
		return 4;
	}

	public String getLabel(int index) {
		switch(index) {
		case(0): return "Numero de la chambre";
		case(1): return "Type";
		case(2): return "Etat";
		case(3): return "Prix";
		}
		return null;
	}

	public int getCol(int index) {
		switch(index) {
		case(0): return 15;
		case(1): return 10;
		case(2): return 10;
		case(3): return 10;
		}
		return 0;
	}

	@Override
	public String searchElements(int i) {
		 return "par numero";
	
	}
	}


