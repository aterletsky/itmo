package tersletsky.ru;

public class MobilePhone {
	public String manufacturer;
	public String model;
	public String madeInCountry;
	
	public void setInfo(String man, String mod, String made) {
		manufacturer = man;
		model = mod;
		madeInCountry = made;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	public String getModel() {
		return model;
	}
	public String getMadeIn() {
		return madeInCountry;
	}
	
	public void getInfo () {
		 System.out.println("Company: " + manufacturer + ", Model: " + model + ", Made in " + madeInCountry);	
	} 
}

