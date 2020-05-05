package abstractFactoryPattern;

public class SubFactoryC implements MainFactoryInterface {

	@Override
	public MainInterface get() {
		// TODO Auto-generated method stub
		return new SubclassC();
	}

}
