public class ShipDemo {
    public static void main(String[] args) {
        // Create a static array of Ship of size 3
        Ship[] ships = new Ship[3];

        // Populate the array dynamically with one of each object type
        ships[0] = new Ship("Oceanic Explorer", "1998");
        ships[1] = new CruiseShip("Grand Voyager", "2015", 3500);
        ships[2] = new CargoShip("Atlantic Titan", "2020", 85000);

        System.out.println("==================================================");
        System.out.println("             SHIP POLYMORPHISM DEMO               ");
        System.out.println("==================================================");

        // Loop through the array and call the overridden print functions
        for (Ship s : ships) {
            s.print();
            System.out.println("--------------------------------------------------");
        }
    }
}

// Base Class: Ship
class Ship {
    private String shipName;
    private String yearBuilt;

    // Constructor
    public Ship(String shipName, String yearBuilt) {
        this.shipName = shipName;
        this.yearBuilt = yearBuilt;
    }

    // Getters and Setters (Accessors and Mutators)
    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(String yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    // Print function
    public void print() {
        System.out.println("Ship Name: " + shipName);
        System.out.println("Year Built: " + yearBuilt);
    }
}

// Derived Class 1: CruiseShip
class CruiseShip extends Ship {
    private int maxPassengers;

    // Constructor
    public CruiseShip(String shipName, String yearBuilt, int maxPassengers) {
        super(shipName, yearBuilt);
        this.maxPassengers = maxPassengers;
    }

    // Getters and Setters
    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    // Overridden print function
    @Override
    public void print() {
        System.out.println("Cruise Ship Name: " + getShipName());
        System.out.println("Maximum Passengers: " + maxPassengers);
    }
}

// Derived Class 2: CargoShip
class CargoShip extends Ship {
    private int cargoCapacity; // in tonnage

    // Constructor
    public CargoShip(String shipName, String yearBuilt, int cargoCapacity) {
        super(shipName, yearBuilt);
        this.cargoCapacity = cargoCapacity;
    }

    // Getters and Setters
    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    // Overridden print function
    @Override
    public void print() {
        System.out.println("Cargo Ship Name: " + getShipName());
        System.out.println("Cargo Capacity: " + cargoCapacity + " tons");
    }
}