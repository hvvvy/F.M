package model;

public class FoodInfomation {

	String foodName;
	int weight;
	int cal;
	double pro;
	double fat;
	double carbo;
	String remarks;
	int totalCal;

	public FoodInfomation(String resultFoodName,
						int resultWeight,
						int resultCal,
						double resultPro,
						double resultFat,
						double resultCarbo,
						String resultRemarks) {

		this.foodName = resultFoodName;
		this.weight = resultWeight;
		this.cal = resultCal;
		this.pro = resultPro;
		this.fat = resultFat;
		this.carbo = resultCarbo;
		this.remarks = resultRemarks;

	}
	public FoodInfomation(String foodName, int weight, int cal) {

		this.foodName = foodName;
		this.weight = weight;
		this.cal = cal;

	}
	/**
	 *
	 * @return
	 */
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getCal() {
		return cal;
	}
	public void setCal(int cal) {
		this.cal = cal;
	}

	public double getPro() {
		return pro;
	}
	public void setPro(double pro) {
		this.pro = pro;
	}

	public double getFat() {
		return fat;
	}
	public void setFat(double fat) {
		this.fat = fat;
	}

	public double getCarbo() {
		return carbo;
	}
	public void setCarbo(double carbo) {
		this.carbo = carbo;
	}

	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getTotalCal() {
		return totalCal;
	}
	public void setTotalCal(int totalCal) {
		this.totalCal = totalCal;
	}
}
