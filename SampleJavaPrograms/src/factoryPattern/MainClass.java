package factoryPattern;

public class MainClass {
	
	
	public static void main(String args[]) {
		
		FactoryClass obj = new FactoryClass();
		InterfaceA cls = obj.getsubClass(1);
		cls.print();
		
	}

}
