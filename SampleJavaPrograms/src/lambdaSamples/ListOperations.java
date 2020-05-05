package lambdaSamples;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ListOperations {

	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(new Person("surya", "rao", 33),
				new Person("mallika", "upad", 32),
		        new Person("shobha", "duvvuri", 57));
//          Collections.sort(persons, new Comparator<Person>() {
//
//			@Override
//			public int compare(Person o1, Person o2) {
//				
//				return o1.getLastName().compareTo(o2.getLastName());
//			}
//        	  
//          });
          
          Collections.sort(persons, (o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));
//          PrintAll all = new PrintAll() {
//
//			@Override
//			public void printAll(List<Person> persons) {
//				
//				for(Person person : persons) {
//					System.out.println(person.getFirstName());
//				}	
//			}
//        	  
//          };
          
          print(persons, p -> true);
          
//          Predicate<Person> cond = p -> {
//        		if(p.getFirstName().startsWith("m")) {
//        			System.out.println(p.getFirstName());
//        		}
//				return false;
//          };
//			
//          for(Person p : persons) {
//          cond.test(p);
//          }
          
          print(persons, p -> p.getFirstName().startsWith("m"));
          
          print(persons, p -> p.getLastName().startsWith("r"), p -> System.out.println(p.getFirstName()));
	}
	
	private static void print(List<Person> persons , Predicate<Person> p) {
		for(Person s : persons) {
			if(p.test(s)) {
				System.out.println(s.getFirstName());
			}
		}
	}
	
	private static void print(List<Person> persons, Predicate<Person> predicate, Consumer<Person> c) {
		for(Person p : persons) {
			if(predicate.test(p)) {
				c.accept(p);
			}
		}
	}
	
	

}
