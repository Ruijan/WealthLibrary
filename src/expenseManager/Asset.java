package expenseManager;

public class Asset {

	public String name;
	public double yearReturn;
	public double initiaValue;

	public Asset(String newAssetName, double newYearReturn, double newAssetCurrentValue) {
		name = newAssetName;
		yearReturn = newYearReturn;
		initiaValue = newAssetCurrentValue;
	}

}
