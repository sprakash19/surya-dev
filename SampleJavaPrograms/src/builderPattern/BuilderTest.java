package builderPattern;

public class BuilderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        PersonBuilder pb = new PersonBuilder();
       Person p = pb.addAddress("USA").addfName("surya").addLName("D").build();
       
      
       
       
	}

}
