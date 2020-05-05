package visitorPattern;

public class LargeVehicle implements Vehicle {

	private String seating;
	
	public LargeVehicle(String seating) {
		this.setSeating(seating);
	}

	@Override
	public void accept(Visitor visit) {
		visit.visit(this);
	}

	public String getSeating() {
		return seating;
	}
	public void setSeating(String seating) {
		this.seating = seating;
	}

}
