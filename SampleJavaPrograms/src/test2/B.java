package test2;

public class B implements A, E {

	@Override
	public void method1() {
		System.out.print("Class B");	
		
	}

	@Override
	public void method2() {
		System.out.print("Class B");	
		
	}

	@Override
	public void parse() {
		method1();
		method2();
		
	}

}
