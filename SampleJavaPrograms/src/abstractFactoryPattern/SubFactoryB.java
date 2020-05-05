package abstractFactoryPattern;

public class SubFactoryB implements MainFactoryInterface {

	@Override
	public MainInterface get() {
		// TODO Auto-generated method stub
		return new SubclassB();
	}

}
