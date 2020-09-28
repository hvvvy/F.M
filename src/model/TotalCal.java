package model;

public class TotalCal {

	int totalCal;


	public int getTotalCal() {
		return totalCal;
	}
	public void setTotalCal(int cal) {
		this.totalCal = cal;
	}

	public void setTotalCals(int cal) {
		this.totalCal += cal;
	}
}
