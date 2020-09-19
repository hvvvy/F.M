package model;

public class Calculation {

	FoodInfomation foodInfo = null;
	String foodName;
	double resultPro;
	double resultFat;
	double resultCarbo;
	String remarks;

	//取得した情報を基に計算するコンストラクタ
	public Calculation(String useName, String usePro, String useFat, String useCarbo, String useRemarks,int weight) {

		foodName = useName;
		resultPro = ((double)Math.round(weight * Double.parseDouble(usePro) * 100) / 100);
		resultFat = ((double)Math.round(weight * Double.parseDouble(useFat) * 100) / 100);
		resultCarbo = ((double)Math.round(weight * Double.parseDouble(useCarbo) * 100) / 100);
		remarks = useRemarks;

	}
	//計算された情報を返却するメソッド
	public FoodInfomation getResult() {

		return foodInfo;
	}


}
