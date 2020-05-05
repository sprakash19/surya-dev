package lambdaSamples;

import java.math.BigInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class LambdaExpression1 {

	public static void main(String[] args) {
		Greetings greet= () -> System.out.println("hello world!");

        greet.perform();
        greet(() -> System.out.println("hello world!"));
        
        AddInterface add = (int a, int b) -> a+b;
        
        System.out.println(add.add(1, 2));
        
        
        int x =  add((int c, int d) -> c+d);
        System.out.println(x);
        
        int y =  add1((c, d) -> c+d);
        System.out.println(y);
        
        IntFunc func =  (num) -> System.out.println(Integer.parseInt(num));
        func.convert("2");
        
        
        UnaryOperator<String> newGreet = "hello, "::concat;
        System.out.println(newGreet.apply("Surya"));
        
        Function<String, BigInteger> newInt = BigInteger::new;
        System.out.println(newInt.apply("1234"));
        
        Consumer<String> c = System.out::println;
        c.accept("print it");
        
        Consumer<String> c1 = p -> System.out.println("hello again, "+ p);
        c1.accept("Surya");
				
			
		
	}
	
	public static void greet(Greetings g) {
		g.perform();
	}
	
	public static int add(AddInterface a) {
	 return	a.add(2, 3);
	}
	
	public static int add1(AddInterface a) {
		 return	a.add(4, 3);
		}

}

