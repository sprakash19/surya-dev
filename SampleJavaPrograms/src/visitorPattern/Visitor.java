package visitorPattern;

public interface Visitor {
	
	public void visit(SmallVehicle vehicle);
	public void visit(MediumVehicle vehicle);
	public void visit(LargeVehicle vehicle);

}
