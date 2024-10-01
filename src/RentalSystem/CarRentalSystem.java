package RentalSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem {
    private List<Car> cars;
    private List<Customer> customers;
    private List<RentalInfo> rentalInfos;

    public CarRentalSystem(){
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentalInfos = new ArrayList<>();
    }

    public void addCar(Car car){
        cars.add(car);
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public void rentCar(Car car,Customer customer, int days){
        if(car.isAvailable()){
            car.rent();
            rentalInfos.add(new RentalInfo(car,customer,days));
        }else {
            System.out.println("Car is not available for rent...");
        }
    }

    public void returnCar(Car car){
        car.returnCar();
        RentalInfo rentalInfoToRemove = null;
        for(RentalInfo rentalInfo : rentalInfos){
            if(rentalInfo.getCar() == car){
                rentalInfoToRemove = rentalInfo;
                break;
            }
        }
        if(rentalInfoToRemove != null){
            rentalInfos.remove(rentalInfoToRemove);
            System.out.println("Car is returned successfully...");
        }else {
            System.out.println("Car was not rented...");
        }
    }

    public void menu(){
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("======Car Rental System======");
            System.out.println("1. Rent a car");
            System.out.println("2. Return a car");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // to consume new line

            if(choice == 1){
                System.out.println("\n== Rent a car ==\n");
                System.out.print("Enter your name: ");
                String customerName = sc.nextLine();

                System.out.println("\n== Available cars ==\n");
                for(Car car: cars){
                    if(car.isAvailable()){
                        System.out.println(car.getCarId()+ " - " +car.getBrand()
                            +" - " + car.getModel());
                    }
                }

                System.out.print("\nEnter the car ID you want to rent: ");
                String carId = sc.nextLine();

                System.out.print("\nEnter the number of days for rental: ");
                int rentalDays = sc.nextInt();

                sc.nextLine(); // to consume next line

                Customer newCustomer = new Customer("CUS" + (customers.size()+1),customerName);
                addCustomer(newCustomer);

                Car selectedCar = null;
                for(Car car: cars){
                    if(car.getCarId().equals(carId) && car.isAvailable()){
                        selectedCar = car;
                        break;
                    }
                }

                if(selectedCar != null){
                    double totalPrice = selectedCar.calculatePrice(rentalDays);
                    System.out.println("\n== Rental Information ==\n");
                    System.out.println("Customer ID: " + newCustomer.getCustomerId());
                    System.out.println("Customer name: "+ newCustomer.getName());
                    System.out.println("Car : " + selectedCar.getBrand()+"  "+selectedCar.getModel());
                    System.out.println("Rental Days: "+ rentalDays);
                    System.out.printf("Total Price: $%.2f%n", totalPrice );

                    System.out.println("\nConfirm rental(Y/N): ");
                    String confirm = sc.nextLine();

                    if(confirm.equalsIgnoreCase("y")){
                        rentCar(selectedCar,newCustomer,rentalDays);
                        System.out.println("\nCar rented successfully...");
                    }else {
                        System.out.println("\nRental canceled...");
                    }
                }else {
                    System.out.println("\nInvalid car selection or car is not available for rent...");
                }
            }

            else if (choice == 2) {
                System.out.println("\n== Return car ==");
                System.out.print("Enter the car ID you want to return: ");
                String carId = sc.nextLine();

                Car carToReturn = null;
                for(Car car: cars){
                    if(car.getCarId().equals(carId) && !car.isAvailable())
                    {
                        carToReturn = car;
                        break;
                    }
                }

                if(carToReturn != null){
                    Customer customer = null;
                    for(RentalInfo rentalInfo : rentalInfos){
                        if(rentalInfo.getCar() == carToReturn){
                            customer = rentalInfo.getCustomer();
                            break;
                        }
                    }

                    if(customer != null){
                        returnCar(carToReturn);
                        System.out.println("car is returned successfully by "+ customer.getName());
                    }else {
                        System.out.println("Car was not rented or rental information is missing...");
                    }
                }else {
                    System.out.println("Invalid car ID of car is not rented...");
                }
            }

            else if (choice == 3) {
                break;
            }

            else {
                System.out.println("Invalid choice. Please enter a valid option...");
            }
        }

        System.out.println("Thank You for using the Car Rental System!!!");
    }
}
