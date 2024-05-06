### Car Rental System

This project implements a simple car rental system using Object-Oriented Programming concepts in Java. Below are the key OOP concepts utilized in this code:

1. **Encapsulation**: The classes `Car`, `Customer`, and `Rental` encapsulate their respective data fields and provide methods to access and modify them, maintaining data integrity and security.

2. **Inheritance**: While inheritance is not explicitly demonstrated in this code, the concept could be applied to create specialized types of cars or customers by extending the existing classes.

3. **Polymorphism**: Though not explicitly demonstrated, polymorphism allows methods in the `Car` class, such as `getBase_Price_perday`, to behave differently depending on the number of days provided as an argument.

4. **Abstraction**: Abstraction is seen throughout the code, where complex real-world entities like cars, customers, and rentals are represented as classes with simplified interfaces and behaviors.

### Functionality

The system consists of three main classes:

- **Car**: Represents a car with attributes such as ID, brand, model, base price per day, and availability. It provides methods to rent and return the car.

- **Customer**: Represents a customer with attributes like ID and name. It provides methods to access customer information.

- **Rental**: Represents a rental transaction, associating a car with a customer and the number of days rented.

- **CarRentalSystem**: Manages the rental system, including adding cars and customers, renting cars, returning cars, and displaying a menu for user interaction.

### Usage

To use the system, follow these steps:

1. Instantiate the `CarRentalSystem` class.
2. Create instances of `Car` using the `Car` class constructor, providing parameters like Car ID, brand, model, and base price per day.
3. Add cars to the system using the `addCar` method.
4. Use the `menu` method to display the menu and interact with the system. Options include renting a car, returning a car, and exiting the system.
5. Follow the prompts to input customer information, select a car to rent, specify the rental duration, and confirm the rental. You can also return a rented car by providing the car ID.

### Example

Below is an example of using the `Main` class to set up the system and interact with it:

java
public class Main {
  public static void main(String[] args) {
    CarRentalSysytem rentalSysytem = new CarRentalSysytem();

    // Create instances of Car
    Car car1 = new Car("C001", "Mahindra", "Thar", 150.0);
    Car car2 = new Car("C002", "Mahindra", "Baleno", 10.0);
    // Add cars to the system
    rentalSysytem.addCar(car1);
    rentalSysytem.addCar(car2);

    // Display the menu and interact with the system
    rentalSysytem.menu();
  }
}


### Conclusion

This project demonstrates the use of OOP principles to create a simple car rental system, providing functionality to rent and return cars while maintaining data integrity and encapsulation.



### ScreenShots


<img width="960" alt="1" src="https://github.com/Vishal2970/Car_Rental/assets/96405876/85c33444-d450-4b8c-8ff5-32e27d48e125">


<img width="345" alt="2" src="https://github.com/Vishal2970/Car_Rental/assets/96405876/9d596823-bd69-4c23-882b-a97f860d9c44">



<img width="540" alt="3" src="https://github.com/Vishal2970/Car_Rental/assets/96405876/ed2d9580-0b41-41e8-92b0-9c90251a147e">



<img width="383" alt="4" src="https://github.com/Vishal2970/Car_Rental/assets/96405876/5822bd0c-8cef-4fc4-af76-8b88c63bbc31">



<img width="390" alt="5" src="https://github.com/Vishal2970/Car_Rental/assets/96405876/551b2779-cf0c-40e6-8abc-10140edb9ed8">




<img width="471" alt="6" src="https://github.com/Vishal2970/Car_Rental/assets/96405876/c523d7ab-7ac4-407b-aa99-66b69209dd83">




<img width="512" alt="7" src="https://github.com/Vishal2970/Car_Rental/assets/96405876/cc99502b-f4a0-42da-9b90-8e7a8c8c6cee">
