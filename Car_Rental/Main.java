import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    class Car{
        private String Car_Id;
        private String Brand;
        private String Model;
        private Double Base_Price_perday;
        private boolean isAvailable;

        public Car(String Car_Id, String Brand, String Model, Double Base_Price_perday, boolean isAvailable){
            this.Car_Id=Car_Id;
            this.Brand=Brand;
            this.Model=Model;
            this.Base_Price_perday=Base_Price_perday;
            this.isAvailable=true;

        }
        public String getCar_Id(){
            return Car_Id;
        }
        public String getBrand(){
            return Brand;
        }
        public String getModel(){
            return Model;
        }
        public double getBase_Price_perday(int Number_of_Day){
            return Number_of_Day*Base_Price_perday;
        }
        public boolean isAvailable(){
            return isAvailable;
        }
        public void Rent(){
            isAvailable=false;
        }
        public void Return_Car(){
            isAvailable=true;
        }

    }

    class Customer{
        private String Customer_Id;
        private String Customer_Name;
        public Customer(String Customer_Id,String Customer_Name){
            this.Customer_Name=Customer_Name;
            this.Customer_Id=Customer_Id;
        }
        public String getCustomer_Id(){
            return Customer_Id;
        }
        public String getCustomer_Name(){
            return Customer_Name;
        }
    }

    class Rental{
        private Car car;
        private Customer customer;
        private int days;
        public Rental(Car car, Customer customer,int days){
            this.car=car;
            this.customer=customer;
            this.days=days;
        }
        public Car getCar(){
            return car;
        }
        public Customer getCustomer(){
            return customer;
        }
        public int getDays(){
            return days;
        }
    }

    class CarRentalSysytem{
        private List<Car> cars;
        private List<Customer> customers;
        private List<Rental>rentals;

        public CarRentalSysytem(){
            cars=new ArrayList<>();
            customers=new ArrayList<>();
            rentals=new ArrayList<>();
        }

        public void addCar(Car car){
            cars.add(car);
        }
        public void addCustomer(Customer customer){
            customers.add(customer);
        }

        public void rentACar(Car car, Customer customer, int days){
            if (car.isAvailable){
                car.Rent();
                rentals.add(new Rental(car,customer,days));
            }else {
                System.out.println("Car is not avaliable for rent");
            }
        }
        public void returnCar(Car car){
            car.Return_Car();
            Rental rentalToRemove=null;
            for(Rental rental:rentals){
                if (rental.getCar() == car){
                    rentalToRemove=rental;
                    break;
                }
            }
            if (rentalToRemove !=null){
                rentals.remove(rentalToRemove);
                System.out.println("Car Return successfully");
            }else {
                System.out.println("Car was not returned");
            }
        }
    }

    public void menu(){
        Scanner sc =new Scanner(System.in);
        while (true){
            System.out.println("===============Car Rental System===============");
            System.out.println("1. Rent a car");
            System.out.println("2. Exit");
            System.out.println("Enter your choice");
            int choice=sc.nextInt();
            sc.nextLine();

            if (choice == 1){
                System.out.println("\n==Rent a car==\n");
                System.out.println("Enter Your Name");
                String Customer_Name=sc.next();
                System.out.println("\n Available cars");
                for(Car car: Car){
                    if (car.isAvailable){
                        System.out.println(car.getCar_Id()+" - "+car.getBrand()+" - "+ car.getModel());
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello Vishal");
    }
}
