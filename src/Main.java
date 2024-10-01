import RentalSystem.Car;
import RentalSystem.CarRentalSystem;

public class Main {
    public static void main(String[] args) {

        CarRentalSystem rentalSystem = new CarRentalSystem();

        Car car1 = new Car(40,"Toyota","C001","Creta");
        Car car2 = new Car(60,"Honda","C002","Civic");
        Car car3 = new Car(150,"Mahindra","C003","Thar");
        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);

        rentalSystem.menu();
    }
}