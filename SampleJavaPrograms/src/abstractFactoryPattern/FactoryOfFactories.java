package abstractFactoryPattern;

public class FactoryOfFactories {
	
	public MainInterface instantiate(MainFactoryInterface obj) {
		return obj.get();
	}

}
