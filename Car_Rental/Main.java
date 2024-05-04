import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


    class Car{
        private String Car_Id;
        private String Brand;
        private String Model;
        private Double Base_Price_perday;
        private boolean isAvailable;

        public Car(String Car_Id, String Brand, String Model, Double Base_Price_perday){
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
    class CarRentalSysytem {

        private List<Car> cars;
        private List<Customer> customers;
        private List<Rental> rentals;

        public CarRentalSysytem() {
            cars = new ArrayList<>();
            customers = new ArrayList<>();
            rentals = new ArrayList<>();
        }

        public void addCar(Car car) {
            cars.add(car);
        }

        public void addCustomer(Customer customer) {
            customers.add(customer);
        }

        public void rentACar(Car car, Customer customer, int days) {
            if (car.isAvailable()) {
                car.Rent();
                rentals.add(new Rental(car, customer, days));
            } else {
                System.out.println("Car is not avaliable for rent");
            }
        }

        public void returnCar(Car car) {
            Rental rentalToRemove = null;
            for (Rental rental : rentals) {
                if (rental.getCar() == car) {
                    rentalToRemove = rental;
                    break;
                }
            }
            if (rentalToRemove != null) {
                rentals.remove(rentalToRemove);
                car.Return_Car();
                System.out.println("Car Return successfully");
            } else {
                System.out.println("Car was not returned");
            }
        }

        public void menu() {
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("===============Car Rental System===============");
                System.out.println("1. Rent a car");
                System.out.println("2. Return a car");
                System.out.println("3. Exit");
                System.out.println("Enter your choice");
                int choice = sc.nextInt();
                sc.nextLine();

                if (choice == 1) {
                    System.out.println("\n==Rent a car==\n");
                    System.out.println("Enter Your Name");
                    String Customer_Name = sc.next();
                    System.out.println("\n Available cars");
                    for (Car car : cars) {
                        if (car.isAvailable()) {
                            System.out.println(car.getCar_Id() + " - " + car.getBrand() + " - " + car.getModel());
                        }
                    }
                    System.out.println("\n Enter car id which you wanted to rent ");
                    String carId=sc.next();
                    System.out.println("\n Enter no of days for you wanted a car");
                    int Rentaldays=sc.nextInt();
                    sc.nextLine();
                    Customer customer=new Customer("Cus"+(customers.size()+1),Customer_Name);
                    addCustomer(customer);

                    Car selected_Car=null;
                    for(Car car:cars){
                        if(car.getCar_Id().equals(carId) && car.isAvailable()){
                            selected_Car=car;
                            break;
                        }
                    }
                    if (selected_Car!=null){
                        double total_price=selected_Car.getBase_Price_perday(Rentaldays);
                        System.out.println("\n ========Rental Informations======== \n");
                        System.out.println("\n Customer_id = " + customer.getCustomer_Id());
                        System.out.println("\n Customer Name = "+customer.getCustomer_Name());
                        System.out.println("\n selected car = "+ selected_Car.getModel()+" "+selected_Car.getBrand());
                        System.out.println("\n Rental Days = "+ Rentaldays);
                        System.out.println("Total Price ="+ total_price);
//                        $%.2f%n
                        System.out.println("\n Confirm Rental  Y/N");
                        String confirm = sc.next();
                        if (confirm.equalsIgnoreCase("Y")){
                            rentACar(selected_Car,customer,Rentaldays);
                            System.out.println("Successfully Rented Car id "+selected_Car.getCar_Id());
                        }else {
                            System.out.println("Car Rental Cancelled");
                        }
                    }else {
                        System.out.println("\n Invalid Car or car is not available for rent");
                    }
                } else if (choice==2) {
                    System.out.println("\n========Return a Car ========");
                    System.out.println("\n======== Enter car id for return ========");
                    String car_id=sc.next();

                    Car carToReturn =null;
                    for (Car car:cars){
                        if (car.getCar_Id().equals(car_id) && !car.isAvailable()){
                            carToReturn=car;
                            break;
                        }
                    }
                    if (carToReturn!=null){
                        Customer customer=null;
                        for(Rental rental:rentals){
                            if (rental.getCar()==carToReturn){
                                customer=rental.getCustomer();
                                break;
                            }
                        }
                        if (customer!=null){
                            returnCar(carToReturn);
                            System.out.println("Returned Car Successfully for Customer "+customer.getCustomer_Name());
                        }else {
                            System.out.println("Car Was not returned either car information was wrong or information is missing");
                        }
                    }else {
                        System.out.println("Invalid car id or car is not rented");
                    }
                }else if (choice==3){
                    break;
                }else {
                    System.out.println("Invalid Choice ");
                }
            }
            System.out.println("\n Thank you for using car rental by Vishal");
        }
    }


public class Main {
    public static void main(String[] args) {
        CarRentalSysytem rentalSysytem=new CarRentalSysytem();
        Car car1=new Car("C001","Mahindra","Thar",150.0);
        Car car2=new Car("C002","Mahindra","Baleno",10.0);
        Car car3=new Car("C003","Mahindra","Volvo",16.0);
        Car car4=new Car("C004","Mahindra","Dezire",158.0);
        Car car5=new Car("C005","Mahindra","Swift",122.0);


        rentalSysytem.addCar(car1);
        rentalSysytem.addCar(car2);
        rentalSysytem.addCar(car3);
        rentalSysytem.addCar(car4);
        rentalSysytem.addCar(car5);


        rentalSysytem.menu();
    }
}
