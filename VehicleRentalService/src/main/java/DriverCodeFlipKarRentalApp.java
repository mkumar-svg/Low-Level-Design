import com.flipcart.rentalvehicle.cars.Activa;
import com.flipcart.rentalvehicle.cars.Bike;
import com.flipcart.rentalvehicle.cars.Sedan;
import com.flipcart.rentalvehicle.cars.Suv;
import com.flipcart.rentalvehicle.dao.Branch;
import com.flipcart.rentalvehicle.service.RentalService;

public class DriverCodeFlipKarRentalApp {

	public static void main(String[] args) {
		RentalService rentalService = new RentalService();
		
		Branch kormangla = new Branch("Koramangla");
		Branch bellandur = new Branch("Bellandur");
		Branch whitwfield = new Branch("WhiteField");
		rentalService.addBranch(kormangla);
		rentalService.addBranch(bellandur);
		rentalService.addBranch(whitwfield);
		
		rentalService.addVehicleToBranch("Koramangla", "Suv", new Suv("S001", 12.0));
		rentalService.addVehicleToBranch("Koramangla", "Sedan", new Sedan("S002", 10.0));
		rentalService.addVehicleToBranch("Koramangla", "Bike", new Bike("B001", 20.0));
		rentalService.addVehicleToBranch("Bellandur", "Sedan", new Sedan("S003", 13.0));
		rentalService.addVehicleToBranch("Bellandur", "Bike", new Bike("B002", 30.0));
		rentalService.addVehicleToBranch("WhiteField", "Activa", new Activa("B003", 11.0));
		rentalService.addVehicleToBranch("WhiteField", "Suv", new Suv("S004", 15.0));
		
		rentalService.addVehicleToBranch("Koramangala", "Sedan", new Sedan("S005", 10.0));

		rentalService.bookVehicle("Suv", 2);
		rentalService.bookVehicle("Suv", 2);
		rentalService.bookVehicle("Suv", 2);
		
		rentalService.systemView();
	}

}
