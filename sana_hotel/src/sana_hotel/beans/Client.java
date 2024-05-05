package sana_hotel.beans;

public class Client implements AttributeGetter, attributsSearch {

	private static int id=0;
	private String nom, prenom; 
	private int age;
	private int numtel;
	private String ville;
	private String pays;
	
	public Client(){
		
	}

	public Client(int id,String n,String pr, int a,String v, String p, int num) {
		this.id=id;
		nom=n;
		prenom=pr;
		age=a;
		numtel=num;
		ville=v;
		pays=p;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public int getId() {
		return id;
	}
	
	public String toString() {
		return "Client [nom=" + nom + ", ville=" + ville + ", pays=" + pays + "]";
	}

	public int getNum() {
		return 6;
	}

	public String getLabel(int index) {
		switch(index) {
		case(0): return "Nom du client";
		case(1): return "Prénom du client";
		case(2): return "Age";
		case(3): return "Ville";
		case(4): return "Pays";
		case(5): return "N° de téléphone";
		}
		return null;
	}

	public int getCol(int index) {
		switch(index) {
		case(0): return 15;
		case(1): return 10;
		case(2): return 15;
		case(3): return 10;
		case(4): return 15;
		case(5): return 20;
		}
		return 0;
	}

	@Override
	public String searchElements(int i) {
		switch(i) {
		case(0): return "par ID";
		case(1): return "par nom";
	}
		return null;
	}
	

}
