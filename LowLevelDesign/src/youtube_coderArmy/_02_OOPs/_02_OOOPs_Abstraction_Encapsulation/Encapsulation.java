package youtube_coderArmy._02_OOPs._02_OOOPs_Abstraction_Encapsulation;


/*
Encapsulation says 2 things:
1. An Object's Characteristics and its behaviour are encapsulated together
within that Object.
2. All the characteristics or behaviours are not for everyone to access.
Object should provide data security.

We follow above 2 pointers about Object of real world in programming by:
1. Creating a class that act as a blueprint for Object creation. Class contain
all the characteristics (class variable) and behaviour (class methods) in one block,
encapsulating it together.
2. We introduce access modifiers (public, private, protected, default) etc to provide data
security to the class members.
*/
class SportsCar1 {
    // character
    private String brand;
    private String model;
    private boolean isEngineOn = false;
    private int currentSpeed = 0;
    private int currentGear = 0;

    //Introduce new variable to explain setters
    private String tyreCompany = "Teja";

    public SportsCar1(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    // behaviour
    public int getSpeed() {
        return currentSpeed;
    }

    public String getTyreCompany() {
        return tyreCompany;
    }

    public void setTyreCompany(String tyreCompany) {
        this.tyreCompany = tyreCompany;
    }

    public void startEngine() {
        isEngineOn = true;
        System.out.println(brand + " " + model + " : Engine starts with a roar!");
    }

    public void shiftGear(int gear) {
        this.currentGear = gear;
        System.out.println(brand + " " + model + " : Shifted to gear " + currentGear);
    }

    public void accelerate() {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Engine is off! Cannot accelerate.");
            return;
        }
        currentSpeed += 20;
        System.out.println(brand + " " + model + " : Accelerating to " + currentSpeed + " km/h");
    }

    public void brake() {
        currentSpeed -= 20;
        if (currentSpeed < 0) currentSpeed = 0;
        System.out.println(brand + " " + model + " : Braking! Speed is now " + currentSpeed + " km/h");
    }

    public void stopEngine() {
        isEngineOn = false;
        currentGear = 0;
        currentSpeed = 0;
        System.out.println(brand + " " + model + " : Engine turned off.");
    }
}

//Main Method
public class Encapsulation {
    public static void main(String[] args) {

        SportsCar1 mySportsCar1 = new SportsCar1("Ford", "Mustang");

        mySportsCar1.startEngine();
        mySportsCar1.shiftGear(1);
        mySportsCar1.accelerate();
        mySportsCar1.shiftGear(2);
        mySportsCar1.accelerate();
        mySportsCar1.brake();
        mySportsCar1.stopEngine();

        System.out.println(mySportsCar1.getTyreCompany());
        mySportsCar1.setTyreCompany("Universe");
        System.out.println(mySportsCar1.getTyreCompany());
        //Setting arbitrary value to speed.
//        mySportsCar1.currentSpeed = 500;

        // System.out.println("Current Speed of My Sports Car is set to " + mySportsCar1.currentSpeed);

        System.out.println("Current Speed of My Sports Car is " + mySportsCar1.getSpeed());
    }
}