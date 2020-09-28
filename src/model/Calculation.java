package model;

public class Calculation {

	FoodInfomation foodInfo = null;
	String foodName;
	int cal;
	double resultPro;
	double resultFat;
	double resultCarbo;
	String remarks;

	//取得した情報を基に計算するコンストラクタ
	public Calculation(String foodName, int weight, String pro, String fat, String carbo, String remarks,TotalCal totalCal) {


		resultPro = ((double)Math.round(weight * (Double.parseDouble(pro)) * 100) / 100);
		resultFat = ((double)Math.round(weight * (Double.parseDouble(fat)) * 100) / 100);
		resultCarbo = ((double)Math.round(weight * (Double.parseDouble(carbo)) * 100) / 100);
		//計算したPFCを基にカロリーを算出
		cal = (int)((resultPro * 4) + (resultFat * 9) + (resultCarbo * 4));
		//食材のカロリーをtotalCalへセット
		totalCal.setTotalCals(cal);
		//モデルに格納
		foodInfo = new FoodInfomation(foodName,weight,cal,resultPro,resultFat,resultCarbo,remarks);

	}
	//計算された情報を返却するメソッド
	public FoodInfomation getResult() {

		return foodInfo;
	}


}
