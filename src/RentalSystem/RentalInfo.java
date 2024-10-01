package RentalSystem;

public class RentalInfo {
    private Car car;
    private Customer customer;
    private int days;

    public RentalInfo(Car car, Customer customer, int days) {
        this.car = car;
        this.customer = customer;
        this.days = days;
    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getDays() {
        return days;
    }
}
