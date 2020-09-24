package model;

import java.util.ArrayList;

public class FoodInfomationManager {

	public ArrayList<FoodInfomation> getFoodInfoList(
			ArrayList<FoodInfomation> foodInfoList,
			String foodName,
			int weight,
			int cal,
			double protein,
			double fat,
			double carbo,
			String remarks){

		//セッションから食材名、重量、カロリーが取得できない場合は初回リクエストとして処理
		//リストを新規作成
		if(foodInfoList == null) {
			foodInfoList = new ArrayList<FoodInfomation>();
		}
		//リストに追加をして返却
		foodInfoList.add(new FoodInfomation(foodName,weight,cal,protein,fat,carbo,remarks));
		return foodInfoList;
	}
}
