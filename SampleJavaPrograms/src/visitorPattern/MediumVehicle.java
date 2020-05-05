package visitorPattern;

public class MediumVehicle implements Vehicle {

    private String seating;
	
	public MediumVehicle(String seating) {
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
