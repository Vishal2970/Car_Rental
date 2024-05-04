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
        public String GetCar_Id(){
            return Car_Id;
        }
        public String GetBrand(){
            return Brand;
        }
        public String GetModel(){
            return Model;
        }
        public double GetBase_Price_perday(int Number_of_Day){
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
    }

    public static void main(String[] args) {
        System.out.println("Hello Vishal");
    }
}
