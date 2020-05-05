package interfacetest;

public class A extends ASuper implements AInterface {
	
	public static void main(String[] args) {
		A a = new A();
		a.setVariableName("Surya");
		a.setVar(a);
	}
	
	public void setVar(AInterface a) {
		System.out.print(a.getVariableName());
		
	}
	
	public class B{
		
		void print(){
			
		}
	}

}
