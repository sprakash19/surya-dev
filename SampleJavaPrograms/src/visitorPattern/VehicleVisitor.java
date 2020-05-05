package visitorPattern;

public class VehicleVisitor implements Visitor {

	@Override
	public void visit(SmallVehicle vehicle) {
		System.out.println("Road Tax of small Vehicle is "+ Integer.parseInt(vehicle.getSeating())*2);
		
	}

	@Override
	public void visit(MediumVehicle vehicle) {
		System.out.println("Road Tax of Medium Vehicle is "+ Integer.parseInt(vehicle.getSeating())*4);
		
	}

	@Override
	public void visit(LargeVehicle vehicle) {
		System.out.println("Road Tax of Large Vehicle is "+ Integer.parseInt(vehicle.getSeating())*10);
		
	}
	
	

}
