package factoryPattern;

public class FactoryClass {
	
	public InterfaceA getsubClass(int type) {
		
		if(type == 1) {
			return new SubclassB();
		}
		else {
		return new SubclassC();
		}
	}

}
