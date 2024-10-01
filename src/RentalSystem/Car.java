package RentalSystem;

public class Car {
    private String carId;
    private String brand;
    private String model;
    private double basePriceperDay;
    private boolean isAvailable;

    public Car(double basePriceperDay, String brand, String carId, String model) {
        this.basePriceperDay = basePriceperDay;
        this.brand = brand;
        this.carId = carId;
        this.model = model;
        this.isAvailable = true;
    }

    public String getBrand() {
        return brand;
    }

    public String getCarId() {
        return carId;
    }

    public String getModel() {
        return model;
    }

    public double calculatePrice(int rentalDays){
        return basePriceperDay * rentalDays;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void rent(){
        isAvailable = false;
    }

    public void returnCar(){
        isAvailable = true;
    }
}
