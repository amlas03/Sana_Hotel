package sana_hotel.beans;

public class Date {
	private int jour;
	private int mois;
	private int year;
	
	public Date() {
		
	}
	
	public Date(int jour, int mois, int year) {
		super();
		this.jour = jour;
		this.mois = mois;
		this.year = year;
	}

	public int getJour() {
		return jour;
	}

	public void setJour(int jour) {
		this.jour = jour;
	}

	public int getMois() {
		return mois;
	}

	public void setMois(int mois) {
		this.mois = mois;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String toString() {
		return "Date [jour=" + jour + ", mois=" + mois + ", year=" + year + "]";
	}
	

}
