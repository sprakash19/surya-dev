package visitorPattern;

public class VisitorTester {

	public static void main(String[] args) {
		Visitor visitor = new VehicleVisitor();
		Vehicle vehicle = new LargeVehicle("20");
		vehicle.accept(visitor);
		vehicle = new MediumVehicle("7");
		vehicle.accept(visitor);
		
		vehicle = new SmallVehicle("2");
		vehicle.accept(visitor);

	}

}
