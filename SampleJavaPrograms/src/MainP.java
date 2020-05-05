import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MainP {
	private Collection<String> messages;

	public static void main(String[] args) {
    MainP obj = new MainP();
    obj.test();
	}
	
	private void test() {
		Set<String> messages = new HashSet<String>();
		List<SampleObj> list = new ArrayList<>();
		list.add(new SampleObj("1", "Surya"));
		list.add(new SampleObj("2", "Surya1"));
		list.add(new SampleObj(null, "Surya2"));
		
		
	   Map<String , SampleObj> map =  list.stream().filter(key -> {
		    if(key.getId() == null) {
		    	System.out.println("this is null");
		    }
		   return key.getId() != null;}).
			   collect(Collectors.toMap(SampleObj::getId, obj -> obj));
	    	
	   System.out.print(map.toString());
	   
	    }
		




class SampleObj {
	
	String id;
	String name;
	
	public SampleObj(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
}
