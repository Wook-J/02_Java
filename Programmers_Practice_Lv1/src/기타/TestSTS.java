package 기타;

public class TestSTS {

	public double unitPrice(String pricePerIngred) {
		int index = pricePerIngred.indexOf("원");
		String price = pricePerIngred.substring(0, index);
		return Double.parseDouble(price);
	}
	
	public double volume(String ingredVolume) {
		String[] volume = ingredVolume.split("g|개|ml");
		return Double.parseDouble(volume[0]);
	}
}
