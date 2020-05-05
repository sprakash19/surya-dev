package abstractFactoryPattern;

public class MainClass {

	public static void main(String[] args) {
		MainFactoryInterface fac = new SubFactoryB();
		MainInterface obj = fac.get();
		obj.print();
		fac = new SubFactoryC();
		obj = fac.get();
		obj.print();

	}

}
